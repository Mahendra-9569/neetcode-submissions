class Solution {
   static class Info{
        int row;
        int col; 
        public Info(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int BFS(int grid[][], int i, int j, int x[], int y[], boolean vis[][]){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(i, j));
        int ans = 0;
        while(!q.isEmpty()){
            Info curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            if(!vis[row][col]){
                vis[row][col] = true;
                ans++;
            }
          
            for(int k = 0; k<4; k++){
                int nrow = row + x[k];
                int ncol = col + y[k];
                if(nrow>=0 && nrow <grid.length && ncol >= 0 && ncol <grid[0].length && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    q.add(new Info(nrow, ncol));
                }
            }
        }

        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        int ans = 0;
        int x[] = {1, 0, -1, 0};
        int y[] = {0, 1, 0, -1};
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int curr = BFS(grid, i, j, x, y, vis);
                    ans = Math.max(ans, curr);
                }
            }
        }

        return ans;
    }
}