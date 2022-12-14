package  datastructure;

import datastructure.entity.graph.Graph2;

public class MainGraph {

    public static void main(String[] args) {

        Graph2.Vertex v1=new Graph2.Vertex(5);
        Graph2.Vertex v2=new Graph2.Vertex(45);
        Graph2.Vertex v3=new Graph2.Vertex(55);
        Graph2.Vertex v4=new Graph2.Vertex(75);
        Graph2.Vertex v5=new Graph2.Vertex(85);
        Graph2.Vertex v6=new Graph2.Vertex(55);
        Graph2.Vertex v7=new Graph2.Vertex(235);

        Graph2 myGraph =new Graph2();
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

        Graph2.Vertex res=myGraph.bfs(55);
        System.out.println(res);

        res=myGraph.dfs(111);
        System.out.println(res);

    }
}
