package homework3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

class BalanceCheckerTest {

    protected static final Logger logger = Logger.getLogger("BalanceCheckerLogger");

    @BeforeAll
    static void mainStart() throws IOException {
        Handler handler = new FileHandler("src/main/resources/logs/logBalanceChecker.log");
        logger.addHandler(handler);
        logger.setLevel(Level.FINE);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s\t%s\t%s%n", record.getLevel(), new Date(record.getMillis()), record.getMessage());
            }
        });
        handler.setLevel(Level.FINE);
    }

    @DisplayName("Проверка балансный массив")
    @Test
    void testAdd1() {
        int[] lineToCheck = {1, 2, 3, 4, 5, 6, 2, 1, 3, 3};
        Assertions.assertEquals(true, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка дисбалансный массив, нечетная сумма элементов")
    @Test
    void testAdd2() {
        int[] lineToCheck = {2, 2, 3, 4, 5, 6, 2, 1, 3, 3};
        Assertions.assertEquals(false, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка дисбалансный массив, четная сумма элементов")
    @Test
    void testAdd3() {
        int[] lineToCheck = {4, 2, 3, 4, 5, 6, 2, 1, 2, 3};
        Assertions.assertEquals(false, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка дисбалансный массив, отрицательный элемент")
    @Test
    void testAdd4() {
        int[] lineToCheck = {-4, 2, 3, 4, 5, 6, 2, 1, 2, 1};
        Assertions.assertEquals(false, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка дисбалансный массив, отрицательные элементы")
    @Test
    void testAdd5() {
        int[] lineToCheck = {-1, -2, -3, -4, -5, -6, -2, -1, -3, -3};
        Assertions.assertEquals(true, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка балансный массив, 2 значения")
    @Test
    void testAdd6() {
        int[] lineToCheck = {-8, 8};
        Assertions.assertEquals(true, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка балансный массив, значения с разными знаками")
    @Test
    void testAdd7() {
        int[] lineToCheck = {1, 1, 0, -7, 3, 4, -1, 2, 3};
        Assertions.assertEquals(true, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

    @DisplayName("Проверка, один элемент")
    @Test
    void testAdd8() {
        int[] lineToCheck = {1};
        Assertions.assertEquals(false, HomeWorkApp3.balanceChecker(lineToCheck));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }

}