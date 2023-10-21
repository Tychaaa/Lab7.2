package lab;

import java.util.Scanner;

// Класс для объекта "Сотрудник"
public class Employee extends Human {
    private String position;    // Должность сотрудника
    private float salary;       // Зарплата сотрудника

    // Конструктор без параметров
    public Employee(){
        this.position = "";
        this.salary = 0;
    }

    // Контруктор с параметрами
    public Employee(String firstName, String lastName, String position, float salary){
        super(firstName, lastName);
        this.position = position;
        this.salary = salary;
    }

    // Метод для установки должности сотрудника
    public void setPosition(String position) {
        this.position = position;
    }

    // Метод для установки зарплаты сотрудника
    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Метод для получения должности сотрудника
    public String getPosition() {
        return position;
    }

    // Метод для получения зарплаты сотрудника
    public float getSalary() {
        return salary;
    }

    // Метод для ввода информации о сотруднике
    public void inputEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя сотрудника: ");
        setFirstName(scanner.next());
        scanner.nextLine(); // Очищаем буфер для считывания строки

        System.out.print("Введите фамилию сотрудника: ");
        setLastName(scanner.next());
        scanner.nextLine(); // Очищаем буфер для считывания строки

        System.out.print("Введите должность сотрудника: ");
        setPosition(scanner.nextLine());

        System.out.print("Введите зарплату сотрудника: ");
        setSalary(scanner.nextFloat());
    }

    // Метод для вывода информации о сотруднике
    public void outputEmployee() {
        System.out.println("Имя: " + getFirstName() + " " + getLastName());
//        System.out.println("Фамилия: " + getLastName());
        System.out.println("Должность: " + getPosition());
        System.out.println("Зарплата: " + getSalary());
    }
}
