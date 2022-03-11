package homework10_3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        int appleCount = 0;
        int orangeCount = 0;

        ArrayList<Box<Fruit>> box = new ArrayList<>();  //Создание списка ящиков
        ArrayList<Orange> orange = new ArrayList<>();   //Создание списка апельсинов
        ArrayList<Apple> apple = new ArrayList<>();     //Создание списка яблок

        //Инициализация 6 пустых ящиков
        for (int i = 0; i < 6; i++) {
            box.add(new Box<>(i, random.nextInt(20) * 0.5 + 8.0));
        }
        //Инициализация 30 апельсинов
        for (int i = 0; i < 30; i++) {
            orange.add(new Orange());
            orangeCount++;
        }
        //Инициализация 30 яблок
        for (int i = 0; i < 30; i++) {
            apple.add(new Apple());
            appleCount++;
        }
        //Попытка добавить 2 апельсина в 0-й ящик
        for (int i = 0; i < 2; i++) {
            box.get(0).add(orange.get(i));
        }
        //Попытка добавить 3 яблока в 1-й ящик
        for (int i = 0; i < 3; i++) {
            box.get(1).add(apple.get(i));
        }
        //Попытка добавить 5 яблок во 2-й ящик
        for (int i = 0; i < 5; i++) {
            box.get(2).add(apple.get(i));
        }
        //Случайный выбор типа фруктов и последующая попытка насыпать в 3-й ящик от 1 до 10 фруктов
        if (random.nextInt(2) == 0) {
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                box.get(3).add(apple.get(i));
            }
        } else {
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                box.get(3).add(orange.get(i));
            }
        }
        //Случайный выбор типа фруктов и последующая попытка насыпать в 4-й ящик от 1 до 10 фруктов
        if (random.nextInt(2) == 0) {
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                box.get(4).add(apple.get(i));
            }
        } else {
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                box.get(4).add(orange.get(i));
            }
        }
        //Попытка добавить в 0-й ящик, содержащий апельсины, 1 яблоко
        box.get(0).add(apple.get(0));
        //Вывод в консоль веса 0-го и 1-го ящиков
        System.out.println("Коробка №" + box.get(0).numberOfBox + " весит " + box.get(0).getWeight());
        System.out.println("Коробка №" + box.get(1).numberOfBox + " весит " + box.get(1).getWeight());
        //Сравнение веса 0-го и 1-го ящика
        System.out.println(box.get(0).compare(box.get(1)));
        //Печать состояния 6 созданных ящиков
        box.get(0).printInfo();
        box.get(1).printInfo();
        box.get(2).printInfo();
        box.get(3).printInfo();
        box.get(4).printInfo();
        box.get(5).printInfo();
        //Попытка пересыпать из 3-го ящика фруктов в пустой 5-й ящик
        box.get(3).pourFruits(box.get(5));
        //Попытка пересыпать из 0-го ящика фруктов в 4-й ящик
        box.get(0).pourFruits(box.get(4));

        //Печать состояния 6 созданных ящиков
        box.get(0).printInfo();
        box.get(1).printInfo();
        box.get(2).printInfo();
        box.get(3).printInfo();
        box.get(4).printInfo();
        box.get(5).printInfo();
    }
}
