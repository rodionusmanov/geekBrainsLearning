package homework8;

import java.util.Locale;
import java.util.Random;

public class RandomNameSetter {
    static String[] humNames = {"Алексей", "Борис", "Виталий", "Глеб", "Дмитрий", "Егор", "Захар", "Игорь", "Кирилл", "Максим"};
    static String[] sog = {"б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    static String[] gla = {"а", "е", "и", "у", "ю", "о", "э"};
    static String[] robNames = {"Ax1", "Bs2", "Cz3", "Db4", "Er5", "Fx6", "Gt7", "Hk8", "Id9", "Jr0"};
    static Random random = new Random();

    protected static String getCatName() {      //Метод получения случайного имени путем чередующегося добавления в Строку с именем согласных и гласных букв
        String name = new String();
        name += randomCatSymbol(0).toUpperCase(Locale.ROOT);
        for (int i = 1; i < random.nextInt(3) + 4; i++) {
            name += randomCatSymbol(i);
        }
        return name;
    }

    private static String randomCatSymbol(int i) {    //Метод выбора случайной гласной или согласной буквы, в зависимости от позиции в имени
        if (i % 2 == 0) {
            return sog[random.nextInt(20)];
        }
        return gla[random.nextInt(7)];
    }

    protected static String getHumanName() {
        return humNames[random.nextInt(10)];
    }

    protected static String getRobotName() {
        return robNames[random.nextInt(10)];
    }
}
