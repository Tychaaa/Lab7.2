package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

// Класс для объекта "Магазин"
public class Store {
    private static final int MAX_RECORDS = 100; // Максимальное количество виниловых пластинок в магазине
    private static final int MAX_EMPLOYEES = 50; // Максимальное количество сотрудников магазина
    private static int numVinylRecords;
    private static int numEmployees;

    private String storeName;    // Название магазина
    private String storeAddress; // Адрес магазина
    private VinylRecord[] vinylRecordsInStore = new VinylRecord[MAX_RECORDS]; // Список имеющихся в магазине виниловых пластинок
    private Employee[] employeesInStore = new Employee[MAX_EMPLOYEES];        // Список сотрудников магазина

    // Конструктор без параметров
    public Store() {
        this.storeName = "";
        this.storeAddress = "";
    }

    // Метод для получения названия магазина
    public String getStoreName() {
        return storeName;
    }

    // Метод для установки названия магазина
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    // Метод для получения адреса магазина
    public String getStoreAddress() {
        return storeAddress;
    }

    // Метод для установки адреса магазина
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    // Методы для получения массива сотрудников магазина
    public Employee[] getEmployeesInStore(){
        return employeesInStore;
    }

    // Методы для получения массива виниловых пластинок в магазине
    public VinylRecord[] getVinylRecordsInStore(){
        return vinylRecordsInStore;
    }

    // Метод для ввода информации о магазине
    public void inputStoreInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t~~Создание магазина~~");
        System.out.println("-------------------------------------------");

        System.out.print("Введите название магазина: ");
        setStoreName(scanner.nextLine());

        System.out.print("Введите адрес магазина: ");
        setStoreAddress(scanner.nextLine());
        System.out.println("-------------------------------------------");

        // Ввод количества виниловых пластинок с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество виниловых пластинок, которые вы хотите добавить: ");
                numVinylRecords = scanner.nextInt();

