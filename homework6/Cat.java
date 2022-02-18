package homework6;

public final class Cat extends Animal {

    public Cat(String name) {
        this(name, 0);
    }

    public Cat(String name, int distance) {
        super(name, distance);
        Main.catCount++;
    }

    @Override
    public void run(int distance) {
        setDistance(distance);
        if (getDistance() <= 200 && getDistance() > 0) {
            System.out.printf("%s пробежал %d м.%n", getName(), getDistance());
        } else if (getDistance() > 200) {
            System.out.printf("%s не смог пробежать %d м. Коты не могут бегать на дистанции больше 200 метров%n", getName(), getDistance());
        } else {
            System.out.printf("%s не смог побежать.%n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s пошел ко дну. Местные коты не умеют плавать%n", getName());
    }
}
