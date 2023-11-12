package lab;

import java.util.Scanner;

public class Main {
    // Флаги для отслеживания создания магазина и заказа
    public static boolean StoreCreated = false;
    public static boolean OrderCreated = false;
    // Добавляем переменную для хранения количества созданных заказов
    private static int OrderCreatedCount = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Создание объектов магазина и заказа
        Store store = new Store();
        Order[] orders = new Order[100];

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
            System.out.println("10. Посмотреть информацию о заказе");
            System.out.println("11. Очистить список заказов");
            System.out.println("0. Выход из программы\n");

            // Ввод выбора пользователя
            System.out.print("Выберите действие: ");
            while (!scan.hasNextInt()) {
                System.out.print("Некорректный ввод!\nВыберите действие: ");
                scan.next(); // Очищаем буфер после некорректного ввода
            }
            input = scan.nextInt();
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
                        newOrder.inputOrderInfo(store);
                        orders[OrderCreatedCount++] = newOrder;
                        OrderCreated = true;
                    }else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 10. Информация о заказе
                case 10:
                    if(StoreCreated && OrderCreated) {
                        Order.outputOrder(orders);
                    }
                    else
                        System.out.println("Ни одного заказа не найдено!\n");
                    break;
                // 10. Очистка списка заказов
                case 11:
                    if (StoreCreated && OrderCreated) {
                        System.out.println("\n\t\t~~ВНИМАНИЕ~~");
                        System.out.println("-------------------------------------------");
                        System.out.println("Вы уверены, что хотите удалить список заказов?");
                        System.out.print("Введите ответ (yes/no): ");
                        String confirm = scan.nextLine().toLowerCase();

                        if (confirm.equals("yes")) {
                            Order.clearOrders(orders);
                            OrderCreatedCount = 0;
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
                System.out.println("Нажмите любую клавишу для продолжения!");
                scan.nextLine(); // Ожидание ввода пользователя
            }
        }while (input != 0);
    }
}
