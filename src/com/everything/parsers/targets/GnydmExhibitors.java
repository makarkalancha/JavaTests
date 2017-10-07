package com.everything.parsers.targets;

import com.everything.parsers.gnydm.Exhibitor;
import com.everything.strings.StringUtil;
import com.everything.utils.fileUtils.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 24/09/14
 * Time: 2:02 PM
 */
public class GnydmExhibitors {
    public static void main(String[] args) {
        ////outer html
        String filePath = "D:\\Tasks\\067__gnydm2014_sd\\2-data\\20140923\\exhibitors_original.html";
        StringBuilder htmlString = new StringBuilder();
        try{
            FileUtils.readFileIntoString(filePath, htmlString);
//            System.out.println(htmlString);
        }catch(IOException e){
            e.printStackTrace();
        }

        String from = "<tr valign=\"TOP\"><td colspan=\"2\"><hr align=\"center\" size=\"2\" color=\"#999999\"></td></tr>";
        String to = "</tbody></table><table><tbody>";

        String htmlStringClean = htmlString.toString().replace(from, to);
        htmlStringClean = htmlStringClean.toString().replace("<td class=\"label\">&nbsp;</td>", "<td class=\"label\">Address1:</td>");
        htmlStringClean = htmlStringClean.toString().replace("&nbsp;", " ");
//        htmlStringClean = htmlStringClean.toString().replace("&nbsp;", Character.toString((char)32));

//        Document doc = Jsoup.parseBodyFragment(htmlString.toString());
        Document doc = Jsoup.parseBodyFragment(htmlStringClean);
        Elements tableRows = doc.getElementsByTag("table");
//        System.out.println(tableRows);
//        System.out.println(tableRows.size());
        List<Exhibitor> exhibitors = new ArrayList<>();
        mapElementToExhibitor(tableRows, exhibitors);
        int exhibitorIter = 1;
        for(Exhibitor exhibitor : exhibitors){
            exhibitor.setID("Exh"+exhibitorIter);
            System.out.println(exhibitor);
            exhibitorIter++;
        }
    }

    private static void getValue(Element elem, String rowHeader, Exhibitor exhibitor){
        Elements rows = elem.select("tr:has(td:containsOwn("+rowHeader+"))");
        if(rows.size()==1 && rows.select("td").size() == 2) {
            try {
                exhibitor.getClass().getField(StringUtil.convertStringToCamelCase(rowHeader)).set(exhibitor, rows.select("td:nth-child(2)").text());
            }catch (NoSuchFieldException | IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    public static void mapElementToExhibitor(Elements elements, Collection<Exhibitor> exhibitorCollection) {
        Iterator<Element> iterator = elements.iterator();
        while(iterator.hasNext()) {
//            Exhibitor exhibitor = Exhibitor.createExhibitor();
            Exhibitor exhibitor = new Exhibitor();
            Element table = iterator.next();
            ///////////Exhibitor
            getValue(table,"Exhibitor:",exhibitor);
            ///////////Address
            getValue(table,"Address:",exhibitor);
            /////////Address1
            getValue(table,"Address1:",exhibitor);
            ///////////Country
            getValue(table,"Country:",exhibitor);
            ///////////Telephone
            getValue(table,"Telephone:",exhibitor);
            ///////////Fax
            getValue(table,"Fax:",exhibitor);
            ///////////WebSite
            getValue(table,"Web Site:",exhibitor);
            ///////////Booths
            getValue(table,"Booth(s):",exhibitor);


//            System.out.println(exhibitor);
//            break;
            if(exhibitor.Exhibitor != null){
                exhibitorCollection.add(exhibitor);
            }
        }
    }
}

