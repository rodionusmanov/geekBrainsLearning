package homework10_1;

import java.util.Random;

public class Main {
    static final int ARRAY_LENGTH = 10;
    static Random random = new Random();

    public static void main(String[] args) {

        //Создание и заполнение целочисленного массива
        PlaceChange<Integer> intArray = new PlaceChange<>(ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            intArray.add(random.nextInt(100));
        }

        //Создание и заполнение массива строк
        PlaceChange<String> stringArray = new PlaceChange<>(ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            String stringInsert = "";
            for (int j = 0; j < random.nextInt(10) + 1; j++) {
                char charInsert = (char) (random.nextInt(90) + 33);
                stringInsert = stringInsert + charInsert;
            }
            stringArray.add(stringInsert);
        }

        //Создание и заполнение массива котов
        PlaceChange<Cat> catArray = new PlaceChange<>(ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            catArray.add(new Cat());
        }

        //Вывод массивов в начальном виде
        intArray.display();
        stringArray.display();
        catArray.display();

        //Обмен местами элементов массива с заданными индексами
        intArray.changePlace(1, 5);
        stringArray.changePlace(8, 4);
        catArray.changePlace(0, 9);
        System.out.println();

        //Вывод массивов в обработанном виде
        intArray.display();
        stringArray.display();
        catArray.display();

    }
}
