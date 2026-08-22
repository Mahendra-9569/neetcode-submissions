class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int row[] = {1,0,-1,0};
        int col[] = {0,1,0,-1};
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    int cnt = 4;
                    for(int k = 0; k<4; k++){
                        int nrow = i+row[k];
                        int ncol = j+col[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1){
                            cnt--;
                        }
                    }
                        res += cnt;
                }
            }
        }

        return res;
    }
}