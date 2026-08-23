class Solution {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char ch = board[row][col];

                // Ignore empty cells
                if (ch == '.') {
                    continue;
                }

                int num = ch - '0';

                // Find which 3x3 box this cell belongs to
                int box = (row / 3) * 3 + (col / 3);

                // Number already exists in row
                if (rows[row][num]) {
                    return false;
                }

                // Number already exists in column
                if (cols[col][num]) {
                    return false;
                }

                // Number already exists in 3x3 box
                if (boxes[box][num]) {
                    return false;
                }

                // Mark number as present
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }
}