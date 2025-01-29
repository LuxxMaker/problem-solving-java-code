package medium.p2661.firstCompletelyPaintedRowOrColumn;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 4, 2};
//        int[][] mat = new int[][]{{1, 4}, {2, 3}};

        int[] arr = new int[]{1, 4, 5, 2, 6, 3};
        int[][] mat = new int[][]{{4, 3, 5}, {1, 2, 6}};

        Solution solution = new Solution();
        System.out.println("answer : " + solution.firstCompleteIndex(arr, mat));
    }


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // faster than using HashMap
        // faster than 2d array
        int[] elementToRow = new int[arr.length + 1];
        int[] elementToCol = new int[arr.length + 1];

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                int element = mat[row][col];
                elementToRow[element] = row;
                elementToCol[element] = col;
            }
        }

        int totalRows = mat.length;
        int totalCols = mat[0].length;

        int[] rowFillCount = new int[totalRows];
        int[] colFillCount = new int[totalCols];

        for (int i = 0; i < arr.length; i++) {
            int currentRow = elementToRow[arr[i]];
            int currentCol = elementToCol[arr[i]];
            if (++rowFillCount[currentRow] == totalCols || ++colFillCount[currentCol] == totalRows) {
                return i;
            }
        }
        return arr.length - 1;
    }
}
