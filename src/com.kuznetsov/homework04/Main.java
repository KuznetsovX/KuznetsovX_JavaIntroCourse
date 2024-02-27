package com.kuznetsov.homework04;

import java.util.Scanner;

public class Main {

    /*
    1. В билете 6 цифр. Вычислить, является ли билет счастливым, не используя цикл.
    Сделать случайную генерацию цифр билета в отдельном методе. ✔
    2. Добавить пользователю возможность вводить цифры билета из консоли.
    В случае неверно введенного количества цифр билета - предусмотреть возможность пользователю
    ввести данные снова. ✔
    3. Пользователь вводит последовательность цифр. Определить, стоят ли цифры в числе по возрастанию/убыванию. ✔
    4. Ввести с клавиатуры число в диапазоне: от 100 до 100 000 000 (введенное число проверяется).
    Подсчитать количество чётных и нечётных цифр в этом числе в процентном отношении. ✔
    5. Пользователь вводит координаты центра окружности и её радиус, после чего пользователь вводит
    координаты пяти точек. Определить, сколько из них лежат в окружности (для определения расстояний
    и проверок сделать отдельные методы). ✔
    6. Одноклеточная амёба каждые 3 часа делится на 2 клетки. Определить, сколько клеток будет
    через 3, 6, 9, ..., 24 часа, если первоначально была одна амёба. ✔
    */

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("--- Счастливый билет, рандом ---");
        System.out.println(isThisALuckyTicket(String.valueOf(getRandomNumberInRange(100000, 999999))) ? "Поздравляю! Вы достали счастливый билет!" : "К сожалению, Вы потерпели неудачу.");

        System.out.println("\n--- Счастливый билет, ручной ввод ---");
//        getTheLuckyTicket();//Второе задание ✔

        System.out.println("\n--- Последовательность ---");
//        checkSequencesOfNumbers();//Третье задание ✔

        System.out.println("\n--- Чётные / нечётные цифры ---");
//        countTheNumberOfEvenOddNumbers();//Четвёртое задание ✔

        System.out.println("\n--- Координаты ---");
//        doesThePointLieOnACircle();//Пятое задание ✔

