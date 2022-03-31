package homework13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semophore;
    private static int numberOfTunnel;

    public Tunnel() {
        numberOfTunnel++;
        this.length = 80;
        this.description = "Тоннель-" + numberOfTunnel + " " + length + " метров";
        this.semophore = new Semaphore(Main.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {

        try {
            System.out.println("\u001b[0m" + "Время: " + (System.currentTimeMillis() - c.time) + " мс. "
                    + c.getName() + " готовится к этапу(ждет): " + description);
            this.semophore.acquire();
            System.out.println("\u001b[0m" + "Время: " + (System.currentTimeMillis() - c.time) + " мс. "
                    + c.getName() + " начал этап: " + description + ". Мест в туннеле: " + this.semophore.availablePermits());
            c.accurateTime = ((double) length / (double) c.getSpeed()) * 1000;
            Thread.sleep((long) c.accurateTime);
//            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\u001b[0m" + "Время: " + (System.currentTimeMillis() - c.time) + " мс. "
                    + c.getName() + " закончил этап: " + description + ". Мест в туннеле: " + (this.semophore.availablePermits() + 1));
            this.semophore.release();
        }
    }
}

