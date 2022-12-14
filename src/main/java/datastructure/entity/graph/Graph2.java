package datastructure.entity.graph;

import java.util.*;

public class Graph2 {

    List<Vertex> nodes;

    public Graph2() {
        nodes = new ArrayList<>();
    }

    public void addNode(Vertex v) {
        nodes.add(v);
    }

    public void addEdge(Vertex a, Vertex b) {
        //with this way of adding edge, we make graph undirected
        a.adjacencyList.add(b);
        b.adjacencyList.add(a);
    }

    private void makeGraphNotVisited() {
        nodes.forEach(item -> item.visited = false);
    }

    /**
     * this only works if the graph is connected,
     * otherwise we need an upper loop
     * @param k
     * @return
     */
    public Vertex bfs(int k) {
        System.out.println("start of bfs search for " + k);
        if (nodes.isEmpty()) return null;

        Queue<Vertex> queue = new LinkedList<>();
        makeGraphNotVisited();
        queue.add(nodes.get(0));
        nodes.get(0).visited = true;

        while (!queue.isEmpty()) {
            Vertex newOne = queue.poll();
            if (newOne.data == k)  return newOne;
            newOne.adjacencyList.forEach(item -> {
                if (!item.visited) {
                    item.visited = true;
                    queue.add(item);
                }
            });
        }
        return null;
    }

    public Vertex dfs(int k) {
        System.out.println("start of dfs search for " + k);
        if (nodes.isEmpty()) return null;

        Deque<Vertex> stack = new ArrayDeque<>();
        makeGraphNotVisited();
        stack.push(nodes.get(0));
        nodes.get(0).visited = true;

        while (!stack.isEmpty()) {
            Vertex newOne = stack.pop();
            if (newOne.data == k) return newOne;
            newOne.adjacencyList.forEach(item -> {
                if (!item.visited) {
                    stack.push(item);
                    item.visited = true;
                }
            });
        }
        return null;
    }

    public boolean isCycle() {
        makeGraphNotVisited();
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).visited) {
                nodes.get(i).visited = true;
                if (hasCycle(nodes.get(i),null))
                    return true;
            }
        }
        return false;
    }

    public boolean hasCycle(Vertex node, Vertex parent) {
        List<Vertex> children = node.adjacencyList;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).visited && children.get(i) != parent)
                return true;
            if (hasCycle(children.get(i), parent))
                return true;
        }
        return false;
    }

    static class Vertex {
        int data;
        boolean visited;
        List<Vertex> adjacencyList;

        public Vertex(int data) {
            this.data = data;
            visited = false;
            adjacencyList = new ArrayList<>();
        }
    }
}

