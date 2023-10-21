package lab;

public class Store {
    private static final int MAX_RECORDS = 100; // Максимальное количество виниловых пластинок в магазине
    private static final int MAX_EMPLOYEES = 50; // Максимальное количество сотрудников магазина

    private String storeName;    // Название магазина
    private String storeAddress; // Адрес магазина
    private VinylRecord[] vinylRecordsInStore = new VinylRecord[MAX_RECORDS]; // Список имеющихся в магазине виниловых пластинок
    private Employee[] employeesInStore = new Employee[MAX_EMPLOYEES];        // Список сотрудников магазина

    // Конструктор без параметров
    public Store() {
        this.storeName = "";
        this.storeAddress = "";
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public VinylRecord[] getVinylRecordsInStore() {
        return vinylRecordsInStore;
    }

    public void setVinylRecordsInStore(VinylRecord[] vinylRecordsInStore) {
        this.vinylRecordsInStore = vinylRecordsInStore;
    }

    public Employee[] getEmployeesInStore() {
        return employeesInStore;
    }

    public void setEmployeesInStore(Employee[] employeesInStore) {
        this.employeesInStore = employeesInStore;
    }


}
