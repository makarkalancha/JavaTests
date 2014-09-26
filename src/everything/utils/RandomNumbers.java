package everything.utils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 30/05/14
 * Time: 4:29 PM
 */
public class RandomNumbers {
    public static void main(String[] args) {
//        //white list
//        Set<Integer> whitelist = new TreeSet<>();
//        for (int i = 0; whitelist.size() < 100; i++) {
//            whitelist.add(getRandomIntNumber(1, 200));
//        }
//        try{
//            String filePath = Paths.get("").toAbsolutePath().toString()+"\\text.txt";
//            IOUtils iou = new IOUtils(filePath, false);
////            IOUtils.writeIntoFile(filePath,"",false);
//            for(int i : whitelist){
////                IOUtils.writeIntoFile(filePath,Integer.toString(i),true);
//                iou.writeIntoFile(Integer.toString(i));
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }

//        List<RandomWeird> whitelistLong = new ArrayList<>();
        Set<RandomWeird> whitelistLong = new HashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            whitelistLong.add(getWeirdRandom());
        }
        try{
            String filePath = Paths.get("").toAbsolutePath().toString()+"\\text_weird_set_1M.txt";
            IOUtils iou = new IOUtils(filePath, false);
//            IOUtils.writeIntoFile(filePath,"",false);
            for(RandomWeird i : whitelistLong){
//                IOUtils.writeIntoFile(filePath,Integer.toString(i),true);
                iou.writeIntoFile(i.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //// [lo,hi] - including lo and hi;
    public static int getRandomIntNumber(int lo, int hi) {
        Random r = new Random();
        return r.nextInt(hi - lo + 1) + lo;
    }

    public static long getWeirdRandomIntNumber() {
        Random rand = new Random();
        long token;

        do {

            token = rand.nextLong();
        } while (token < 1_000_000_000_000_000_000L);

        return token;
    }

    public static RandomWeird getWeirdRandom() {
        int i=1;


        Random rand = new Random();
        long token;

        long start = System.nanoTime();
        do {

            token = rand.nextLong();
            i++;
        } while (token < 1_000_000_000_000_000_000L);
//        token = rand.nextLon

        long end = System.nanoTime();
//        String duration = DateUtils.duration(end - start);
        String duration = Long.toString(end - start);
        RandomWeird weird = new RandomWeird();
        weird.times = i;
        weird.value = token;
        weird.duration = duration;
        return weird;
    }


    static class RandomWeird{
        public int times;
        public long value;
        public String duration;

        @Override
        public String toString() {
            return "RandomWeird{" +
                    "value=" + value +
                    ", times=" + times +
                    ", duration='" + duration + '\'' +
                    '}';
        }
    }


}
