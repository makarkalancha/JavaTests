package com.everything;

/**
 * User: Makar Kalancha
 * Date: 11/11/13
 * Time: 11:38 AM
 */
public class PolygonTest {
    public static void main(String [] args){
        int sides = 4;


//        float[] coordX = {
//                2724f,
//                2724f,
//                6298f,
//                6298f
////                ,2724f
//        };
//        float[] coordY = {
//                1005f,
//                2458f,
//                2458f,
//                1005f
////                ,1005f
//        };
        ////inside
//        com.everything.Point test = new com.everything.Point(2768f,2153f);
//        com.everything.Point test = new com.everything.Point(2768f,2393f);
//        com.everything.Point test = new com.everything.Point(3128f,2393f);
//        com.everything.Point test = new com.everything.Point(3128f,2153f);
//        com.everything.Point test = new com.everything.Point(3248f,2033f);
//        com.everything.Point test = new com.everything.Point(3248f,2393f);
//        com.everything.Point test = new com.everything.Point(3488f,2393f);
//        com.everything.Point test = new com.everything.Point(3488f,2033f);
        ////outside
//        com.everything.Point test = new com.everything.Point(18368f,3953f);
//        com.everything.Point test = new com.everything.Point(6368f,1433f);

        float[] coordX = {
                1f,
                5f,
                5f,
                1f
        };
        float[] coordY = {
                2f,
                2f,
                4f,
                4f
        };
        Point test = new Point(2f,2f);

        Polygon p = new Polygon(sides,coordX,coordY,test);

        p.precalc_values();
        System.out.println(p.pointInPolygon());

    }
}

class Polygon {
    int    polySides;
    float  polyX[];
    float  polyY[];
    float  x, y;
    float  constant[];
    float  multiple[];

    Polygon(int polySides,float  polyX[],float  polyY[],Point testP){
        this.polySides = polySides;
        this.polyX = polyX;
        this.polyY = polyY;
        this.x = testP.x;
        this.y = testP.y;
        this.constant = new float[polyX.length];
        this.multiple = new float[polyX.length];
    }

    void precalc_values() {

        int i, j=polySides-1 ;

        for(i=0; i<polySides; i++) {
            if(polyY[j]==polyY[i]) {
                constant[i]=polyX[i];
                multiple[i]=0;
            }
            else {
//                float a=polyX[i];
//                float b=(polyY[i]*polyX[j])/(polyY[j]-polyY[i]);
//                float c=(polyY[i]*polyX[i])/(polyY[j]-polyY[i]);
                constant[i]=polyX[i]-(polyY[i]*polyX[j])/(polyY[j]-polyY[i])+(polyY[i]*polyX[i])/(polyY[j]-polyY[i]);
                multiple[i]=(polyX[j]-polyX[i])/(polyY[j]-polyY[i]);
            }
            j=i;
        }
    }

    boolean pointInPolygon() {

        int   i, j=polySides-1 ;
        boolean oddNodes=false;

        for (i=0; i<polySides; i++) {
            if ((polyY[i]< y && polyY[j]>=y || polyY[j]< y && polyY[i]>=y)) {
                oddNodes^=(y*multiple[i]+constant[i]<x);
            }
            j=i;
        }

        return oddNodes;
    }

    //  Globals which should be set before calling these functions:
//
//  int    polySides  =  how many corners the polygon has
//  float  polyX[]    =  horizontal coordinates of corners
//  float  polyY[]    =  vertical coordinates of corners
//  float  x, y       =  point to be tested
//
//  The following global arrays should be allocated before calling these functions:
//
//  float  constant[] = storage for precalculated constants (same size as polyX)
//  float  multiple[] = storage for precalculated multipliers (same size as polyX)
//
//  (Globals are used in this example for purposes of speed.  Change as
//  desired.)
//
//  USAGE:
//  Call precalc_values() to initialize the constant[] and multiple[] arrays,
//  then call pointInPolygon(x, y) to determine if the point is in the polygon.
//
//  The function will return YES if the point x,y is inside the polygon, or
//  NO if it is not.  If the point is exactly on the edge of the polygon,
//  then the function may return YES or NO.
//
//  Note that division by zero is avoided because the division is protected
//  by the "if" clause which surrounds it.

}

class InsideRectangleCheck {
    float  polyX[];
    float  polyY[];
    float  x, y;
    int polySides = 4;

    InsideRectangleCheck(float  polyX[],float  polyY[]){
        this.polyX = polyX;
        this.polyY = polyY;
    }

    void precalc_values() {

    }

    boolean pointInPolygon() {

        int   i, j=polySides-1 ;
        boolean oddNodes=false;

        for (i=0; i<polySides; i++) {
            if ((polyY[i]< y && polyY[j]>=y || polyY[j]< y && polyY[i]>=y)) {
//                oddNodes^=(y*multiple[i]+constant[i]<x);
            }
            j=i;
        }

        return oddNodes;


    }

    //  Globals which should be set before calling these functions:
//
//  int    polySides  =  how many corners the polygon has
//  float  polyX[]    =  horizontal coordinates of corners
//  float  polyY[]    =  vertical coordinates of corners
//  float  x, y       =  point to be tested
//
//  The following global arrays should be allocated before calling these functions:
//
//  float  constant[] = storage for precalculated constants (same size as polyX)
//  float  multiple[] = storage for precalculated multipliers (same size as polyX)
//
//  (Globals are used in this example for purposes of speed.  Change as
//  desired.)
//
//  USAGE:
//  Call precalc_values() to initialize the constant[] and multiple[] arrays,
//  then call pointInPolygon(x, y) to determine if the point is in the polygon.
//
//  The function will return YES if the point x,y is inside the polygon, or
//  NO if it is not.  If the point is exactly on the edge of the polygon,
//  then the function may return YES or NO.
//
//  Note that division by zero is avoided because the division is protected
//  by the "if" clause which surrounds it.

}

class Point{
    float x;
    float y;
    Point(float x, float y){
        this.x = x;
        this.y = y;
    }
}
