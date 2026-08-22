class Solution {
    static int INF = 2147483647;
    static class Pair{
        int row;
        int col;
        int steps;
        public Pair(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
  
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x[] = {1, 0, -1, 0};
        int y[] = {0, 1, 0, -1};
       
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                }
            }
        } 
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int steps = curr.steps;

            for(int i = 0; i<4; i++){
                int nr = r + x[i];
                int nc = c + y[i];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc<grid[0].length && grid[nr][nc] == INF){
                    grid[nr][nc] = steps+1;
                    q.add(new Pair(nr, nc, steps+1));
                }
            }

        }

    }
}
