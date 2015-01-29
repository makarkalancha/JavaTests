package everything.algorithms.byRobertLafore.ch14.weightedDirectional;

import everything.algorithms.byRobertLafore.ch14.EdgeCh14;
import everything.algorithms.byRobertLafore.ch14.PriorityQueueEdge;
import everything.algorithms.byRobertLafore.ch14.VertexCh14;

import javax.sound.midi.Soundbank;

/**
 * User: Makar Kalancha
 * Date: 29/01/2015
 * Time: 09:37
 */
public class GraphWeightedDirectional{
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1_000_000;
    private VertexCh14[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int currentVert;
    private int nTree;
    private DistanceParent[] sPath;
    private int startToCurrent;

    public GraphWeightedDirectional() {
        vertexList = new VertexCh14[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        sPath = new DistanceParent[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new VertexCh14(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    public int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;

        for (int j = 1; j < nVerts; j++) {
            // smaller than old one
            if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void adjustSPath() {
        //adjust values in shortest-path array sPath
        int column = 1;
        while (column < nVerts) {
            //if this column's vertex already in tree, skip it
            if (vertexList[column].isInTree) {
                column++;
                continue;
            }

            //calculate distance for one sPath entry
            //get edge from currentVert to column
            int currentToFringe = adjMat[currentVert][column];
            //add distance from start
            int startToFringe = startToCurrent + currentToFringe;
            //get distance of current sPath entry
            int sPathDist = sPath[column].distance;

            //compare distance from start with sPath entry
            if (startToFringe < sPathDist) {
                sPath[column].parentVertex = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");//B=

            if (sPath[j].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j].distance);
            }

            char parent = vertexList[sPath[j].parentVertex].label;
            System.out.print("(" + parent + ")  ");
        }
        System.out.println();
    }

    public void path(int startingVertexIndex) {
//        int startTree = 0;
        System.out.println("Starting vertex: "+vertexList[startingVertexIndex].label);
        int startTree = startingVertexIndex;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        //transfer row of distances from adjMat to sPath
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistanceParent(startTree, tempDist);
        }

        //until all vertices are in the tree
        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;

            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices: "+vertexList[indexMin].label);
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjustSPath();
        }

        displayPaths();

        nTree = 0;
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
        System.out.println("---------------------------------------------------");
    }

    public int getSize() {
        return nVerts;
    }
}
