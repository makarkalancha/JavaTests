package everything.strings;

import everything.fileUtils.FileUtils;
import org.jsoup.Jsoup;
import sun.net.www.content.audio.x_aiff;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Makar Kalancha
 * Date: 02/01/14
 * Time: 11:02 AM
 */
public class StringTest {
    public static void main(String[] args) {
////        String str = "99.png";
////        System.out.println(str.substring(0,str.lastIndexOf('.')));
//
////        String nonNullString = "hello";
////        String nullString = null;
////        System.out.println(nonNullString.trim()+"_"+nullString);
//
////        String s1 = "RAFA&#322;";
////        String s2 = "&#39511;&#35657;&#24744;&#30340;&#38651;&#23376;&#37109;";
////        System.out.println(s1+"->"+ Jsoup.parse(s1).text());
////        System.out.println(s2+"->"+ Jsoup.parse(s2).text());
//
////        String s = "&lt;p&gt;Your chance to put questions to our speakers - interactive discussion and Q&amp;com.test.everything.A, led by the Chair&lt;/p&gt;";
////        String s = "Men&rsquo;s health";
////        String s = "Protein p&#226;t&eacute;s";
////        String s = "<img border=\"0\" src=\"http://www2.iscwest.com/images/180/2014_Conference/identiv.gif\" width=\"200\" height=\"29\">";
//        String s = "<img border=\\\"0\\\" src=\\\"http://image.email-reedexpo.com/lib/fe671570756602747314/m/1/2014-LMV-Logo_BLACK.gif\\\" width=\\\"200\\\" height=\\\"43\\\">";
////        String s = "Panel of industry experts representing policy experts, providers, payers, suppliers and patients\\r\\nModerated by Steve Miff, PhD, Senior Vice President, Clinical Care & Delivery Solutions\\r\\n<br><br>\\r\\nThe Affordable Care Act is transforming health care as the implementation of regulations reach the patient and consumer level in 2014. Still, questions remain whether health care systems have addressed the gaps that will allow them to be successful. In this session, various health care sector representatives and stakeholders will discuss the impact of how new requirements are being met. Audiences will hear how providers, payers and employers are mapping out new relationships to achieve their goals of better care, better value and healthier communities.\\r\\n<br><br>Objectives: <br>\\r\\n• Identify the most significant changes being implemented nationally or locally that will change care delivery and market dynamics<br><br>\\r\\n\\r\\n\\r\\n• Uncover the most innovative, yet practical thing that various healthcare stakeholders and sectors have implemented in 2013 and 2014<br><br>\\r\\n\\r\\n \\r\\n• Describe some key initiatives each stakeholder may need to implement in the next 24-36 months to be successful<br><br>\\r\\n\\r\\n\\r\\n\\r\\n1.0 Contact Hours (Physician, Nursing, Pharmacy, General CEU) <br>\\r\\n0.10 CEUs";
//        System.out.println(s);
////        System.out.println("->"+ Jsoup.parse(s).text());
////        System.out.println("->"+ Jsoup.parse(Jsoup.parse(s).text()).text());
////        System.out.println("->"+ StringEscapeUtils.unescapeHtml(s));
////        System.out.println("->"+ Jsoup.parse(StringEscapeUtils.unescapeHtml(s)).text());
//        String newS = Jsoup.parse(s.replaceAll("(?i)<br[^>]*>", "br2n")).text();
//        String newS1 = newS.replaceAll("br2n", "\n");
////        System.out.println("->"+ newS);
//        System.out.println("->" + newS1);

//        String imageTag = "<img border=\"0\" src=\"http://image.email-reedexpo.com/lib/fe671570756602747314/m/1/2014-LMV-Logo_BLACK.gif\" width=\"200\" height=\"43\">";
//        Document document = Jsoup.parse(imageTag);
//        Elements elements = document.select("img");
//        for(Element element : elements){
//            System.out.println(element.attr("src"));
//        }
//        Element firstElement = document.select("img").first();
//        System.out.println(firstElement.attr("src"));

//        String first = "first";
//        String second = "second";
//        String nullSt = null;
//        System.out.println(first+","+second+","+nullSt);


//        String prefix = "_pre_";
//        String string = "hello";
//        System.out.println("prefix:\t"+prefix);
//        System.out.println("string:\t"+string);
//        //prefix
//        String prefixString = prefix + string;
//        System.out.println("preStr:\t"+prefixString);
//        //unPrefix
//        String unPrefixString = prefixString.replace(prefix,"");
//        System.out.println("unPS:\t"+unPrefixString);
//
//        String str = "sherpa:$h3rp4d4t4";
//        System.out.println(new String(Base64.encodeBase64(str.getBytes())));


//        String s1 = "MODULE A4 - HEART HEALTH";
//        String s2 = "MODULE K1:OPENING KEYNOTE PANEL";
//        String s3 = "MODULE B7 - SPORTS & PERSONALISED NUTRITION";
//
////        String pattern = "MODULE\\s\\w+\\W";
////        String parent = s1.inreplaceAll(pattern, "");
////        System.out.println(parent);
//
//        System.out.println(getParentModule(s1));
//        System.out.println(getParentModule(s2));
//        System.out.println(getParentModule(s3));
//        System.out.println(getChildModule(s1));
//        System.out.println(getChildModule(s2));
//        System.out.println(getChildModule(s3));
//
//
//        String child = "";
//
//        String upperCase = "HEART HEALTH";
//        String firstUpperCase = upperCase.toLowerCase().replaceAll("^.", upperCase.substring(0, 1).toUpperCase());
////        firstUpperCase = firstUpperCase.
//        System.out.println(firstUpperCase);

//        String s = "925 sterling silver diamond studded designer palm bracelet jewelry.";
//        String s1 = "http://jcklv14.mapyourshow.com/MYS_Shared/jcklv14/specials/394995/PD9204-10K.jpg";
//        System.out.println(s.hashCode()+s1.hashCode());
//        String s2 = "925 sterling silver diamond studded designer palm bracelet jewelry.";
//        String s3 = null;
//        System.out.println(s2.hashCode()+s3.hashCode());

//        String columnName = "logo_file_resource_id";
////        String columnName = "_logo_file_resource_id";
//        System.out.println(columnName);
//        System.out.println(toFieldName(columnName));
//        System.out.println(toDaoClass(columnName));

//        Date now = new Date();
//        java.sql.Timestamp timestamp = new java.sql.Timestamp(now.getTime());
////        long tenSecondsMore = TimeUnit.SECONDS.toMillis((long) Math.pow(10L,3));
//        long tenSecondsMore = (long) Math.pow(TimeUnit.MILLISECONDS.toSeconds(10_000L),2);
//        java.sql.Timestamp timestamp10Sec = new java.sql.Timestamp(now.getTime()+tenSecondsMore);
//        System.out.println(timestamp);
//        System.out.println(tenSecondsMore);
//        System.out.println(timestamp10Sec);

//        String sql = String.format("DELETE FROM any WHERE id IN (%1$s)","2");
//        System.out.println(sql);

//        String fullName = "Chris Watts, Ph.D.";
////        String fullName = "Chris Watts";
//        Pattern pattern = Pattern.compile("(\\w+)\\s(\\w+)(,\\s([\\w+\\.]+))?");
////        Pattern pattern = Pattern.compile("(\\w+)\\s(\\w+),\\s([\\w+\\.]+)");
//        Matcher matcher = pattern.matcher(fullName);
//        if(matcher.find()){
//            System.out.println(matcher.groupCount());
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));//first name
//            System.out.println(matcher.group(2));//last name
//            if(matcher.groupCount() == 4 && matcher.group(4)!=null){
//                System.out.println(matcher.group(3));
//                System.out.println(matcher.group(4));//title
//            }
//        }

