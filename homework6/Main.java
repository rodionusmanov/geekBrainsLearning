package homework6;

public class Main {

    static int animalCount = 0;
    static int catCount = 0;
    static int dogCount = 0;

    public static void main(String[] args) {


        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Цапиль");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Dog dog3 = new Dog("Чапиль");
        Cat cat4 = new Cat("Тестер", 17);

        cat1.run(140);
        cat2.run(305);
        cat3.run(-2);
        dog1.run(560);
        dog2.run(430);
        dog3.run(-4);
        cat1.swim(1);
        dog1.swim(3);
        dog2.swim(12);
        dog3.swim(-3);

        System.out.printf("Создано %d животных: %n", animalCount);
        System.out.printf("Создано %d котов: %n", catCount);
        System.out.printf("Создано %d собак: %n", dogCount);
    }
}
