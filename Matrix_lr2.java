import java.util.Scanner;
import java.util.Random;

public class Matrix_lr2 {

    public static int[][] createMatrix(int rows, int cols, boolean random) {
        int[][] matrix = new int[rows][cols];
        Scanner scanner = new Scanner(System.in);

        if (random) {
            Random rand = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = rand.nextInt(100);
                }
            }
        } else {
            System.out.println("Введіть елементи матриці:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Елемент [" + i + "][" + j + "]: ");
                    matrix[i][j] = scanner.nextInt();
                }
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

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static double findAverage(int[][] matrix) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        return sum / count;
    }

    public static double findGeometricMean(int[][] matrix) {
        double product = 1;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                product *= matrix[i][j];
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці: ");
        int rows = scanner.nextInt();

        System.out.print("Введіть кількість стовпців матриці: ");
        int cols = scanner.nextInt();

        System.out.println("Виберіть метод створення матриці:");
        System.out.println("1. Вручну");
        System.out.println("2. Випадковим чином");
        System.out.print("Вибір: ");
        int choice = scanner.nextInt();

        boolean random = (choice == 2);
        int[][] matrix = createMatrix(rows, cols, random);

        System.out.println("\nМатриця:");
        printMatrix(matrix);

        System.out.println("\nМінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + findAverage(matrix));

        System.out.println("Середнє геометричне: " + findGeometricMean(matrix));
    }
}
