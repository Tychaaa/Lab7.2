package lab;

// Класс для объекта "Магазин", который продает
// не только виниловые пластинки, но также компакт-диски и кассеты
public class StoreItem<T1, T2> {
    private T1 value1;
    private T2 value2;

    // Конструктор без параметров
    public StoreItem() {
        this.value1 = null;
        this.value2 = null;
    }

    // Конструктор с параметрами
    public StoreItem(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    // Метод для вывода информации о товаре
    public void displayInfo() {
        System.out.println("Товар: " + value1 + ", Цена: " + value2 + " руб.");
    }

}
