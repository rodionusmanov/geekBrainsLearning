package homework6;

public abstract class Animal {
    private String name;
    private int distance;

    public Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
        Main.animalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
