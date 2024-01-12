// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs=new ArrayList<>();
        for(int i=0;i<n;i++) adjLs.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 if(isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j); 
                    adjLs.get(j).add(i); 
                }
            }
            }
            int[]vis=new int[n+1];
            int cnt=0;
            for(int i=0;i<n;i++){
                if(vis[i]==0){
                    cnt++;
                    dfs(i,vis,adjLs);
                }
            }
            return cnt;
        }
        void dfs(int node,int[]vis,ArrayList<ArrayList<Integer>> adjLs){
            vis[node]=1;
            for(Integer it:adjLs.get(node)){
                if(vis[it]==0){
                    dfs(it,vis,adjLs);
                }
            }
        }
    }
