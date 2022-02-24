package homework7;


import java.util.Random;

public class Plate {
    Random random = new Random();
    private int numberOfPlate;
    protected int foodCount;
    private int capacity;

    public Plate(int numberOfPlate) {                   //Создание миски
        this.numberOfPlate = numberOfPlate + 1;         //Получение порядкового номера
        this.foodCount = random.nextInt(15) + 3;    //Начальное наполнение случайным количеством корма
        this.capacity = random.nextInt(20) + 20;    //Случайная максимальная вместимость миски
    }

    public void printInfo() {
        System.out.println(this);
    }   //Вывод состояния миски

    @Override
    public String toString() {
        return "Миска " + numberOfPlate +
                ", содержит " + foodCount + "/" + capacity + " ед.";
    }

    public int decreaseFood(int eatFood) {  //Метод уменьшения количества корма в миске
        if (this.foodCount == 0) {          //Проверка на пустоту миски
            return eatFood;
        }
        int remainingHunger = 0;            //Переменная для возврата оставшегося уровня голода кота после кормления из данной миски
        if (eatFood <= foodCount) {         //Проверка достаточного уровня корма в миске для удовлетворения кота
            this.foodCount -= eatFood;      //Уменьшение количества корма на уровень голода кота
            return 0;                       //Возврат текущего уровня голода
        } else {
            remainingHunger = eatFood - this.foodCount; //Получение уровня голода кота после опустошения миски
            this.foodCount = 0;             //Опустошение миски
            return remainingHunger;         //Возврат текущего уровня голода
        }
    }


    public void refillPlate() {             //Метод заполнения миски случайным количеством корма, таким образом, чтобы не превысить вместимость миски
        int refill = random.nextInt((this.capacity - this.foodCount)) + 1;
        System.out.println("В миску №" + this.numberOfPlate + " досыпано " + refill + " ед. корма");    //Вывод информации о количестве добавленного корма
        this.foodCount += refill;           //Изменение текущего количества корма в миске
    }
}
