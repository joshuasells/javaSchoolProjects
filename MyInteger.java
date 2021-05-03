/**
 * MyInteger
 */

import java.util.Scanner;

// Define the MyInteger class
public class MyInteger {
  // The value of the int
  private int value;


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int i = 1;

    while (i > 0) {
      System.out.print("Enter a positive integer to create a MyInteger object or to move on to next part of program:");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        i = Integer.parseInt(s);
        MyInteger obj0 = new MyInteger(i);
        System.out.println("MyInteger obj0 = new MyInteger(" + i + ");");
        System.out.println("obj0.getValue() = " + obj0.getValue());
        System.out.println("obj0.isEven() = " + obj0.isEven());
        System.out.println("obj0.isOdd() = " + obj0.isOdd());
        System.out.println("obj0.isPrime() = " + obj0.isPrime());
      }
    }

    while (i > 0) {
      System.out.print("Enter a positive integer to test static isXXX(int) methods or to move on to next part of program:");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        i = Integer.parseInt(s);
        System.out.println("MyInteger.isEven(" + i + ") = " + MyInteger.isEven(i));
        System.out.println("MyInteger.isOdd(" + i + ") = " + MyInteger.isOdd(i));
        System.out.println("MyInteger.isPrime(" + i + ") = " + MyInteger.isPrime(i));
      }
    }

    while (i > 0) {
      System.out.print("Enter a positive integer to test static isXXX(MyInteger) methods or to move on to next part of program:");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        i = Integer.parseInt(s);
        MyInteger obj1 = new MyInteger(i);
        System.out.println("MyInteger obj1 = new MyInteger(" + i + ");");
        System.out.println("obj1.getValue() = " + obj1.getValue());
        System.out.println("MyInteger.isEven(obj1) = " + MyInteger.isEven(obj1));
        System.out.println("MyInteger.isOdd(obj1) = " + MyInteger.isOdd(obj1));
        System.out.println("MyInteger.isPrime(obj1) = " + MyInteger.isPrime(obj1));
      }
    }

    while (i > 0) {
      System.out.print("Enter a the first of two positive integers to create obj2 and test obj2.equals(int) or to move on to next part of program:");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        i = Integer.parseInt(s);
        MyInteger obj2 = new MyInteger(i);
        System.out.println("MyInteger obj2 = new MyInteger(" + i + ");");
        System.out.println("obj2.getValue() = " + obj2.getValue());
        System.out.print("Enter a the second of two positive integers to test obj2.equals(int):");
        s = input.nextLine();
        int i2 = Integer.parseInt(s);
        System.out.println("obj2.equals(" + i2 + ") = " + obj2.equals(i2));
      }
    }

    while (i > 0) {
      System.out.print("Enter a the first of two positive integers to create obj2 and test obj2.equals(MyInteger obj3) or to move on to next part of program:");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        i = Integer.parseInt(s);
        MyInteger obj2 = new MyInteger(i);
        System.out.println("MyInteger obj2 = new MyInteger(" + i + ");");
        System.out.println("obj2.getValue() = " + obj2.getValue());
        System.out.print("Enter a the second of two positive integers to create obj3 and test obj2.equals(MyInteger obj3):");
        s = input.nextLine();
        int i2 = Integer.parseInt(s);
        MyInteger obj3 = new MyInteger(i2);
        System.out.println("MyInteger obj3 = new MyInteger(" + i2 + ");");
        System.out.println("obj3.getValue() = " + obj3.getValue());
        System.out.println("obj2.equals(obj3) = " + obj2.equals(obj3));
      }
    }

    while (i > 0) {
      System.out.print("Enter a positive integer that will be placed into a char[] array to demonstrate the MyInteger.parseInt(char[]):");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        char[] chars = s.toCharArray();
        MyInteger obj4 = new MyInteger(MyInteger.parseInt(chars));
        System.out.println("MyInteger obj4 = new MyInteger(MyInteger.parseInt(char []);");
        System.out.println("obj4.getValue() = " + obj4.getValue());
        System.out.println("obj4.isEven() = " + obj4.isEven());
        System.out.println("obj4.isOdd() = " + obj4.isOdd());
        System.out.println("obj4.isPrime() = " + obj4.isPrime());
      }
    }

    while (i > 0) {
      System.out.print("Enter a positive integer that will be placed into a String to demonstrate the MyInteger.parseInt(String):");
      String s = input.nextLine();
      if (s == "" || Integer.parseInt(s) <= 0) {
        break;
      }
      else {
        MyInteger obj5 = new MyInteger(MyInteger.parseInt(s));
        System.out.println("MyInteger obj5 = new MyInteger(MyInteger.parseInt(String);");
        System.out.println("obj5.getValue() = " + obj5.getValue());
        System.out.println("obj5.isEven() = " + obj5.isEven());
        System.out.println("obj5.isOdd() = " + obj5.isOdd());
        System.out.println("obj5.isPrime() = " + obj5.isPrime());
      }
    }

  }

  
  // Construct a MyInteger with a specified value
  MyInteger(int value) {
    this.value = value;
  }

  // return value
  public int getValue() {
    return this.value;
  }

  // check the current object if it is even
  public boolean isEven() {
    if (this.value % 2 == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  // check the current object if it is odd
  public boolean isOdd() {
    if (this.value % 2 == 1) {
      return true;
    }
    else {
      return false;
    }
  }

  // check the current object if it is prime
  public boolean isPrime() {
    // check if value is 1 or less
    if (this.value <= 1) {
      return false;
    }

    // check from 2 to this.value - 1
    for (int i = 2; i < this.value - 1; i++) {
      if (this.value % i == 0) {
        return false;
      }
    }
    
    return true;
  }

  // check if a specific value is even
  public static boolean isEven(int myInt) {
    if (myInt % 2 == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  // check if a specific value is odd
  public static boolean isOdd(int myInt) {
    if (myInt % 2 == 1) {
      return true;
    }
    else {
      return false;
    }
  }

  // check if a specific value is prime
  public static boolean isPrime(int myInt) {
    // check if value is 1 or less
    if (myInt <= 1) {
      return false;
    }

    // check from 2 to this.value - 1
    for (int i = 2; i < myInt - 1; i++) {
      if (myInt % i == 0) {
        return false;
      }
    }
    
    return true;
  }

  // check if a specific MyInteger object is even
  public static boolean isEven(MyInteger myInt) {
    if (myInt.value % 2 == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  // check if a specific MyInteger object is odd
  public static boolean isOdd(MyInteger myInt) {
    if (myInt.value % 2 == 1) {
      return true;
    }
    else {
      return false;
    }
  }

  // check if a specific MyInteger object is prime
  public static boolean isPrime(MyInteger myInt) {
    // check if value is 1 or less
    if (myInt.value <= 1) {
      return false;
    }

    // check from 2 to this.value - 1
    for (int i = 2; i < myInt.value - 1; i++) {
      if (myInt.value % i == 0) {
        return false;
      }
    }
    
    return true;
  }

  // check if a specific value is equal to this object's value
  public boolean equals(int myInt) {
    if (this.value == myInt) {
      return true;
    }
    else {
      return false;
    }
  }

  // check if a specific MyInteger value is equal to this object's value
  public boolean equals(MyInteger myInt) {
    if (this.value == myInt.value) {
      return true;
    }
    else {
      return false;
    }
  }

  // returns an integer from the given character array
  public static int parseInt(char[] charArray) {
    return Integer.parseInt(new String(charArray));
  }

  // returns an integer from the given string
  public static int parseInt(String s) {
    return Integer.parseInt(s);
  }
}