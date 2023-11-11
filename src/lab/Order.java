package lab;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Класс для объекта "Заказ"
public class Order {
    private static int orderNumberGenerator;  // Генератор номеров заказов
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

    // Метод для получения сотрудника, оформившего заказ
    public Employee getEmployee() {
        return employee;
    }

    // Метод для получения клиента, сделавшего заказ
    public Customer getCustomer() {
        return customer;
    }

    // Метод для получения заказанной виниловой пластинки
    public VinylRecord getOrderedRecord() {
        return orderedRecord;
    }

    // Статический метод для генерации уникального номера заказа
    public static int generateOrderNumber() {
        Random random = new Random();
        return random.nextInt(10000) + 1;  // Генерация случайного числа от 1 до 10000
    }

    // Метод для ввода информации о заказе
    public void inputOrderInfo(Store store) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t~~Оформление заказа~~");
        System.out.println("-------------------------------------------");

        orderNumberGenerator = generateOrderNumber();
        setOrderNumber(orderNumberGenerator);

        System.out.println("\tЗаказ №" + orderNumberGenerator);
        System.out.println("-------------------------------------------");

        System.out.print("Введите дату заказа: ");
        setOrderDate(scanner.nextLine());
        System.out.println("-------------------------------------------");

        // Выводим список доступных сотрудников для выбора
        store.outputEmployeesShortList();

        // Ввод индекса сотрудника с проверкой
        int employeeIndex;
        do {
            System.out.print("Выберите номер сотрудника: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Некорректный ввод! Пожалуйста, введите число: ");
                scanner.next(); // Очищаем буфер после некорректного ввода
            }
            employeeIndex = scanner.nextInt();
            if (employeeIndex < 1 || employeeIndex > store.getEmployeesInStore().length) {
                System.out.println("Некорректный номер сотрудника. Пожалуйста, введите существующий номер.");
            }
        } while (employeeIndex < 1 || employeeIndex > store.getEmployeesInStore().length);

        employee = store.getEmployeesInStore()[employeeIndex - 1];
        System.out.println("-------------------------------------------");

        // Вводим данные клиента
        System.out.println("Введите информацию о клиенте, оформившем заказ:");
        customer = new Customer();
        customer.inputCustomer();
        System.out.println("-------------------------------------------");

        // Выводим список доступных виниловых пластинок для выбора
        store.outputVinylRecordsShortList();

        // Ввод индекса виниловой пластинки с проверкой
        int recordIndex;
        do {
            System.out.print("Выберите номер виниловой пластинки: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Некорректный ввод! Пожалуйста, введите число: ");
                scanner.next(); // Очищаем буфер после некорректного ввода
            }
            recordIndex = scanner.nextInt();
            if (recordIndex < 1 || recordIndex > store.getVinylRecordsInStore().length) {
                System.out.println("Некорректный номер виниловой пластинки. Пожалуйста, введите существующий номер.");
            }
        } while (recordIndex < 1 || recordIndex > store.getVinylRecordsInStore().length);

        orderedRecord = store.getVinylRecordsInStore()[recordIndex - 1];
        System.out.println("-------------------------------------------");

        System.out.print("Введите количество заказанных виниловых пластинок: ");
        setQuantityOrdered(scanner.nextInt());
        System.out.println("-------------------------------------------\n");

        // Вычисляем общую стоимость заказа
        setTotalCost(orderedRecord.getPrice() * getQuantityOrdered());
        totalCost = orderedRecord.getPrice() * quantityOrdered;
    }

    // Метод для вывода информации о заказе
    public void outputOrder(Order[] orders) {
        System.out.println("\n\t~~Информация о заказах~~");
        System.out.println("-------------------------------------------");

        for (Order order : orders) {
            if (order != null) {
                System.out.println("\tЗаказ №" + order.getOrderNumber());
                System.out.println("Дата заказа: " + order.getOrderDate());
                System.out.println("Сотрудник: " + order.getEmployee().getFirstName() + " " + order.getEmployee().getLastName());
                System.out.println("Клиент: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
                System.out.println("Заказанная виниловая пластинка: " + order.getOrderedRecord().getAlbumName() + " - " + order.getOrderedRecord().getArtist());
                System.out.println("Количество заказанных виниловых пластинок: " + order.getQuantityOrdered());
                System.out.println("Общая стоимость заказа: " + order.getTotalCost());
                System.out.println("-------------------------------------------");
            }
        }
        System.out.println();
    }

    // Статический метод для очистки массива заказов
    public static void clearOrders(Order[] orders) {
        Arrays.fill(orders, null);
        System.out.println("Список заказов удалён!\n");
    }

}
