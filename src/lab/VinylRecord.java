package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

// Класс для объекта "Виниловая пластинка"
public class VinylRecord {
    private String albumName;   // Название альбома
    private String artist;      // Исполнитель
    private int year;           // Год выпуска
    private String genre;       // Жанр
    private float price;        // Цена
    private int quantity;       // Количество в наличии

    // Конструктор без параметров
    public VinylRecord(){
        this.albumName = "";
        this.artist = "";
        this.year = 0;
        this.genre = "";
        this.price = 0;
        this.quantity = 0;
    }

    // Контруктор с параметрами
    public VinylRecord(String albumName, String artist, int year, String genre, float price, int quantity){
        this.albumName = albumName;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
    }

    // Метод для установки названия виниловой пластинки
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    // Метод для получения названия виниловой пластинки
    public String getAlbumName() {
        return albumName;
    }

    // Метод для установки исполнителя
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Метод для получения исполнителя
    public String getArtist() {
        return artist;
    }

    // Метод для установки года издания
    public int getYear() {
        return year;
    }

    // Метод для получения года издания
    public void setYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должнен быть положительным целым числом.");
        }
        this.year = year;
    }

    // Метод для установки жанра
    public String getGenre() {
        return genre;
    }

    // Метод для получения жанра
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Метод для установки цены виниловой пластинки
    public float getPrice() {
        return price;
    }

    // Метод для получения цены виниловой пластинки
    public void setPrice(float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительным целым числом.");
        }
        this.price = price;
    }

    // Метод для установки количества виниловой пластинки
    public int getQuantity() {
        return quantity;
    }

    // Метод для получения количества виниловой пластинки
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным целым числом.");
        }
        this.quantity = quantity;
    }

    // Метод для ввода информации о виниловой пластинке
    public void inputVinylRecord() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название альбома: ");
        setAlbumName(scanner.nextLine());

        System.out.print("Введите исполнителя: ");
        setArtist(scanner.nextLine());

        // Ввод года выпуска с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите год выпуска: ");
                setYear(scanner.nextInt());
                break; // Выход из цикла, если ввод успешен
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введен некорректный год. Год должен быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        scanner.nextLine(); // Очищаем буфер

        System.out.print("Введите жанр: ");
        setGenre(scanner.nextLine());

        // Ввод цены с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите цену: ");
                setPrice(scanner.nextFloat());
                break; // Выход из цикла, если ввод успешен
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введена некорректная цена. Цена должна быть числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }

        // Ввод количества с защитой от некорректного ввода
        while (true) {
            try {
                System.out.print("Введите количество в наличии: ");
                setQuantity(scanner.nextInt());
                break; // Выход из цикла, если ввод успешен
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка: Введено некорректное количество. Количество должно быть целым числом.\n");
                scanner.nextLine(); // Очищаем буфер
            } catch (IllegalArgumentException e) {
                System.out.println("\nОшибка: " + e.getMessage() + "\n");
            }
        }
    }

    // Метод для вывода информации о виниловой пластинке
    public void outputVinylRecord() {
        System.out.println("Название альбома: " + getAlbumName());
        System.out.println("Исполнитель: " + getArtist());
        System.out.println("Год выпуска: " + getYear());
        System.out.println("Жанр: " + getGenre());
        System.out.println("Цена: " + getPrice());
        System.out.println("Количество в наличии: " + getQuantity());
    }
}
