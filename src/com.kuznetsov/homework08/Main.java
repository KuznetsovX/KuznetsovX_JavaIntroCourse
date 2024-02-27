package com.kuznetsov.homework08;

public class Main {

    /*
    1. Написать свой стек на массиве для char. ✔
    2. Вывести строку задом наперед с использованием стека. ✔
    3. Определить является ли строка “{()}(){}[]<>((({}[])))” правильной скобочной последовательностью (ПСП). ✔
    4. * Если да то вывести ее в стиле программирования. ✔
     */

    public static void main(String[] args) {

        String string = "!ьсоличулоп ёсв ,йанз - едив моньламрон в отэ ьшеатич ыт илсЕ";//Если ты читаешь это в нормальном виде - знай, всё получилось!
        CharStack charStack = new CharStack();
        for (char i : string.toCharArray()) {
            charStack.add(i);
        }
        while (!charStack.isEmpty()) {
            System.out.print(charStack.remove());
        }
        System.out.println();

        String stringToCheck = "({})(){}[]<>((({}[])))";
        System.out.println("Строка \"" + stringToCheck + "\"  " + (isCorrectSequenceOfParentheses(stringToCheck) ? "" : "не ") + "корректна.");
        if (isCorrectSequenceOfParentheses(stringToCheck)) {
            printSequenceOfParentheses(stringToCheck);
        }
    }

    private static boolean isCorrectSequenceOfParentheses(String string) {
        CharStack charStack = new CharStack();
        for (char i : string.toCharArray()) {
            switch (i) {
                case '(':
                case '{':
                case '[':
                case '<':
                    charStack.add(i);
            }
            switch (i) {
                case ')':
                    if (charStack.get() != '(') return false;
                    else charStack.remove();
                    continue;
                case '}':
                    if (charStack.get() != '{') return false;
                    else charStack.remove();
                    continue;
                case ']':
                    if (charStack.get() != '[') return false;
                    else charStack.remove();
                    continue;
                case '>':
                    if (charStack.get() != '<') return false;
                    else charStack.remove();
            }
        }

        return charStack.isEmpty();
    }//Третье задание ✔

    private static void printSequenceOfParentheses(String string) {
        CharStack charStack = new CharStack();
        System.out.println("Начало вывода");
        for (char i : string.toCharArray()) {
            switch (i) {
                case '(':
                case '{':
                case '[':
                case '<':
                    for (int j = 0; j < charStack.length; j++) System.out.print(charStack.get());
                    charStack.add('\t');
            }
            switch (i) {
                case ')':
                case '}':
                case ']':
                case '>':
                    charStack.remove();
                    for (int j = 0; j < charStack.length; j++) System.out.print(charStack.get());
            }
            System.out.println(i);
        }
        System.out.println("Конец вывода");
    }//Четвёртое задание ✔
}
