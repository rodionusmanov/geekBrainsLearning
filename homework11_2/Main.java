package homework11_2;

public class Main {

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Ivanov", "12");
        pb.add("Ivanov", "13");
        pb.add("Yanov", "31");
        pb.add("Ivanov", "13");
        pb.add("Petrov", "1122");
        pb.add("Petrov", "13");
        pb.get("Ivanov");
        pb.get("Yanov");
        pb.get("Petrov");
        pb.get("Sidorov");
    }
}
