class Solution {
    class Info {
        int row;
        int col;
        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int x[] = {1, 0, -1, 0};
        int y[] = {0, 1, 0, -1};
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {   
                    Queue<Info> q = new LinkedList<>();
                    q.add(new Info(i, j));
                    vis[i][j] = true;

                    while (!q.isEmpty()) {
                        Info in = q.remove();
                        int row = in.row;
                        int col = in.col;

                        for (int k = 0; k < 4; k++) {
                            int nrow = row + x[k];
                            int ncol = col + y[k];

                        
                            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
                                res++;
                            }
                
                            else if (grid[nrow][ncol] == 0) {
                                res++;
                            }
                            
                            else if (!vis[nrow][ncol]) {
                                q.add(new Info(nrow, ncol));
                                vis[nrow][ncol] = true;
                            }
                        }
                    }
                    return res; 
                }
            }
        }
        return res;
    }
}
