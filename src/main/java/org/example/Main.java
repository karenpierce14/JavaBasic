package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main{

    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше " + MAX_SIZE + "): ");
        int width = Math.min(scanner.nextInt(), MAX_SIZE);

        System.out.print("Введіть висоту матриці (не більше " + MAX_SIZE + "): ");
        int height = Math.min(scanner.nextInt(), MAX_SIZE);

        int[][] matrix;

        System.out.println("Виберіть спосіб створення матриці:");
        System.out.println("1. Введення з клавіатури");
        System.out.println("2. Рандомне створення");
        int choice = scanner.nextInt();

        if (choice == 1) {
            matrix = createMatrixFromInput(width, height, scanner);
        } else {
            matrix = createRandomMatrix(width, height);
        }

        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricAverage = calculateGeometricAverage(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricAverage);

        scanner.close();
    }

    private static int[][] createMatrixFromInput(int width, int height, Scanner scanner) {
        int[][] matrix = new int[width][height];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] createRandomMatrix(int width, int height) {
        int[][] matrix = new int[width][height];
        Random random = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Отримана матриця:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }

        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }

        return (double) sum / count;
    }

    private static double calculateGeometricAverage(int[][] matrix) {
        double product = 1.0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                product *= value;
                count++;
            }
        }

        return Math.pow(product, 1.0 / count);
    }
}
