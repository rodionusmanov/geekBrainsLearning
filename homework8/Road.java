package homework8;

import java.util.Random;

public class Road implements Obstacle {

    Random random = new Random();
    int size;

    public Road() {
        this.size = setSize();
    }

    @Override
    public int setSize() {
        return random.nextInt(20) + 5;
    }

    @Override
    public String type() {
        return "Дорожка";
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Дорожка " + size;
    }
}