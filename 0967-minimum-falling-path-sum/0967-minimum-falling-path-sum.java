class Solution {
    public int minFallingPathSum(int[][] mat) {
        int min=Integer.MAX_VALUE;
        int m=mat.length;
        int n=mat[0].length;
        int dp[][] = new int[m][n];
        if(m==1 && n==1)
            return mat[0][0];
        else if(m==1){
            for(int i=0;i<n;i++)
                min=Math.min(min,mat[0][i]);
                return min;
        }
        
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                dp[row][col]=mat[row][col];
            }
        }
        for(int row=1;row<m;row++){
            for(int col=0;col<n;col++){
                if(col==0){
                    dp[row][col]+=Math.min(dp[row-1][col],dp[row-1][col+1]);
                }
                else if (col==n-1){
                    dp[row][col]+=Math.min(dp[row-1][col],dp[row-1][col-1]);
                }
                else{
                    dp[row][col]+=Math.min(Math.min(dp[row-1][col],dp[row-1][col-1]),dp[row-1][col+1]);
                }

                if(row==m-1){
                    if(dp[row][col]<min){
                        min=dp[row][col];
                    }
                }
                
            }
        }
        return min;
    }
}