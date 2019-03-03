package com.everything.algorithms.byRobertLafore.ch14;

/**
 * User: Makar Kalancha
 * Date: 29/01/2015
 * Time: 09:33
 */
public class EdgeCh14 implements Comparable<EdgeCh14>{
    public int srcVert;
    public int destVert;
    public int distance;

    public EdgeCh14(int sv, int dv, int d) {
        this.srcVert = sv;
        this.destVert = dv;
        this.distance = d;
    }

    @Override
    public int compareTo(EdgeCh14 edge) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.distance > edge.distance){
            return AFTER;
        }

        if(this.distance == edge.distance){
            return EQUAL;
        }

        //if(this.distance < edge.distance){
        return BEFORE-1;
    }
}
