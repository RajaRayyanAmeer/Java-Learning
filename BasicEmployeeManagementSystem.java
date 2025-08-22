import java.util.Scanner;

class Employee
{
 private String Name;
 private String ID;

 public Employee(String Name, String ID)
 {
  this.Name = Name;
  this.ID = ID;
 }

 
 public String getName()
 {
  return Name;
 }

 public String getID()
 {
  return ID;
 }
}

class Manager extends Employee
{
 private String Department;

 public Manager(String Name, String ID, String Department)
 {
  super(Name, ID);
  this.Department = Department;
 }

 public String getDepartment()
 {
  return Department;
 }
}

public class BasicEmployeeManagementSystem
{
 public static void main(String[] args)
 {
  Scanner scanner = new Scanner(System.in);
  while (true)
  {
   System.out.println("Who are you?");
   System.out.println("1. Employee");
   System.out.println("2. Manager");
   System.out.println("3. Exit");
   System.out.print("Enter your choice (1 for Employee, 2 for Manager, 3 for Exit): ");

   int option = scanner.nextInt();
   scanner.nextLine(); 
   switch (option)
   {
    case 1:
           System.out.print("Enter Your Name: ");
           String empName = scanner.nextLine();

           System.out.print("Enter Your ID: ");
           String empID = scanner.nextLine();

           Employee employee = new Employee(empName, empID);

           System.out.println("Employee Details:");
           System.out.println("Name: " + employee.getName());
           System.out.println("ID: " + employee.getID());
    break;

    case 2:
           System.out.print("Enter Your Name: ");
           String mgrName = scanner.nextLine();

           System.out.print("Enter Your ID: ");
           String mgrID = scanner.nextLine();

           System.out.print("Enter Your Department: ");
           String mgrDept = scanner.nextLine();

           Manager manager = new Manager(mgrName, mgrID, mgrDept);

           System.out.println("Manager Details:");
           System.out.println("Name: " + manager.getName());
           System.out.println("ID: " + manager.getID());
           System.out.println("Department: " + manager.getDepartment());
    break;

    case 3:
           System.out.println(" EXITING... ");
           return;
    
    default:
           System.out.println("ERROR! You entered the wrong option.");
           break;
   }
  }
 }
}