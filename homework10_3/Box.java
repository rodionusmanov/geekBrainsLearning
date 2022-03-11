package homework10_3;


public class Box<E> implements BoxInterface<E> {
    protected int numberOfBox;
    private int numberOfFruits;
    private double currentCapacity;
    private double capacity;
    private String typeOfFruits;
    private Fruit[] fruitsIn = new Fruit[100];

    public Box(int numberOfBox, double capacity) {
        this.numberOfBox = numberOfBox;
        this.numberOfFruits = 0;
        this.currentCapacity = 0.0;
        this.capacity = capacity;
        this.typeOfFruits = "";
    }

    @Override
    //Метод добавки фруктов в ящик
    public void add(Fruit fruit) {
        //Проверка на пустоту ящика
        if (typeOfFruits == "") {
            typeOfFruits = fruit.type;
        }
        //Проверка на соответствие типов фруктов
        if (typeOfFruits == fruit.type) {
            //Проверка на наличие свободного места для вносимого фрукта
            if ((currentCapacity + fruit.weight) <= capacity) {
                //Добавка фрукта в ящик
                fruitsIn[numberOfFruits] = fruit;
                currentCapacity += fruit.weight;
                numberOfFruits++;
            } else {
                System.out.println("Еще " + fruit.type + " не поместится в коробке №" + numberOfBox);
            }
        } else {
            System.out.println("В эту коробку №" + numberOfBox + " можно положить только " + typeOfFruits);
        }
    }

    @Override
    //Метод возвращающий вес ящика
    public double getWeight() {
        return currentCapacity;
    }

    @Override
    //Метод, сравнивающий вес ящиков
    public boolean compare(Box boxToCompare) {
        return this.currentCapacity == boxToCompare.currentCapacity;
    }

    @Override
    //Метод вывода информации о ящике в консоль
    public void printInfo() {
        System.out.println("Коробка №" + numberOfBox + " содержит " + typeOfFruits + " в количестве " + numberOfFruits +
                " штук. Коробка заполнена на: " + currentCapacity + "/" + capacity);
    }

    @Override
    //Метод пересыпания фруктов из одного ящика в другой
    public void pourFruits(Box boxToPour) {
        //Проверка на пустой исходный ящик
        if (this.numberOfFruits == 0) {
            System.out.println("Исходная коробка пуста");
            //Проверка на пустоту конечного ящика и возможность добавить в него фрукт
        } else if (boxToPour.numberOfFruits == 0 && boxToPour.capacity < this.fruitsIn[0].weight) {
            System.out.printf("В пустой коробке №%d нет места для %s.", boxToPour.numberOfBox, this.typeOfFruits);
            //Присвоение конечному ящику типа, содержащихся в нем фруктов
        } else if (boxToPour.numberOfFruits == 0) {
            boxToPour.typeOfFruits = this.typeOfFruits;
        }
        {
            int count = 0;  //Счетчик пересыпанных фруктов
            //Проверка на соответствие типов фруктов в ящиках
            if (this.typeOfFruits == boxToPour.typeOfFruits) {
                //Проверка на наличие свободного места в конечном ящике
                if (boxToPour.capacity - boxToPour.currentCapacity < this.fruitsIn[0].weight) {
                    System.out.printf("Из коробки №%d не высыпали %s так как в коробке №%d не хватает места.%n",
                            this.numberOfBox, boxToPour.typeOfFruits, boxToPour.numberOfBox);
                } else {
                    //Цикл, на каждую итерацию переносящий один фрукт из исходного ящика в конечный
                    //и проверяющий конечный ящик на возможность принять еще один фрукт
                    while (boxToPour.capacity >= boxToPour.currentCapacity + this.fruitsIn[0].weight && this.numberOfFruits > 1) {
                        boxToPour.add(fruitsIn[0]);
                        this.fruitsIn[this.numberOfFruits - 1] = null;
                        this.currentCapacity -= fruitsIn[0].weight;
                        this.numberOfFruits--;
                        count++;
                    }
                    //Перенос последнего фрукта из исходного ящика и обнуление типа фруктов в исходном ящике
                    if (boxToPour.capacity >= boxToPour.currentCapacity + this.fruitsIn[0].weight && this.numberOfFruits == 1) {
                        boxToPour.add(fruitsIn[0]);
                        this.currentCapacity -= fruitsIn[0].weight;
                        this.fruitsIn[this.numberOfFruits - 1] = null;
                        this.numberOfFruits--;
                        this.typeOfFruits = "";
                        System.out.printf("Из коробки №%d полностью высыпали %s. В коробке №%d теперь %d %s%n",
                                this.numberOfBox, boxToPour.typeOfFruits, boxToPour.numberOfBox, boxToPour.numberOfFruits, boxToPour.typeOfFruits);

                    } else {
                        System.out.printf("Из коробки №%d высыпали %d %s. В коробке №%d теперь %d %s%n",
                                this.numberOfBox, count, this.typeOfFruits, boxToPour.numberOfBox, boxToPour.numberOfFruits, boxToPour.typeOfFruits);

                    }
                }
            } else {
                System.out.println("В коробках содержатся разные виды фруктов");
            }
        }
    }
}
