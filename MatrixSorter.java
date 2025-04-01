import java.util.Scanner;
import java.util.Arrays;

public class MatrixSorter {

    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    public static void sortColumns(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][j];
            }
            Arrays.sort(column);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = column[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int cols = scanner.nextInt();

        int[][] matrix = createMatrix(rows, cols);

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        System.out.println("\nМатрица после сортировки по строкам:");
        sortRows(matrix);
        printMatrix(matrix);

        System.out.println("\nМатрица после сортировки по столбцам:");
        sortColumns(matrix);
        printMatrix(matrix);
    }
}
