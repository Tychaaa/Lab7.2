package lab;

import java.util.Scanner;

// Класс для объекта "Заказ"
public class Order {
    private int orderNumber;             // Номер заказа
    private String orderDate;            // Дата заказа
    private Employee employee;           // Сотрудник магазина
    private Customer customer;           // Клиент
    private VinylRecord orderedRecord;   // Заказанная виниловая пластинка
    private int quantityOrdered;         // Кол/во заказанных виниловых пластинок
    private float totalCost;             // Общая стоимость заказа

    // Конструктор без параметров
    public Order(){
        this.orderNumber = 0;
        this.orderDate = "";
        this.quantityOrdered = 0;
        this.totalCost = 0;
    }

    // Метод для получения номера заказа
    public int getOrderNumber() {
        return orderNumber;
    }

    // Метод для установки номера заказа
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    // Метод для получения даты заказа
    public String getOrderDate() {
        return orderDate;
    }

    // Метод для установки даты заказа
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    // Метод для получения количества заказанных пластинок
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    // Метод для установки количества заказанных пластинок
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    // Метод для получения итоговой стоимости заказа
    public float getTotalCost() {
        return totalCost;
    }

    // Метод для установки итоговой стоимости заказа
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    // Метод для ввода информации о заказе
    public void inputOrderInfo(Store store) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t~~Оформление заказа~~");
        System.out.println("-------------------------------------------");

        System.out.print("Введите номер заказа: ");
        setOrderNumber(scanner.nextInt());
        scanner.nextLine(); // Очищаем буфер после ввода числа

        System.out.print("Введите дату заказа: ");
        setOrderDate(scanner.nextLine());
        System.out.println("-------------------------------------------");

        // Выводим список доступных сотрудников для выбора
        store.outputEmployeesShortList();
        System.out.print("Выберите номер сотрудника: ");
        int employeeIndex = scanner.nextInt();
        employee = store.getEmployeesInStore()[employeeIndex - 1];
        System.out.println("-------------------------------------------");

        // Выводим список доступных клиентов для выбора
        System.out.println("Введите информацию о клиенте, оформившем заказ:");
        customer = new Customer();
        customer.inputCustomer();
        System.out.println("-------------------------------------------");

        // Выводим список доступных виниловых пластинок для выбора
        store.outputVinylRecordsShortList();
        System.out.print("Выберите номер виниловой пластинки: ");
        int recordIndex = scanner.nextInt();
        orderedRecord = store.getVinylRecordsInStore()[recordIndex - 1];

        System.out.print("Введите количество заказанных виниловых пластинок: ");
        setQuantityOrdered(scanner.nextInt());
        System.out.println("-------------------------------------------\n");

        // Вычисляем общую стоимость заказа
        setTotalCost(orderedRecord.getPrice() * getQuantityOrdered());
        totalCost = orderedRecord.getPrice() * quantityOrdered;
    }

    // Метод для вывода информации о заказе
    public void outputOrder() {
        System.out.println("\n\t~~Информация о заказе~~");
        System.out.println("-------------------------------------------");
        System.out.println("Номер заказа: " + getOrderNumber());
        System.out.println("Дата заказа: " + getOrderDate());
        System.out.println("Сотрудник: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Клиент: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Заказанная виниловая пластинка: " + orderedRecord.getAlbumName() + " - " + orderedRecord.getArtist());
        System.out.println("Количество заказанных виниловых пластинок: " + getQuantityOrdered());
        System.out.println("Общая стоимость заказа: " + getTotalCost());
        System.out.println("-------------------------------------------\n");
    }

}
