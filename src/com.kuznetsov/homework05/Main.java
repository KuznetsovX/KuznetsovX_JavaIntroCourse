package com.kuznetsov.homework05;

public class Main {

    /*
    1. Написать интерфейс IString. ✔
    2. Создать реализацию MutableString. ✔
    3. Создать реализацию ImmutableString. ✔
    */

    public static void main(String[] args) {

        System.out.println("\n---Mutable String---");
        IString mutableString = new MutableString(new char[]{'H', 'E', 'L', 'L', 'O'});
        //Write your code here   (╯°□°）╯︵ ┻━┻
        System.out.println(mutableString);


        System.out.println("\n---Immutable String---");
        IString immutableString = new ImmutableString(new char[]{'H', 'E', 'L', 'L', 'O'});
        //Write your code here   ┬─┬ ノ( ゜-゜ノ)
        System.out.println(immutableString);
    }
}
