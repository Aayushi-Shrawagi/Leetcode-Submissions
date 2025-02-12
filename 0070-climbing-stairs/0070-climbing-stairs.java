class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0||i==1) dp[i]=1;
            else{
                dp[i]=0;
            }
        }
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    
    }
}