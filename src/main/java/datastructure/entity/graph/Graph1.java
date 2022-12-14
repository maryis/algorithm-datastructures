package datastructure.entity.graph;

import java.util.*;

public class Graph1 {

    Map<Integer, List<Vertex>> adjList;
    Vertex root = null;

    public void addEdge(Vertex a, Vertex b) {
        //with this way of adding edge, we make graph undirected
        adjList.get(a.idx).add(b);
        adjList.get(b.idx).add(a);
        if (root == null) root = a;
    }

    /**
     * this only works if the graph is connected,
     * otherwise we need an upper loop
     * @param k : value to search for
     * @return node index
     */
    public int bfsSearch(int k) {
        System.out.println("start of bfs search for " + k);
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Vertex newOne = queue.poll();
            if (newOne.value == k)
                return newOne.idx;
            for (Vertex item : adjList.get(newOne.value)) {
                if (!visited.contains((item))) {
                    visited.add(item);
                    queue.add(item);
                }
            }
        }
        return -1;
    }

    /**
     * this only works if the graph is connected,
     * otherwise we need an upper loop
     * @param k : value to search for
     * @return node index
     */
    public int dfs(int k) {
        System.out.println("start of dfs search for " + k);
        Set<Vertex> visited = new HashSet<>();
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            Vertex newOne = stack.pop();
            if (newOne.value == k)
                return newOne.idx;
            for (Vertex item : adjList.get(newOne.value)) {
                if (!visited.contains((item))) {
                    visited.add(item);
                    stack.push(item);
                }
            }
        }
        return -1;
    }

    static class Vertex {
        int idx;
        int value;
        public Vertex(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
