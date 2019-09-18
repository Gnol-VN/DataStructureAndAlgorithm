package graph;

import java.util.LinkedList;

/**
 * 1. Graph format: Adjacency List
 * 2. Graph data
 *    0----1----2
 *    |   /|   /
 *    | /  | /
 *    3    4
 */
public class MyGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        addEdge(graph,0,1);
        addEdge(graph,0,3);
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,1,4);
        addEdge(graph,2,4);
        printGraph(graph);
    }

    /**
     * Graph has a list vertices
     * Each vertex is a linkedlist, in which contains its neighbors (neighbors represent an integer)
     */
    static class Graph{
        int NumberOfVertices;
        LinkedList<Integer> listVertices[];

        public Graph(int numberOfVertices) {
            NumberOfVertices = numberOfVertices;
            listVertices = new LinkedList[numberOfVertices];

            //Init Vertices' neighbors. Each vertex has its neighbors
            for (int i = 0; i < numberOfVertices; i++) {
                listVertices[i] = new LinkedList<>();
            }
        }
    }

    //Add neighbor to the vertex
    static void addEdge(Graph graph, int src, int dst){
        graph.listVertices[src].add(dst);
        graph.listVertices[dst].add(src);
    }

    static void printGraph(Graph graph){
        int i = 0;
        for (LinkedList<Integer> vertex: graph.listVertices) {
            System.out.print(i);
            for(Integer neighbor:vertex){
                System.out.print("--->" + neighbor);
            }
            System.out.println();
            i++;
        }
    }
}
