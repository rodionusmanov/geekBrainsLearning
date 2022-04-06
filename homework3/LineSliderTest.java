package homework3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;
import java.util.stream.Stream;

class LineSliderTest {

    protected static final Logger logger = Logger.getLogger("LineSliderLogger");
    private int[] lineToSlide = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @BeforeAll
    static void mainStart() throws IOException {
        Handler handler = new FileHandler("src/main/resources/logs/logLineSlider.log");
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

    @BeforeEach
    void startUp() {
        System.out.println(Arrays.toString(lineToSlide));
        logger.log(Level.SEVERE, "логирование на уровне Severe");
        logger.fine("логирование на уровне Fine");
    }


    @DisplayName("Проверка сдвига")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int[] expected, int slide) {
        Assertions.assertArrayEquals(expected, HomeWorkApp3.lineSlider(lineToSlide, slide));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0),
                Arguments.arguments(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2}, 2),
                Arguments.arguments(new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8}, -2),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100),
                Arguments.arguments(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, -137),
                Arguments.arguments(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, Integer.MAX_VALUE)
        );
    }
}
