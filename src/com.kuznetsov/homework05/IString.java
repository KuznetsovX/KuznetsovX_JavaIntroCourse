package com.kuznetsov.homework05;

/**
 * <code>IString concat(char charVar)</code> - добавить символ в конец <p>
 * (charVar: 'y')   "He" -> "Hey" <p><p>
 * <code>IString concat(String stringVar)</code> - добавить строку в конец <p>
 * (stringVar: " Java!")   "Hello" -> "Hello Java!" <p><p>
 * <code>IString replaceCharAll(char toReplace, char newChar)</code> - заменить указанный символ <p>
 * (toReplace: '!', newChar: 'l')   "He!!" -> "Hell" <p><p>
 * <code>IString replaceCharOnlyFirst(char toReplace, char newChar)</code> - заменить только первый подходящий символ <p>
 * (toReplace: "X", newChar: "A")   "Size: XXL" -> "Size: AXL" <p><p>
 * <code>IString setChar(int ind, char newChar)</code> - заменить символ (по индексу) <p>
 * (ind: 2, "c")   "Fast!" -> "Fact!" <p><p>
 * <code>char getChar(int ind)</code> - вывести символ <p>
 * (ind: 0)   "Interface" -> "I" <p><p>
 * <code>IString reverse()</code> - переворот всей строки <p>
 * (-)   "Кот Ток Кит Тик" -> "киТ тиК коТ тоК" <p><p>
 * <code>IString reverse(int from, int upTo)</code> - переворот от - до ... <p>
 * (from: 4, upTo: 6)   "Кот Ток" -> "Кот коТ" <p><p>
 * <code>IString subString(int from, int upTo)</code> - вывод указанного участка кода <p>
 * (from: 4, upTo: 6)   "Тор Рот" -> "Рот" <p>
 *
 * @author Kuznetsov
 */

public interface IString {

    char getChar(int ind);

    IString setChar(int ind, char newChar);

    IString replaceCharOnlyFirst(char toReplace, char newChar);

    IString replaceCharAll(char toReplace, char newChar);

    IString reverse();

    IString reverse(int from, int upTo);

    IString swap(int firstInd, int secondInd);

    IString concat(char charVar);

    IString concat(String stringVar);

    IString subString(int from, int upTo);

}//Первое задание ✔
