package lab;

public abstract class Human {
    private String firstName;   // Имя человека
    private String lastName;    // Фамилия человека

    public Human(){
    }

    public Human(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Методы для установки имени и фамилии человека
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Методы для получения имени и фамилии человека
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

}
