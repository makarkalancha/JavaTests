package com.everything.regex;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Makar Kalancha
 * Date: 13/12/13
 * Time: 3:17 PM
 */
public class RegexTest {
    public static void main(String[] args) throws ParseException {
//        String str = "Event, Education";
//        str = str.replaceAll("\\s*,\\s*", "/");
//        System.out.println(str);

//        String xml =
//                "<exhibitor>\n" +
//                    "<showcatid_8>\n" +
//                        "<catcode>hello\n" +
//                        "</catcode>\n" +
//                        "<itemdesc>Ingredients</itemdesc>\n" +
//                    "</showcatid_8>\n" +
//                    "<maincontactid>1297</maincontactid>\n" +
//                    "<twitterurl>\n" +
//                    "</twitterurl>\n" +
//                        "\n" +
//                    "<showcatid_1>\n" +
//                    "</showcatid_1>\n" +
//                    "<postcode>276807</postcode>\n" +
//                        "\n" +
//                    "<showcatid_18>\n" +
//                    "</showcatid_18>\n" +
//                    "<integrationpassword>TQJ132VFJ767</integrationpassword>\n" +
//                    "<status>Standard</status>\n" +
//                    "<youtube_social>\n" +
//                    "</youtube_social>\n" +
//                        "\n" +
//                    "<showcatid_10>\n" +
//                        "<catcode>\n" +
//                        "255\n" +
//                        "</catcode>\n" +
//                        "<itemdesc>Dietary supplements</itemdesc>\n" +
//                    "</showcatid_10>\n" +
//                        "\n" +
//                    "<showcatid_16>\n" +
//                        "<catcode>\n" +
//                        "</catcode>\n" +
//                        "<itemdesc>Functional food</itemdesc>\n" +
//                    "</showcatid_16>\n" +
//                        "\n" +
//                    "<showcatid_14>\n" +
////                        "<catcode>\n" +
//                        "<catcode/>\n" +
//                        "<itemdesc>Functional\ndrinks</itemdesc>\n" +
//                    "</showcatid_14>\n" +
//                    "<address2>Lanshan District</address2>\n" +
//                    "<county>\n" +
//                    "</county>\n"+
//                    "\n" +
//                    "<showcatid_18>\n" +
//                    "</showcatid_18>\n" +
//                "</exhibitor>\n";
//
////        xml = xml.replaceAll("<showcatid_(\\d*)>", "<showcatid cat=\"$1\">");
////        xml = xml.replaceAll("</showcatid_(\\d*)>", "</showcatid>");
////        String CATCODE_TAG = "(<catcode>\\W*</catcode>|<catcode/>|.*?)";
////        String ITEM_TAG = "(<itemdesc>\\W*</itemdesc>|<itemdesc/>|.*?)";
//        //"<showcatid_(\\d*)>(\\W*)"+CATCODE_TAG+"(\\.*|\\W*)</showcatid_(\\d*)>"
////        xml = xml.replaceAll("<showcatid_(\\d*)>([\\.\\W\\s]*?)</showcatid_(\\d*)>", "<showcat><catcode>$1</catcode></showcat>");
////        xml = xml.replaceAll("itemdesc>(.*)</itemdesc", "itemdesc>~~~</itemdesc");
////        xml = xml.replaceAll("</showcatid_(\\d*)>", "</showcat>");
////        System.out.println(xml);
////        String pattern = "(.*)<showcatid_(\\d*)>(.*)</showcatid_(\\d*)>(.*)";
////        String pattern = "<showcatid_(\\d*)>(.*?)</showcatid_(\\d*)>";
////        String pattern = "<showcatid_(\\d*)>"+CATCODE_TAG+ITEM_TAG+"</showcatid_(\\d*)>";
//        String CATCODE_TAG = "(<catcode>.*?</catcode>|<catcode/>)";
//        String ITEM_TAG = "(<itemdesc>.*?</itemdesc>|<itemdesc/>)";
//        String pattern = "<showcatid_(\\d*)>\\W*?("+CATCODE_TAG+"\\W*?"+ITEM_TAG+")\\W*?</showcatid_(\\d*)>";
////        String pattern_v1 = "<showcatid_(\\d*)>\\W*?("+CATCODE_TAG+"\\W*?"+ITEM_TAG+")\\W*?</showcatid_(\\d*)>";
////        String patternString = ".*?<showcatid_(\\d*)>\\W*?("+CATCODE_TAG+"\\W*?"+ITEM_TAG+")\\W*?</showcatid_(\\d*)>.*?";
////        String pattern = "<showcatid_(\\d*)>(<catcode>\\w*?</catcode>|<catcode/>)*";
//        Pattern compiledPattern = Pattern.compile(pattern, Pattern.DOTALL);
//        Matcher matcher = compiledPattern.matcher(xml);
//////        String newXml = matcher.replaceAll("$1<showcat></showcat>$5");
//////        System.out.println(newXml);
//////        while(matcher.find()){
//////            System.out.println();
//////            System.out.println("start:\t"+matcher.start());
//////            System.out.println("end:\t"+matcher.end());
//////            System.out.println("group:\t"+matcher.group());
//////            System.out.println();
//////        }
//
////        String newXml = matcher.replaceAll("<showcat><catcode>$1</catcode><two>$2</two><three>$3</three><four>$4</four></showcat>");
////        String newXml = matcher.replaceAll("<showcat><catcode>$1</catcode>$4</showcat>");
//        String newXml_v1 = matcher.replaceAll("<showcat>$3$4</showcat>");
////////        String newXml = matcher.replaceAll("<showcat><catcode>$1</catcode><two>$2</two>");
//////        String newXml = xml.replaceAll(patternString,"<showcat><catcode>$1</catcode>$4</showcat>");
////        System.out.println("newXml:"+newXml);
//        System.out.println("newXml:" + newXml_v1);
//////        System.out.println("xml:"+xml);


//        String date = "2014-05-07T00:00:00";
//        String time = "1980-01-01T17:00:00";
//        String newDateTime = merge(date, time);
//        System.out.println(newDateTime);
//        DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        Date dateObj = DATETIME_FORMAT.parse(newDateTime);
//        System.out.println(dateObj.toString());

//        System.out.println(convertIntoUpperCase("Global ; . Expo"));

//        String ids = "2709,2708,2707";
//        String ids = "1_4,ad,2709,2708,2707";
//        String ids = "2707";
//        String ids = "Stream com.everything.A";
//        String prefix = "pre_";
//        String suffix = "_suf";
//        String newIds = ids.replaceAll("(\\w+)", prefix + "$1" + suffix);
//        System.out.println(newIds);

//        String MATCHER = "[Ff]ree.*";
//        String MATCHER = "[Ff][Rr][Ee][Ee].*";
//        String cost1 = "Paid Programming";
//        String cost2 = "";
//        String cost3 = "Free for all ISC badgeholders";
//        String cost4 = "Free";
//        String cost5 = "fREE ";
//        System.out.println(cost1.matches(MATCHER));
//        System.out.println(cost2.matches(MATCHER));
//        System.out.println(cost3.matches(MATCHER));
//        System.out.println(cost4.matches(MATCHER));
//        System.out.println(cost5.matches(MATCHER));

//        String cat = "Manufacturer - ingredients";
//        String newCat = cat.replaceAll("[Mm]anufacturer\\W+", "");
//        System.out.println(convertFromUpperToLowerCase(newCat));


//        String id = "3_81";
//        String id = "4_8";
//        String id = "5_";
//        System.out.println(id);
//        String tmp = id;
//        System.out.println(tmp.replaceAll("_\\d*", ""));

//        String catName = "abcd_32";
////        String catName = "abcd_3";
////        String catName = "abcd_";
//        System.out.println(getCategoryId(catName));
////        getCategoryId(catName);

//        String s = "1564%";
////        String s = "1%";
////        String s = "%";
//        System.out.println(getCategoryId(s));
////        getCategoryId(catName);

//        String fileStr = "d:\\hello\\test.txt";
//        String fileStr = "d:\\hello\\test";
//        String fileStr = "d:\\hello\\test - Copy 1.txt";
//        String fileStr = "d:\\hello - Copy 1\\test - Copy 6";
//        File file = new File(fileStr);
//        String fileName = file.getName();
//
//        String prefix = " - Copy ";
//        int prefixNumber = 1;
//
////        System.out.println(fileName.replaceAll("."));
//
//        int prefixIndex = fileName.lastIndexOf(prefix);
//        System.out.println(prefixIndex);
//        if(prefixIndex > -1) {
//
//            Pattern pattern = Pattern.compile(prefix + "\\d+");
//            Matcher matcher = pattern.matcher(fileName);
//            while(matcher.find()){
//                String tmp = matcher.group();
//                System.out.println(tmp);
//                prefixNumber = Integer.parseInt(tmp.replace(prefix, ""));
//                System.out.println(prefixNumber);
//                fileName=fileName.replaceAll(prefix + "\\d+", "");
//            }
//            prefixNumber++;
//
//        }
//        StringBuilder sb = new StringBuilder(fileName);
//        int charNumber = fileName.contains(".") ? fileName.lastIndexOf(".") : fileName.length();
//        sb.insert(charNumber, " - Copy "+prefixNumber);
//        System.out.println(sb.toString());

//        String query = "select * from _schema_version order by id desc limit 1";
//        String upperCaseQuery = query.toUpperCase();
//        System.out.println(upperCaseQuery);
//        String[] queryWordArray = upperCaseQuery.split("[^A-Z_]+");
////        String[] queryWordArray = upperCaseQuery.split("[^\\w]");
////        System.out.println(Arrays.toString(queryWordArray));
//        for(String oneWord : queryWordArray){
//            System.out.println(">"+oneWord+"<");
//        }

//        String txt = "Doctors,Hygienists,Assistants,Lab Technicians,Staff,General Attendees";
//        String regex = "(\\w[,.:;])(\\w)";
////        String newTxt = txt.replaceAll(regex, "$1 $2");
//        String newTxt = txt.replaceAll(regex, "$1\r\n$2");
//        System.out.println(txt);
//        System.out.println(newTxt);

//        String price = "340.0000";
//        System.out.println(roundOf(price));

        System.out.println(getDatabaseUrl("jck"));


        // hello
        // <b>world</b>
        // , and
        // <b>you</b>
        // !
//        String bold = "hello <b>world</b>, and <b>you</b>!";
//        String separatorPattern = "\\.*<b>\\.+</b>\\.*";
//        String[] strings = bold.split(separatorPattern);

        String string = "asldkf*asdf";
        String regex = "*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        if(m.find()){
            System.out.println(m.group(0));
        }
    }

    public static String getDatabaseUrl(String edition){
        return String.format("jdbc:postgresql://localhost:5432/%s", edition);
    }

    protected static String roundOf(String str){
        Double price = Double.parseDouble(str);
        return String.valueOf(price.intValue());
    }

    private static boolean isCategoryNameDisctount(String categoryName){
        Pattern p = Pattern.compile("^\\d+%$");
        Matcher m = p.matcher(categoryName);
        if(m.find()) {
            System.out.println(m.group(0));
            return true;
        }
//        while(m.find()){
//            System.out.println(m.group());
//        }
        return false;
    }

    private static String getCategoryId(String categoryName){
        Pattern p = Pattern.compile("\\d+$");
        Matcher m = p.matcher(categoryName);
        if(m.find()){
            return m.group(0);
        }
//        while(m.find()){
//            System.out.println(m.group());
//        }
        return null;
    }

    private static String convertIntoUpperCase(String name) {
        String res = "";
//        res = name.toUpperCase().replaceAll("[^com.everything.A-Z0-9]", "_");
        res = name.toUpperCase().replaceAll("\\W+", "_");
        return res;
    }

    private static String convertFirstLetterIntoUpperCase(String name) {
        String res = "";
//        res = name.toUpperCase().replaceAll("[^com.everything.A-Z0-9]", "_");
        res = name.toUpperCase().replaceAll("\\W+", "_");
        return res;
    }

    private static String merge(String d, String t) {
        String res = "";
        res = d.replaceAll("(T[0-9\\:]*)", t.substring(t.indexOf("T")));
        return res;
    }

    private static String convertFromUpperToLowerCase(String upperCaseString) {
        String lowerCase = upperCaseString.toLowerCase();
        String onlyFirstUpperCase = lowerCase.replaceAll("^.", lowerCase.substring(0, 1).toUpperCase());
        return onlyFirstUpperCase;
    }
}
