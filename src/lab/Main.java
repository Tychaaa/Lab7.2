package lab;

import java.util.Scanner;

public class Main {

    public static boolean StoreCreated = false;
    public static boolean OrderCreated = false;
    public static void main(String[] args) {

        int input;
        Store store1 = new Store();

        System.out.println("\t~~Первая программа на Java~~");
        System.out.println("Главное меню:");
        System.out.println("1. Создать магазин пластинок");
        System.out.println("2. Посмотреть информацию о магазине");
        System.out.println("3. Посмотреть информацию о сотрудниках");
        System.out.println("4. Посмотреть ассортимент магазина");
        System.out.println("5. Создать заказ");
        System.out.println("6. Посмотреть информацию о заказе");
        System.out.println("0. Выход из программы\n");

        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Выберите действие: ");
            while (!scan.hasNextInt()) {
                System.out.print("Некорректный ввод!\nВыберите действие: ");
                scan.next(); // Очищаем буфер после некорректного ввода
            }
            input = scan.nextInt();

            switch (input) {
                // 1. Создание магазина
                case 1:
                    // Создание нового магазина
                    if(!StoreCreated) {
                        store1.inputStoreInfo();
                        StoreCreated = true;
                    // Пересоздание магазина, если он уже был создан
                    }else{
                        System.out.println("Магазин уже создан. Хотите пересоздать магазин? (да/нет)");
                        String response = scan.nextLine().toLowerCase();

                        if (response.equals("да")) {
                            store1.inputStoreInfo();
                        } else {
                            System.out.println("Магазин не будет пересоздан.");
                        }
                    }
                    break;
                // 2. Информация о магазине
                case 2:
                    if(StoreCreated)
                        store1.outputStoreInfo();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!");
                    break;
                // 3. Информация о сотрудниках
                case 3:
                    if(StoreCreated)
                        store1.outputEmployees();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!");
                    break;
                // 4. Информация о пластинках
                case 4:
                    if(StoreCreated)
                        store1.outputVinylRecords();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!");
                    break;
                case 5:
                    if(StoreCreated) {
                        System.out.println();
                        StoreCreated = true;
                    }else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!");
                    break;
                case 6:
                    if(StoreCreated && OrderCreated)
                        System.out.println();
                    else
                        System.out.println("Ни одного заказа не найдено!");
                    break;
                case 0:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Некорректный выбор!\n");
            }
        }while (input != 0);
    }

}
