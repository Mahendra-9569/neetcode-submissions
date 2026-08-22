class Solution {
    public static void DFS(char grid[][], boolean vis[][], int row, int col, int x[], int y[]){
        vis[row][col] = true;
        for(int l =  0; l<4; l++){
            int nrow = row+x[l];
            int ncol = col+y[l];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol] == 'O'&& !vis[nrow][ncol]){
                DFS(grid, vis, nrow, ncol, x, y);
            }
        }

        
    }
    public void solve(char[][] board) {
      int n = board.length;
      int m = board[0].length;
      int x[] = {1,0,-1,0};
      int y[] = {0,1,0,-1};
      boolean vis[][] = new boolean[n][m];
      for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(i == 0 || i == n-1 || j == 0 || j == m-1){
                if(board[i][j] == 'O'){
                    DFS(board, vis, i, j, x, y);
                }
            }
        }
      }

      for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(vis[i][j] == false){
                board[i][j] = 'X';
            }
        }
      }

      
    }
}
