package homework10_3;

public interface BoxInterface<E> {

    void add(Fruit item);

    double getWeight();

    boolean compare(Box boxToCompare);

    void printInfo();

    void pourFruits(Box boxToPour);
}
