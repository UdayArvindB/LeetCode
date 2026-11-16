class Solution {
    public int maxProfit(int[] prices) {
       int minPrice=prices[0];
       int maxProfit=0;
       int n=prices.length;
       for(int i=1; i<n; i++){
        int cost=prices[i]-minPrice;
        maxProfit=Math.max(maxProfit, cost);
        minPrice=Math.min(minPrice, prices[i]);
       }
       return maxProfit;
    }
}