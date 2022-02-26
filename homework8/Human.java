package homework8;

import java.util.Random;

public class Human implements Participant {
    Random random = new Random();
    private String name;
    private int runAbility;
    private int jumpAbility;

    public Human() {
        this.name = RandomNameSetter.getHumanName();
        this.runAbility = random.nextInt(20) + 6;
        this.jumpAbility = random.nextInt(20) + 6;
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
        return "Человек " + name + " - бегучесть: " + runAbility + ", прыгучесть: " + jumpAbility;
    }
}
