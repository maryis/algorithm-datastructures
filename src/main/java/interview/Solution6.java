package interview;

import java.util.ArrayList;
import java.util.List;

//public class ConstructGraphWithSlashes {
public class Solution6 {
    static int[][] dirs = new int[][] {{0, 1}, {0, - 1}, {1, 0}, {- 1, 0}};

    static boolean[] visited = new boolean[16];
    public static void main(String[] args) {
        char[][] slashes = {{'/', '\\', ' '},
                {' ', '/', ' '},
                {' ', ' ', '/'}};

        List<List<Integer>> graph = new ArrayList<>();
        constructGraph(slashes, graph);

        List<List<Integer>> paths = new ArrayList<>();

        dfs(graph, paths, new ArrayList<Integer>(), 0);
        for(int i=0; i<16; i++) {
            System.out.print(i+":");
            graph.get(i).stream().forEach(System.out::print);
            System.out.println("");
        }

        paths.get(0).stream().forEach(i -> System.out.print(i+" "));
    }

    private static void dfs(List<List<Integer>> graph, List<List<Integer>> paths, List<Integer> path, int i) {
        if(i==15) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int dest : graph.get(i)) {
            if(!visited[dest]) {
                visited[dest] = true;
                path.add(dest);
                dfs(graph, paths, path, dest);
                path.remove(path.size()-1);
                visited[dest] = false;
            }
        }
    }

    private static void constructGraph(char[][] slashes, List<List<Integer>> graph) {

        for(int i=0; i<4*4; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++) {
                if(i==0 || i==3) {
                    if(j-1>=0) {
                        graph.get(i * 4 + j).add(i * 4 + j - 1);
                        graph.get(i * 4 + j - 1).add(i * 4 + j);
                    }
                }
                if(j==0 || j==3) {
                    if(i-1>=0) {
                        graph.get(i * 4 + j).add((i-1) * 4 + j);
                        graph.get((i-1) * 4 + j).add(i * 4 + j);
                    }
                }
            }

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++) {
                if(slashes[i][j] == '\\') {
                    if(i+1<4 && j+1<4) {
                        graph.get(i * 4 + j).add((i + 1) * 4 + j + 1);
                        graph.get((i + 1) * 4 + j + 1).add(i * 4 + j);
                    }
                }
                if(slashes[i][j] == '/') {
                    if(i+1<4 && j+1<4) {
                        graph.get(i * 4 + j + 1).add((i + 1) * 4 + j);
                        graph.get((i + 1) * 4 + j).add(i * 4 + j + 1);
                    }
                }
            }
        return;
    }
}