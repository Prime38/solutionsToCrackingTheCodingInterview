package arraysAndStrings;

public class RotateMatrix {
    //book solution
    static int[][] rotate(int[][] mat) {
        if (mat.length == 0 || mat.length != mat[0].length) return new int[mat.length][mat.length];
        int n = mat.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = mat[first][i];//save top
                mat[first][i] = mat[last - offset][first];//left->top
                mat[last - offset][first] = mat[last][last - offset];//bottom->left
                mat[last][last - offset] = mat[i][last];//right-> bottom
                mat[i][last] = top; //right -> saved top
            }
        }
        return mat;
    }


//    //my solution -> doesn't work
//    static int[][] rotate(int[][] mat){
//        int[][] ans=mat;
//        for (int i=0;i<4;i++){
//            for(int j=0;j<4;j++){
//                ans[i][j]=mat[4-1-j][i];
//            }
//        }
//        return ans;
//    }


    public static void main(String[] args) {
        int[][] mat = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = j + 10 * i;
            }
        }
        print(mat);
        mat = rotate(mat);
        System.out.println();
        print(mat);
    }

    static void print(int[][] mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