                if (numVinylRecords > 0) {
                    // Выход из цикла, если ввод успешен и число больше нуля
                    scanner.nextLine(); // Очищаем буфер после ввода числа
                    break;
                } else {
                    throw new IllegalArgumentException("Количество пластинок должно быть положительным целым числом.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. количество должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        System.out.println("-------------------------------------------");
        vinylRecordsInStore = new VinylRecord[numVinylRecords];
        for (int i = 0; i < numVinylRecords; ++i) {
            System.out.println("Ввод информации о виниловой пластинке #" + (i + 1));
            vinylRecordsInStore[i] = new VinylRecord();
            vinylRecordsInStore[i].inputVinylRecord();
            System.out.println("-------------------------------------------");
        }

        // Ввод количества сотрудников с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество сотрудников, которых вы хотите добавить: ");
                numEmployees = scanner.nextInt();

                if (numEmployees > 0) {
                    // Выход из цикла, если ввод успешен и число больше нуля
                    scanner.nextLine(); // Очищаем буфер после ввода числа
                    break;
                } else {
                    throw new IllegalArgumentException("Количество сотрудников должно быть положительным целым числом.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. Количество должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        System.out.println("-------------------------------------------");
        employeesInStore = new Employee[numEmployees];
        for (int i = 0; i < numEmployees; ++i) {
            System.out.println("Ввод информации о сотруднике #" + (i + 1));
            employeesInStore[i] = new Employee();
            employeesInStore[i].inputEmployee();
            System.out.println("-------------------------------------------");
        }
        System.out.println();
    }

    public void addVinylRecordsToStore(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t~~Добавление новых пластинок в магазин~~");

        System.out.println("-------------------------------------------");
        int additionalRecords;
        // Ввод количества виниловых пластинок с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество виниловых пластинок, которые вы хотите добавить: ");
                additionalRecords = scanner.nextInt();

                if (additionalRecords >= 0) {
                    // Выход из цикла, если ввод успешен и число больше нуля
                    scanner.nextLine(); // Очищаем буфер после ввода числа
                    break;
                } else {
                    throw new IllegalArgumentException("Количество пластинок должно быть неотрицательным целым числом.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. Количество должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        if (additionalRecords == 0)
        {
            System.out.println("Добавление отменено!");
            System.out.println("-------------------------------------------");
            System.out.println();
            return;
        }

        int newSize = numVinylRecords + additionalRecords;

        if (newSize > MAX_RECORDS) {
            System.out.println("Ошибка: превышено максимальное количество виниловых пластинок в магазине.");
            return;
        }

        VinylRecord[] newVinylRecords = new VinylRecord[newSize];

        // Копирование существующих записей
        System.arraycopy(vinylRecordsInStore, 0, newVinylRecords, 0, numVinylRecords);

        System.out.println("-------------------------------------------");

        // Добавление новых записей
        for (int i = numVinylRecords; i < newSize; i++) {
            System.out.println("Ввод информации о виниловой пластинке #" + (i + 1));
            newVinylRecords[i] = new VinylRecord();
            newVinylRecords[i].inputVinylRecord();
            System.out.println("-------------------------------------------");
        }

        // Обновление массива виниловых пластинок
        vinylRecordsInStore = newVinylRecords;
        numVinylRecords = newSize;

        System.out.println("Виниловые пластинки успешно добавлены в магазин.");
    }

    public void addEmployeesToStore(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t~~Добавление новых сотрудников в магазин~~");

        System.out.println("-------------------------------------------");
        int additionalEmployees;
        // Ввод количества сотрудников с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество сотрудников, которых вы хотите добавить: ");
                additionalEmployees = scanner.nextInt();

                if (additionalEmployees >= 0) {
                    // Выход из цикла, если ввод успешен и число неотрицательное
                    scanner.nextLine(); // Очищаем буфер после ввода числа
                    break;
                } else {
                    throw new IllegalArgumentException("Количество сотрудников должно быть неотрицательным целым числом.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. Количество должно быть числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        if (additionalEmployees == 0)
        {
            System.out.println("Добавление отменено!");
            System.out.println("-------------------------------------------");
            System.out.println();
            return;
        }

        int newSize = numEmployees + additionalEmployees;

        if (newSize > MAX_EMPLOYEES) {
            System.out.println("Ошибка: превышено максимальное количество сотрудников в магазине.");
            return;
        }

        Employee[] newEmployees = new Employee[newSize];

        // Копирование существующих сотрудников
        System.arraycopy(employeesInStore, 0, newEmployees, 0, numEmployees);

        System.out.println("-------------------------------------------");

        // Добавление новых сотрудников
        for (int i = numEmployees; i < newSize; i++) {
            System.out.println("Ввод информации о дополнительном сотруднике #" + (i + 1));
            newEmployees[i] = new Employee();
            newEmployees[i].inputEmployee();
            System.out.println("-------------------------------------------");
        }

        // Обновление массива сотрудников
        employeesInStore = newEmployees;
        numEmployees = newSize;

        System.out.println("Сотрудники успешно добавлены в магазин.");
    }

    public void removeVinylRecord(){
        Scanner scanner = new Scanner(System.in);

        if (numVinylRecords == 1) {
            System.out.println("\n\t~~ПРЕДУПРЕЖДЕНИЕ~~");
            System.out.println("Невозможно удалить единственную пластинку!\n");
            return;
        }

        System.out.println("\n\t~~Удаление виниловых пластинок из магазина~~");

        System.out.println("-------------------------------------------");
        // Выводим список доступных виниловых пластинок для выбора
        outputVinylRecordsShortList();
        System.out.println("-------------------------------------------");

        int recordIndex;

        while (true) {
            try {
                System.out.print("Выберите номер виниловой пластинки, которую вы хотите удалить: ");
                recordIndex = scanner.nextInt();

                if (recordIndex >= 1 && recordIndex <= numVinylRecords) {
                    break; // Выход из цикла, если ввод успешен
                } else {
                    throw new IllegalArgumentException("Введен некорректный номер виниловой пластинки.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введен некорректный номер. Номер должен быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            }
        }

        // Создаем новый массив с уменьшенным размером
        VinylRecord[] newVinylRecords = new VinylRecord[numVinylRecords - 1];

        // Копируем элементы до удаляемого индекса
        System.arraycopy(vinylRecordsInStore, 0, newVinylRecords, 0, recordIndex - 1);

        // Копируем элементы после удаляемого индекса
        System.arraycopy(vinylRecordsInStore, recordIndex, newVinylRecords, recordIndex - 1, numVinylRecords - recordIndex);

        // Обновляем массив виниловых пластинок
        vinylRecordsInStore = newVinylRecords;
        numVinylRecords--;

        System.out.println("-------------------------------------------");
        System.out.println("Виниловая пластинка успешно удалена из магазина.");
        System.out.println("-------------------------------------------");

        System.out.println();
    }

    public void removeEmployee(){
        Scanner scanner = new Scanner(System.in);

        if (numEmployees == 1) {
            System.out.println("\n\t~~ПРЕДУПРЕЖДЕНИЕ~~");
            System.out.println("Невозможно удалить единственного сотрудника!\n");
            return;
        }

        System.out.println("\n\t~~Удаление сотрудника из магазина~~");

        System.out.println("-------------------------------------------");
        // Выводим список доступных сотрудников для выбора
        outputEmployeesShortList();
        System.out.println("-------------------------------------------");

        int employeeIndex;

        while (true) {
            try {
                System.out.print("Выберите номер сотрудника, которого вы хотите удалить: ");
                employeeIndex = scanner.nextInt();

                if (employeeIndex >= 1 && employeeIndex <= numEmployees) {
                    break; // Выход из цикла, если ввод успешен
                } else {
                    throw new IllegalArgumentException("Введен некорректный номер сотрудника.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введен некорректный номер. Номер должен быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            }
        }

        // Создаем новый массив с уменьшенным размером
        Employee[] newEmployees = new Employee[numEmployees - 1];

        // Копируем элементы до удаляемого индекса
        System.arraycopy(employeesInStore, 0, newEmployees, 0, employeeIndex - 1);

        // Копируем элементы после удаляемого индекса
        System.arraycopy(employeesInStore, employeeIndex, newEmployees, employeeIndex - 1, numEmployees - employeeIndex);

        // Обновляем массив сотрудников
        employeesInStore = newEmployees;
        numEmployees--;

        System.out.println("-------------------------------------------");
        System.out.println("Сотрудник успешно удален из магазина.");
        System.out.println("-------------------------------------------");

        System.out.println();
    }

    // Метод для вывода информации о введенных сотрудниках
    public void outputEmployees() {
        System.out.println("\n\t~~Информация о сотрудниках магазина \"" + getStoreName() + "\"~~");
        int employeeNumber = 1; // Счетчик для номера сотрудника
        System.out.println("---------------------------");
        for (Employee employee : employeesInStore) {
            if (employee != null) {
                System.out.println("Сотрудник #" + employeeNumber);
                System.out.println(employee.toString());  // Заменил метод output используя метод toString
                System.out.println("---------------------------");
                employeeNumber++;
            }
        }
        System.out.println();
    }

    // Метод для вывода краткой информации о сотрудниках магазина
    public void outputEmployeesShortList(){
        System.out.println("Сотрудники магазина:");
        int employeeNumber = 1; // Счетчик для номера сотрудника
        for (Employee employee : employeesInStore) {
            if (employee != null) {
                System.out.println(employeeNumber + ") " + employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getPosition());
                employeeNumber++;
            }
        }
    }

    // Метод для вывода информации о введенных виниловых пластинках
    public void outputVinylRecords() {
        System.out.println("\n\t~~Информация о виниловых пластинках в магазине \"" + getStoreName() + "\"~~");
        int recordNumber = 1; // Счетчик для номера пластинки
        System.out.println("---------------------------");
        for (VinylRecord record : vinylRecordsInStore) {
            if (record != null) {
                System.out.println("Виниловая пластинка #" + recordNumber);
                System.out.println(record.toString());
                System.out.println("---------------------------");
                recordNumber++;
            }
        }
        System.out.println();
    }

    // Метод для вывода краткой информации о виниловых пластинках в магазине
    public void outputVinylRecordsShortList(){
        System.out.println("Пластинки в наличии:");
        int recordNumber = 1;
        for (VinylRecord record : vinylRecordsInStore) {
            if (record != null) {
                System.out.println(recordNumber + ") " +record.getAlbumName() + " - " + record.getArtist() + " (" + record.getQuantity() + " шт.)");
                recordNumber++;
            }
        }
    }

    // Метод для вывода всей информации о магазине
    public void outputStoreInfo() {
        System.out.println("\n\t~~Информация о магазине~~");
        System.out.println("-------------------------------------------");
        System.out.println("Название магазина: " + getStoreName());
        System.out.println("Адрес магазина: " + getStoreAddress());
        outputVinylRecordsShortList();
        outputEmployeesShortList();
        System.out.println("-------------------------------------------\n");
    }
}
