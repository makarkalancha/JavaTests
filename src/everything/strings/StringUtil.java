package everything.strings;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * User: Makar Kalancha
 * Date: 04/08/14
 * Time: 3:02 PM
 */
public class StringUtil {
    public static final String UTF8 = "UTF-8";
    public static final String MD5 = "MD5";
    public static final String EMPTY = "";
    public static final String SHERPA_KEY_ALPHABET = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main (String[] args) {
//        char[] separators = {'&', ',', '/', '-'};
//        String[] booths = {"A410 & 10223",
////                "N/A",
//                "6300/5350/5300",
//                "5500",
//                "8400 - Scottish Pavilion ",
//                "10221, 10227, 8525",
//                "9320 & 9414   - Korean Pavilion"
//        };
//        for(String booth : booths){
//            List<String> parsed = explode(booth,separators);
//            for(String oneBooth : parsed){
//                System.out.print(">"+oneBooth+"<, ");
//            }
//            System.out.println();
//        }
        String[] names = {"Tuition (Dentist)",
                "Course Topic",
                "Speaker(s)",
                "Tuition (Aux)"
        };
        for(String name : names){
            System.out.println(convertStringToCamelCase(name));
        }

        int oneInt = 1;
        Long twoLong = 2L;
        System.out.println(String.format("message int=%s; long = %s", oneInt, twoLong));
        System.out.println(format(Integer.toString(oneInt), twoLong.toString()));
    }

    private static String format(String... param){
        return String.format("message int=%s; long = %s", param);
    }

    // remove left and right spaces
    public static String strip(String string)
    {
        if (isEmpty(string))
        {
            return EMPTY;
        }

        return StringUtils.strip(string);
    }

    @Deprecated
    public static String html2txt (String html)
    {
        if (isEmpty(html))
        {
            return EMPTY;
        }

        // guard-clause needed, as the Jason.parse would remove line-breaks
        if (isHtml(html))
        {
            Document document = Jsoup.parse(html);
            document.select("br").append("\\n");
            document.select("p").prepend("\\n\\n");
            document.select("li").prepend("\\n-&nbsp;");
            String txt = document.text().replaceAll("\\\\n", "\n");
            return txt;
        }
        else
        {
            return html;
        }
    }

    public static String html2text (String html)
    {
        if (isEmpty(html))
        {
            return EMPTY;
        }

        String textWithEntities = Jsoup.parse(html.replaceAll("(?i)<br[^>]*>|(\\r\\n)", "br2n")).text(); //like "&lt;p&gt;" is converted to "<p>"
        String textCleanFromEntities = Jsoup.parse(textWithEntities).text();
        String textWithCarriageReturn = textCleanFromEntities.replaceAll("br2n", "\r\n");

        return textWithCarriageReturn;
    }

    public static String selectiveClean(String html, List<String> tagToKeep)
    {
        if (isEmpty(html) || isEmpty(tagToKeep))
        {
            return EMPTY;
        }

        Whitelist whitelist = new Whitelist();
        whitelist.addTags(tagToKeep.toArray(new String[tagToKeep.size()]));
        String cleanHtmlWithTagsToKeep = Jsoup.clean(html, whitelist);
        return cleanHtmlWithTagsToKeep;
    }

    public static String html2xhtml (String html)
    {
        if (isEmpty(html))
        {
            return EMPTY;
        }

        Document document = Jsoup.parse(html);
        return document.html();
    }

    // http://stackoverflow.com/questions/3052052/how-to-find-if-string-contains-html-data
    public static boolean isHtml(String text)
    {
        String xtxt = text.replace("\n", "")
                .replace("\r", "")
                .replace("( )+", " ");
        String txt = Jsoup.parse(xtxt).text();

        return !xtxt.equals(txt);
    }

    public static String trim(String str){

        if(!StringUtil.isEmpty(str)){
            return str.trim();
        }

        return str;
    }

    public static String clean(String str)
    {
        if (isEmpty(str))
        {
            return EMPTY;
        }
        return str.replace((char)65533, ' ');
    }

