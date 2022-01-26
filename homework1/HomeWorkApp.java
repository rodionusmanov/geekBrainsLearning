package homework1;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {                 //1 пункт домашнего задания

    public static void main(String[] args) {
        printThreeWords();                 //вызов метода 2 пункта домашнего задания
        checkSumSign();                    //вызов метода 3 пункта домашнего задания
        printColor();                      //вызов метода 4 пункта домашнего задания
        compareNumbers();                  //вызов метода 5 пункта домашнего задания
    }

    public static void printThreeWords() {  //объявление метода 2 пункта домашнего задания
        System.out.println("Orange");       //построчный вывод слов
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println("");             //отделительная строка между выводами методов
    }

    public static void checkSumSign() {     //объявление метода 3 пункта домашнего задания
        int a = ThreadLocalRandom.current().nextInt(-10, 9);    //объявление переменной "a" со случайным значением в интервале (-10 ; 9)
        int b = ThreadLocalRandom.current().nextInt(-10, 9);    //объявление переменной "b" со случайным значением в интервале (-10 ; 9)
        System.out.println("a = " + a);     //построчный вывод объявленных переменных
        System.out.println("b = " + b);
        System.out.println("a + b = " + (a + b));   //контрольный вывод суммы переменных
        if (a + b >= 0) {                           //проверка знака полученной суммы с последующим выводом результата
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
        System.out.println("");             //отделительная строка между выводами методов
    }

    public static void printColor() {        //объявление метода 4 пункта домашнего задания
        int value = ThreadLocalRandom.current().nextInt(-99, 200);  //объявление переменной "value" со случайным значением в интервале (-99 ; 200)
        System.out.println("value = " + value);          //контрольный вывод переменной "value"
        if (value <= 0) {                   //проверка принадлежности переменной "value" к одному из интервалов и последующий вывод результата
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else System.out.println("Зеленый");
        System.out.println("");             //отделительная строка между выводами методов
    }

    public static void compareNumbers() {    //объявление метода 5 пункта домашнего задания
        int a = ThreadLocalRandom.current().nextInt(-10, 9);    //объявление переменной "a" со случайным значением в интервале (-10 ; 9)
        int b = ThreadLocalRandom.current().nextInt(-10, 9);    //объявление переменной "b" со случайным значением в интервале (-10 ; 9)
        System.out.println("a = " + a);     //контрольный вывод объявленных переменных
        System.out.println("b = " + b);
        if (a >= b) {                        //сравнение переменных с последующим выводом результата
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }
}
