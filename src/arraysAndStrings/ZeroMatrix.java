package arraysAndStrings;

public class ZeroMatrix {
    //book solution 2
    void setZeros(int[][] matrix){
        boolean rowHasZero=false;
        boolean colHasZero=false;
        //check if the first row has a zero
        for (int i = 0; i <matrix[0].length ; i++) {
            if (matrix[0][i]==0) {
                rowHasZero=true;
                break;
            }
        }
        //check if the first col has a zero
        for (int i = 0; i <matrix.length ; i++) {
            if (matrix[i][0]==0) {
                colHasZero=true;
                break;
            }
        }
        //check for zeroes in the rest of the matrix
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0) nullifyRow(matrix,i);
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0) nullifyColumn(matrix,i);
        }
        if(rowHasZero) nullifyRow(matrix,0);
        if(colHasZero) nullifyColumn(matrix,0);
    }


    // book solution 1
//    void setZeros(int[][] matrix) {
//        boolean[] row = new boolean[matrix.length];
//        boolean[] column = new boolean[matrix[0].length];
//        // Store the row and column index with value 0
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    row[i] = true;
//                    column[j] = true;
//                }
//            }
//        }
//        //Nullify rows
//        for (int i = 0; i < row.length; i++) {
//            if (row[i]) nullifyRow(matrix, i);
//        }
//        // Nullify columns
//        for (int j = 0; j < column.length; j++) {
//            if (column[j]) nullifyColumn(matrix, j);
//        }
//    }


    void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }


    void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
