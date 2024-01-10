public class BFS {
    class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] vis=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
         q.add(0);
         vis[0] = true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it:adj.get(node)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
     
        return bfs;
        
    }
}
    public static void main(String[] args) {
        //watever you want for your graph.
    }
}
