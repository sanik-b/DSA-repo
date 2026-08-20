class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i< 9;i++){
            for(int j = 0;j<9;j++){
                char digit = board[i][j];
                if(digit == '.') continue;

                String rowKey = digit + "in row" + i;
                String colKey = digit + "in column" +j;
                String boxKey = digit + "in box"+ (i/3) + "," + (j/3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}