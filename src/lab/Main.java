package lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\t~~Первая программа на Java~~");
        System.out.println("Главное меню:");
        System.out.println("1. Создать магазин пластинок");
        System.out.println("2. Посмотреть информацию о сотрудниках");
        System.out.println("3. Посмотреть ассортимент магазина");
        System.out.println("4. Создать заказ");
        System.out.println("5. Посмотреть информацию о заказе\n");

        int input;

        do {
            System.out.print("Выберите действие: ");
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();

            switch (input) {
                case 1:
                    System.out.println("1 действие");
                    break;
                case 2:
                    System.out.println("2 действие");
                    break;
                case 3:
                    System.out.println("3 действие");
                    break;
                case 4:
                    System.out.println("4 действие");
                    break;
                case 5:
                    System.out.println("5 действие");
                    break;
                default:
                    System.out.println("Некорректный выбор!\n");
            }
        }while (input < 1 || input > 5);
    }

}
