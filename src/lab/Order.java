package lab;

import java.util.Scanner;

public class Order {
    private int orderNumber;             // Номер заказа
    private String orderDate;            // Дата заказа
    private Employee employee;           // Сотрудник магазина
    private Customer customer;           // Клиент
    private VinylRecord orderedRecord;   // Заказанная виниловая пластинка
    private int quantityOrdered;         // Кол/во заказанных виниловых пластинок
    private float totalCost;             // Общая стоимость заказа

    public Order(){}

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

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
