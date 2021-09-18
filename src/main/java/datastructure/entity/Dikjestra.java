package datastructure.entity;

import java.util.Arrays;

public class Dikjestra {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        shortPath(adjacencyMatrix);
    }

    private static void shortPath(int[][] mat) {
        int n=mat.length;

        int[] parents=new int[n];

        boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);

        int[] shortPath=new int[n];
        Arrays.fill(shortPath,Integer.MAX_VALUE);

        shortPath[0]=0;
        parents[0]=-1;//no_parent

        for(int i=0;i<n;i++){
            int curr=getMin(shortPath,visited);
            if(curr==-1)
                break;
            if(!visited[curr]){
                visited[curr]=true;

                for(int j=0;j<n;j++){
                    if(mat[curr][j]!=0 && shortPath[j]>shortPath[curr]+mat[curr][j]) {
                        shortPath[j] = shortPath[curr] + mat[curr][j];
                        parents[j]=curr;
                    }
                }

            }
        }
        printPaths(mat,shortPath,parents);
        return ;
    }

    private static void printPaths(int[][] mat, int[] shortPath, int[] parents) {
        for(int i=0;i<shortPath.length;i++){
            System.out.print(i+ " Dis:"+shortPath[i]+ "  -->");
            printPaths(i,parents);
            System.out.println("  "+i);
        }
    }

    private static void printPaths(int i, int[] parents) {
        if(parents[i]==-1)
            return;
        printPaths(parents[i],parents);
        System.out.print("  "+parents[i]);
    }

    private static int getMin(int[] shortPath, boolean[] visited) {
        int min=Integer.MAX_VALUE;
        int minIdx=-1;
        for(int i=0;i<shortPath.length;i++) {
            if (!visited[i] && shortPath[i] < min) {
                min = shortPath[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}
