package class02;
//leetcode 测试,正确
public class Code01_BestTimetoBuyandSellStock1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int maxBenefit = 0;
        for(int i = 0;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            maxBenefit = Math.max(maxBenefit,prices[i]-min);
        }
        return maxBenefit;
    }
}
