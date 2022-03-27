package homework12;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static final int QUARTER = HALF / 2;

    public static void main(String[] args) throws InterruptedException {
        //Массивы чисел для прохода одним, двумя и четырьмя потоками
        float[] arr = new float[SIZE];
        float[] arr21 = new float[HALF];
        float[] arr22 = new float[HALF];
        float[] arr41 = new float[QUARTER];
        float[] arr42 = new float[QUARTER];
        float[] arr43 = new float[QUARTER];
        float[] arr44 = new float[QUARTER];
        //Массивы для хранения склееных данных
        float[] arrGlued2 = new float[SIZE];
        float[] arrGlued4 = new float[SIZE];

        //Задание всем элементам массива значения "1"
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        //Клонирование массива с единицами, для последующих операций в потоках
        float[] arrToCut = arr.clone();

        //Проход по массиву с расчетами целиком и вывод времени, затраченного на проход
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время расчета полного массива: " + (System.currentTimeMillis() - a) + " мс");

        //Создание потоков для разбития на 2 массива
        Thread t21 = new Thread(() -> {
            System.arraycopy(arrToCut, 0, arr21, 0, HALF);
            for (int i = 0; i < HALF; i++) {
                arr21[i] = (float) (arr21[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr21, 0, arrGlued2, 0, HALF);
        }, "Первая половина");

        Thread t22 = new Thread(() -> {
            System.arraycopy(arrToCut, HALF, arr22, 0, HALF);
            for (int i = 0; i < HALF; i++) {
                arr22[i] = (float) (arr22[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
            System.arraycopy(arr22, 0, arrGlued2, HALF, HALF);
        }, "Вторая половина");

        //Создание потоков для разбития на 4 массива
        Thread t41 = new Thread(() -> {
            System.arraycopy(arrToCut, 0, arr41, 0, QUARTER);
            for (int i = 0; i < QUARTER; i++) {
                arr41[i] = (float) (arr41[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr21, 0, arrGlued4, 0, QUARTER);
        }, "Первая четверть");

        Thread t42 = new Thread(() -> {
            System.arraycopy(arrToCut, QUARTER, arr42, 0, QUARTER);
            for (int i = 0; i < QUARTER; i++) {
                arr42[i] = (float) (arr42[i] * Math.sin(0.2f + (i + QUARTER) / 5) * Math.cos(0.2f + (i + QUARTER) / 5) * Math.cos(0.4f + (i + QUARTER) / 2));
            }
            System.arraycopy(arr42, 0, arrGlued4, QUARTER, QUARTER);
        }, "Вторая четверть");

        Thread t43 = new Thread(() -> {
            System.arraycopy(arrToCut, HALF, arr43, 0, QUARTER);
            for (int i = 0; i < QUARTER; i++) {
                arr43[i] = (float) (arr43[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) *
                        Math.cos(0.4f + (i + HALF) / 2));
            }
            System.arraycopy(arr43, 0, arrGlued4, HALF, QUARTER);
        }, "Третья четверть");

        Thread t44 = new Thread(() -> {
            System.arraycopy(arrToCut, HALF + QUARTER, arr44, 0, QUARTER);
            for (int i = 0; i < QUARTER; i++) {
                arr44[i] = (float) (arr44[i] * Math.sin(0.2f + (i + HALF + QUARTER) / 5) * Math.cos(0.2f + (i + HALF+ QUARTER) / 5)
                        * Math.cos(0.4f + (i + HALF+ QUARTER) / 2));
            }
            System.arraycopy(arr44, 0, arrGlued4, HALF + QUARTER, QUARTER);
        }, "Четвертая четверть");

        //Проход по двум половинам массива с расчетами, предварительным разбитием основного массива
        //на 2 половины и последующей склейкой, и вывод времени, затраченного на проход
        long b = System.currentTimeMillis();
        t21.start();
        t22.start();
        t21.join();
        t22.join();
        System.out.println("Время расчета разбитого на 2 части массива и последующей склейки: " + (System.currentTimeMillis() - b) + " мс");

        //Проход по четырем частям массива с расчетами, предварительным разбитием основного массива
        //на 4 четверти и последующей склейкой, и вывод времени, затраченного на проход
        long c = System.currentTimeMillis();
        t41.start();
        t42.start();
        t43.start();
        t44.start();
        t41.join();
        t42.join();
        t43.join();
        t44.join();
        System.out.println("Время расчета разбитого на 4 части массива и последующей склейки: " + (System.currentTimeMillis() - c) + " мс");

        //Проверка соответствия отдельных элементов рассчитанных массивов
        System.out.println(arrGlued2[10101] == arr[10101]);
        System.out.println(arrGlued2[5010101] == arr[5010101]);
        System.out.println(arrGlued4[10101] == arr[10101]);
        System.out.println(arrGlued4[2010101] == arr[2010101]);
        System.out.println(arrGlued4[8010101] == arr[8010101]);

    }
}
