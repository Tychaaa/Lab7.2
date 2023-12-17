package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

// Класс для объекта "Клиент"
public class Customer extends Human {
    private float money;        // Количество денег клиента
    private String address;     // Адрес доставки клиента

    // Конструктор без параметров
    public Customer(){
        this.money = 0;
        this.address = "";
    }

    // Контруктор с параметрами
    public Customer(String firstName, String lastName, float money, String address) {
        super(firstName, lastName);
        this.money = money;
        this.address = address;
    }

    // Метод для установки денег клиента
    public void setMoney(float money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Количество денег должно быть положительным числом.");
        }
        this.money = money;
    }

    // Метод для установки адресса клиента
    public void setAddress(String address) {
        this.address = address;
    }

    // Метод для получения адресса клиента
    public float getMoney() {
        return money;
    }

    // Метод для получения количества денег клиента
    public String getAddress() {
        return address;
    }

    // Метод для ввода информации о клиенте
    public void inputCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя клиента: ");
        firstName = scanner.next();
        scanner.nextLine(); // Очищаем буфер для считывания строки

        System.out.print("Введите фамилию клиента: ");
        lastName = scanner.next();
        scanner.nextLine(); // Очищаем буфер

        // Ввод денег клиента с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество денег клиента: ");
                setMoney(scanner.nextFloat());
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество денег. Количество денег должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        scanner.nextLine(); // Очищаем буфер
        System.out.print("Введите адрес доставки клиента: ");
        setAddress(scanner.nextLine());
    }

    // Метод для вывода информации о клиенте
    public void outputCustomer() {
        System.out.println("Имя: " + firstName + " " + lastName);
        System.out.println("Количество денег: " + getMoney());
        System.out.println("Адрес доставки: " + getAddress());
    }
}