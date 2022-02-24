package homework7;

import java.util.Locale;
import java.util.Random;

public class Cat {
    String[] sog = {"б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    String[] gla = {"а", "е", "и", "у", "ю", "о", "э"};
    Random random = new Random();
    protected String name;
    protected int currentHunger;
    protected int maxHunger;
    protected boolean hunger;


    public Cat() {                                              //Создание кота
        this.name = getName();                                  //Метод создания случайного имени
        this.currentHunger = random.nextInt(6);           //Метод получения случайного текущего уровня сытости
        this.maxHunger = random.nextInt(11) + 7;          //Метод получения случайного максимального уровня сытости
        this.hunger = (this.maxHunger != this.currentHunger);   //Задание состояния голода кота
    }

    private String getName() {      //Метод получения случайного имени путем чередующегося добавления в Строку с именем согласных и гласных букв
        String name = new String();
        name += randomSymbol(0).toUpperCase(Locale.ROOT);
        for (int i = 1; i < random.nextInt(3) + 4; i++) {
            name += randomSymbol(i);
        }
        return name;
    }

    private String randomSymbol(int i) {    //Метод выбора случайной гласной или согласной буквы, в зависимости от позиции в имени
        if (i % 2 == 0) {
            return sog[random.nextInt(20)];
        }
        return gla[random.nextInt(7)];
    }

    public void printInfo() {   //Метод печати состояния кота
        if (!hunger) {
            System.out.println(this + " - сытый");
        } else {
            System.out.println(this + " - голодный");
        }
    }

    @Override
    public String toString() {
        return "Кот " + name + ": текущая сытость " + currentHunger + "/" + maxHunger + " ед.";
    }

    public void eat(Plate plate) {  //Метод кормления кота из миски
        if (plate.foodCount != 0) { //Проверка на пустоту миски
            currentHunger = maxHunger - plate.decreaseFood(maxHunger - currentHunger); //Получение нового уровня сытости
        }
        this.hunger = (this.maxHunger != this.currentHunger); //Задание состояния голода кота
    }
}

