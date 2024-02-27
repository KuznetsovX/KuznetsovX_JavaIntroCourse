package com.kuznetsov.homework01;

import java.util.Date;

public class Main {

    /*
    1. Вывести фразу "съешь же ещё этих мягких французских булок, да выпей чаю". ✔
    2. Вывести числа: 1 2 4 8 16 32 64 … 1024 ✔
    3. Вывести предыдущее задание в двоичной системе счисления. ✔
    4. Вывести числа: 0 1 3 7 15 31 63 … Integer.MAX_VALUE ✔
    5. Вывести предыдущее задание в двоичной системе счисления. ✔
    6. Написать числом серый цвет, зеленый, голубой.
    Например: красный - 0xFF0000. Выведите все цвета в десятеричной системе счисления. ✔
    7. Вывести все числа от 0 до 2000, которые делятся на 3 и на 5. ✔
    8. Вывести все числа от 0 до 2000, которые делятся на 3 или на 5. ✔
    9. Вывести все числа от 0 до 2000, которые делятся только на 3 или на 5. ✔
    10. В каком задании чисел больше? В седьмом, восьмом или девятом задании? ✔
    11. Вывести английский алфавит. ✔
    12. Вывести только гласные из английского алфавита. ✔
    13. Написать степенным литералом (double num = 1e20) следующие числа:
    1_000_000_000, 1_000_000_000 + 7, 1_000, 0.000_005. ✔
    */

    public static void main(String[] args) {

        String introductoryText;
        introductoryText = "Привет! ";
        System.out.print(introductoryText);
        introductoryText = "Cъешь же ещё этих мягких французских булок, да выпей чаю.\n";
        System.out.print(introductoryText + "\n");//Первое задание ✔


        for (int i = 1; i < 1024 + 1; i *= 2)
            System.out.print(i + " ");//Второе задание ✔
        System.out.println();

        for (int i = 1; i < 1024 + 1; i *= 2)
            System.out.print(toBinaryString(i) + " ");//Третье задание ✔
        System.out.println("\n");

        for (int i = 1; i < Integer.MAX_VALUE; i = i * 2 + 1)
            System.out.print(i + " ");//Четвёртое задание ✔
        System.out.println();

        for (int i = 1; i < Integer.MAX_VALUE; i = i * 2 + 1)
            System.out.print(toBinaryString(i) + " ");//Пятое задание ✔
        System.out.println("\n");


        int gray = 0x4B4B4B, red = 0xFF0000, green = 0x00FF00, blue = 0x0000FF;

        System.out.print("Цвета в десятеричной системе счисления: ");
        System.out.print("серый >> " + gray + ", красный >> " + red + ", зелёный >> " + green + ", синий >> " + blue);//Шестое задание ✔
        System.out.println();

        System.out.print("Цвета в шестнадцатеричной системе счисления: ");
        System.out.print("серый >> " + toHexString(gray) + ", красный >> " + toHexString(red) + ", зелёный >> " + toHexString(green) + ", синий >> " + toHexString(blue));
        System.out.println("\n");


        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        System.out.print("Все числа от 0 до 2000, которые делятся на 3 и 5: ");
        for (int i = 0; i < 2000 + 1; i++)
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print(i + " ");//Седьмое задание ✔
                cnt1++;
            }
        System.out.println("\nКоличество чисел: " + cnt1);

        System.out.print("Все числа от 0 до 2000, которые делятся на 3 или 5: ");
        for (int i = 0; i < 2000 + 1; i++)
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(i + " ");//Восьмое задание ✔
                cnt2++;
            }
        System.out.println("\nКоличество чисел: " + cnt2);

        System.out.print("Все числа от 0 до 2000, которые делятся только на 3 или 5: ");
        for (int i = 0; i < 2000 + 1; i++)
            if (i % 3 == 0 ^ i % 5 == 0) {
                System.out.print(i + " ");//Девятое задание ✔
                cnt3++;
            }
        System.out.println("\nКоличество чисел: " + cnt3);


        int[] largeArray = {cnt1, cnt2, cnt3};
        int smallest = largeArray[0], biggest = largeArray[0];

        for (int j : largeArray) {
            if (j < smallest) smallest = j;
            if (j > biggest) biggest = j;
        }
        System.out.println("Наименьшее кол-во чисел: " + smallest);
        System.out.println("Наибольшее кол-во чисел: " + biggest + "\n");//Десятое задание ✔


        char engAlphabet;
        System.out.print("Английский алфавит: ");
        for (engAlphabet = 'a'; engAlphabet < 'z' + 1; engAlphabet++)
            System.out.print(engAlphabet + " ");//Одиннадцатое задание ✔
        System.out.println();

        System.out.print("Только гласные: ");
        for (engAlphabet = 'a'; engAlphabet < 'z' + 1; engAlphabet++)
            switch (engAlphabet) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    System.out.print(engAlphabet + " ");//Двенадцатое задание ✔
            }
        System.out.println();

        char ruAlphabet;
        System.out.print("Русский алфавит: ");
        for (ruAlphabet = 'а'; ruAlphabet < 'я' + 1; ruAlphabet++)
            System.out.print(ruAlphabet + " ");
        System.out.println();

        System.out.print("Только гласные звуки: ");
        for (ruAlphabet = 'а'; ruAlphabet < 'я' + 1; ruAlphabet++)
            switch (ruAlphabet) {
                case 'а':
                case 'и':
                case 'у':
                case 'о':
                case 'ы':
                case 'э':
                    System.out.print(ruAlphabet + " ");
            }
        System.out.println("\n");


        double num1 = 1e+9, num2 = 1e9 + 7, num3 = 1e3, num4 = 5e-6;

        System.out.printf("%.0f\n", num1);
        System.out.printf("%.0f\n", num2);
        System.out.printf("%.0f\n", num3);
        System.out.printf("%2f\n", num4); //Тринадцатое задание ✔
        System.out.println();


        date();
    }

    private static String toBinaryString(int number) {
        return String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
    }

    private static String toHexString(int number) {
        return String.format("%6s", Integer.toHexString(number)).replace(' ', '0');
    }

    private static void date() {
        Date date_custom = new Date();
        System.out.printf("%te %tB %tY", date_custom, date_custom, date_custom);
        System.out.println();
    }
}