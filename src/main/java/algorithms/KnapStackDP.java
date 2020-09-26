package  algorithms;

public class KnapStackDP { //knapsack

    public static void main(String[] args) {
        int n=4;
        int []wt=new int[]{45,2,36,8};
        int []v=new int[]{5,24,2,33};
        int W=45;

        //call fun
        knapsack(v,wt,n,W);

    }

    private static void knapsack(int[] v, int[] wt, int n, int W) {

        int[][] agg_values = new int[n][W];//rows: items  columns:weights
        //column j shows agg_values for items up to j kg

        for (int i = 0; i < n; i++) { //i th item
            for (int j = 0; j < W; j++) {
                if (i == 0 || j == 0)
                    agg_values[i][j] = 0;

                else if (wt[i - 1] <= j) {//weight of ith item is less than j(j:weight)
                    agg_values[i][j] = Math.max(v[i - 1] + agg_values[i - 1][j - wt[i - 1]], v[i - 1]);
                } else
                    agg_values[i][j] = v[i - 1];

                System.out.print(agg_values[i][j] + " ");
            }
            System.out.printf("\n");


        }
    }
}
