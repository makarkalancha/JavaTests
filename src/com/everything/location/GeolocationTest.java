package com.everything.location;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.TimeZoneApi;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * Created by mcalancea
 * Date: 21 Mar 2018
 * Time: 09:09
 */
public class GeolocationTest {
//    String googleKey check email

    public static void main(String[] args) throws Exception {
        String googleKey = args[0];

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(googleKey)
                .build();
//        LatLng latLng = new LatLng(38.908133, -77.047119);
//        LatLng latLng = new LatLng(45.461374, -73.4659812);
        LatLng latLng = new LatLng(45.5027821, -73.5010193);

        TimeZone timeZone = TimeZoneApi.getTimeZone(context, latLng).await();
        System.out.println(timeZone.toZoneId().toString());

        GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(context, latLng).await();

        System.out.println(geocodingResults);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(gson.toJson("addressComponents:" + Arrays.toString(geocodingResults[0].addressComponents)));
        System.out.println(gson.toJson("addressComponents[0].types:" +
                Arrays.stream(geocodingResults[0].addressComponents)
//                    .flatMap(addressComponent -> Arrays.stream(addressComponent.types))
                    .filter(addressComponent -> Arrays.stream(addressComponent.types)
                                .allMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY) || addressComponentType.equals(AddressComponentType.POLITICAL))
                    )
                    .map(addressComponent1 -> addressComponent1.shortName)
                    .collect(Collectors.toList())
        ));
        System.out.println(gson.toJson("country:" +
                        Arrays.stream(geocodingResults[0].addressComponents)
                                .filter(addressComponent -> Arrays.stream(addressComponent.types)
//                                        .anyMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY))
                                        .allMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY) || addressComponentType.equals(AddressComponentType.POLITICAL))
                                )
                                .map(addressComponent1 -> addressComponent1.shortName)
                                .findFirst().orElse(null)
        ));
//        System.out.println(gson.toJson("addressComponents:" + geocodingResults[0].addressComponents[0].types));
//        System.out.println(gson.toJson("types:" + Arrays.toString(geocodingResults[0].types)));
//        System.out.println(gson.toJson("formattedAddress:" + geocodingResults[0].formattedAddress));
//        System.out.println(gson.toJson("geometry:" + geocodingResults[0].geometry));
//        System.out.println(gson.toJson("partialMatch:" + geocodingResults[0].partialMatch));
//        System.out.println(gson.toJson("placeId:" + geocodingResults[0].placeId));
//        System.out.println(gson.toJson("postcodeLocalities:" + geocodingResults[0].postcodeLocalities));
//        System.out.println(gson.toJson("addressComponents1:" + Arrays.toString(geocodingResults[1].addressComponents)));


        Client client = Client.create();

        WebResource webResource = client
//                .resource("https://maps.googleapis.com/maps/api/timezone/json?location=38.908133,-77.047119&timestamp=1458000000&key="+googleKey);
                .resource("https://maps.googleapis.com/maps/api/timezone/json?location=38.908133,-77.047119&key="+googleKey);
        String json1 = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(json1);

        webResource = client
                .resource("https://maps.googleapis.com/maps/api/geocode/json?latlng=38.908133,-77.047119&key="+googleKey);
        String json2 = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
//        System.out.println(json2);


//        JsonObject jsonObject = gson.fromJson(json2, JsonObject.class);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json2).getAsJsonObject();
        String country = null;
        for(JsonElement jsonElement : jsonObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonArray("address_components")){
            JsonArray typesArray = jsonElement.getAsJsonObject().getAsJsonArray("types");
            List<String> arrName = Arrays.asList(new Gson().fromJson(typesArray, String[].class));
            if(arrName.contains("country") && arrName.contains("political")){
                country = jsonElement.getAsJsonObject().get("short_name").getAsString();
            }
        }

        Response geocodingResults2 = gson.fromJson(webResource.accept(MediaType.APPLICATION_JSON).get(String.class), Response.class);
        System.out.println(geocodingResults2);

        System.out.println("country:" +
                Arrays.stream(geocodingResults2.getResult()[0].addressComponents)
                        .filter(addressComponent -> Arrays.stream(addressComponent.types)
//                                        .anyMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY))
                                        .allMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY) || addressComponentType.equals(AddressComponentType.POLITICAL))
                        )
                        .map(addressComponent1 -> addressComponent1.shortName)
                        .findFirst().orElse(null)
        );
    }

    static class Response implements ApiResponse<GeocodingResult[]> {
        public String status;
        public String errorMessage;
        public GeocodingResult[] results;

        Response() {
        }

        public boolean successful() {
            return "OK".equals(this.status) || "ZERO_RESULTS".equals(this.status);
        }

        public GeocodingResult[] getResult() {
            return this.results;
        }

        public ApiException getError() {
            return this.successful()?null:ApiException.from(this.status, this.errorMessage);
        }
    }
}
