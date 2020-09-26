package algorithms;

import java.util.Arrays;

public class NumOfWays {
    //Design an algorithm that finds the number of ways in which
    // you can traverse N meters by doing jumps of 1, 2, 3, 4, or 5 meter lengths. Assume that N can be a very large number.
    // What is the resulting complexity?

    static int noOfWays=0;
    public static void main(String[] args) {
        int N=3;
        dfs(N,0);//0 : sum of element till here
        System.out.println(noOfWays);

        System.out.println(dynamic(N));
    }

    private static void dfs(int N,int i) {
        if(i==N){
            noOfWays++;
            return;
        }
        if(i>N)
            return;

        dfs(N,i+1);
        dfs(N,i+2);
        dfs(N,i+3);
        dfs(N,i+4);
        dfs(N,i+5);
    }

    private static int dynamic(int N) {

        int[][] matrix=new int[5][N];
        for(int i=1;i<5;i++)
            matrix[i][0]=0;
        Arrays.fill(matrix[0],1);

        for(int i=1;i<5;i++)
            for(int j=1;j<N;j++){
                if(i<=j)
                    matrix[i][j]=1+Math.max(matrix[i-1][j],matrix[i][j-1]);
                else
                    matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
            }
        return matrix[4][N-1];
    }

}
