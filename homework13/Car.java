package homework13;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    protected String color;
    protected long time = 0;
    protected double accurateTime;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.color = "\u001b[" + (31 + CARS_COUNT % 7) + "m";
        CARS_COUNT++;
        this.name = this.color + "#" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " cкорость: " + speed + ". готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(name + " готов");
            Main.readyToStartBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Main.startLock.tryLock()) {
                System.out.println("\u001b[0m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        }
        this.time = System.currentTimeMillis();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (Main.winnersLock.tryLock()) {
            System.out.println("\u001b[0m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + name + "\u001b[0m" + " - ПОБЕДИЛ!!!");
        }
        System.out.println(name + " преодолел дистанцию за " + (System.currentTimeMillis() - time) + " мс.");
        try {
            Main.finishBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Main.finishLock.tryLock()) {
                System.out.println("\u001b[0m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        }
    }
}