package algorithms;

import java.util.Arrays;

public class LCS {

    //the length of longest common subsequent of two string
    //dynamic programming
    public static void main(String[] args) {

        String str1 = "abcdefg";
        String str2 = "cdefg";

        System.out.println(getLCS_DP(str1, str2, str1.length(), str2.length()));
    }

    //recursive : overlap
    private static int getLCS(String str1, String str2, int n1, int n2) {

        if (n1 == 0 || n2 == 0)
            return 0;

        int max = 0;
        if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1))
            max = getLCS(str1, str2, n1 - 1, n2 - 1) + 1;
        else
            max = Math.max(getLCS(str1, str2, n1 - 1, n2), getLCS(str1, str2, n1, n2 - 1));

        return max;

    }

    //dynamic programming
    private static int getLCS_DP(String str1, String str2, int n1, int n2) {

        int[][] matrix = new int[n1 + 1][n2 + 1];
        Arrays.fill(matrix[0], 0);
        for (int i = 0; i <= n1; i++) {
            matrix[i][0] = 0;
        }

        for(int i=1;i<=n1;i++)
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    matrix[i][j]=1+matrix[i-1][j-1];
                else
                    matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
            }
        return matrix[n1][n2];
    }

}
