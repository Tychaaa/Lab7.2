package lab;

import java.util.Scanner;

public class Store {
    private static final int MAX_RECORDS = 100; // Максимальное количество виниловых пластинок в магазине
    private static final int MAX_EMPLOYEES = 50; // Максимальное количество сотрудников магазина

    private String storeName;    // Название магазина
    private String storeAddress; // Адрес магазина
    private VinylRecord[] vinylRecordsInStore = new VinylRecord[MAX_RECORDS]; // Список имеющихся в магазине виниловых пластинок
    private Employee[] employeesInStore = new Employee[MAX_EMPLOYEES];        // Список сотрудников магазина

    // Конструктор без параметров
    public Store() {
        this.storeName = "";
        this.storeAddress = "";
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    // Метод для ввода информации о магазине
    public void inputStoreInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t~~Создание магазина виниловых пластинок~~");

        System.out.print("Введите название магазина: ");
        setStoreName(scanner.nextLine());

        System.out.print("Введите адрес магазина: ");
        setStoreAddress(scanner.nextLine());
        System.out.println("-------------------------------------------");

        System.out.print("Введите количество виниловых пластинок, которые вы хотите добавить: ");
        int numVinylRecords = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после ввода числа

        System.out.println("-------------------------------------------");
        vinylRecordsInStore = new VinylRecord[numVinylRecords];
        for (int i = 0; i < numVinylRecords; ++i) {
            System.out.println("Ввод информации о виниловой пластинке #" + (i + 1));
            vinylRecordsInStore[i] = new VinylRecord();
            vinylRecordsInStore[i].inputVinylRecord();
            System.out.println("-------------------------------------------");
        }

        System.out.print("Введите количество сотрудников, которых вы хотите добавить: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после ввода числа

        System.out.println("-------------------------------------------");
        employeesInStore = new Employee[numEmployees];
        for (int i = 0; i < numEmployees; ++i) {
            System.out.println("Ввод информации о сотруднике #" + (i + 1));
            employeesInStore[i] = new Employee();
            employeesInStore[i].inputEmployee();
            System.out.println("-------------------------------------------");
        }
    }
    // Метод для вывода информации о введенных сотрудниках
    public void outputEmployees() {
        System.out.println("Информация о сотрудниках магазина \"" + getStoreName() + "\"");
        int employeeNumber = 1; // Счетчик для номера сотрудника
        System.out.println("---------------------------");
        for (Employee employee : employeesInStore) {
            if (employee != null) {
                System.out.println("Сотрудник #" + employeeNumber);
                System.out.println("Имя: " + employee.getFirstName());
                System.out.println("Фамилия: " + employee.getLastName());
                System.out.println("Должность: " + employee.getPosition());
                System.out.println("Зарплата: " + employee.getSalary());
                System.out.println("---------------------------");
                employeeNumber++;
            }
        }
    }
    // Метод для вывода информации о введенных виниловых пластинках
    public void outputVinylRecords() {
        System.out.println("Информация о виниловых пластинках в магазине \"" + getStoreName() + "\"");
        int recordNumber = 1; // Счетчик для номера пластинки
        System.out.println("---------------------------");
        for (VinylRecord record : vinylRecordsInStore) {
            if (record != null) {
                System.out.println("Виниловая пластинка #" + recordNumber);
                System.out.println("Название альбома: " + record.getAlbumName());
                System.out.println("Исполнитель: " + record.getArtist());
                System.out.println("Год выпуска: " + record.getYear());
                System.out.println("Жанр: " + record.getGenre());
                System.out.println("Цена: " + record.getPrice());
                System.out.println("Количество в наличии: " + record.getQuantity());
                System.out.println("---------------------------");
                recordNumber++;
            }
        }
    }
    // Метод для вывода всей информации о магазине
    public void outputStoreInfo() {
        System.out.println("Информация о магазине:");
        System.out.println("Название магазина: " + getStoreName());
        System.out.println("Адрес магазина: " + getStoreAddress());
        System.out.println("Пластинки в наличии:");
        int recordNumber = 1;
        for (VinylRecord record : vinylRecordsInStore) {
            if (record != null) {
                System.out.println(recordNumber + ") " +record.getAlbumName() + " - " + record.getArtist() + " (" + record.getQuantity() + " шт.)");
                recordNumber++;
            }
        }
        System.out.println("Сотрудники магазина:");
        int employeeNumber = 1; // Счетчик для номера сотрудника
        for (Employee employee : employeesInStore) {
            if (employee != null) {
                System.out.println(employeeNumber + ") " + employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getPosition());
                employeeNumber++;
            }
        }
    }
}
