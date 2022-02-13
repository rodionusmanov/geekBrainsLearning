package homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    private static final char DOT_EMPTY = '•';                  //символ для обозначения пустой ячейки
    private static final char DOT_HUNAN = 'X';                  //символ для обозначения ячейки с ходом игрока
    private static final char DOT_AI = '0';                     //символ для обозначения ячейки с ходом компьютера
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();
    private static char map[][] = new char[30][30];             //двумерный массив, содержащий информацию об игровом поле
    private static int mapSize;                                 //линейный размер игрового поля
    private static int ruleSet;                                 //количество символов в ряд, необходимое для победы
    private static int rowNumber;                               //номер ряда последнего хода
    private static int columnNumber;                            //номер колонки последнего хода
    private static int maxTurnNumber;                           //максимально возможное количество ходов
    private static int turnNumber = 0;                          //счетчик ходов


    public static void main(String[] args) {
        setFieldSize();                                         //метод определяющий размер поля и условия победы
        initField();                                            //метод для инициализации поля с заполнением ячеек пустым значением
        drawField();                                            //метод отображающий в консоль состояние игрового поля и нмерацию строк и колонок
        while (true) {                                          //цикл включающий в себя поочередные ходы человека и компьютера
                                                                //с промежуточным отображением поля и проверкина окончание игры
            humanTurn();                                        //метод хода человека
            drawField();
            if (checkEnd(DOT_HUNAN)) {                          //проверка условия победы человека
                System.out.println("Поздравляю! Человек победил!");
                break;
            }
            if (checkDraw()) {                                  //проверка условия ничьей
                System.out.println("Поле заполнено. Ничья.");
                break;
            }
            aiTurn();                                           //метод хода компьютера
            drawField();
            if (checkEnd(DOT_AI)) {                             //проверка условия победы компьютера
                System.out.println("Машина победила!");
                break;
            }
            if (checkDraw()) {                                  //проверка условия ничьей
                System.out.println("Поле заполнено. Ничья.");
                break;
            }
        }
    }

    private static void aiTurn() {
/*        do {                                      Полный рандом
            rowNumber = random.nextInt(mapSize) + 1;
            columnNumber = random.nextInt(mapSize) + 1;
        } while (map[rowNumber - 1][columnNumber - 1] != DOT_EMPTY);

 */
        boolean isTurnDone = false;                 //переменная завершения хода для первого цикла хода
        outerloop:
        for (int i = 0; i < mapSize; i++) {         //цикл проверяющий каждую свободную ячейку на условие победы человека
            for (int j = 0; j < mapSize; j++) {     //и устанавливающий символ компьютера в первую найденную ячейку удовлетворяющую этому условию
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_HUNAN;
                    if (checkEnd(DOT_HUNAN)) {
                        map[i][j] = DOT_AI;
                        rowNumber = i + 1;
                        columnNumber = j + 1;
                        isTurnDone = true;
                        break outerloop;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        if(!isTurnDone){                            //если в первом цикле проверок не найдено ни одной ячейки удовлетворяющей условию
            outerloop:                              //то происходит заполнение первой попавшейся свободной ячейки символом компьютера
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (map[i][j] == DOT_EMPTY){
                        map[i][j] = DOT_AI;
                        rowNumber = i + 1;
                        columnNumber = j + 1;
                        break outerloop;
                    }
                }
            }
        }
        turnNumber++;                               //увеличение счетчика ходов
    }

    private static boolean checkDraw() {
        return (turnNumber == maxTurnNumber);                   //если количество произведенных ходов равно количеству ячеек, то срабатывает условие ничьей
    }

    private static boolean checkEnd(char sym) {         //проверка методами условий по горизонтали, вертикали и 2 видам диагоналей
        return (checkHorizontal(sym) || checkVertical(sym) || checkPrimaryDiagonal(sym) || checkSecondaryDiagonal(sym));
    }

    private static boolean checkSecondaryDiagonal(char sym) {
        int lineCounter = 0;                            //счетчик проверяемых символов в ряд
        if ((rowNumber + columnNumber - 2) <= mapSize - 1) {    //условие выбора способа прохода по выбранной диагонали
            for (int i = 0; (rowNumber + columnNumber - 2 - i) >= 0; i++) { //цикл проверки наличия необходимого количества проверяемого символа в ряд
                if (map[i][rowNumber + columnNumber - 2 - i] == sym) {
                    lineCounter++;
                    if (lineCounter == ruleSet) {
                        return true;
                    }
                } else {
                    lineCounter = 0;
                }
            }
        } else {
            for (int i = 0; (rowNumber + columnNumber - mapSize + i - 1) < mapSize; i++) {  //цикл проверки наличия необходимого количества проверяемого символа в ряд
                if (map[mapSize - i - 1][rowNumber + columnNumber - mapSize + i - 1] == sym) {
                    lineCounter++;
                    if (lineCounter == ruleSet) {
                        return true;
                    }
                } else {
                    lineCounter = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkPrimaryDiagonal(char sym) {
        int lineCounter = 0;                            //счетчик проверяемых символов в ряд
        if (rowNumber <= columnNumber) {                //условие выбора способа прохода по выбранной диагонали
            for (int i = 0; (i + columnNumber - rowNumber) < mapSize; i++) {    //цикл проверки наличия необходимого количества проверяемого символа в ряд
                if (map[i][columnNumber - rowNumber + i] == sym) {
                    lineCounter++;
                    if (lineCounter == ruleSet) {
                        return true;
                    }
                } else {
                    lineCounter = 0;
                }
            }
        } else {
            for (int i = 0; (i + rowNumber - columnNumber) < mapSize; i++) {    //цикл проверки наличия необходимого количества проверяемого символа в ряд
                if (map[rowNumber - columnNumber + i][i] == sym) {
                    lineCounter++;
                    if (lineCounter == ruleSet) {
                        return true;
                    }
                } else {
                    lineCounter = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkVertical(char sym) {
        int lineCounter = 0;                            //счетчик проверяемых символов в ряд
        for (int i = 0; i < mapSize; i++) {             //цикл проверки наличия необходимого количества проверяемого символа в ряд
            if (map[i][columnNumber - 1] == sym) {
                lineCounter++;
                if (lineCounter == ruleSet) {
                    return true;
                }
            } else {
                lineCounter = 0;
            }
        }
        return false;
    }

    private static boolean checkHorizontal(char sym) {
        int lineCounter = 0;                        //счетчик проверяемых символов в ряд
        for (int i = 0; i < mapSize; i++) {         //цикл проверки наличия необходимого количества проверяемого символа в ряд
            if (map[rowNumber - 1][i] == sym) {
                lineCounter++;
                if (lineCounter == ruleSet) {
                    return true;
                }
            } else {
                lineCounter = 0;
            }
        }
        return false;
    }

    private static void drawField() {
        drawHeader();                                       //метод отображающий в консоль номера колонок
        drawBody();                                         //метод отображающий номера строк и игровое поле
    }

    private static void drawBody() {
        if (mapSize < 10) {                                 //условие определяющее отступы между колонками в зависимости от размера поля
            for (int i = 0; i < mapSize; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < mapSize; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < mapSize; i++) {
                if (i < 9) {                                //условие определяющее отступ для номера строки в зависимости от его значения
                    System.out.print(i + 1 + "  ");
                } else {
                    System.out.print(i + 1 + " ");
                }
                for (int j = 0; j < mapSize; j++) {
                    System.out.print(map[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    private static void humanTurn() {
        do {
            rowNumber = getValidNumber("строки");                  //ввод номера ряда хода игрока с проверкой на правильность ввода
            columnNumber = getValidNumber("столбца");              //ввод номера колонки хода игрока с проверкой на правильность ввода
        } while (map[rowNumber - 1][columnNumber - 1] != DOT_EMPTY);    //проверка на пустое значение введенной ячейки
        map[rowNumber - 1][columnNumber - 1] = DOT_HUNAN;               //присвоение заданной ячейке символа человека
        turnNumber++;                                                   //увеличение счетчика ходов
    }

    private static int getValidNumber(String text) {                    //метод для проверки правильности введенного с клавиатуры значения
        while (true) {
            System.out.println("Введите координату " + text + " в промежутке от 1 до " + mapSize + ":");
            if (in.hasNextInt()) {                                      //условие ввода числа
                int n = in.nextInt();
                if (inMapSize(n)) {                                     //условие ввода числа в интервале размера поля
                    return n;
                }
            } else {
                in.next();
                System.out.println("Допускаются только целые числа");
            }
        }
    }

    private static boolean inMapSize(int n) {
        return (n > 0 && n <= mapSize);
    }

    private static void initField() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void drawHeader() {
        if (mapSize < 10) {                             //условие определяющее отступы между номерами колонок в зависимости от размера поля
            System.out.print("# ");
            for (int i = 0; i < mapSize; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        } else {
            System.out.print("#  ");
            for (int i = 0; i < mapSize; i++) {
                if (i < 9) {                            //условие определяющее отступы между номерами колонок в зависимости от номера колонки
                    System.out.print(i + 1 + "  ");
                } else {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void setFieldSize() {
        do {
            System.out.println("Введите размер поля от 3 до 30:");      //ввод размера поля
            if (in.hasNextInt()) {                                      //проверка на ввод числа
                mapSize = in.nextInt();
            } else {
                in.next();
                System.out.println("Допускаются только целые числа");
            }

        } while (mapSize < 3 || mapSize > 31);                          //ограничение размеров игрового поля
        ruleSet = setWinLength(mapSize);                                //метод, определяющий количество символов в ряд для победы
        maxTurnNumber = mapSize * mapSize;                              //вычисление максимально возможного количества ходов
    }

    private static int setWinLength(int mapSize) {
        if (mapSize < 6) {
            System.out.println("Для победы необходимо 3 символа в ряд");
            return 3;
        } else if (mapSize > 10) {
            System.out.println("Для победы необходимо 5 символов в ряд");
            return 5;
        } else {
            System.out.println("Для победы необходимо 4 символа в ряд");
            return 4;
        }
    }
}
