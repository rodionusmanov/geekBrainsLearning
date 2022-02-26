package homework8;

import java.util.Random;

public class Robot implements Participant {
    Random random = new Random();
    private String name;
    private int runAbility;
    private int jumpAbility;

    public Robot() {
        this.name = RandomNameSetter.getRobotName();
        this.runAbility = random.nextInt(11) + 15;
        this.jumpAbility = random.nextInt(11) + 15;
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
        return "Робот " + name + " - бегучесть: " + runAbility + ", прыгучесть: " + jumpAbility;
    }
}
