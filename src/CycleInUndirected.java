//BFS
import java.util.*;

class Solution {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean detectCycle(int src, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (int it : adj.get(node)) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    q.add(new Pair(it, node));
                } else if (parent != it) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (detectCycle(i, vis, adj)) return true;
            }
        }
        return false;
    }
}
//Dfs
import java.util.*;

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && hasCycle(i, -1, visited, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
