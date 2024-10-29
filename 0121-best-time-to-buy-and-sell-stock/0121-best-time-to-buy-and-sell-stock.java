class Solution {
    public int maxProfit(int[] prices) {
        int min_price=Integer.MAX_VALUE,max_profit=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            if(min_price>prices[i]){
                min_price=prices[i];
            }
            if(max_profit<prices[i]-min_price)
                max_profit=prices[i]-min_price;
        }
        return max_profit;
    }
}