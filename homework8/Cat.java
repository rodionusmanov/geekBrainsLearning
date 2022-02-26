package homework8;

import java.util.Random;

public class Cat implements Participant {
    Random random = new Random();
    private String name;
    private int runAbility;
    private int jumpAbility;

    public Cat() {
        this.name = RandomNameSetter.getCatName();
        this.runAbility = random.nextInt(15) + 10;
        this.jumpAbility = random.nextInt(15) + 10;
    }

    @Override
    public boolean run(int road) {
        return (this.runAbility >= road);
    }

    @Override
    public boolean jump(int wall) {
        return (this.jumpAbility >= wall);
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Кот " + name + " - бегучесть: " + runAbility + ", прыгучесть: " + jumpAbility;
    }
}
