package lab;

// Вспомогательный класс для класса "Order"
public class OrderHelper {

    private float value;     // Переменная для хранения итоговой суммы

    // Конструктор с параметрами
    public OrderHelper (float value){
        this.value = value;
    }

    // Метод для получения значения
    public float getValue() {
        return value;
    }

    // Метод для установки значения
    public void setValue(float value) {
        this.value = value;
    }
}
