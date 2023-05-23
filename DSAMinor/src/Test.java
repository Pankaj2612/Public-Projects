import java.util.Scanner;

public class Test {

    public static void arrangeEmployeeBySalary(Employee e[]){

        for (int i = 0; i < e.length-1; i++) {
            for (int j = 0; j < e.length-i-1; j++) {
                if(e[j].salary < e[j+1].salary){
                    Employee temp = e[j];
                    e[j] = e[j+1];
                    e[j+1] = temp;
                }
            }
        }
        

    }
    
    public static void getEmployeesByJobPosition(Employee e[], String jp){
            System.out.println("Employees with job position '" + jp + "':");

            for (Employee employee : e) {
                    if(employee.jobPosition.equals(jp)){
                        employee.display();
                    }
                
                }
        }

        public static boolean isDateinRange(Date date, Date d1, Date d2) {
    
            if (date.year > d1.year && date.year < d2.year) {
                return true;
            } else if (date.year == d1.year) {
                if (date.month > d1.month) {
                    return true;
                } else if (date.month == d1.month) {
                    return date.day >= d1.day;
                }
            } else if (date.year == d2.year) {
                if (date.month < d2.month) {
                    return true;
                } else if (date.month == d2.month) {
                    return date.day <= d2.day;
                }
               
            }
        return false;
        }

        public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2){

            System.out.println("Employees hired between " + d1.day + "-" + d1.month + "-" + d1.year +
                " and " + d2.day + "-" + d2.month + "-" + d2.year + ":");

            for (int i = 0; i < e.length; i++) {
                if(isDateinRange(e[i].hireDate, d1, d2)){
                    e[i].display();
                }
            }

        }

        public static int foreignEmployeeCount(Employee e[]){

            int count = 0;

            for (int i = 0; i < e.length; i++) {
                if(!e[i].contactNumber.startsWith("+91")){
                    count++;
                }
            }
            return count;

        }
                


        public static void getEmployeesBySalary(Employee e[], double s1, double s2){
            for (int i = 0; i < e.length; i++) {
                if(e[i].salary > s1 && e[i].salary < s2){
                    e[i].display();
                }
            }
        }

        public static void main(String[] args) {
            
            Employee[] emp = new Employee[500];

            Scanner scanner = new Scanner(System.in);


            for (int i = 0; i < emp.length; i++) {
                System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Employee ID: ");
            int empId = scanner.nextInt();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            System.out.println("Enter hire date (dd mm yyyy): ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            Date hireDate = new Date(day, month, year);

            // Read the remaining newline character after reading the hire date
            scanner.nextLine();

            System.out.print("Job Position: ");
            String jobPosition = scanner.nextLine();

            System.out.print("Contact Number: ");
            String contactNumber = scanner.nextLine();

            System.out.print("Address - Street: ");
            String street = scanner.nextLine();

            System.out.print("Address - City: ");
            String city = scanner.nextLine();

            System.out.print("Address - State: ");
            String state = scanner.nextLine();

            System.out.print("Address - Country: ");
            String country = scanner.nextLine();

            Address address = new Address(street, city, state, country);

            emp[i] = new Employee(name, empId, salary, hireDate, jobPosition, contactNumber, address);


        }

        arrangeEmployeeBySalary(emp);
        getEmployeesByJobPosition(emp, "Manager");

        Date d1 = new Date(01, 04, 2022);
        Date d2 = new Date(31, 03, 2023);

        getEmployeesByHireDate(emp, d1, d2);

        int foreigncount = foreignEmployeeCount(emp);
        System.out.println("Number of Foreign Employee : " +foreigncount );

        getEmployeesBySalary(emp, 150000, 300000);



        }
    }