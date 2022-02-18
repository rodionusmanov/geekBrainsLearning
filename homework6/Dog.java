package homework6;

public final class Dog extends Animal {

    public Dog(String name) {
        this(name, 0);
    }

    public Dog(String name, int distance) {
        super(name, distance);
        Main.dogCount++;
    }

    @Override
    public void run(int distance) {
        setDistance(distance);
        if (getDistance() <= 500 && getDistance() > 0) {
            System.out.printf("%s пробежал %d м.%n", getName(), getDistance());
        } else if (getDistance() > 500) {
            System.out.printf("%s не смог пробежать %d м. Собаки не могут бегать на дистанции больше 500 метров%n", getName(), getDistance());
        } else {
            System.out.printf("%s не смог побежать.%n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        setDistance(distance);
        if (getDistance() <= 10 && getDistance() > 0) {
            System.out.printf("%s проплыл %d м.%n", getName(), getDistance());
        } else if (getDistance() > 10) {
            System.out.printf("%s не смог проплыть %d м. Собаки не могут плавать на дистанции больше 10 метров%n", getName(), getDistance());
        } else {
            System.out.printf("%s не смог поплыть.%n", getName());
        }
    }
}

