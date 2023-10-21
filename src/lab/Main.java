package lab;

public class Main {

    public static void main(String[] args) {

     /*   Customer customer1 = new Customer();

        customer1.inputCustomer();
        customer1.outputCustomer();

        Employee employee1 = new Employee();

        employee1.inputEmployee();
        employee1.outputEmployee();*/

        VinylRecord record1 = new VinylRecord();

        System.out.println("\t~~Введите информацию о виниловой пластинке~~");
        record1.inputVinylRecord();
        System.out.println("\t~~Информация о виниловой пластинке~~");
        record1.outputVinylRecord();
    }

}