    /**
     * This method ensures that the output String has only
     * valid XML unicode characters as specified by the
     * XML 1.0 standard. For reference, please see
     * <a href="http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char">the
     * standard</a>. This method will return an empty
     * String if the input is null or empty.
     *
     * @param in The String whose non-valid characters we want to remove.
     * @return The in String, stripped of non-valid characters.
     */
    public static String stripNonValidXMLCharacters(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in))) return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            if ((current == 0x9) ||
                    (current == 0xA) ||
                    (current == 0xD) ||
                    ((current >= 0x20) && (current <= 0xD7FF)) ||
                    ((current >= 0xE000) && (current <= 0xFFFD)) ||
                    ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }

    public static String md5(String str)
    {
        if (str == null)
        {
            return null;
        }

        try
        {
            byte[] bytes = str.getBytes(UTF8);
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] xbytes = md.digest(bytes);
            return new String(HexBin.encode(xbytes)).toLowerCase();
        }
        catch (UnsupportedEncodingException e)
        {
            throw new IllegalStateException("Unable to generate md5", e);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("Unable to generate md5", e);
        }
    }

    /**
     * - "good enough"..
     */
    public static boolean isMd5(String/*Null*/ str)
    {
        if (isEmpty(str))
        {
            return false;
        }

        if (str.length() != 32)
        {
            return false;
        }

        for (int i=0; i < str.length(); i++)
        {
            Character aChar = str.charAt(i);
            if (!Character.isLetterOrDigit(aChar))
            {
                return false;
            }
        }

        return true;
    }

    public static String randomSherpaKey ()
    {
        StringBuilder buff = new StringBuilder();
        for (int i=0 ; i<6 ; i++)
        {
            double j = Math.random() * 61d;
            buff.append(SHERPA_KEY_ALPHABET.charAt((int)j));
        }
        return buff.toString();
    }

    public static String fixUrl(String url)
    {
        if (isEmpty(url))
        {
            return url;
        }

        String xurl = url.toLowerCase();
        if (xurl.startsWith("www") || (!xurl.startsWith("http://") && !xurl.startsWith("https://")))
        {
//            if (xurl.startsWith("twitter.com") || xurl.startsWith("facebook.com") || xurl.startsWith("linkedin.com"))
//            {
//                xurl = "http://www." + url;
//            }
//            else
//            {
            xurl = "http://" + url;
//            }
            boolean valid = isUrlValid(xurl);
            return valid ? xurl : url;
        }
        else
        {
            return url;
        }
    }

    public static boolean isUrlValid(String url){
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        try
        {
            return urlValidator.isValid(encodeUrl(url));
        }
        catch(IllegalStateException e)
        {
            return false;
        }
    }

    public static String encodeUrl(String url){
        String result = "";
        try{
            URL urlObj = new URL(url);
            URLCodec codec = new URLCodec();
            String protocol = urlObj.getProtocol();
            String host = codec.encode(urlObj.getHost());
            String[] path = StringUtils.split(urlObj.getPath(),'/');
            for(int i = 0;i < path.length;i++){
                path[i] = codec.encode(path[i]);
            }
            result = new URL(protocol,host,"/"+ StringUtils.join(Arrays.asList(path), "/")).toString();
        }catch (MalformedURLException e){
            throw new IllegalStateException("Unable to encode url : " + url, e);
        }catch (EncoderException e){
            throw new IllegalStateException("Unable to encode url : " + url, e);
        }

        return result;
    }

    public static boolean isEmpty (String str)
    {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty (List list)
    {
        return list == null || list.size() == 0;
    }

    public static List<String> explode (String str, char separator)
    {
        return explode(str, separator, true);
    }
    public static List<String> explode (String str, char separator, boolean ignoreEmpty)
    {
        if (isEmpty(str))
        {
            return Collections.EMPTY_LIST;
        }
        else
        {
            StringBuilder separators = new StringBuilder();
            separators.append(separator);
            return split(str, separators.toString(), ignoreEmpty);
        }
    }

    public static List<String> explode (String str, char[] separators) {
        List<String> result = new ArrayList<>();
        for (char separator : separators) {
            if (str.indexOf(separator) != -1) {
//                result.addAll(explode(str, separator, true));
                result = explode(str, separator, true);
                break;
            }
        }

        if(result.size() == 0) {
            result.add(str);
        }

        return result;
    }

    public static List<String> split(String str, String separators)
    {
        return split(str, separators, true);
    }

    public static List<String> split(String str, String separators, boolean ignoreEmpty)
    {
        if (isEmpty(str))
        {
            return Collections.EMPTY_LIST;
        }
        else
        {
            StringTokenizer tokenizer = new StringTokenizer(str, separators);
            List<String> result = new ArrayList<String>();
            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken().trim();
                if (isEmpty(token) && ignoreEmpty)
                {
                    continue;
                }
                result.add(token);
            }
            return result;
        }
    }

    public static String merge(Collection<String> tokens, String separator)
    {
        StringBuilder sb = new StringBuilder();
        for (String token : tokens)
        {
            if (!isEmpty(token))
            {
                if (sb.length() > 0)
                {
                    sb.append(separator);
                }
                sb.append(token);
            }
        }
        return sb.toString();
    }

    public static <T> String mergeObjects(Collection<T> tokens, String separator)
    {
        StringBuilder sb = new StringBuilder();

        for (T token : tokens)
        {
            if (token != null)
            {
                if (sb.length() > 0)
                {
                    sb.append(separator);
                }
                sb.append(token.toString());
            }
        }
        return sb.toString();
    }

    public static String merge(String[] tokens, String separator)
    {
        return merge(Arrays.asList(tokens), separator);
    }

    public static boolean toBool (String str)
    {
        return "Y".equalsIgnoreCase(str) || "Yes".equalsIgnoreCase(str) || "True".equalsIgnoreCase(str);
    }

    public static boolean isValidImage(String path)
    {
        if (isEmpty(path))
        {
            return false;
        }
        else
        {
            String xpath = path.toLowerCase();
            return xpath.endsWith(".png")
                    || xpath.endsWith(".jpg")
                    || xpath.endsWith(".jpeg")
                    || xpath.endsWith(".gif");
        }
    }

    public static String convertFirstLetterToUpperCase(String string) {
        String lowerCase = string.toLowerCase();
        String onlyFirstUpperCase = lowerCase.replaceAll("^.", lowerCase.substring(0, 1).toUpperCase());
        return onlyFirstUpperCase;
    }

    public static String convertStringToCamelCase(String string) {
        StringBuilder sb = new StringBuilder();
        String cleanString = string.replaceAll("[^A-Za-z0-9_\\s]", "");
        String[] subStrings = cleanString.split("\\s+");
//        String[] subStrings = string.split("\\s+");
        for (String subString : subStrings) {
            if (!isEmpty(subString)) {
                subString = subString.replaceAll("\\(|\\)", "");
                subString = convertFirstLetterToUpperCase(subString);
//                System.out.println(subString);
                sb.append(subString);
            }
        }

        return sb.toString();
    }
}
