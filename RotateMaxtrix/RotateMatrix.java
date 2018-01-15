import java.util.Scanner;

class RotateMatrix {
    static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
                if(j != matrix[0].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    //1  2  3  4          13 9  5 1
    //5  6  7  8    ==>   14 10 6 2
    //9  10 11 12         15 11 7 3
    //13 14 15 16         16 12 8 4

    //By layer, going concentrically from the outermost layer to the innermost layer:
    //temp <= top-left
    //top-left <= bottom-left
    //bottom-left <= bottom-right
    //bottom-right <= top-right
    //top-right <= temp
    static int[][] rotateMatrixCW(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m/2; i++){
            for(int j = i; j < n - i - 1; j++){
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[m-j-1][i];
                matrix[m-j-1][i] = matrix[m-i-1][n-j-1];
                matrix[m-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }

        return matrix;
    }

    //1  2  3  4          4 8 12 16
    //5  6  7  8    ==>   3 7 11 15
    //9  10 11 12         2 6 10 14
    //13 14 15 16         1 5 9  13

    //By layer, going concentrically from the outermost layer to the innermost layer:
    //temp <= bottom-left
    //bottom-left <= top-left
    //top-left <= top-right
    //top-right <= bottom-right
    //bottom-right <= temp
    static int[][] rotateMatrixCCW(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m/2; i++){ //by rows
            for(int j = i; j < n - i - 1; j++){ //by columns
                int t = matrix[m-j-1][i];
                matrix[m-j-1][i] = matrix[i][j];
                matrix[i][j] = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[m-i-1][n-j-1];
                matrix[m-i-1][n-j-1] = t;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //rows
        int n = sc.nextInt(); //columns
        int r = sc.nextInt(); //times to rotate
        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        printMatrix(matrix);
        System.out.println();

        for(int i = 0; i < r; i++){
            matrix = rotateMatrixCCW(matrix);
        }

        printMatrix(matrix);
    }
}
