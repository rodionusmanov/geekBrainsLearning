package homework8;

import java.util.Random;

public class Wall implements Obstacle {

    Random random = new Random();
    int size;

    public Wall() {
        this.size = setSize();
    }

    @Override
    public int setSize() {
        return random.nextInt(18) + 7;
    }

    @Override
    public String type() {
        return "Стена";
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
        return "Стена " + size;
    }
}
