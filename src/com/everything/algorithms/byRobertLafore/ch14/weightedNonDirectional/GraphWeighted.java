package com.everything.algorithms.byRobertLafore.ch14.weightedNonDirectional;

import com.everything.algorithms.byRobertLafore.ch14.EdgeCh14;
import com.everything.algorithms.byRobertLafore.ch14.PriorityQueueEdge;
import com.everything.algorithms.byRobertLafore.ch14.VertexCh14;

/**
 * User: Makar Kalancha
 * Date: 29/01/2015
 * Time: 09:37
 */
public class GraphWeighted {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1_000_000;
    private VertexCh14[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int currentVert;
    private PriorityQueueEdge thePQ;
    private int nTree;

    public GraphWeighted() {
        vertexList = new VertexCh14[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        thePQ = new PriorityQueueEdge();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new VertexCh14(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void putInPQ(int newVert, int newDist) {
        EdgeCh14 edgeCh14 = thePQ.findByDestanation(newVert);
        if (edgeCh14 != null) {
            int oldDist = edgeCh14.distance;
            if (oldDist > newDist) {
                thePQ.removeN(edgeCh14);
                EdgeCh14 theEdge = new EdgeCh14(currentVert, newVert, newDist);
                thePQ.insert(theEdge);
            }
        } else {
            EdgeCh14 theEdge = new EdgeCh14(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }

    }

    //minimum spanning tree, weighted
    public void mstw() {
        currentVert = 0;
        while (nTree < nVerts - 1) {
            vertexList[currentVert].isInTree = true;
            nTree++;

            //insert edges adjacent to currentVert into PQ
            for (int j = 0; j < nVerts; j++) {
                if (j == currentVert) {
                    continue;
                }

                if(vertexList[j].isInTree){
                    continue;
                }

                int distance = adjMat[currentVert][j];
                if (distance == INFINITY) {
                    continue;
                }

                putInPQ(j, distance);

            }

            if (thePQ.size() == 0) {
                System.out.println(" GRAPH NOT CONNECTED");
                return;
            }

            //remove edge with minimum distance, from PQ
            EdgeCh14 theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            //display edge from source to current
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }

        //mst is complete
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }
}
