package algorithms.knapstack;

public class DPSolution {

    static int W;
    static int maxV=Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] wt={45,2,36,8};
        int[] v={5,24,2,33};
        W=45;
        int n=wt.length;

        System.out.println(knapsack(v,wt,n,W));

    }

    private static int knapsack(int[] v, int[] wt, int n, int W) {

        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)//get max
                    K[i][w]
                            = Math.max(v[i - 1]+ K[i - 1][w - wt[i - 1]],// this item + max value for remaining weight(w - wt[i - 1])
                            K[i - 1][w]);//do not add this item
                else
                    K[i][w] = K[i - 1][w];//do not add this item
            }
        }

        return K[n][W];
    }
}

