package everything.algorithms.byRobertLafore.ch13;

import java.util.LinkedList;

/**
 * User: Makar Kalancha
 * Date: 28/01/2015
 * Time: 10:58
 */
public class GraphDirected {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private char[] sortedArray;

    private LinkedList<Integer> theStack = new LinkedList<>();
    private LinkedList<Integer> theQueue = new LinkedList<>();

    public GraphDirected() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }

    //@return vert with no successors
    //(or -1 if no such verts
    public int noSuccessors(){
        boolean isEdge = false;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if(!isEdge){
                return row;
            }
        }
        return -1;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col+1];
        }
    }

    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }

            //delete row from adjMat
            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            //delete colfrom adjMat
            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts);
            }
        }
        nVerts--;
    }

    public void topo() {
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            //get a vertex with no successors, or -1
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }

            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        //verteces all gone; display sortedArray
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println();
    }

    public void connectivityTable() {
        for(int vertexId = 0 ; vertexId < nVerts;vertexId++) {
            vertexList[vertexId].wasVisited = true;
            displayVertex(vertexId);
            theStack.push(vertexId);

            while (!theStack.isEmpty()) {
                //get an unvisited vertex adjacent to stack top
                int v = getAdjUnvisitedVertex(theStack.peek()); //or theStack.peekFirst()
                if (v == -1) {
                    theStack.poll(); //or theStack.pollFirst()
                } else {
                    vertexList[v].wasVisited = true;
                    displayVertex(v);
                    theStack.push(v);
                }
            }

            //stack is empty, so we're done
            for (int j = 0; j < nVerts; j++) {
                vertexList[j].wasVisited = false;
            }
            System.out.println();
        }
    }

}
