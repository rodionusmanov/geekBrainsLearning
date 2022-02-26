package homework8;

import java.util.Random;

public class Main {

    private static final Random random = new Random();
    private static final int humanCount = random.nextInt(4) + 1;  //Задание случайного числа людей
    private static final int catCount = random.nextInt(4) + 1;    //Задание случайного числа котов
    private static final int robotCount = random.nextInt(4) + 1;  //Задание случайного числа роботов
    private static final int NUMBER_OF_PARTICIPANTS = (humanCount + catCount + robotCount);  //Установка размера массива учатников
    private static final int NUMBER_OF_OBSTACLES = 4;             //Размер массива препятствий
    private static final Participant[] participants = new Participant[NUMBER_OF_PARTICIPANTS]; //Массив участников
    private static final Obstacle[] obstacles = new Obstacle[NUMBER_OF_OBSTACLES];            //Массив перпятствий

    public static void main(String[] args) {
        System.out.printf("Участники:%n");
        int count = 0;
        while (count < humanCount + catCount + robotCount) {    //Наполнение массива участников заданным числом людей, котов и роботов
            if (count < humanCount) {
                participants[count] = new Human();              //Каждый участник создается со случайными параметрами,
            } else if (count < humanCount + catCount) {         //разнящимися от класса к классу
                participants[count] = new Cat();
            } else if (count < humanCount + catCount + robotCount) {
                participants[count] = new Robot();
            }
            count++;
        }
        for (int i = 0; i < count; i++) {   //Вывод массива с информацией об участниках
            participants[i].printInfo();
        }
        System.out.printf("%nПрепятствия:%n");
        for (int i = 0; i < NUMBER_OF_OBSTACLES; i++) { //Наполнение массива препятствий заданным числом дорожек и стенок
            if (random.nextInt(2) == 0) {   //Условие случайного выбора дорожки или стены для создания
                obstacles[i] = new Road();          //Создание дорожки
            } else {
                obstacles[i] = new Wall();          //Создание стены
            }
        }
        for (int i = 0; i < NUMBER_OF_OBSTACLES; i++) { //Вывод массива с информацией о препятствиях
            obstacles[i].printInfo();
        }
        System.out.printf("%nПреодоление препятствий:%n");
        for (int i = 0; i < count; i++) {   //Цикл прогоняющий каждого из участников по полосе препятствий
            boolean active = true;  //Отметка о том, что участник не сошел с дистанции
            for (int j = 0; j < NUMBER_OF_OBSTACLES; j++) { //Цикл прогоняющий участница по каждому препятствию
                if (obstacles[j].type().equals("Дорожка")) { //Проверка на тип препятствия
                    active = active && participants[i].run(obstacles[j].getSize());     //Проверка на преодоление дорожки
                } else {
                    active = active && participants[i].jump(obstacles[j].getSize());    //Проверка на преодоление стены
                }
                if (!active) {   //Проверка на сход с дистанции с выводом непреодоленного препятствия с остановкой вложенного цикла
                    System.out.println(participants[i].getName() + " сошел с дистанции на препятствии: " + obstacles[j].type() + " " + obstacles[j].getSize());
                    break;
                }
            }
            if (active) {       //Проверка на преодоление последнего препятствия с выводом сообщения об успехе
                System.out.println(participants[i].getName() + " преодолел дистанцию");
            }
        }
    }

}

