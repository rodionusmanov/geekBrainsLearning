package homework9;

import java.io.IOException;

public class MyArraySizeException extends IOException {

    public MyArraySizeException() {
        super("Размер массива не соответствует требованиям");
    }

//    public MyArraySizeException() {
//        super("Размер массива не соответствует требованиям");
//    }
}
