package homework3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp3 {
    static Random random = new Random();            //Задание переменной рендомайзера
    static Scanner in = new Scanner(System.in);     //Задание переменной для считывания с консоли

    public static void main(String[] args) {
        System.out.printf("1 пункт д/з: %n");
        numberInverter();                           //Вызов метода 1 пункта д/з
        System.out.printf("%n2 пункт д/з: %n");
        oneHundred();                               //Вызов метода 2 пункта д/з
        System.out.printf("%n3 пункт д/з: %n");
        underSixDoubler();                          //Вызов метода 3 пункта д/з
        System.out.printf("%n4 пункт д/з: %n");
        crossOne();                                 //Вызов метода 4 пункта д/з
        System.out.printf("%n5 пункт д/з: %n Введите размер массива: %n");
        int len = in.nextInt();                     //Ввод через консоль длины массива 5 пункта д/з
        System.out.printf("%nВведите значение элемента массива: %n");
        int initialValue = in.nextInt();            //Ввод через консоль значения элемента массива 5 пункта д/з
        System.out.println("Полученный массив: " + Arrays.toString(lengthLineFiller(len, initialValue))); //Вывод на экран полученного массива полученного из метода 5 пункта д/з
        System.out.printf("%n6 пункт д/з: %n");
        minMaxFinder();                             //Вызов метода 6 пункта д/з
        System.out.printf("%n7 пункт д/з: %n");
        int[] lineToCheck = new int[10];            //Создание массива из 10 элементов с его последующим заполнением случайными числами
        for (int i = 0; i < lineToCheck.length; i++) {
            lineToCheck[i] = random.nextInt(1, 9);
        }
        System.out.println("Массив для проверки баланса: " + Arrays.toString(lineToCheck));
        System.out.println(balanceChecker(lineToCheck));    //Вывод результата работы метода 7 пункта д/з в виде переменной типа boolean
        System.out.printf("%n8 пункт д/з: %n");
        int[] lineToSlide = new int[10];            //Создание и заполнение массива последовательными числами для наглядности
        for (int i = 0; i < lineToSlide.length; i++) {
            lineToSlide[i] = i + 1;
        }
        System.out.println(Arrays.toString(lineToSlide));   //Вывод на экран массива в изначальной форме
        System.out.printf("%nВведите значение сдвига массива массива (знак '-' сдвигает вправо): %n");
        int n = in.nextInt();                       //Ввод через консоль значения сдвига массива
        lineSlider(lineToSlide, n);                 //Вызов метода 8 пункта д/з
    }

    public static void numberInverter() {
        int[] numberLine = new int[10];     //Создание и заполение массива 1 и 0 в случайном порядке
        for (int i = 0; i < numberLine.length; i++) {
            numberLine[i] = random.nextInt(2);
        }
        System.out.println("Заданный массив:        " + Arrays.toString(numberLine));   //Вывод изначального массива
        for (int i = 0; i < numberLine.length; i++) {       //Цикл, меняющий значение элементов массива
            if (numberLine[i] == 0) {
                numberLine[i] = 1;
            } else {
                numberLine[i] = 0;
            }
        }
 /*       for (int i = 0; i < numberLine.length; i++) {     альтернативный вариант
            numberLine[i] = 1 - numberLine[i];
        } */
        System.out.println("Инвертированный массив: " + Arrays.toString(numberLine));   //Вывод инвертированного массива
    }

    public static void oneHundred() {
        int[] oneHun = new int[100];        //Создание и заполнение массива значениями по порядку
        for (int i = 0; i < oneHun.length; i++) {
            oneHun[i] = i + 1;
        }
        System.out.println("Полученный массив: " + Arrays.toString(oneHun));    //Вывод полученного массива
    }

    public static void underSixDoubler() {
        int[] doubler = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //Создание и заполнение массива заданными числами
        System.out.println("Заданный массив:            " + Arrays.toString(doubler));  //Вывод изначального массива
        for (int i = 0; i < doubler.length; i++) {  //Цикл умножающий чила меньшие 6 на 2
            if (doubler[i] < 6) {
                doubler[i] *= 2;
            }
        }
        System.out.println("Обработанный массив:        " + Arrays.toString(doubler));  //Вывод обработанного массива
    }

    public static void crossOne() {
        int leng = random.nextInt(3, 10);   //Задание случайного размра двумерного матрицы
        int[][] cross = new int[leng][leng];            //Создание и заполнение нулями двумерного массива
        for (int[] row : cross) {
            Arrays.fill(row, 0);
        }
        System.out.println("Начальный двумерный массив:");  //Вывод изначального массива
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < leng; j++) {
                System.out.print(cross[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Обработанный двумерный массив:");   //Присвоение диагональным элементам массива значения 1
        for (int i = 0; i < leng; i++) {
            cross[i][i] = 1;
            cross[i][leng - i - 1] = 1;
        }
        for (int i = 0; i < leng; i++) {                        //Вывод полученного массива
            for (int j = 0; j < leng; j++) {
                System.out.print(cross[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] lengthLineFiller(int len, int initialValue) {
        int[] filledLine = new int[len];            //Создание массива с 'len' количестом элементов
        Arrays.fill(filledLine, initialValue);      //Заполнение массива элементами равными 'initialValue'
        return filledLine;                          //Возврат массива в вызывающий метод
    }

    public static void minMaxFinder() {
        int[] numberLine = new int[10];                 //Создание и заполнение массива случайными элементами
        for (int i = 0; i < numberLine.length; i++) {
            numberLine[i] = random.nextInt(20);
        }
        System.out.println("Заданный массив:        " + Arrays.toString(numberLine));   //ывод полученного массива
        int min = numberLine[0];        //Создание переменных содержащих минимальное и максимальное значения элементов массива
        int max = numberLine[0];
        for (int i = 1; i < numberLine.length; i++) {   //Цикл, сравнивающий значение каждого элемента массива с ммаксимальным и минимальным
            if (numberLine[i] > max) {
                max = numberLine[i];
            }
            if (numberLine[i] < min) {
                min = numberLine[i];
            }
        }
        System.out.printf("Минимальное значение элемента: %d%nМаксимальное значение элемента: %d%n", min, max); //Вывод минимального и максимального значений массива
    }

    public static boolean balanceChecker(int[] lineToCheck) {
        int sum = 0;            //Создание вспомогательных переменных
        int controlNum = 0;
        for (int i = 0; i < lineToCheck.length; i++) {  //Цикл, определяющий сумму элементов массива
            sum += lineToCheck[i];
        }
        System.out.println("Сумма элементов = " + sum);
        if (sum % 2 == 1) {     //Проверка и отсев нечетных значений суммы элементов
            return false;
        }
        int count = 0;      //Вспомогательная переменная-счетчик
        sum /= 2;           //Определение значения необходимого для баланса между половинами массива
        do {                //Цикл, определяющий соблюдение баланса между частями массива
            controlNum += lineToCheck[count];
            if (controlNum == sum) {
                return true;
            }
            count++;
        }
        while (controlNum < sum);   //Если баланс не достигнут, а сумма уже просуммированных элементов превысила значение баланса,
        return false;               //то происходит завершение цикла с последующим возвратом отрицательно результата в вызывающий метод
    }

    public static void lineSlider(int[] lineToSlide, int n) {
        System.out.println("Сещенный на " + n + " массив:");
        n %= lineToSlide.length;        //Отсечение от переменной сдвига значений полного смещения цикла
        if (n < 0) {                    //Перевод отрицательного сдвиг в аналогичный положительный
            n = lineToSlide.length + n;
        }
        for (int i = n; i < (lineToSlide.length + n); i++) {    //Вывод в консоль внешнего вида сдвинутого массива
            System.out.print(lineToSlide[(i) % lineToSlide.length] + " ");
        }
        System.out.println();
        int reserve;                                            //Создание вспомогательной переменной
        for (int i = 0; i < n; i++) {                           //Постепенный сдвиг элементов массива на заданное значение
            reserve = lineToSlide[0];                           //с последующим получением обработанного массива
            for (int j = 0; j < (lineToSlide.length - 1); j++) {
                lineToSlide[j] = lineToSlide[j + 1];
            }
            lineToSlide[lineToSlide.length - 1] = reserve;
        }
        System.out.println(Arrays.toString(lineToSlide));       //Вывод в консоль сдвинутого массива
    }
}
