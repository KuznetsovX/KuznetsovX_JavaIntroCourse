package com.kuznetsov.homework03;

public class Main {

    /*
    1. Вывести матрицу циклом for. ✔
    2. Вывести матрицу циклом while. ✔
    3. Вывести матрицу хвостовой рекурсией. ✔
    4. Нарисовать 5 фигур из множества. Цвета любые. ✔
    5. Перевернуть картинку слева направо. ✔
    6. * Повернуть картинку на угол 90 градусов. ✔
    */

//        Во многих заданиях этого класса есть условие "if (false)" - это нужно лишь для того, чтобы
//        не выводить кучу лишнего материала.
//        Чтобы код заработал условие "if (false) нужно заменить на "if (true)"
//        или просто удалить само условие.

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 4, 8}, {16, 32, 64, 128}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }//Первое задание ✔
        System.out.println();


        int iCycleWhile = 0, jCycleWhile = 0;
        while (iCycleWhile < matrix.length) {
            while (jCycleWhile < matrix[iCycleWhile].length) {
                System.out.print(matrix[iCycleWhile][jCycleWhile] + " ");
                jCycleWhile++;
            }
            iCycleWhile++;
            jCycleWhile = 0;
            System.out.println();
        }//Второе задание ✔
        System.out.println();


        outputTheMatrixUsingTailRecursion(matrix, 0, 0);//Третье задание ✔


        if (false) {
            int[][] matrixEducation = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};

            for (int i = 0; i < matrixEducation.length; i++) {
                for (int j = 0; j < matrixEducation[i].length; j++) {
                    System.out.print(matrixEducation[i][j] + " ");
                }
                System.out.println();
            }//Матрица: простой вывод
        }

        if (false) {
            int[][] matrixEducation = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};

            for (int i = 0; i < matrixEducation.length; i++) {
                for (int j = matrixEducation[i].length - 1; j > -1; j--) {
                    System.out.print(matrixEducation[i][j] + " ");
                }
                System.out.println();
            }//Матрица: справа налево
        }

        if (false) {
            int[][] matrixEducation = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};

            for (int i = matrixEducation.length - 1; i > -1; i--) {
                for (int j = 0; j < matrixEducation[i].length; j++) {
                    System.out.print(matrixEducation[i][j] + " ");
                }
                System.out.println();
            }//Матрица: снизу вверх
        }

        if (false) {
            int[][] matrixEducation = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};

            for (int i = matrixEducation.length - 1; i > -1; i--) {
                for (int j = matrixEducation[i].length - 1; j > -1; j--) {
                    System.out.print(matrixEducation[i][j] + " ");
                }
                System.out.println();
            }//Матрица: снизу вверх + справа налево
        }

        if (false) {
            int[][] matrixEducation = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};

            for (int j = 0; j < matrixEducation[0].length; j++) {
                for (int i = 0; i < matrixEducation.length; i++) {
                    System.out.print(matrixEducation[i][j] + " ");
                }
                System.out.println();
            }//Матрица: столбцы
        }
    }

    private static void outputTheMatrixUsingTailRecursion(int[][] matrix, int i, int j) {
        if (i < matrix.length) {
            if (j < matrix[i].length) {
                System.out.print(matrix[i][j] + " ");
                outputTheMatrixUsingTailRecursion(matrix, i, j + 1);
            } else {
                System.out.println();
                outputTheMatrixUsingTailRecursion(matrix, i + 1, 0);
            }
        }
    }
}
