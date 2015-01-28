package everything.algorithms.byRobertLafore.ch13;

import java.util.LinkedList;

/**
 * User: Makar Kalancha
 * Date: 27/01/2015
 * Time: 11:41
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;

    private LinkedList<Integer> theStack = new LinkedList<>();
    private LinkedList<Integer> theQueue = new LinkedList<>();

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
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

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

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
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.add(0);

        while (!theQueue.isEmpty()) {
            //get an unvisited vertex adjacent to stack top
            int current = getAdjUnvisitedVertex(theQueue.peek());
            if (current == -1) {
                theQueue.remove(); //or theStack.poll()
            } else {
                vertexList[current].wasVisited = true;
                displayVertex(current);
                theQueue.add(current);
            }
        }

        //stack is empty, so we're done
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    //minimum spanning tree
    public void mst(){
        vertexList[0].wasVisited = true;
        theStack.push(0);

        while(!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            //get next unvisited neighbour
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print("  ");
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
}
