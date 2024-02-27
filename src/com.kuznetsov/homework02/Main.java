package com.kuznetsov.homework02;

public class Main {

    /*
    1. Вывести число в полуинтервале [0, n) циклом. ✔
    2. Вывести число в полуинтервале [0, n) хвостовой рекурсией. ✔
    3. Перевернуть строку методом двух указателей. ✔
    4. Вывести строку задом наперед с использованием стековой рекурсии. ✔
    5. Решить: 2, 3, 4, 5 и 11 задачу из прошлого домашнего задания с использованием хвостовой рекурсии. ✔
    */

    public static void main(String[] args) {

        int n = 20, cnt = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            cnt++;
        }
        System.out.println("\nВыведено " + cnt + " раз(-а)." + " Формула расчёта вручную: n - i = x.\n");//Первое задание ✔


        int[] arr = {1, 5, 10, 6, 3, 2};
        outputAnArrayUsingTailRecursion(arr, 0, arr.length);//Второе задание ✔
        System.out.println();
        outputAnArrayUsingStackRecursion(arr, 0, arr.length);//Дополнение ко второму заданию ✔
        System.out.println("\n");


        String textToReverse = "ялетазаку авД";//Два указателя
        char[] arrText = textToReverse.toCharArray();
        for (int l = 0, r = arrText.length - 1; l < r; l++, r--) {
            char temp = arrText[l];
            arrText[l] = arrText[r];
            arrText[r] = temp;
        }
        System.out.println(arrText);//Третье задание ✔
        System.out.println();


        char[] chars = {'к', 'е', 'т', 'С'};
        outputAnArrayUsingStackRecursion(chars, 0, chars.length);//Четвёртое задание ✔
        System.out.println("\n");

        outputAnArrayUsingTailRecursion(1, 1024 + 1);
        System.out.println();

        outputAnArrayUsingTailRecursionToBinaryString(1, 1024 + 1);
        System.out.println("\n");

        outputAnArrayUsingTailRecursionIntegerMaxValue(1, Integer.MAX_VALUE);
        System.out.println();

        outputAnArrayUsingTailRecursionIntegerMaxValueToBinaryString(1, Integer.MAX_VALUE);
        System.out.println("\n");

        outputEngAlphabetUsingTailRecursion('a', 'z');//Пятое задание ✔
        System.out.println();
    }

    private static void outputAnArrayUsingTailRecursion(int[] arr, int from, int upTo) {
        if (from < upTo) {
            System.out.print(arr[from] + " ");
            outputAnArrayUsingTailRecursion(arr, from + 1, upTo);
        }
    }

    private static void outputAnArrayUsingStackRecursion(int[] arr, int from, int upTo) {
        if (from < upTo) {
            outputAnArrayUsingStackRecursion(arr, from + 1, upTo);
            System.out.print(arr[from] + " ");
        }
    }

    private static void outputAnArrayUsingStackRecursion(char[] chars, int from, int upTo) {
        if (from < upTo) {
            outputAnArrayUsingStackRecursion(chars, from + 1, upTo);
            System.out.print(chars[from]);
        }
    }

    public static void outputAnArrayUsingTailRecursion(int from, int upTo) {
        if (from < upTo) {
            System.out.print(from + " ");
            outputAnArrayUsingTailRecursion(from * 2, upTo);
        }
    }

    public static void outputAnArrayUsingTailRecursionToBinaryString(int from, int upTo) {
        if (from < upTo) {
            System.out.print(toBinaryString(from) + " ");
            outputAnArrayUsingTailRecursionToBinaryString(from * 2, upTo);
        }
    }

    private static void outputAnArrayUsingTailRecursionIntegerMaxValue(int from, int upTo) {
        if (from < upTo) {
            System.out.print(from + " ");
            outputAnArrayUsingTailRecursionIntegerMaxValue(from * 2 + 1, upTo);
        }
    }

    private static void outputAnArrayUsingTailRecursionIntegerMaxValueToBinaryString(int from, int upTo) {
        if (from < upTo) {
            System.out.print(toBinaryString(from) + " ");
            outputAnArrayUsingTailRecursionIntegerMaxValueToBinaryString(from * 2 + 1, upTo);
        }
    }

    private static void outputEngAlphabetUsingTailRecursion(char from, char upTo) {
        if (from < upTo + 1) {
            System.out.print(from + " ");
            outputEngAlphabetUsingTailRecursion((char) (from + 1), upTo);
        }
    }

    private static String toBinaryString(int number) {
        return String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
    }
}
