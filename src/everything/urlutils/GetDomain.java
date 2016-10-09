package everything.urlutils;

import com.google.common.net.InternetDomainName;
import java.util.ArrayList;

/**
 * Created by mcalancea on 2015-09-21.
 */
public class GetDomain {

    public static void main(String[] args) {
        ArrayList<String> cases = new ArrayList<String>();
//        cases.add("www.google.com");
//        cases.add("google.com");
//        cases.add("ww.socialrating.it");
//        cases.add("www-01.hopperspot.com");
//        cases.add("wwwsupernatural-brasil.blogspot.com");
//        cases.add("xtop10.net");
//        cases.add("zoyanailpolish.blogspot.com");
//        cases.add("comp.infosystems.www.servers.unix");//false
//
        cases.add("https://www.google.ca/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=nhl");
//        cases.add("https://google.ca/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=nhl/kj;lkj/");
//        cases.add("http://desturl24-1.com");




        for(String url : cases) {
            String domain = InternetDomainName.from(cleanUrl(url)).topPrivateDomain().toString();
            System.out.println(url+"\t:\t"+domain);
        }
//        System.out.println("============================================================================");
//        try {
//            for(String urlString : cases) {
//                URL urlObj = new URL(urlString);
//                String domain = urlObj.getHost();
//                System.out.println(domain);
//            }
//        } catch (MalformedURLException e){
//            e.printStackTrace();
//        }

    }

    private static String removeProtocol(String urlWithProtocol) {
        return urlWithProtocol.replaceAll("^\\w+://", "");
    }

    private static String removeSubPath(String urlWithSubPath) {
        return urlWithSubPath.replaceAll("(.[^/]+)/(.+)", "$1");
    }

    private static String cleanUrl(String url) {
//        String cleanUrl = removeProtocol(url);
//        String cleanUrl1= removeSubPath(cleanUrl);
//        return cleanUrl1;
        return removeSubPath(removeProtocol(url));
    }

}
