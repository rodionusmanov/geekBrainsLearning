package homework5;

public class Employee {
    String surname;
    String name;
    String patronymic;
    String post;
    String mail;
    String phone;
    int salary;
    int age;

    //метод заполнения полей объекта
    public Employee(String surname, String name, String patronymic, String post, String mail, String phone, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.post = post;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //метод представления полей объекта в строку
    public String toString() {
        return String.format("Сотрудник: %s, %s, %s, должность: %s, почта: %s, телефон: %s, зарплата: %d, возраст: %d", surname, name, patronymic, post, mail, phone, salary, age);
    }

    //метод вывода полей в консоль
    public void printInfo() {
        System.out.println(this.toString());
    }
}
