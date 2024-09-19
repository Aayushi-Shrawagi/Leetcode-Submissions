class Solution {
    static int m,n;
    static int dfs(int i,int j,int count){
        if(i== (m-1) && j==(n-1)){
            count++;
            return count;
        }
        if(i>=m || j>=n)
            return count;
        count=dfs(i+1, j, count);
        count=dfs(i,j+1,count);
        return count;
    }
    static int dp(int m,int n){
        int count=0;
        int [][]dpMat=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 ||j==0)
                    dpMat[i][j]=1;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dpMat[i][j]=dpMat[i-1][j]+dpMat[i][j-1];
            }
        }
        
        return dpMat[m-1][n-1];
    }
    public static int uniquePaths(int row, int col) {
        m=row;
        n=col;
        // return dfs(0, 0, 0);
        return dp(m,n);
    }
}