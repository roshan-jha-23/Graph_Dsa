class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] nearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int row = current.first;
            int col = current.second;

            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && !visited[nrow][ncol]) {
                    result[nrow][ncol] = result[row][col] + 1;
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        return result;
    }
}
