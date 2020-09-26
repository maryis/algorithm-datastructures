package  datastructure;

import  datastructure.entity.Graph;

public class MainGraph {

    public static void main(String[] args) {

        Graph.Vertex v1=new Graph.Vertex(5);
        Graph.Vertex v2=new Graph.Vertex(45);
        Graph.Vertex v3=new Graph.Vertex(55);
        Graph.Vertex v4=new Graph.Vertex(75);
        Graph.Vertex v5=new Graph.Vertex(85);
        Graph.Vertex v6=new Graph.Vertex(55);
        Graph.Vertex v7=new Graph.Vertex(235);

        Graph myGraph =new Graph();
        myGraph.addNode(v1);
        myGraph.addNode(v2);
        myGraph.addNode(v3);
        myGraph.addNode(v4);
        myGraph.addNode(v5);
        myGraph.addNode(v6);
        myGraph.addNode(v7);

        myGraph.addEdge(v1,v2);
        myGraph.addEdge(v2,v3);
        myGraph.addEdge(v3,v4);
        myGraph.addEdge(v4,v5);
        myGraph.addEdge(v5,v6);
        myGraph.addEdge(v6,v7);

        Graph.Vertex res=myGraph.bfs(55);
        System.out.println(res);

        res=myGraph.dfs(111);
        System.out.println(res);

    }
}
