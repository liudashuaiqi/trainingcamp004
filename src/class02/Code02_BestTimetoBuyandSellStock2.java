package class02;
//leetcode 测试,正确
public class Code02_BestTimetoBuyandSellStock2 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0){
            return 0;
        }
        int max = 0;
        for(int i = 1;i < prices.length;i++){
            max += prices[i] - prices[i-1] > 0? prices[i] - prices[i-1]:0;//我的写法
            //max += Math.max(prices[i] - prices[i-1], 0);//左的写法
        }
        return max;
    }
}
