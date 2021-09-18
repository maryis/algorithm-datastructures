package  algorithms;

public class MaxStock {

    public static void main(String[] args) {
        int[] prices={1,3,6,52,8,7,53,120,41};
        int profit=getMaxProfit(prices);
        System.out.println("tha max profit: "+profit);

    }

    private static int getMaxProfit(int[] prices) {
        //for each day, the max profit= diff with max stock in the days before
        //to prevent repetitive calculation of max, we preserve the last max idx
        int maxProfit=Integer.MIN_VALUE;
        int lastMaxIdx=0;

        for(int i=1;i<prices.length;i++){
            if(prices[lastMaxIdx]>prices[i-1]){
                lastMaxIdx=i-1;
            }
            maxProfit=Math.max(maxProfit,prices[i]-prices[lastMaxIdx]);

        }
        return maxProfit;

    }
}