        System.out.println("\n--- Амёба ---");
        divisionOfAmoeba();//Шестое задание ✔
    }

    /* Lucky Ticket */
    private static void getTheLuckyTicket() {
        System.out.println("Введите число...");
        String textIn = scanner.next();

        if (isCorrectLuckyTicket(textIn)) {
            System.out.println(isThisALuckyTicket(textIn) ? "Поздравляю! Вы достали счастливый билет!" : "К сожалению, Вы потерпели неудачу.");
            if (scannerContinueQuestion()) {
                getTheLuckyTicket();
            }
        } else {
            getTheLuckyTicket();
        }
    }

    private static boolean isCorrectLuckyTicket(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Число не было введено. Попробуйте еще раз.");
            return false;
        }

        if (str.length() == 6) {
            if (str.equals("000000")) {
                System.out.println("Число не может состоять только из нулей.");
                return false;
            }
            if (str.startsWith("0")) {
                System.out.println("Число не может начинаться с нуля.");
                return false;
            }
            return true;
        } else {
            System.out.println("Введена неверная длинна! Запрашиваемая длинна: 6.");
            return false;
        }
    }

    private static boolean isThisALuckyTicket(String str) {
        int firstHalf = str.charAt(0) + str.charAt(1) + str.charAt(2);
        int secondHalf = str.charAt(3) + str.charAt(4) + str.charAt(5);
        return firstHalf == secondHalf;
    }

    /* Other Tasks */
    public static int getRandomNumberInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static void checkSequencesOfNumbers() {
        System.out.println("Введите желаемую длину...");
        String length = scanner.next();

        if (scannerIntChecker(length)) {
            if (Integer.parseInt(length) < 3) {
                System.out.println("Длинна слишком мала.");
                checkSequencesOfNumbers();
                return;
            }
            int[] array = new int[Integer.parseInt(length)];
            System.out.println("Длинна: " + length);

            for (int i = 0; i < array.length; i++) {
                System.out.println("Введите число...");
                String fillingTheArray = scanner.next();
                if (scannerIntChecker(fillingTheArray)) {
                    array[i] = Integer.parseInt(fillingTheArray);
                } else {
                    i--;
                }
            }

            boolean isAscending = array[0] < array[1];
            for (int i = 0; i < array.length - 1; i++) {
                if ((array[i] > array[i + 1] && isAscending) || (array[i] < array[i + 1] && !isAscending) || (array[i] == array[i + 1])) {
                    System.out.println("Нет последовательности.");
                    return;
                }
            }
            System.out.println(isAscending ? "Восходящая." : "Нисходящая.");
        } else {
            checkSequencesOfNumbers();
        }

    }

    private static void countTheNumberOfEvenOddNumbers() {
        System.out.println("Введите число в диапазоне: от 100 до 100000000");
        String textIn = scanner.next();

        if (scannerIntChecker(textIn)) {
            int intIn = Integer.parseInt(textIn);
            if (intIn > 100 & intIn < 100000000) {
                int resultEven = 0;
                int resultOdd = 0;
                while (intIn != 0) {
                    int currentInt = intIn % 10;
                    if (currentInt % 2 == 0) {
                        resultEven++;
                    } else {
                        resultOdd++;
                    }
                    intIn = intIn / 10;
                }
                System.out.println("Соотношение чётных к нечётным: " + (double) 100 / (resultEven + resultOdd) * resultEven + "%");
            } else {
                countTheNumberOfEvenOddNumbers();
            }
        } else {
            countTheNumberOfEvenOddNumbers();
        }

    }

    private static void divisionOfAmoeba() {
        for (int hours = 1, amoeba = 1; hours < 25; hours++) {
            if (hours % 3 == 0) {
                System.out.print((amoeba = amoeba * 2) + " ");
            }
        }
    }

    /* Coordinates */
    private static void doesThePointLieOnACircle() {
        double[] coordinates = new double[3];
        System.out.println("Введите последовательно: " + "\n x,y,R круга");
        for (int i = 0; i < coordinates.length; i++) {
            String textIn = scanner.next();
            if (scannerDoubleChecker(textIn)) {
                double doubleIn = Double.parseDouble(textIn);
                coordinates[i] = doubleIn;
            } else {
                i--;
            }
        }

        double[] pointCoordinates = new double[2];
        for (int i = 0; i < 6; i++) {
            System.out.println("Введите x,y точки...");
            for (int j = 0; j < pointCoordinates.length; j++) {
                String textIn = scanner.next();
                if (scannerDoubleChecker(textIn)) {
                    double nextParam = Double.parseDouble(textIn);
                    pointCoordinates[j] = nextParam;
                } else {
                    j--;
                }
            }
            System.out.println(calculateCoordinates(coordinates[0], coordinates[1], coordinates[2], pointCoordinates[0], pointCoordinates[1]) ? "Точка принадлежит кругу." : "Точка не принадлежит кругу.");
        }
    }

    private static boolean calculateCoordinates(double circleX, double circleY, double circleRadius, double pointX, double pointY) {
        return Math.pow(circleX - pointX, 2) + Math.pow(circleY - pointY, 2) < Math.pow(circleRadius, 2);
    }

    /* Scanner */
    private static boolean scannerContinueQuestion() {
        System.out.println("Хотите продолжить?\n" + "Введите \"Y\", если желаете продолжить.\n" + "Введите \"N\", если хотите прервать операцию.\n");
        String answer = scanner.next();
        if (answer.equals("Y")) {
            return true;
        } else if (answer.equals("N")) {
            System.out.println("Прерываю операцию...\n");
            return false;
        } else {
            return scannerContinueQuestion();
        }
    }

    private static boolean scannerIntChecker(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Число не было введено. Попробуйте еще раз.");
            return false;
        }
    }

    private static boolean scannerDoubleChecker(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Число не было введено. Попробуйте еще раз.");
            return false;
        }
    }
}
