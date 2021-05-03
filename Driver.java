/**
 * Driver
 */

import java.util.*;

public class Driver {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter");
    System.out.println("1)To create a student");
    System.out.print("2)To create an employee:");
    int method = promptForInt(1, 2, input);
    // clear buffer
    input.nextLine();

    System.out.print("Enter name:");
    String name = input.nextLine();
    System.out.print("Enter address:");
    String address = input.nextLine();
    System.out.print("Enter phone number:");
    String phone = input.nextLine();
    System.out.print("Enter email:");
    String email = input.nextLine();

    if (method == 1) {
      System.out.print("Enter student's status:");
      String status = input.nextLine();
      Student student = new Student(name, address, phone, email, status);
      System.out.print(student.toString());
    }
    else {
      System.out.println("Enter");
      System.out.println("1)To create a faculty member");
      System.out.print("2)To create a staff member:");
      method = promptForInt(1, 2, input);
      // clear buffer
      input.nextLine();

      System.out.print("Enter office number:");
      int officeNumber = input.nextInt();
      input.nextLine();
      System.out.print("Enter salary:");
      int salary = input.nextInt();
      input.nextLine();
      System.out.print("Enter date hired (mm/dd/yy):");
      String date = input.nextLine();

      if (method == 1) {
        System.out.print("Enter office hours:");
        String officeHours = input.nextLine();
        System.out.print("Enter rank:");
        String rank = input.nextLine();
        Faculty faculty = new Faculty(name, address, phone, email, officeNumber, salary, date, officeHours, rank);
        System.out.print(faculty.toString());
      }
      else {
        System.out.print("Enter title:");
        String title = input.nextLine();
        Staff staff = new Staff(name, address, phone, email, officeNumber, salary, date, title);
        System.out.print(staff.toString());
      }
    }
  }

  public static int promptForInt(int min, int max, Scanner input) {
    int num;
    do {
      try {
        num = input.nextInt();
        if (num < min || num > max) {
          System.out.print("Invalid. Enter 1 or 2: ");
        }
      }
      catch(Exception e) {
        // This consumes the existing input so that we don't have an infinite loop!
        input.nextLine();
        System.out.print("Invalid. Enter 1 or 2: ");
        num = max + 1;
      }
    } while (num < min || num > max);

    return num;
  }

  public static class Person {
    protected String name;
    protected String address;
    protected String phone;
    protected String email;

    public Person(String name, String address, String phone, String email) {
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.email = email;
    }

    @Override
    public String toString() {
      String s = "Address: " + this.address + "\n"
        + "Phone Number: " + this.phone + "\n"
        + "Email: " + this.email + "\n";
      return s;
    }
  }

  public static class Student extends Person {
    protected String status;
    protected final String FRESHMAN = "Freshman";
    protected final String SOPHMORE = "Sophmore";
    protected final String JUNIOR = "Junior";
    protected final String SENIOR = "Senior";

    public Student(String name, String address, String phone, String email, String status) {
      super(name, address, phone, email);
      this.status = status;
    }


    @Override
    public String toString() {
      String s = "Student: " + this.name + "\n"
        + "Status: " + this.status + "\n"
        + super.toString();
      return s;
    }
  }

  public static class Employee extends Person {
    protected int officeNumber;
    protected int salary;
    protected MyDate dateHired;

    public Employee(String name, String address, String phone, String email, 
      int officeNumber, int salary, String date) {
      super(name, address, phone, email);
      this.officeNumber = officeNumber;
      this.salary = salary;
      this.dateHired = new MyDate(date);
    }

    @Override
    public String toString() {
      String s = "Office: " + this.officeNumber + "\n"
      + super.toString();
      return s;
    }
  }

  public static class Faculty extends Employee {
    protected String officeHours;
    protected String rank;

    public Faculty(String name, String address, String phone, String email, 
      int officeNumber, int salary, String date, String officeHours, String rank) {
      super(name, address, phone, email, officeNumber, salary, date);
      this.officeHours = officeHours;
      this.rank = rank;
    }

    @Override
    public String toString() {
      String s = "Faculty: " + this.name + "\n"
        + "Rank: " + this.rank + "\n"
        + "Salary: $" + this.salary + "\n"
        + "Date Hired: " + this.dateHired.date + "\n\n"
        + "Office Hours: " + this.officeHours + "\n"
        + super.toString();
      return s;
    }
  }

  public static class Staff extends Employee {
    protected String title;

    public Staff(String name, String address, String phone, String email, 
      int officeNumber, int salary, String date, String title) {
      super(name, address, phone, email, officeNumber, salary, date);
      this.title = title;
    }

    @Override
    public String toString() {
      String s = "Staff: " + this.name + "\n"
      + "Salary: $" + this.salary + "\n"
      + "Date Hired: " + this.dateHired.date + "\n\n"
      + super.toString();
      return s;
    }
  }

  public static class MyDate {
    private String date; // date in the form mm/dd/yy

    public MyDate(String date) {
      this.date = date;
    }

    public String getDate() {
      return date;
    }
  }
}