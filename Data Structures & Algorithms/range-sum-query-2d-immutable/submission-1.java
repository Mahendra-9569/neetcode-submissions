class NumMatrix {
    int[][] rowSum;
    int[][] colSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        rowSum = new int[n][m];
        colSum = new int[n][m];


        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[i][j];
                rowSum[i][j] = sum;
            }
        }

        
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += rowSum[i][j];
                colSum[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = colSum[row2][col2];
        int up = (row1 > 0) ? colSum[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? colSum[row2][col1 - 1] : 0;
        int diag = (row1 > 0 && col1 > 0) ? colSum[row1 - 1][col1 - 1] : 0;

        return total - up - left + diag;
    }
}
