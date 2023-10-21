package lab;

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
        setFirstName(scanner.next());
        scanner.nextLine(); // Очищаем буфер для считывания строки

        System.out.print("Введите фамилию клиента: ");
        setLastName(scanner.next());
        scanner.nextLine(); // Очищаем буфер

        System.out.print("Введите количество денег клиента: ");
        setMoney(scanner.nextFloat());

        scanner.nextLine(); // Очищаем буфер
        System.out.print("Введите адрес доставки клиента: ");
        setAddress(scanner.nextLine());
    }

    // Метод для вывода информации о клиенте
    public void outputCustomer() {
        System.out.println("Имя: " + getFirstName() + " " + getLastName());
//        System.out.println("Фамилия: " + getLastName());
        System.out.println("Количество денег: " + getMoney());
        System.out.println("Адрес доставки: " + getAddress());
    }
}