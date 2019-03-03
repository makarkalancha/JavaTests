package com.everything;

/**
 * Created with IntelliJ IDEA.
 * User: makar
 * Date: 13-10-15
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String [] args) {
//        int i = 10;
//        System.out.println("args = " + i);
//
//		System.out.println(Test.class.getName());
//
//        System.out.println(String.class.getName());
//        System.out.println(String.class.getSimpleName());
//
//        long l1 = 1409889600000L;
//        long l2 = 1382500800805L;
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(l1);
//        Date date1 = cal.getTime();
//        System.out.println(date1);
//
//        cal.setTimeInMillis(l2);
//        Date date2 = cal.getTime();
//        System.out.println(date2);
//
////        DateFormat df = new SimpleDateFormat("EEEE, MMMM d,yyyy K:mm aaa");
////        DateFormat df = new SimpleDateFormat("yyyy-MM-dd h:mm aaa");
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mma");
////        String tmp = "2014-01-23 8:30 PM";
//        String tmp = "01/14/2014 8:30AM";
////        System.out.println("now="+df.format(new Date()));
//        try{
//            System.out.println("now="+df.parse(tmp).toString());
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//
//        int processors = Runtime.getRuntime().availableProcessors();
//        System.out.println("available cpu: "+processors);
//
//        System.out.println(String.format("\t%2$4d\t%1$s", "Booth", 2846));
//        System.out.println(String.format("\t%2$4d\t%1$s","Category",4559));
//        System.out.println(String.format("\t%2$4d\t%1$s","test",1));
//
//        Random r = new Random();
//        for(int j = 0;j< 10;j++){
//            System.out.println(r.nextInt(30));
//        }

//        long total = 515_375_104L;
//        long free = 509_738_664L;
//        long mem1 = 1_480_088L;
//        long mem2 = 2_186_016L;
//        long mem = (mem2-mem1) / (1024*1024);
//        long a = mem2-mem1;
//        long b = (1024 * 1024);
//        long c = a / b;
//        System.out.println("mem:"+mem);
//        System.out.println("a / b = c:"+a+"/"+b+"="+c);

//        long SESSION_MAX_LENGTH = TimeUnit.HOURS.toMillis(1);
//        long SESSION_MAX_LENGTH1 = TimeUnit.HOURS.toSeconds(1);
//        System.out.println(SESSION_MAX_LENGTH);
//        System.out.println(SESSION_MAX_LENGTH1);
//        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date dateMin = sdf.parse("2014-05-23 18:18:37");
//            Date dateMax = sdf.parse("2014-05-25 10:16:35");
//            long eventTimeMin = dateMin.getTime();
//            long eventTimeMax = dateMax.getTime();
//            long diff = (eventTimeMax - eventTimeMin)/1000;
//            System.out.println(diff);
//            long diff1 = (eventTimeMax - eventTimeMin);
//            System.out.println(diff1);
//
//            System.out.println("old eventTimeMin:"+eventTimeMin);
//            System.out.println("old eventTimeMax:"+eventTimeMax);
//            if(diff > SESSION_MAX_LENGTH1) {
//                eventTimeMax = eventTimeMin + (SESSION_MAX_LENGTH1*1000);
//            }
//            System.out.println("new eventTimeMax:"+eventTimeMax);
//            Date newDateMin = new Date(eventTimeMin);
//            Date newDateMax = new Date(eventTimeMax);
//            System.out.println("new newDateMin:"+newDateMin);
//            System.out.println("new newDateMax:"+newDateMax);
//        }catch(ParseException e){
//            e.printStackTrace();
//        }

        String a = "a";
        String b = "a";
        System.out.println(a == b);
    }
}
