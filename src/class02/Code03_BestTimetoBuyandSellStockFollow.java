package class02;

public class Code03_BestTimetoBuyandSellStockFollow {
    //k次交易
    //没有斜率优化的版本 时间复杂度 n^3
    //leetcode测试  正确
    public static int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        if(k > prices.length/2){
            return allTrans(k,prices);
        }
        int N = prices.length;
        int[][] dp = new int[N][k+1];
        int max = 0;
        for(int i = 1;i < N;i++){
            for(int j = 1;j <= k;j++){
                dp[i][j] = dp[i-1][j];
                for(int cnt = 0;cnt <=i;cnt++){
                    dp[i][j] = Math.max(dp[i][j],dp[cnt][j-1]+prices[i]-prices[cnt]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    //斜率优化的版本 leetcode测试正确
    public static int maxProfit1(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        if(k >= prices.length/2){
            return allTrans(k,prices);
        }
        int N = prices.length;
        int[][] dp = new int[N][k+1];
        int max = 0;
        for(int j = 1;j <= k;j++){
            int t = dp[0][j-1] - prices[0];
            for(int i = 1;i < N;i++){
                t = Math.max(t,dp[i][j-1]-prices[i]);
                dp[i][j] = Math.max(dp[i-1][j],t+prices[i]);
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public static int allTrans(int k, int[] prices){
        int max = 0;
        for(int i = 1;i < prices.length;i++){
            max += Math.max(prices[i]-prices[i-1],0);
        }
        return max;
    }
}
