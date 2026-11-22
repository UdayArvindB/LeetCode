class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, column = n-1;
        while(row < m && column >= 0){
            if(matrix[row][column] == target){
                return true;
            } else if(matrix[row][column] < target){
                row++;
            }else{
                column--;
            }
        }
        return false;
    }
}