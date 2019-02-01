package com.everything.algorithms.byRobertLafore.ch14;

import com.everything.algorithms.byRobertLafore.ch14.weightedDirectional.GraphWeightedDirectional;
import com.everything.algorithms.byRobertLafore.ch14.weightedNonDirectional.GraphWeighted;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * User: Makar Kalancha
 * Date: 28/01/2015
 * Time: 14:35
 */
public class WGraphApp {
    public static void main(String[] args) {
//        WGraphApp.priorityQueueTest();

//        WGraphApp.priorityQueueGraphWTest();

//        WGraphApp.executeWeightedNonDirectionalGraph();

        WGraphApp.executeWeightedDirectionalGraph();
//        WGraphApp.executeWeightedDirectionalGraphFloyd();


    }

    public static void priorityQueueTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(20);
        priorityQueue.add(10);
        priorityQueue.add(50);
        priorityQueue.add(2);
        priorityQueue.add(5);

        System.out.println(Arrays.toString(priorityQueue.toArray()));

//        Iterator<Integer> integerIterator = priorityQueue.iterator();
//        while(integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//        }

        System.out.println("Priority content:");
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
            System.out.println(Arrays.toString(priorityQueue.toArray()));
        }
    }

    public static void priorityQueueGraphWTest(){
        PriorityQueueEdge priorityQueue = new PriorityQueueEdge();

//        priorityQueue.insert(20);
//        priorityQueue.insert(10);
//        priorityQueue.insert(50);
//        priorityQueue.insert(2);
//        priorityQueue.insert(5);
//
//        System.out.println("size: " + priorityQueue.size());
//        Iterator<EdgeCh14> integerIterator = priorityQueue.iterator();
//        while(integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//        }
//
//        priorityQueue.removeN(50);
//        System.out.println("peek min: " + priorityQueue.peekMin());
//        System.out.println("size: " + priorityQueue.size());
//
//        while(!priorityQueue.isEmpty()) {
//            System.out.println("remove min: " + priorityQueue.removeMin());
//        }
    }

    public static void executeWeightedNonDirectionalGraph() {
        GraphWeighted theGraph = new GraphWeighted();

        theGraph.addVertex('A'); //0
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4
        theGraph.addVertex('F'); //5

        theGraph.addEdge(0, 1, 6); //AB 6
        theGraph.addEdge(0, 3, 4); //AD 4
        theGraph.addEdge(1, 2, 10); //BC 10
        theGraph.addEdge(1, 3, 7); //BD 7
        theGraph.addEdge(1, 4, 7); //BE 7
        theGraph.addEdge(2, 3, 8); //CD 8
        theGraph.addEdge(2, 4, 5); //CE 5
        theGraph.addEdge(2, 5, 6); //CF 6
        theGraph.addEdge(3, 4, 12); //DE 12
        theGraph.addEdge(4, 5, 7); //EF 7

        System.out.println("Minimum Spanning Tree: ");
        theGraph.mstw();
        System.out.println();
    }

    public static void executeWeightedDirectionalGraph() {
        GraphWeightedDirectional theGraph = new GraphWeightedDirectional();

        theGraph.addVertex('A'); //0
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3
        theGraph.addVertex('E'); //4

        theGraph.addEdge(0, 1, 50); //AB 50
        theGraph.addEdge(0, 3, 80); //AD 80
        theGraph.addEdge(1, 2, 60); //BC 60
        theGraph.addEdge(1, 3, 90); //BD 90
        theGraph.addEdge(2, 4, 40); //CE 40
        theGraph.addEdge(3, 2, 20); //DC 20
        theGraph.addEdge(3, 4, 70); //DE 70
        theGraph.addEdge(4, 1, 50); //EB 50

        System.out.println("Shortest Path: ");
        for (int i = 0; i < theGraph.getSize(); i++) {
            theGraph.path(i);
        }

        theGraph.displayAdjMat();
        theGraph.algorithmFloyd();
        System.out.println();
        theGraph.displayAdjMat();
    }

    public static void executeWeightedDirectionalGraphFloyd() {
        GraphWeightedDirectional theGraph = new GraphWeightedDirectional();

        theGraph.addVertex('A'); //0
        theGraph.addVertex('B'); //1
        theGraph.addVertex('C'); //2
        theGraph.addVertex('D'); //3

        theGraph.addEdge(1, 0, 70); //BA 70
        theGraph.addEdge(1, 3, 10); //BD 10
        theGraph.addEdge(2, 0, 30); //CA 30
        theGraph.addEdge(3, 2, 20); //DC 20

//        System.out.println("Shortest Path: ");
//        for (int i = 0; i < theGraph.getSize(); i++) {
//            theGraph.path(i);
//        }

        theGraph.displayAdjMat();
        theGraph.algorithmFloyd();
        System.out.println();
        theGraph.displayAdjMat();
    }
}
