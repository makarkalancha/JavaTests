package everything;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: Makar Kalancha
 * Date: 13/12/13
 * Time: 1:42 PM
 */
public class Encoding {
    public static void main(String[] args) {
//        String email = "gshand@interiordesign.net";
//        String email = "0157";
        String email = "rcowdrey@advanstar.com";   //"fd6c073b9db995ae0b2b385fba0bc9e0"
//        String email = "qwe";
//        String email = "33556";
//        String email = "92708";
//        byte[] emailInBytes = email.getBytes();
        try{
            MessageDigest md1 = MessageDigest.getInstance("MD5");
            md1.reset();
            md1.update(email.getBytes(Charset.forName("UTF8")));
//            byte[] mdInBytes = md1.digest(emailInBytes);
            byte[] mdInBytes = md1.digest();
            String result = new String(Hex.encodeHex(mdInBytes));
            System.out.println(result);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

          ////md5 is one way algorithm
//        System.out.println("+++++++++++++++++++++++++++");
//        String stringInMd5 = "4de01bab35532822cbf98d9bdbb3634c";
//        try{
//            byte[] md5InByte = Hex.decodeHex(stringInMd5.toCharArray())
//            MessageDigest md2 = MessageDigest.getInstance("UTF8");
//            md2.reset();
//            md2.update(stringInMd5.getBytes(Charset.forName("MD5")));
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
