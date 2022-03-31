package homework13;

public class Road extends Stage {
    private static int numberOfRoad;
    public Road(int length) {
        numberOfRoad++;
        this.length = length;
        this.description = "Дорога-" + numberOfRoad + " " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println("\u001b[0m" + "Время: " + (System.currentTimeMillis() - c.time) + " мс. " + c.getName() + " начал этап: " + description);
            c.accurateTime = ((double) length / (double) c.getSpeed()) * 1000;
            Thread.sleep((long) c.accurateTime);
//            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println("\u001b[0m" + "Время: " + (System.currentTimeMillis() - c.time) + " мс. " + c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
