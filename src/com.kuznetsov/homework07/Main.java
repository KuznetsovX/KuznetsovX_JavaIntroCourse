package com.kuznetsov.homework07;

import java.util.Scanner;

public class Main {

    /*
    1. Посчитать кол-во чисел в диапазоне [1..n] которые делятся или на 2, или на 3, или на 5, или на 7.
    Использовать long. Решение должно быть за константу. ✔
    2. Создать реализацию ImmutableSet с поддержкой значений в полуинтервале [0..32). ✔
    3. Создать реализацию DynamicSet с поддержкой больших значений. Используйте массив int.
    Реализация должна быть Mutable. ✔
     */

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        long n = 2000;//(>^_^)> rewrite to your number <(^_^<)
        long divNum = n / 2 + n / 3 + n / 5 + n / 7;
        divNum = divNum - n / (2 * 3) - n / (2 * 5) - n / (2 * 7) - n / (3 * 5) - n / (3 * 7) - n / (5 * 7);
        divNum = divNum + (n / (2 * 3 * 5) + n / (2 * 3 * 7) + n / (2 * 5 * 7) + n / (3 * 5 * 7));
        divNum = divNum - (n / (2 * 3 * 5 * 7));
        System.out.println(divNum);//Первое задание ✔

        vennDiagram();//Дополнение к первому заданию ✔

        ImmutableSet immutableSet = new ImmutableSet();
        //Write your code here   ༼ つ ◕_◕ ༽つ
        System.out.println(immutableSet);


        MutableSet mutableSet = new MutableSet();
        //Write your code here   (づ｡◕‿‿◕｡)づ
        System.out.println(mutableSet);


        DynamicSet dynamicSet1 = new DynamicSet();
        DynamicSet dynamicSet2 = new DynamicSet();
        //Write your code here   ᕙ(⇀‸↼‶)ᕗ
        System.out.println(dynamicSet1);
        System.out.println(dynamicSet2);
    }

    private static void vennDiagram() {
        long[] divider = new long[4];
        for (int i = 0; i < divider.length; i++) {
            int counter = i + 1;
            System.out.println("Введите " + counter + "-й делитель...");
            String textIn = scanner.next();

            try {
                Long.parseLong(textIn);
            } catch (NumberFormatException e) {
                System.out.println("Число не было введено. Попробуйте еще раз.");
                i--;
                continue;
            }
            long longIn = Long.parseLong(textIn);
            divider[i] = longIn;

        }

        long[] number = new long[1];
        for (int i = 0; i < number.length; i++) {
            System.out.println("Введите число...");
            String textIn = scanner.next();

            try {
                Long.parseLong(textIn);
            } catch (NumberFormatException e) {
                System.out.println("Число не было введено. Попробуйте еще раз.");
                i--;
                continue;
            }
            long longIn = Long.parseLong(textIn);
            number[i] = longIn;
        }

        System.out.println(calculate(number[0], divider[0], divider[1], divider[2], divider[3]));
    }

    private static long calculate(long number, long dividerFirst, long dividerSecond, long dividerThird, long dividerFourth) {
        long divNum = number / dividerFirst + number / dividerSecond + number / dividerThird + number / dividerFourth;
        divNum = divNum - number / (dividerFirst * dividerSecond) - number / (dividerFirst * dividerThird) - number / (dividerFirst * dividerFourth) - number / (dividerSecond * dividerThird) - number / (dividerSecond * dividerFourth) - number / (dividerThird * dividerFourth);
        divNum = divNum + (number / (dividerFirst * dividerSecond * dividerThird) + number / (dividerFirst * dividerSecond * dividerFourth) + number / (dividerFirst * dividerThird * dividerFourth) + number / (dividerSecond * dividerThird * dividerFourth));
        divNum = divNum - (number / (dividerFirst * dividerSecond * dividerThird * dividerFourth));
        return divNum;
    }
}
