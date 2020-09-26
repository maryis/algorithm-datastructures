package  datastructure.entity;

import java.util.*;

public class Graph {    // graph with vertexList


    //if we wants to represent graph with matrix:
//    int n;
//    boolean[][] AdjacencyMatrix;

    public static class Vertex {
        int data;
        boolean visited;
        List<Vertex> adjacencyList;

        public Vertex(int data) {
            this.data = data;
            visited = false;
            adjacencyList = new ArrayList<>();
        }
    }

    List<Vertex> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Vertex v) {
        nodes.add(v);
    }

    public void addEdge(Vertex a, Vertex b) {
        a.adjacencyList.add(b);
        b.adjacencyList.add(a);
    }

    private void makeGraphNotvisited() {
        nodes.forEach(item -> item.visited = false);
    }

    public Vertex bfs(int k) {
        System.out.println("start of bfs search for " + k);
        if (nodes.size() == 0)
            return null;

        Queue<Vertex> queue = new LinkedList<>();
        makeGraphNotvisited();

        queue.add(nodes.get(0));
        nodes.get(0).visited = true;

        while (!queue.isEmpty()) {
            Vertex newOne = queue.poll();
            if (newOne.data == k)
                return newOne;

            newOne.adjacencyList.forEach(item -> {
                if (!item.visited) {
                    item.visited = true;
                    queue.add(item);
                }
            });

        }

        return null;

    }

    public Vertex dfs(int k) {//we have to use visited list to avoid loop

        System.out.println("start of dfs search for " + k);

        if (nodes.size() == 0)
            return null;

        Stack<Vertex> stack = new Stack<>();
        makeGraphNotvisited();

        stack.push(nodes.get(0));
        nodes.get(0).visited = true;

        while (!stack.isEmpty()) {
            Vertex newOne = stack.pop();
            if (newOne.data == k)
                return newOne;

            newOne.adjacencyList.forEach(item -> {
                if (!item.visited) {
                    stack.push(item);
                    item.visited = true;
                }
            });

        }
        return null;
    }


}