////        String str = "7220 -  Swiss Pavilion";
//        String str = "Swiss Pavilion";
//        String[] arr = str.split("-");
//        for(int i = 0 ; i < arr.length;i++){
//            System.out.println(i+">"+arr[i]+"<");
//        }
//        System.out.println("//////////////////////////////");
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(str);
//        if(matcher.find()) {
//            System.out.println("contains booth");
//        } else {
//            System.out.println("is a pavilion");
//        }

//        String fullName = "Dr. Walid Abdelwahab";
//        String firstName = "Walid";
//        String fullName = "Nima Abu Wardeh";
//        String firstName = "Nima ";
//        int titleEnd = fullName.indexOf(firstName);
//        System.out.println(titleEnd);
//        if(titleEnd > 0) {
//            String title = fullName.substring(0, titleEnd);
//            System.out.println(">"+title+"<");
//            System.out.println(">"+title.trim()+"<");
//        }

//        String date = "2014-11-05T09:00:00-05:00";
//        String[] arr = date.split(":");
////        for(String t : arr ){
////            System.out.println(t);
////        }
//        String pattern = "(\\d{4}-\\d{2}-\\w+:\\d{2}:.+)(:)(\\d{2})";
//        String toPattern = "$1$3";
//        if(date.matches(pattern)){
//            System.out.println("yes");
//            date = date.replaceAll(pattern,toPattern);
//            System.out.println(date);
//        } else{
//            System.out.println("NO");
//        }

//        String first = "1212#b6c691";
//        String second = "120C#e9a45b";
//        System.out.println("first:\t"+first.hashCode());
//        System.out.println("second:\t"+second.hashCode());

