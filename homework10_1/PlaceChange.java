package homework10_1;

public class PlaceChange<E> implements PlaceChanger<E> {

    private E[] data;
    private int currentSize;

    @Override
    public void changePlace(int a, int b) {
        E temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    @Override
    public void add(E array) {
        add(array, currentSize);
    }

    public void add(E array, int index) {
        /*if (!(array instanceof Comparable)){
            throw new ClassCastException();
        }*/
        data[index] = array;
        currentSize++;
    }

    public PlaceChange(int size) {
        this.data = (E[]) new Object[size];
        currentSize = 0;
    }

    public void display(){
        for (E datum : data) {
            System.out.print(datum + " - ");
        }
        System.out.println();
    }
}
