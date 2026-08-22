class Solution {
    static class Info{
        int row;
        int col;
        int tm;
        public Info(int i, int j, int t){
            this.row = i;
            this.col = j;
            this.tm = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][]  = new int[n][m];
        Queue<Info> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Info(i, j, 0));
                }
            }
        }    

        int drow[] = {1,0,-1,0};
        int dcol[] = {0,1,0,-1};
        int tm = 0;
        
        while(!q.isEmpty()){
            Info info = q.remove();
            int i = info.row;
            int j = info.col;
            int t = info.tm;
            tm = Math.max(tm,t);
            for(int k = 0; k<4; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] !=2){
                    vis[nrow][ncol] = 2;
                    q.add(new Info(nrow, ncol,t+1 ));
                }
            }
        }    
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] !=2){
                  return -1;
                }
            }
        }    




        return tm;
    }
}