//        String first = "articleDetail";
//        String second = first.replaceAll("[dD]etail","");
//        System.out.println(first);
//        System.out.println(second);

//        String html = "<html>\n" +
//                " <head></head>\n" +
//                " <body>\n" +
//                "  <p></p>\n" +
//                "  <p><strong>Customer Reviews</strong>:&nbsp; For anyone interested, recently added the Absen A7 to its inventory. This has proven to be an awesome product for us and will without a doubt become our flagship LED product. Clients have been blown away by the picture quality, the weight savings, and the speed of install. Thank you Absen for making such a great product!—From Absen Facebook main page.</p>\n" +
//                "  <p style=\"text-align: center;\"><a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-1.jpg\"><img class=\"alignnone size-full wp-image-617\" alt=\"A7usa-1\" src=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-1.jpg\" height=\"309\" width=\"464\" />&nbsp;</a></p>\n" +
//                "  <p style=\"text-align: center;\"><a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-1.jpg\"></a> <a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-2.jpg\"><img class=\"alignnone size-full wp-image-618\" alt=\"A7usa-2\" src=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-2.jpg\" height=\"302\" width=\"471\" />&nbsp;</a></p>\n" +
//                "  <p style=\"text-align: center;\">&nbsp;<a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-3.jpg\"> <br /></a></p>\n" +
//                "  <p style=\"text-align: center;\"><a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-3.jpg\"></a> <a href=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-4.jpg\"><img class=\"alignnone size-full wp-image-620\" alt=\"A7usa-4\" src=\"http://www.usabsen.com/wp-content/uploads/2013/12/A7usa-4.jpg\" height=\"319\" width=\"494\" /></a>&nbsp;</p>\n" +
//                "  <p></p>\n" +
//                " </body>\n" +
//                "</html>";
//
//        System.out.println(html);
//        System.out.println(">>>"+html2text(html)+"<<<");

//        String first = "44B1_THE_CL_MEDICAL_MODEL_PRACTICE_CL_POSITIONING_AND_PRICING_STRATEGIES.pdf";
//        String first = "33B1_HOW _TO_USE_SOCIAL_MEDIA_TOOLS_TO_RECRUIT_AND_HIRE_A_PLAYERS.pdf";
//        String second = first.replaceAll("(^\\w{4}_)([\\w| ]+)(\\.pdf$)","$2");
//        String first = "Current Concepts in Ocular Surface Disease: The Dry Eye, Corneal Dystrophy, and Lid Disease";
//        String first = "My Patient Sees Double - What Should We Do?";
//        String first = "What's New in Eye Care?";
//        String first = "Seeing Your Practice With an Owner's Eye";
//        String first = "Corneacopia: \"See What You've Been Missing with Specular Microscopy\"";
//        String first = "Cracking the Code Clinical Case Management Medical Record Compliance, Part 1";
//        String first = "Cracking the Code Clinical Case Management Medical Record Compliance, Part 2";
//        String first = "Creating a Dry Eye Center from Start to Success - Part 1";
//        String first = "Diabetic Retinopathy from Diagnosis to Treatment";
//        String first = "Frame Buying 101";
//        String first = "\"Googlocation\" - Drive Traffic to Your Practice and Increase Your Visibility";
//        String first = "Sjogren's Syndrome: The New Dry Eye";
//        String first = "Modern Surgical and Post-Surgical Management for Keratoconus";
//        String first = "New Developments in Refrative Surgery";
//        String second = first.replace("'", "").
//                replaceAll("\\W+", "_").
//                replaceAll("(^_|_$)", "").
//                replaceAll("_(\\d)$", "$1").
//                toUpperCase();
//
//        System.out.println(first);
//        System.out.println(second);


//        String xml = "<ExhibitorName>TOPS&#xAE; &#xAE;Software Corporation&#xEC;</ExhibitorName>";
//        System.out.println(xml);
//        System.out.println(convertXmlHexToHtml(xml));

//        String fileToRead = "D:\\Tasks\\071_7244_aasld2014_mm\\2-data\\20141001\\vertical_tab.txt";
//        byte[] bytes = new byte[(int) new File(fileToRead).length()];
//        StringBuilder sb = new StringBuilder();
//        try{
//            FileUtils.readFileByBytes(fileToRead,bytes);
//            FileUtils.readFileIntoString(fileToRead,sb);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        for(byte b : bytes){
//            System.out.println(b+"->\""+((char)b)+"\"");
//        }
//        String badString = sb.toString();
//        System.out.println(badString);
//        String goodString = removeVerticalTab(badString);
//        System.out.println(goodString);
//        byte[] bytes1 = goodString.getBytes();
//        for(byte b : bytes1){
//            System.out.println(b+"->\""+((char)b)+"\"");
//        }

        String test = "103625/1";
