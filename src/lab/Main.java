package lab;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Флаги для отслеживания создания магазина и заказа
    public static boolean StoreCreated = false;
    public static boolean OrderCreated = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Создание объектов магазина и заказа
        Store store = new Store();

        // Заменил массив на ArrayList
        ArrayList<Order> orders = new ArrayList<>();

        String[][] vinylInfo = new String[100][3];

        int input;

        System.out.println("\t~~Модификация программы из лабораторной работы №3~~");

        // Главный цикл программы
        do {
            // Отображение главного меню
            System.out.println("\tГлавное меню:");
            System.out.println("1. Создать магазин пластинок");
            System.out.println("2. Добавить пластинки в магазин");
            System.out.println("3. Добавить сотрудников в магазин");
            System.out.println("4. Удалить пластинку из ассортимента");
            System.out.println("5. Удалить сотрудника из магазина");
            System.out.println("6. Посмотреть информацию о магазине");
            System.out.println("7. Посмотреть информацию о сотрудниках");
            System.out.println("8. Посмотреть ассортимент магазина");
            System.out.println("9. Создать заказ");
            System.out.println("10. Найти заказ");
            System.out.println("11. Посмотреть информацию о заказе");
            System.out.println("12. Посмотреть информацию о заказе (сортировка по номеру заказа)");
            System.out.println("13. Посмотреть информацию о заказанных пластинках");
            System.out.println("14. Очистить список заказов");
            System.out.println("15. Дублировать (клон) заказ");
            System.out.println("16. Демонстрация использования шаблона класса");
            System.out.println("0. Выход из программы\n");

            // Ввод выбора пользователя с защитой от некорректного ввода
            while (true) {
                try {
                    System.out.print("Выберите действие: ");
                    input = scan.nextInt();

                    if (input < 0){
                        throw new IllegalArgumentException("Некорректный выбор! Пожалуйста, введите существующий номер.");
                    }

                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nОшибка: Введите целое число.\n");
                    scan.nextLine(); // Очищаем буфер после некорректного ввода
                } catch (IllegalArgumentException e) {
                    System.out.println("\nОшибка: " + e.getMessage() + "\n");
                    scan.nextLine(); // Очищаем буфер после некорректного ввода
                }

            }

            scan.nextLine(); // Очищаем буфер после ввода числа

            // Обработка выбора пользователя
            switch (input) {
                // 1. Создание магазина
                case 1:
                    // Создание нового магазина
                    if(!StoreCreated) {
                        store.inputStoreInfo();
                        StoreCreated = true;
                    // Пересоздание магазина, если он уже был создан
                    }else{
                        System.out.println("\n\t\t~~ПРЕДУПРЕЖДЕНИЕ~~");
                        System.out.println("-------------------------------------------");
                        System.out.println("Магазин уже создан. Хотите создать новый магазин?");
                        System.out.print("Введите ответ (yes/no): ");
                        String response = scan.nextLine().toLowerCase();
                        System.out.println("-------------------------------------------");

                        if (response.equals("yes")) {
                            store.inputStoreInfo();
                            OrderCreated = false;
                        } else {
                            System.out.println("Магазин не будет пересоздан.");
                            System.out.println("-------------------------------------------\n");
                        }
                    }
                    break;
                // 2. Добавление пластинок
                case 2:
                    if(StoreCreated)
                        store.addVinylRecordsToStore();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 3. Добавление сотрудников
                case 3:
                    if(StoreCreated)
                        store.addEmployeesToStore();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 4. Удаление пластинок
                case 4:
                    if(StoreCreated)
                        store.removeVinylRecord();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 5. Удаление сотрудников
                case 5:
                    if(StoreCreated)
                        store.removeEmployee();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 6. Информация о магазине
                case 6:
                    if(StoreCreated)
                        store.outputStoreInfo();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 7. Информация о сотрудниках
                case 7:
                    if(StoreCreated)
                        store.outputEmployees();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 8. Информация о пластинках
                case 8:
                    if(StoreCreated)
                        store.outputVinylRecords();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 9. Создание заказа
                case 9:
                    if(StoreCreated) {
                        Order newOrder = new Order();
                        newOrder.inputOrderInfo(store, vinylInfo);
                        orders.add(newOrder); // Использую метод add для ArrayList
                        OrderCreated = true;
                    }else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 10. Поиск заказа
                case 10:
                    if (StoreCreated && OrderCreated) {
                        Order.findOrderByNumberAndDisplay(orders);
                    } else {
                        System.out.println("Ни одного заказа не найдено!\n");
                    }
                    break;
                // 11. Информация о заказе
                case 11:
                    if(StoreCreated && OrderCreated) {
                        // Преобразую ArrayList в массив для совместимости с существующим кодом
                        Order.outputOrder(orders.toArray(new Order[0]));
                    }
                    else
                        System.out.println("Ни одного заказа не найдено!\n");
                    break;
                // 12. Информация о заказе (сортировка по номеру заказа)
                case 12:
                    if (StoreCreated && OrderCreated) {
                        Order.outputSortedOrderList(orders);
                    } else {
                        System.out.println("Ни одного заказа не найдено!\n");
                    }
                    break;
                // 13. Информация о заказанных пластинках
                case 13:
                    if (StoreCreated && OrderCreated) {
                        Order.outputOrderInfo(vinylInfo);
                    } else {
                        System.out.println("Ни одного заказа не найдено!\n");
                    }
                    break;
                // 14. Очистка списка заказов
                case 14:
                    if (StoreCreated && OrderCreated) {
                        System.out.println("\n\t\t~~ВНИМАНИЕ~~");
                        System.out.println("-------------------------------------------");
                        System.out.println("Вы уверены, что хотите удалить список заказов?");
                        System.out.print("Введите ответ (yes/no): ");
                        String confirm = scan.nextLine().toLowerCase();

                        if (confirm.equals("yes")) {
                            orders.clear(); // Использую метод clear для очистки ArrayList
                            OrderCreated = false;
                        } else {
                            System.out.println("-------------------------------------------");
                            System.out.println("Операция удаления отменена.");
                            System.out.println("-------------------------------------------\n");
                        }

                    } else {
                        System.out.println("Ни одного заказа не найдено!\n");
                    }
                    break;
                // 15. Клонирование заказов
                case 15:
                    if (StoreCreated && OrderCreated) {
                        System.out.println("\n\t\t~~Клонирование заказов~~");
                        System.out.println("-------------------------------------------");

                        // Выводим список созданных заказов
                        System.out.println("Список созданных заказов:");
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println((i + 1) + ". Заказ №" + orders.get(i).getOrderNumber());
                        }

                        int selectedOrderIndex;
                        // Выбор заказа для клонирования
                        while (true) {
                            try {
                                System.out.print("Выберите номер заказа для клонирования: ");
                                selectedOrderIndex = scan.nextInt();

                                if (selectedOrderIndex < 1 || selectedOrderIndex > orders.size()) {
                                    throw new IllegalArgumentException("Некорректный номер заказа. Пожалуйста, введите существующий номер.");
                                }

                                break; // Выход из цикла, если ввод успешен
                            } catch (InputMismatchException e) {
                                System.out.println("\nОшибка: Введен некорректный номер. Номер должен быть целым числом.\n");
                                scan.nextLine(); // Очищаем буфер после некорректного ввода
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nОшибка: " + e.getMessage() + "\n");
                                scan.nextLine(); // Очищаем буфер после некорректного ввода
                            }
                        }

                        // Очистка буфера после ввода числа
                        scan.nextLine();

                        try {
                            // Клонирование заказа
                            Order clonedOrder = (Order) orders.get(selectedOrderIndex - 1).deepClone();
                            orders.add(clonedOrder);

                            System.out.println("-------------------------------------------");
                            System.out.println("Заказ успешно клонирован!");
                            System.out.println("-------------------------------------------\n");

                        } catch (CloneNotSupportedException e) {
                            System.out.println("\nОшибка при клонировании заказа: " + e.getMessage() + "\n");
                        }
                    } else {
                        System.out.println("Ни одного заказа не найдено!\n");
                    }
                    break;
                // 16. Демонстрация использования шаблона класса
                case 16:
                    System.out.println("\n\t~~Демонстрация использования шаблона класса~~\n");

                    // Пример использования класса StoreItem с разными типами данных
                    StoreItem<String, Double> vinylRecord = new StoreItem<>("Classic Vinyl", 1999.90);
                    StoreItem<String, Double> cd = new StoreItem<>("Rock CD", 1499.50);
                    StoreItem<String, Double> cassette = new StoreItem<>("80s Mixtape", 999.40);

                    // Вывод информации о товарах
                    vinylRecord.displayInfo();
                    cd.displayInfo();
                    cassette.displayInfo();

                    System.out.println();
                    break;
                // Выход из программы
                case 0:
                    System.out.println("\n\t--------------");
                    System.out.println("\t До свидания!");
                    System.out.println("\t--------------");
                    break;
                // Пользователь выбрал несуществующее действие
                default:
                    System.out.println("Некорректный выбор!\n");
            }
            // Прерывание программы пока пользователь не нажмет клавишу
            if (input != 0) {
                System.out.println("Нажмите 'ENTER' для продолжения!");
                scan.nextLine(); // Ожидание ввода пользователя
            }
        }while (input != 0);
    }
}
