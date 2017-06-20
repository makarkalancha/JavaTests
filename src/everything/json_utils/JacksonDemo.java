package everything.json_utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.util.EnumSet;

/**
 * Created by Makar Kalancha
 * Date: 13 Jun 2017
 * Time: 15:49
 */
public class JacksonDemo {
    private enum Color{
        RED, GREEN, BLUE, YELLOW, BROWN, BLACK;
    }

    private static class Picture{
        private EnumSet<Color> colors;
        private int number;
        private String name;

        public Picture() {
            super();
        }

        public Picture(EnumSet<Color> colors, int number, String name) {
            this.colors = colors;
            this.number = number;
            this.name = name;
        }

        public EnumSet<Color> getColors() {
            return colors;
        }

        public void setColors(EnumSet<Color> colors) {
            this.colors = colors;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Picture{" +
                    "colors=" + colors +
                    ", number=" + number +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Picture pictureOut = new Picture(EnumSet.of(Color.RED, Color.GREEN), 10, "name-10");
        String valueOut = objectMapper.writeValueAsString(pictureOut);
        System.out.println(valueOut);

        String valueIn1 = "{\"colors\":[\"YELLOW\",\"BLACK\"],\"number\":46,\"name\":\"title-23\"}";
        Picture pictureIn1 = objectMapper.readValue(valueIn1, Picture.class);
        System.out.println(pictureIn1);

        String valueIn2 = "{\"colors\":[\"YELLO\",\"BLACK\"],\"number\":46,\"name\":\"title-23\"}";
        try {
            Picture pictureIn2 = objectMapper.readValue(valueIn2, Picture.class);
            System.out.println(pictureIn2);
        }catch (InvalidFormatException e){
            System.out.println("e.getCause(): " + e.getCause());
            System.out.println();
            System.out.println("e.getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println();
            System.out.println("e.getMessage(): " + e.getMessage());
            System.out.println();
            System.out.println("e.getOriginalMessage(): " + e.getOriginalMessage());
            System.out.println();
            System.out.println("e.getValue(): " + e.getValue());
        }
    }
}
