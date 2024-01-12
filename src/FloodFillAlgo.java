class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         int n=image.length;
        int m=image[0].length;
        int iniCol=image[sr][sc];
        int[][]ans=image;
        int[] delRow={-1,0,1,0};
        int []delCol={0,1,0,-1};
        dfs(sr,sc,iniCol,color,delRow,delCol,image,ans,n,m);
        return ans;
    }
    void dfs(int row,int col,int iniCol,int newColor,int[]delRow,int[]delCol,int[][]img,int[][]ans,int n,int m ){
        ans[row][col]=newColor;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow<n&& nCol<m && nCol>=0 && nRow>=0 && img[nRow][nCol]==iniCol && ans[nRow][nCol]!=newColor){
            dfs(nRow,nCol,iniCol,newColor,delRow,delCol,img,ans,n,m);
            }
        }
    }
}
