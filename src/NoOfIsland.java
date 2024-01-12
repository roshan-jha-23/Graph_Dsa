//for eight sides.
class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int cnt = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return cnt;
    }

    void bfs(int row, int col, char[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = r + delRow;
                    int nCol = c + delCol;
                    if (nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1') {
                        vis[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}
//for 4 sides.
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int cnt = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return cnt;
    }

void bfs(int row, int col, char[][] grid, int[][] vis) {
    vis[row][col] = 1;
    int n = grid.length;
    int m = grid[0].length;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(row, col));
    while (!q.isEmpty()) {
        int r = q.peek().first;
        int c = q.peek().second;
        q.remove();
        int[] delRows = { -1, 1, 0, 0 };
        int[] delCols = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int nRow = r + delRows[i];
            int nCol = c + delCols[i];
            if (nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1') {
                vis[nRow][nCol] = 1;
                q.add(new Pair(nRow, nCol));
            }
        }
    }
}

}

