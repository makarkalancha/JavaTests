package com.everything.algorithms.byRobertLafore.ch14.weightedDirectional;

/**
 * User: Makar Kalancha
 * Date: 29/01/2015
 * Time: 11:53
 */
public class DistanceParent {
    public int distance;
    public int parentVertex;

    public DistanceParent(int pv, int d) {
        this.distance = d;
        this.parentVertex = pv;
    }
}
