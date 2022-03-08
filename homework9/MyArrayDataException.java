package homework9;

import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException() {
        super("Элемент невозможно преобразовать в int");
    }
}
