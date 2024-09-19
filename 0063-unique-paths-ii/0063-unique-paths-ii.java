class Solution {
    static int dp(int[][] grid){
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    grid[i][j]=-1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //obstacle encountered
                if(grid[i][j]==-1)
                    grid[i][j]=0;
                else if(i==0&&j==0)
                    grid[i][j]=1;
                else if(i==0)
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                else if(j==0)
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                else
                    grid[i][j]=grid[i-1][j]+grid[i][j-1]+grid[i][j];
            }
        }
        
        return grid[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dp(obstacleGrid);
    }
}