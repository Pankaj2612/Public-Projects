public class Employee {
    String name;
    int empId;
    double salary;
    Date hireDate;
    String jobPosition;
    String contactNumber;
    Address address;

    Employee(String name, int empId, double salary, Date hireDate, String jobPosition, String contactNumber, Address address) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.hireDate = hireDate;
        this.jobPosition = jobPosition;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    void display(){

        System.out.println();
        System.out.println("Details of the Employee ");
        System.out.println("Name of the Employee : " + name);
        System.out.println("ID of the Employee  : " + empId);
        System.out.println("Salary of the Employee : " + salary);
        hireDate.display();
        System.out.println("Position of the Employee : " + jobPosition);
        System.out.println("Contact Number of the Employee : " + contactNumber);
        address.display();
    }
}
