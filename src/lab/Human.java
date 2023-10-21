package lab;

// Абстрактный класс для объекта "Человек"
public abstract class Human {
    private String firstName;   // Имя человека
    private String lastName;    // Фамилия человека

    // Конструктор без параметров
    public Human(){
        this.firstName = "";
        this.lastName = "";
    }

    // Контруктор с параметрами
    public Human(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Метод для установки имени человека
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Метод для установки фамилии человека
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Методы для получения имени человека
    public String getFirstName() {
        return firstName;
    }
    // Метод для получения фамилии человека
    public String getLastName() {
        return lastName;
    }

}
