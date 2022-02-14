package homework5;

import lesson05.Player;

public class HomeWorkApp5 {
    public static void main(String[] args) {

        Employee[] empArray = new Employee[5];      //создание массива объектов типа "Employee" из 5 экземпляров
                                                    //заполнение полей объектов
        empArray[0] = new Employee("Abramov", "Anton", "Andreevich", "postman", "AAA@mailpost.com", "89123456789", 20000, 40);
        empArray[1] = new Employee("Baranov", "Boris", "Borisovich", "engineer", "BBB@mailpost.com", "89121098765", 45000, 42);
        empArray[2] = new Employee("Voronov", "Vladislav", "Vladimirovich", "postman", "VVV@mailpost.com", "89123332621", 22000, 45);
        empArray[3] = new Employee("Gruzdev", "Georgiy", "Glebovich", "engineer", "GGG@mailpost.com", "89172353466", 48000, 34);
        empArray[4] = new Employee("Deev", "Denis", "Denisovich", "director", "DDD@mailpost.com", "89262342521", 80000, 48);
        System.out.printf("Полный список сотрудников:%n");  //вывод полного списка сотрудников
        for (int i = 0; i < 5; i++) {
            empArray[i].printInfo();
        }
        System.out.printf("%nСотрудники старше 40 лет:%n"); //вывод списка сотрудников старше 40 лет
        for (int i = 0; i < 5; i++) {
            if (empArray[i].age > 40) {
                empArray[i].printInfo();
            }
        }
    }
}
