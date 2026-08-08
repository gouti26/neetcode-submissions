class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int buyPrice = prices[0];
        int sellPrice = 0;
        for(int i =1;i<n;i++){
            if(prices[i]<buyPrice){
                buyPrice = prices[i];
            }
            if(prices[i]>buyPrice){
                maxProfit = Math.max(maxProfit,prices[i]-buyPrice);
            }
        }
        return maxProfit;
    }
}
