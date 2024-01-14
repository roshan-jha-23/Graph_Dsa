class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    void dfs(int row,int col,int[][]vis,int[][] grid, ArrayList<String> vec,int initRow,int initCol,int n
    ,int m){
        vis[row][col]=1;
        vec.add(toString(row-initRow,col-initCol));
        int[][]dirArray={{-1,0},{0,-1},{1,0},{0,1}};
        for(int [] dir:dirArray){
            int nRow=row+dir[0];
            int nCol=col+dir[1];
            if(nRow<n && nCol<m && nRow>=0 && nCol>=0 && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                dfs(nRow,nCol,vis,grid,vec,initRow,initCol,n,m);
            }
        }
        
    }
    private String toString(int r,int c){
        return Integer.toString(r)+","+Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>> st=new HashSet<>();
        int [][] vis=new int[n][m];
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(vis[i][j]==0 && grid[i][j]==1){
                     ArrayList<String> vec=new ArrayList<>();
                     dfs(i,j,vis,grid,vec,i,j,n,m);
                     st.add(vec);
                 }
             }
         }
         return st.size();
    }
}
