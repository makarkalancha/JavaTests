package everything;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 11/11/13
 * Time: 11:38 AM
 */
public class PolygonTestV2 {
    int    boothSides = 4;
//    float  polyX[];
//    float  polyY[];
    Set<GeoZonePoint> parent;

//    float  x, y;
    BigDecimal[]  constant = new BigDecimal[4];
    BigDecimal[]  multiple = new BigDecimal[4];

    PolygonTestV2(Set<GeoZonePoint> p){
        this.parent = p;
    }

    int check(Set<GeoZonePoint> ch){
        precalc_values();
        System.out.println("precalc done");
        int count=0;
        for(GeoZonePoint point : ch){
            if(pointInPolygon(point.rawx,point.rawy)){
                count++;
            }
        }
        System.out.println("count="+count);
        return count;
    }

    void precalc_values() {

        int i, j=boothSides-1 ;

        for(i=0; i<boothSides; i++) {
//            if(parent.get(j).rawy==parent.get(i).rawy) {
//                constant[i] = parent.get(i).rawx;
//                multiple[i]=new BigDecimal(0);
//            }
//            else {
//                BigDecimal divisor = (parent.get(j).rawy.subtract(parent.get(i).rawy));
//                BigDecimal dividendA = parent.get(i).rawy.multiply(parent.get(j).rawx);
////                System.out.println("dividendA="+dividendA);
////                System.out.println("divisor="+divisor);
////                System.out.println("dividendA.equals(0)="+dividendA.equals(0));
////                System.out.println("divisor.equals(0)="+divisor.equals(0));
//                BigDecimal a = (dividendA.equals(new BigDecimal(0)) || divisor.equals(new BigDecimal(0))) ? new BigDecimal(0) : dividendA.divide(divisor, 3, BigDecimal.ROUND_HALF_UP);
//                BigDecimal dividendB = parent.get(i).rawy.multiply(parent.get(i).rawx);
//                BigDecimal b = (dividendB.equals(new BigDecimal(0)) || divisor.equals(new BigDecimal(0))) ? new BigDecimal(0) : dividendB.divide(divisor, 3, BigDecimal.ROUND_HALF_UP);
//                constant[i]=parent.get(i).rawx.subtract(a).add(b);
//
//                BigDecimal dividendC = parent.get(j).rawx.subtract(parent.get(i).rawx);
//                BigDecimal divisorC = parent.get(j).rawy.subtract(parent.get(i).rawy);
//                multiple[i]=(dividendC.equals(new BigDecimal(0)) || divisorC.equals(new BigDecimal(0))) ? new BigDecimal(0) : dividendC.divide(divisorC, 3, BigDecimal.ROUND_HALF_UP);
//            }
//            j=i;
        }
    }

    boolean pointInPolygon(BigDecimal x, BigDecimal y) {

        int   i, j=boothSides-1 ;
        boolean oddNodes=false;

        for (i=0; i<boothSides; i++) {
//            if ((parent.get(i).rawy.compareTo(y) == -1) && (parent.get(j).rawy.compareTo(y) == 1 || parent.get(j).rawy.compareTo(y) == 0)
//                    || (parent.get(j).rawy.compareTo(y)==-1) && (parent.get(i).rawy.compareTo(y)==1 || parent.get(i).rawy.compareTo(y)==0)) {
//                oddNodes^= ( (y.multiply(multiple[i]).add(constant[i])).compareTo(x) == -1);
//            }
            j=i;
        }

        return oddNodes;
    }

    public static void main(String [] args){
//        List<GeoZonePoint> parent = new ArrayList<GeoZonePoint>();
        Set<GeoZonePoint> parent = new HashSet<GeoZonePoint>();
//        parent.add(new GeoZonePoint(new BigDecimal(2724),new BigDecimal(1005)));
//        parent.add(new GeoZonePoint(new BigDecimal(2724f), new BigDecimal(2458f)));
//        parent.add(new GeoZonePoint(new BigDecimal(6298f), new BigDecimal(2458f)));
//        parent.add(new GeoZonePoint(new BigDecimal(6298f), new BigDecimal(1005f)));
//        parent.add(new GeoZonePoint(new BigDecimal(2724f), new BigDecimal(1005f)));
        parent.add(new GeoZonePoint(new BigDecimal(1), new BigDecimal(2)));
        parent.add(new GeoZonePoint(new BigDecimal(5), new BigDecimal(2)));
        parent.add(new GeoZonePoint(new BigDecimal(5), new BigDecimal(4)));
        parent.add(new GeoZonePoint(new BigDecimal(1), new BigDecimal(4)));
        parent.add(new GeoZonePoint(new BigDecimal(1), new BigDecimal(2)));

//        List<GeoZonePoint> child = new ArrayList<GeoZonePoint>();
        Set<GeoZonePoint> child = new HashSet<GeoZonePoint>();
//        child.add(new GeoZonePoint(new BigDecimal(2768f), new BigDecimal(2153f)));
//        child.add(new GeoZonePoint(new BigDecimal(2768f), new BigDecimal(2393f)));
//        child.add(new GeoZonePoint(new BigDecimal(3128f), new BigDecimal(2393f)));
//        child.add(new GeoZonePoint(new BigDecimal(3128f), new BigDecimal(2153f)));
//        child.add(new GeoZonePoint(new BigDecimal(2768f), new BigDecimal(2153f)));
        //inside
        child.add(new GeoZonePoint(new BigDecimal(1.5f), new BigDecimal(2.5f)));
        child.add(new GeoZonePoint(new BigDecimal(2.5f), new BigDecimal(2.5f)));
        child.add(new GeoZonePoint(new BigDecimal(2.5f), new BigDecimal(3.5f)));
        child.add(new GeoZonePoint(new BigDecimal(1.5f), new BigDecimal(3.5f)));
        child.add(new GeoZonePoint(new BigDecimal(1.5f), new BigDecimal(2.5f)));
//        ////outside
//        child.add(new GeoZonePoint(new BigDecimal(6), new BigDecimal(3)));
//        child.add(new GeoZonePoint(new BigDecimal(8), new BigDecimal(3)));
//        child.add(new GeoZonePoint(new BigDecimal(8), new BigDecimal(4.5f)));
//        child.add(new GeoZonePoint(new BigDecimal(8), new BigDecimal(4.5f)));
//        child.add(new GeoZonePoint(new BigDecimal(6), new BigDecimal(3)));

        PolygonTestV2 p = new PolygonTestV2(parent);
        p.check(child);
//        p.precalc_values();
//        System.out.println(p.pointInPolygon());

    }

    static class GeoZonePoint{
        BigDecimal rawx;
        BigDecimal rawy;
        GeoZonePoint(BigDecimal x, BigDecimal y){
            this.rawx = x;
            this.rawy = y;
        }

        @Override
        public int hashCode ()
        {
            return rawx.hashCode() + rawx.hashCode();
        }
        @Override
        public boolean equals (Object obj)
        {
            Class clazz = getClass();
            if (obj == null || !clazz.equals(obj.getClass()))
            {
                return false;
            }
            else
            {
                return rawx == ((GeoZonePoint)obj).rawx && rawy == ((GeoZonePoint)obj).rawy;
            }
        }

    }

}
