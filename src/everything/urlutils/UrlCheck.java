package everything.urlutils;//import com.sun.deploy.util.StringUtils;
import org.apache.commons.lang.*;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

//import org.apache.commons.validator.UrlValidator;

/**
 * User: Makar Kalancha
 * Date: 19/11/13
 * Time: 5:02 PM
 */
public class UrlCheck {
    public static void main(String[] args) {
        String[] urls = {
//                "ftp://foo.bar.com/",           //
//                "http://www.google.com/foo.png",    //true
//                "www.google.com/foo.png",           //false
//                "google.com/foo.png",               //false
//                "foo.png",                          //false
//                "http://foo.png",                    //false
                "http://twitter.com/12345679",               //true
//                "twitter.com/12345679",               //
//                null,
//                "",
//                "http://desturl24-1.com",
                "http://www.test.com/#$%^('\\'l\\bileurlupdated2~~```!^@%#$^!%@#$^!%@#^$!%@#$^!%@^#$!%@",
                "http://www.testforeverandevermoreandagaina.com/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouette/alouett/"
            };

//        UrlValidator urlValidatorTest = new UrlValidator();
//        System.out.println("urlValidatorTest.isValid:" + urlValidatorTest.isValid("http://desturl24-1.com"));


        String[] schemes = {"http","https"};
        UrlValidator urlValidator1 = new UrlValidator(schemes, UrlValidator.NO_FRAGMENTS);
//        UrlValidator urlValidator1 = new UrlValidator(schemes);
//        System.out.println("urlValidator1");
        checkArr(urlValidator1, urls);
//
//        UrlValidator urlValidator2 = new UrlValidator();
//        System.out.println("urlValidator2");
//        checkArr(urlValidator2, urls);
//
//        System.out.println(TimeUnit.SECONDS.toMinutes(1000));
////        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
////        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(100)));
//        System.out.println(Arrays.toString(splitToComponentTimes(1000)));
//        System.out.println(Arrays.toString(splitToComponentTimes(10000)));

        //////2
////        File set_url_f = new File("D:\\Tasks\\022_validUrl\\set_url.txt");
//        File set_url_f = new File("D:\\Tasks\\022_validUrl\\set_url_v1.txt");
//        UrlValidator urlValidator3 = new UrlValidator(schemes);
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(set_url_f));
//            String line = null;
//            while( (line = br.readLine()) != null){
//                System.out.println(urlValidator3.isValid(line)+"\t"+line);
//                System.out.println("v0:"+encodeUrl(line));
//                System.out.println("v1:"+encodeUrlv1(line));
//                line = encodeUrl(line);
//                System.out.println(urlValidator3.isValid(line)+"\t"+line);
////                if(!urlValidator3.isValid(line)){
//////                    System.out.println(line);
//////                    URLCodec codec = new URLCodec();
//////                    line = codec.encode(line);
////                    System.out.println(urlValidator3.isValid(line)+"\t"+line);
////
////
////
//////                    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
//////                    url = uri.toURL();
//////                    System.out.println(urlValidator3.isValid(url.toString())+"\t"+url.toString());
////                }
////                else{
//
////                    System.out.println(urlValidator3.isValid(line)+"\t"+line);
////                }
//            }
               //////3
////            URL url = new URL("http://PGAMERCH14.mapyourshow.com/mys_shared/PGAMERCH14/specials/389283/1000QL-9-CVERLOOK-FANION-BANDERAS-FAHNEN-DRAPEAUX-PAVILLONS-_[GOLF-FLAG]-340x340.jpg");
////            System.out.println("getProtocol:"+url.getProtocol());
////            System.out.println("getUserInfo:"+url.getUserInfo());
////            System.out.println("getHost:"+url.getHost());
////            System.out.println("getPort:"+url.getPort());
////            System.out.println("getPath:"+url.getPath());
////            System.out.println("getQuery:"+url.getQuery());
////            System.out.println("getRef:"+url.getRef());
//
//            String urlTest = "http://PGAMERCH14.mapyourshow.com/mys_shared/PGAMERCH14/showfeatures/391226/Gant_Puce_magnétique.png";
////            String urlTest = "http://Gant_Puce_magnétique.png";
//            System.out.println(encodeUrl(urlTest));

//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    static void checkArr(UrlValidator url, String[] arr){
        for(String s : arr){
            System.out.println(url.isValid(s)+"\t"+s);
//            System.out.println(url.isValid(encodeUrl(s))+"\t"+s);
        }
    }



    public static String encodeUrl(String url){
        String result = "";
        try{
            if(url != null && url != ""){
//                System.out.println(">>>>url:"+url);

                URL urlObj = new URL(url);
                URLCodec codec = new URLCodec();
                String protocol = urlObj.getProtocol();
                String host = codec.encode(urlObj.getHost());
//                System.out.println(">>>>path:"+urlObj.getPath());
    //            String[] path = urlObj.getPath().split("/");
                String[] path = StringUtils.split(urlObj.getPath(),'/');
    //            for(String p : path){
    //                System.out.println(p);
    //                p = codec.encode(p);
    //                System.out.println(p);
    //            }
                for(int i = 0;i < path.length;i++){
                    path[i] = codec.encode(path[i]);
                }
                result = new URL(protocol,host,"/"+StringUtils.join(Arrays.asList(path),"/")).toString();
//                System.out.println(">>>>randomNumber: "+result);
            }
        }catch (MalformedURLException e){
//            e.printStackTrace();
            System.out.println(">>ERROR: url=" + url + "; MalformedURLException:" + e.getMessage());
        }catch (EncoderException e){
//            e.printStackTrace();
            System.out.println(">>ERROR: url="+url+"; EncoderException:"+e.getMessage());
        }

        return result;
    }

    public static String encodeUrlv1(String url)
    {
        String result = "";
        URLCodec codec = new URLCodec();
        try{
            result = codec.encode(url);
            result = result.replace("%3F","?");
            result = result.replace("%2F", "/");
            result = result.replace("%3A", ":");

        }catch (EncoderException e){
            e.printStackTrace();
        }
        return result;
    }


    public static int[] splitToComponentTimes(long biggy)
    {
        long longVal = biggy;
        int hours = (int) longVal / 3600;
        int remainder = (int) longVal - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;

        int[] ints = {hours , mins , secs};
        return ints;
    }

}