//        String test = "103625/";
//        String test = "103625";
//        String test = "";
        String regex = "^(\\w+)(/\\w*)";
        test = test.replaceAll(regex,"$1");
        System.out.println(test);


    }

    private static String removeVerticalTab(String string) {
        return string.replaceAll("\\x0B", "");
    }

    private static String convertXmlHexToHtml(String xml){
        String result = "";
        String patternString  = "(&#x\\w{2};)";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(xml);
        int count = 0;
        while(matcher.find()) {
            count++;
            String hexNumber = matcher.group();
            System.out.println(count+":"+matcher.start()+"-"+matcher.end()+" "+matcher.group());
            String hexNumberInHtml = Jsoup.parse(hexNumber).text();
            System.out.println(hexNumberInHtml);
            xml = xml.replace(hexNumber, hexNumberInHtml);
        }

        return xml;
    }

    public static String html2text (String html) {

        html = html.replaceAll("(?i)<br[^>]*>|(\\r\\n)|(\\n)", "br2n");
        html = html.replaceAll("(?i)<[^<]*p>", "br2n");
        //32 space, Jsoup converts &nbsp; into 160 space and regex doesn't eat 160 space as \\s
        html = html.replaceAll("\\&nbsp;", String.valueOf((char)32));
//        if(html.contains("</p>")){
//            html = html.replaceAll("(?i)</p[^>]*>", "br2n");
//        } else {
//            html = html.replaceAll("(?i)<p[^>]*>", "br2n");
//        }

        String textWithEntities = Jsoup.parse(html).text(); //like "&lt;p&gt;" is converted to "<p>"
//        System.out.println(textWithEntities);
//        char[] chars = textWithEntities.toCharArray();
//        for(char ch : chars){
//            System.out.println(ch+":"+((int)ch));
//        }

        String textCleanFromEntities = Jsoup.parse(textWithEntities).text();
//        System.out.println(textCleanFromEntities);
//        char[] chars1 = textCleanFromEntities.toCharArray();
//        for(char ch : chars1){
//            System.out.println(ch+":"+((int)ch));
//        }

        textCleanFromEntities = textCleanFromEntities.replaceAll("^((br2n)+(\\s)*)+", "");
//        String textWithCarriageReturn = textCleanFromEntities.replaceAll("(br2n)+(\\s)*", "\r\n");

//        System.out.println(textCleanFromEntities);
//        char[] chars2 = textCleanFromEntities.toCharArray();
//        for(char ch : chars2){
//            System.out.println(ch+":"+((int)ch));
//        }
//        Pattern pattern = Pattern.compile("\\s+");
//        Matcher matcher = pattern.matcher(textCleanFromEntities);
//        while(matcher.find()){
//            System.out.print("group:>"+matcher.group()+"<; ");
//            System.out.print("previous char:>"+textCleanFromEntities.charAt(matcher.start()-1)+"<; ");
//            System.out.print("; start:" + matcher.start());
//            System.out.print("; end:" + matcher.end());
//            System.out.println();
//        }

        String textWithCarriageReturn = textCleanFromEntities.replaceAll("\\s*(br2n)+\\s*(br2n)*", "\r\n");
        textWithCarriageReturn = textWithCarriageReturn.replaceAll("\\s*$", "");


        return textWithCarriageReturn;
    }

    private static String toDaoClass(String columnName) {
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < columnName.length();i++) {
            if(columnName.charAt(i) == '_'){
                continue;
            }

            Character c = new Character(columnName.charAt(i));
            if(result.length()==0 || (i>2 && columnName.charAt(i-1) == '_')){
                c=Character.toUpperCase(c);
            }

            if (Character.isJavaIdentifierPart(c)) {
                result.append(c);
            }
        }
        result.append("Dao");
        return result.toString();
    }

    private static String toFieldName(String columnName) {
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < columnName.length();i++) {
            Character c = new Character(columnName.charAt(i));
            if(i>2 && columnName.charAt(i-1) == '_'){
                c=Character.toUpperCase(c);
            }

            if (Character.isJavaIdentifierPart(c) && !c.equals('_')) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String getParentModule(String string){
        Pattern pattern = Pattern.compile("MODULE\\s\\w+");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
//            System.out.println("group: >"+matcher.group()+"<");
//            System.out.println("parent end: "+matcher.end());
            return matcher.group();
        }
        return "";

//        return string.
    }

    private static String getChildModule(String string) {
        String noParent = string.replaceAll(getParentModule(string)+"\\W*","");
        return noParent;
    }
}
