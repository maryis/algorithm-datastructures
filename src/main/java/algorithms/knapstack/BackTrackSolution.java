package algorithms.knapstack;

public class BackTrackSolution {

    static int W;
    static int maxV=Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] wt={45,2,36,8};
        int[] v={5,24,2,33};
        W=45;
        int n=wt.length;

        knapsack(wt, v,0,0, 0);
        System.out.println(maxV);

    }

    private static void knapsack(int[] wt, int v[], int curW,int curV, int i) {
        if (i == v.length || curW >= W) {
            maxV=Math.max(curV, maxV);
            return;
        }

        if (curW + wt[i] <= W) {
            knapsack(wt, v, curW + wt[i],curV+v[i], i + 1);
        }
        knapsack(wt, v, curW,curV, i + 1);
    }

}
