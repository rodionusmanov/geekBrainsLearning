package homework10_1;

import java.util.Locale;
import java.util.Random;

public class Cat {
    String[] sog = {"б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    String[] gla = {"а", "е", "и", "у", "ю", "о", "э"};
    Random random = new Random();
    protected String name;
    protected String color;


    public Cat() {                                              //Создание кота
        this.name = getName();                                  //Метод создания случайного имени
        this.color = getColor();
    }

    private String getColor() {
        String[] colorArray = {"Белый", "Черный", "Рыжий", "Полосатый", "Серый", "Голубой", "Лысый"};
        return colorArray[random.nextInt(7)];
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

    @Override
    public String toString() {
        return color + " " + name;
    }

}

