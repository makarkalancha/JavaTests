package com.everything.http;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mcalancea
 * Date: 30 Nov 2017
 * Time: 18:05
 */
public class WebClient {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//            .registerTypeAdapter(CurrencyRate.class, new CurrencyRateListAdapter())
            .registerTypeAdapter(List.class, new CurrencyRateListAdapter())
            .create();

    public static void main(String[] args){
        String urlStr = "http://api.fixer.io/";
        String urlPath_latest = "latest";
        String urlPath_Sep012017 = "2017-09-01";
        String urlParameter_baseCAD = "base=CAD";
        String urlParameter_symbolsUSDEUR = "symbols=USD,EUR";

        StringBuilder urlSB = new StringBuilder();
        urlSB.append(urlStr);
        urlSB.append(urlPath_latest);

        StringBuilder paramsSB = new StringBuilder();
        paramsSB.append(urlParameter_baseCAD);
        paramsSB.append("&");
        paramsSB.append(urlParameter_symbolsUSDEUR);

//http://fixer.io/
//https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
//https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post
        HttpURLConnection connection = null;
        try {
//            URL url = new URL(urlSB.toString());
            URL url = new URL(urlSB
                    .append("?")
                    .append(paramsSB)
                    .toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length",
                    Integer.toString(paramsSB.toString().getBytes().length));
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            StringBuilder response = new StringBuilder();
            if(responseCode == HttpURLConnection.HTTP_OK) {
//                //Send request for POST
//                DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
////            dos.writeBytes(paramsSB.toString());
//                dos.flush();
//                dos.close();

                //Get response
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();
            }
            System.out.println(response);

            CurrencyRateForDate currencyRateForDate = GSON.fromJson(response.toString(), CurrencyRateForDate.class);
            System.out.println(currencyRateForDate);

//            String json1 = "{\"USD\":0.77675}";
//            CurrencyRate cr = GSON.fromJson(json1, CurrencyRate.class);
//            System.out.println(cr);

//            String json2 = "{\"base\":\"CAD\",\"date\":\"2017-12-01\",\"rates\":{\"USD\":0.77675,\"EUR\":0.65355}}";
//            CurrencyRateForDate currencyRateForDate = GSON.fromJson(json2, CurrencyRateForDate.class);
//            System.out.println(currencyRateForDate);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    private static class CurrencyRate{
        private String currencyCode;
        private BigDecimal rate;

        public CurrencyRate() {
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public BigDecimal getRate() {
            return rate;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public void setRate(BigDecimal rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "CurrencyRate{" +
                    "currencyCode='" + currencyCode + '\'' +
                    ", rate=" + rate +
                    '}';
        }
    }

    private static class CurrencyRateForDate{
        private String base;
        private LocalDate date;
        private List<CurrencyRate> rates;

        public CurrencyRateForDate() {
        }

        public String getBase() {
            return base;
        }

        public LocalDate getDate() {
            return date;
        }

        public List<CurrencyRate> getRates() {
            return rates;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setRates(List<CurrencyRate> rates) {
            this.rates = rates;
        }

        @Override
        public String toString() {
            return "CurrencyRateForDate{" +
                    "base='" + base + '\'' +
                    ", date=" + date +
                    ", rates=" + rates +
                    '}';
        }
    }

    private static class LocalDateAdapter implements JsonDeserializer<LocalDate>{
        private static final DateTimeFormatter DTF = DateTimeFormatter.ISO_LOCAL_DATE;
        @Override
        public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String jsonStr = jsonElement.getAsString();
            return LocalDate.parse(jsonStr, DTF);
        }
    }

    private static class CurrencyRateListAdapter implements JsonDeserializer<List<CurrencyRate>>{
        @Override
        public List<CurrencyRate> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            List<CurrencyRate> currencyRateList = new ArrayList<>();
            Map<String,String> map = jsonDeserializationContext.deserialize(jsonElement, new TypeToken<Map<String, String>>() {}.getType());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                CurrencyRate currencyRate = new CurrencyRate();
                currencyRate.setCurrencyCode(entry.getKey());
                currencyRate.setRate(new BigDecimal(entry.getValue()));

                currencyRateList.add(currencyRate);
            }
            return currencyRateList;
        }
    }
}
