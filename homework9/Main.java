package homework9;

import java.util.Scanner;

public class Main {
    private static final int ROWS = 4;
    private static final int COLUMNS = 4;

    public static void main(String[] args) {
        String[][] arrayToCheck = new String[ROWS][COLUMNS];

        arrayToCheck = fillArray();

        checkForExceptions(arrayToCheck);
    }

    private static String[][] fillArray() {
        Scanner in = new Scanner(System.in);
        String[][] filledArray = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.printf("Введите значение элемента %d-%d: ", i, j);
                filledArray[i][j] = in.next();
            }
        }
        in.close();
        return filledArray;
    }

    public static void checkForExceptions(String[][] arrayToCheck) {
        try {
            if (ROWS != 4 || COLUMNS != 4) {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            if (ROWS != 4) {
                System.out.println("Количество строк не соответсвует требованиям длины в 4 элемента. Строк в массиве: " + ROWS);
            } else if (COLUMNS != 4) {
                System.out.println("Количество столбцов не соответсвует требованиям длины в 4 элемента. Столбцов в массиве: " + COLUMNS);
            }
        }

        int sumOfElements = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                try {
                    if (arrayToCheck[i][j] == null || arrayToCheck[i][j].equals("")) {
                        throw new MyArrayDataException();
                    }
                    if (!isNumeric(arrayToCheck[i][j])) {
                        throw new MyArrayDataException();
                    }
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                    System.out.println("Тип данных элемента " + i + "-" + j + " невозможно преобразовать в тип 'int': ");

                }
                sumOfElements += Integer.parseInt(arrayToCheck[i][j]);
            }
        }
        System.out.println("Сумма элементов массива: " + sumOfElements);

    }

    public static boolean isNumeric(String elementToParse) {
        int tryValue;
        try {
            tryValue = Integer.parseInt(elementToParse);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}