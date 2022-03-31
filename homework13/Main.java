package homework13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int CARS_COUNT = 6;
    public static Lock winnersLock = new ReentrantLock();
    public static Lock prepareToStartLock = new ReentrantLock();
    public static Lock startLock = new ReentrantLock();
    public static Lock finishLock = new ReentrantLock();
    public static CyclicBarrier readyToStartBarrier = new CyclicBarrier(CARS_COUNT);
    public static CyclicBarrier finishBarrier = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args) {
        prepareToStartLock.lock();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!\nПропускная способность тоннелей: " + CARS_COUNT / 2);
        prepareToStartLock.unlock();
        Race race = new Race(new Road(30), new Tunnel(), new Road(40), new Road(50), new Tunnel(), new Road(15));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 30 + (int) (Math.random() * 30));
        }
        if (prepareToStartLock.tryLock()) {
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
        }
    }
}



