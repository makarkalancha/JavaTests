package com.everything.algorithms.byRobertLafore.ch13;

import java.util.LinkedList;

/**
 * User: Makar Kalancha
 * Date: 27/01/2015
 * Time: 13:48
 */
public class GraphApp {
    public static void main(String[] args) {
//        GraphApp.linkedLists();

//        GraphApp.graphDFS();

//        GraphApp.graphBFS();

//        GraphApp.graphMST();

        GraphApp.graphMSTHelpWGraph();

//        GraphApp.graphDirectedTopologSort();

//        GraphApp.graphDirectedConnTable();
    }

    public static void linkedLists() {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(5);

        System.out.println("peek:" + stack.peek());
        System.out.println("peekFirst:" + stack.peekFirst());
        System.out.println("peekLast:" + stack.peekLast());
        System.out.println();
        System.out.println("poll:" + stack.poll());
        System.out.println("pollFirst:" + stack.pollFirst());
        System.out.println("pollLast:" + stack.pollLast());
        System.out.println("pop:" + stack.pop());
    }

    public static void graphDFS() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4

        theGraph.addEdge(0,1); //AB
        theGraph.addEdge(1,2); //BC
        theGraph.addEdge(0,3); //AD
        theGraph.addEdge(3,4); //DE

        System.out.print("Visits depth-first-search: ");
        theGraph.dfs();
        System.out.println();
    }

    public static void graphBFS() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4

        theGraph.addEdge(0,1); //AB
        theGraph.addEdge(1,2); //BC
        theGraph.addEdge(0,3); //AD
        theGraph.addEdge(3,4); //DE

        System.out.print("Visits breadth-first-search: ");
        theGraph.bfs();
        System.out.println();
    }

    public static void graphMST() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4

        theGraph.addEdge(0, 1); //AB
        theGraph.addEdge(0, 2); //AC
        theGraph.addEdge(0, 3); //AD
        theGraph.addEdge(0, 4); //AE
        theGraph.addEdge(1, 2); //BC
        theGraph.addEdge(1, 3); //BD
        theGraph.addEdge(1, 4); //BE
        theGraph.addEdge(2, 3); //CD
        theGraph.addEdge(2, 4); //CE
        theGraph.addEdge(3, 4); //DE

        System.out.print("Minimum Spanning Tree: ");
        theGraph.mst();
        System.out.println();
    }

    public static void graphMSTHelpWGraph() {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4
        theGraph.addVertex('F'); //5

        theGraph.addEdge(0, 1); //AB
        theGraph.addEdge(0, 3); //AD
        theGraph.addEdge(1, 2); //BC
        theGraph.addEdge(1, 3); //BD
        theGraph.addEdge(1, 4); //BE
        theGraph.addEdge(2, 3); //CD
        theGraph.addEdge(2, 4); //CE
        theGraph.addEdge(2, 5); //CF
        theGraph.addEdge(3, 4); //DE
        theGraph.addEdge(4, 5); //EF

        System.out.print("Minimum Spanning Tree: ");
        theGraph.mst();
        System.out.println();
    }

    public static void graphDirectedTopologSort() {
        GraphDirected theGraph = new GraphDirected();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4
        theGraph.addVertex('F'); //5
        theGraph.addVertex('G'); //6
        theGraph.addVertex('H'); //7

        theGraph.addEdge(0,3); //AD
        theGraph.addEdge(0,4); //AE
        theGraph.addEdge(1,4); //BE
        theGraph.addEdge(2,5); //CF
        theGraph.addEdge(3,6); //DG
        theGraph.addEdge(4,6); //EG
        theGraph.addEdge(6,7); //GH
        theGraph.addEdge(5,7); //FH

        System.out.print("Topological Sort: ");
        theGraph.topo();
    }

    public static void graphDirectedConnTable() {
        GraphDirected theGraph = new GraphDirected();
        theGraph.addVertex('A'); //0 (starts for dfs)
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4
        theGraph.addVertex('F'); //5
        theGraph.addVertex('G'); //6
        theGraph.addVertex('H'); //7

        theGraph.addEdge(0, 2); //AC
        theGraph.addEdge(1, 0); //BA
        theGraph.addEdge(1, 4); //BE
        theGraph.addEdge(3, 4); //DE
        theGraph.addEdge(4, 2); //EC

        System.out.println("Connectivity Table:");
        theGraph.connectivityTable();
    }
}
