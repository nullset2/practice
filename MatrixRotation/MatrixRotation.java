import java.util.Scanner;

class MatrixRotation{
    static void printMatrix(int[][] matrix, int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j]);
                if(j != n - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] layerRotate(int[][] matrix, int m, int n, int r){
        for(int i = 0; i < m - 1;  i++){
            for(int j = i; j < n - 1; j++){
                if(r % (2*(m + n) - 4) == 0)
                    return matrix;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printMatrix(matrix, m, n);
        printMatrix(layerRotate(matrix, m, n, r), m, n);
    }
}
