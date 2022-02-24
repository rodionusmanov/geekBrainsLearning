package homework7;

public class Main {
    protected static final int NUMBER_OF_PLATES = 3;                //Количество мисок
    protected static final int NUMBER_OF_CATS = 5;                  //Количество котов
    protected static Plate[] plate = new Plate[NUMBER_OF_PLATES];   //Создание массива мисок

    public static void main(String[] args) {
        Cat[] cat = new Cat[NUMBER_OF_CATS];                        //Создание массива котов

        for (int i = 0; i < NUMBER_OF_PLATES; i++) {                //Наполнение массива мисок вместимостью и актуальным количеством корма для каждой
            plate[i] = new Plate(i);                                //Создание i-й миски
            plate[i].printInfo();                                   //Вывод информации о миске
        }
        for (int i = 0; i < NUMBER_OF_CATS; i++) {                  //Наполнение массива котов именем, актуальной сытостью и максимальной сытостью для каждого
            cat[i] = new Cat();                                     //Создание i-го кота
            cat[i].printInfo();                                     //Вывод информации о коте
        }

        feedingCats(cat, plate);                                    //Первая итерация метода кормления котов
        while (overallHunger(cat)) {                                //Цикл, в случае наличия голодных котов, наполняющий миски случайным количеством корма,
            System.out.println("Не все коты сыты");                 //и отправляющий голодных котов на повторную кормежку
            for (int i = 0; i < NUMBER_OF_PLATES; i++) {            //Цикл наполнения каждой миски кормом
                plate[i].refillPlate();                             //Метод, наполняющий миску кормом
            }
            feedingCats(cat, plate);                                //Метод кормления котов
        }
        System.out.println("Все коты сыты");


        for (int i = 0; i < NUMBER_OF_PLATES; i++) {                //Вывод информации о состоянии мисок и котов
            plate[i].printInfo();
        }
        for (int i = 0; i < NUMBER_OF_CATS; i++) {
            cat[i].printInfo();
        }
    }

    public static boolean overallHunger(Cat[] cat) {                //Метод проверки наличия голодных котов
        for (int i = 0; i < NUMBER_OF_CATS; i++) {
            if (cat[i].hunger) {                                    //Проверка состояния голода кота
                return true;
            }
        }
        return false;
    }

    public static void feedingCats(Cat[] cat, Plate[] plate) {      //Метод кормления котов
        int preEatCount;                                            //Переменная уровня голода кота перед кормлением
        int currentCat = 0;                                         //Номер первого голодного кота в массиве
        for (int i = 0; i < NUMBER_OF_PLATES; i++) {
            if (plate[i].foodCount != 0) {                          //Проверка наличия корма в миске
                for (int j = currentCat; j < NUMBER_OF_CATS; j++) { //Цикл поочередно вызывающая котов к миске, пока в ней не кончится корм
                    if (cat[j].currentHunger == cat[j].maxHunger) { //Проверка сытости кота
                        System.out.println(cat[j] + " сыт и не хочет есть");
                        currentCat++;                               //Увеличение номера первого голодного кота
                    } else {
                        preEatCount = plate[i].foodCount;
                        cat[j].eat(plate[i]);                       //Метод кормления кота из миски
                        System.out.print(cat[j].name + " съел из миски №" + (i + 1) + " " + (preEatCount - plate[i].foodCount) + " ед. корма");
                        if (cat[j].maxHunger != cat[j].currentHunger) { //Вывод количества съеденного котом корма и,
                            System.out.println(" и опустошил миску");   //в зависимости от утоления голода, его состояния
                            currentCat = j;
                            break;                                      //Прерывание цикла кормления из миски по причине её пустоты
                        } else {
                            System.out.println(" и теперь сыт");
                        }
                    }
                }
            }
        }
    }
}
