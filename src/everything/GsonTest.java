package everything;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * User: Makar Kalancha
 * Date: 31/10/13
 * Time: 11:23 AM
 */
public class GsonTest {
    private Gson _gson = new Gson();
    private Path file_p = Paths.get("D:\\Tasks\\!_archive\\011_573_rsna_speaker\\json_test.js");

    public static void main(String [] args){
//        everything.GsonTest g = new everything.GsonTest();
//        String json = "";
//        BufferedReader br = null;
//        try{
//            br = new BufferedReader(new FileReader(g.file_p.toFile()));
//
//
//            String tmp = "";
//            while( (tmp = br.readLine()) != null){
//                System.out.println(tmp);
//                json += tmp;
//            }
//            System.out.println(g.file_p.toString());
//            System.out.println(tmp);
//            System.out.println(json);
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        everything.GsonTest.SomeData someData = g._gson.fromJson(json, everything.GsonTest.SomeData.class);
//        System.out.println(someData);
//

        String transform = "{\"image_resize\":{\"width\":170}}";
        System.out.println(transform);

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(transform);
//        JsonObject jsonObject  = (JsonObject) jsonParser.parse(transform);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject image_resize = jsonObject.getAsJsonObject("image_resize");
        int width = image_resize.getAsJsonPrimitive("width").getAsInt();

        System.out.println(image_resize);
        System.out.println(width);
//        gson.fromJson(transform, String.class);

    }

    public static class SomeData{
        private String PARENT;
        private String AM_ID;
        private String GUID;
        private String EM_ID;
        private String ACTIVE;

        @Override
        public String toString() {
            return "PARENT: "+PARENT+", AM_ID: "+AM_ID+", GUID: "+GUID+", EM_ID: "+EM_ID+", ACTIVE: "+ACTIVE+";";
        }

        public void setAM_ID(String am_id){
            if(am_id.equals("1")){
                this.AM_ID = "2";
            }
        }
    }
}
