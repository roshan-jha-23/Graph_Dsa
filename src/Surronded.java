class Solution{
   static void dfs(int row, int col, int[][] vis, char[][] replica, int[][] dirArray, int n, int m) {
    vis[row][col] = 1;
    for (int[] andarKaRow : dirArray) {
        int nRow = row + andarKaRow[0];
        int nCol = col + andarKaRow[1];
        if (nRow < n && nCol < m && nCol >= 0 && nRow >= 0 && replica[nRow][nCol] == 'O' && vis[nRow][nCol] == 0) {
            dfs(nRow, nCol, vis, replica, dirArray, n, m);
        }
    }
}
    static char[][] fill(int n, int m, char[][] a) {
    char[][] replica = new char[n][m];
    for (int i = 0; i < n; i++) {
        replica[i] = Arrays.copyOf(a[i], m);
    }

    int[][] vis = new int[n][m];
    int[][] dirArray = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
       
        for(int i=0;i<m;i++){
            //first row
            if(replica[0][i]=='O' && vis[0][i]==0){
                dfs(0,i,vis,replica,dirArray,n,m);
            }
            //last row
            if(replica[n-1][i]=='O' && vis[n-1][i]==0){
                dfs(n-1,i,vis,replica,dirArray,n,m);
            }
        }
           for(int i=0;i<n;i++){
            //first col
            if(replica[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,replica,dirArray,n,m);
            }
            //last col
            if(replica[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,vis,replica,dirArray,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && replica[i][j]=='O') replica[i][j]='X';
            }
        }
        return replica;
        // code here
    }
}
