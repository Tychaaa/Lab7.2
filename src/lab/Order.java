package lab;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Класс для объекта "Заказ"
public class Order {
    private static int orderNumberGenerator;  // Генератор номеров заказов
    private int orderNumber;                  // Номер заказа
    private String orderDate;                 // Дата заказа
    private Employee employee;                // Сотрудник магазина
    private Customer customer;                // Клиент
    private VinylRecord orderedRecord;        // Заказанная виниловая пластинка
    private int quantityOrdered;              // Кол/во заказанных виниловых пластинок
    private float totalCost;                  // Общая стоимость заказа

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
        if (orderNumber <= 0) {
            throw new IllegalArgumentException("Номер заказа должен быть положительным целым числом.");
        }
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
        if (quantityOrdered <= 0) {
            throw new IllegalArgumentException("Количество заказанных пластинок должно быть положительным целым числом.");
        }
        this.quantityOrdered = quantityOrdered;
    }

    // Метод для получения итоговой стоимости заказа
    public float getTotalCost() {
        return totalCost;
    }

    // Метод для установки итоговой стоимости заказа
    public void setTotalCost(float totalCost) {
        if (totalCost <= 0) {
            throw new IllegalArgumentException("Итоговая стоимость должна быть положительным числом.");
        }
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

        while (true) {
            try {
                System.out.print("Выберите номер сотрудника: ");
                employeeIndex = scanner.nextInt();

                if (employeeIndex < 1 || employeeIndex > store.getEmployeesInStore().length) {
                    throw new IllegalArgumentException("Некорректный номер сотрудника. Пожалуйста, введите существующий номер.");
                }

                break; // Выход из цикла, если ввод успешен
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введен некорректный номер. Номер должен быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            }
        }

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

        while (true) {
            try {
                System.out.print("Выберите номер виниловой пластинки: ");
                recordIndex = scanner.nextInt();

                if (recordIndex < 1 || recordIndex > store.getVinylRecordsInStore().length) {
                    throw new IllegalArgumentException("Некорректный номер виниловой пластинки. Пожалуйста, введите существующий номер.");
                }

                break; // Выход из цикла, если ввод успешен
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введен некорректный номер. Номер должен быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            }
        }

        orderedRecord = store.getVinylRecordsInStore()[recordIndex - 1];
        System.out.println("-------------------------------------------");

        // Ввод количества заказанных виниловых пластинок с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество заказанных виниловых пластинок: ");
                setQuantityOrdered(scanner.nextInt());
                System.out.println("-------------------------------------------\n");
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. Количество должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        // Вычисляем общую стоимость заказа
        // Создаем объект вспомогательного класса для вычисления итоговой суммы заказа
        OrderHelper result = calculateTotalCost(quantityOrdered, orderedRecord);
        totalCost = result.getValue();
        setTotalCost(totalCost);
    }

    // Метод для вывода информации о заказе
    public static void outputOrder(Order[] orders) {
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
        System.out.println("-------------------------------------------");
        System.out.println("Список заказов удалён!");
        System.out.println("-------------------------------------------\n");
    }

    // Метод для подсчета итоговой стоимости заказа с помощью вспомогательного класса
    public static OrderHelper calculateTotalCost(int quantityOrdered, VinylRecord orderedRecord) {
        float sum = orderedRecord.getPrice() * quantityOrdered;
        return new OrderHelper(sum);
    }

}
