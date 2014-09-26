package everything.strings;

import everything.utils.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.IOException;

/**
 * User: Makar Kalancha
 * Date: 01/08/14
 * Time: 1:03 PM
 */
public class HtmlParsers {
    public static void main(String[] args) {
        String htmlPath = "D:\\SRC\\Java_work_dir\\test\\files\\Parsing.htm";
        String htmlDestination = "D:\\SRC\\Java_work_dir\\test\\files\\Parsing_output.html";
        String htmlFileInString = null;
        try {
            IOUtils ioUtils = new IOUtils(htmlPath);
            htmlFileInString = ioUtils.readFromFile();
            System.out.println("before: >"+htmlFileInString+"<");

            Whitelist whitelist = new Whitelist();
            whitelist.addTags("br", "p");
            String cleanHtml = Jsoup.clean(htmlFileInString, whitelist);
            System.out.println("after: >"+cleanHtml+"<");
            IOUtils ioUtils1 = new IOUtils(htmlDestination,false);
            ioUtils1.writeIntoFile(cleanHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
