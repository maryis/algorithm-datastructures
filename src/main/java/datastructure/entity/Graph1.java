package  datastructure.entity;

import java.util.*;

public class Graph1 {    // graph with List of LinkedList

    class Vertex {
        int data;

        public Vertex(int data) {
            this.data = data;
        }
    }

    Map<Vertex, LinkedList<Integer>> adjList;


    public void addEdge(int src, int desc) {
        Vertex v1 = new Vertex(src);
        Vertex v2 = new Vertex(desc);


        adjList.get(src).add(desc);

        adjList.get(desc).add(src);
    }

    public Vertex bfs(int root, int k) {//we should consider one node as starting point: root
        System.out.println("start of bfs search for " + k);
        Queue<Vertex> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Vertex(root));
        visited.add(root);


        while (!queue.isEmpty()) {
            Vertex newOne = queue.poll();
            if (newOne.data == k)
                return newOne;

            for (Integer item : adjList.get(newOne.data)) {

                if (!visited.contains((item))) {
                    visited.add(item);
                    queue.add(new Vertex(item));
                }
            }

            return null;
        }

        return null;

    }

    public Vertex dfs(int root, int k) {//we have to use visited list to avoid loop

        System.out.println("start of dfs search for " + k);
        Set<Integer> visited = new HashSet<>();

        Stack<Vertex> stack = new Stack<>();

        stack.push(new Vertex(root));
        visited.add(root);

        while (!stack.isEmpty()) {
            Vertex newOne = stack.pop();
            if (newOne.data == k)
                return newOne;

            adjList.get(newOne.data).forEach(item ->
                    stack.push(new Vertex(item))
            );
        }
        return null;
    }

}
