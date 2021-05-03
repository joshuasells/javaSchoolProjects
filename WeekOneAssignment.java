/*----------------------------
------------------------------
Student: Joshua Sells
Email: joshuataylorsells@gmail.com
Date written: 01/17/2021
Date revised:
------------------------------
----------------------------*/

import java.text.NumberFormat;
import java.util.*;

public class WeekOneAssignment {

  // set booleans for loop control
  static boolean exitProgram = false;
  static boolean exitCurrentAccount = false;

  // ---------------------------- MAIN METHOD START----------------------------------//

  public static void main(String[] args) {

    // Create an array of 10 Account objects and populate them with initial id and balance.
    Account[] accountArray = new Account[10];
    for (int i = 0; i < accountArray.length; i++) {
      accountArray[i] = new Account(i, 100.0);
    }

    // loop to continue prompting for an account number.
    // The user can enter it and modify it, but they will come back here to be asked for another account id.
    // The user may press 'exit' to end the program.
    while (!exitProgram) {
      // get the user's account id.
      int activeId = promptForInt(0, 9, "Enter the account id: ");
      // loop to continue letting the user work with the current account.
      // They can select option '5' to try using a different account.
      if (!exitProgram) {
        Account activeAccount = accountArray[activeId];
        exitCurrentAccount = false;

        // loop to continue letting the user work with the current account.
        // They can select option '5' to try using a different account.
        while (!exitCurrentAccount) {
          printMenu();
          // prompt user to select an option.
          int option = promptForInt(1, 5, "Please make a selection: ");
          // get a number format to simply display double as currency below.
          NumberFormat formatter = NumberFormat.getCurrencyInstance();
          // switch statement to control the flow of the program.
          switch (option) {
            case 1:
              // display current balance.
              System.out.print("\n\n" + "The current balance is: " + formatter.format(activeAccount.getBalance()));
              break;
            case 2:
              // withdraw.
              System.out.print("\n\n");
              double withdrawAmount = promptForDouble(0.0, 1000000.0, "Please enter the amount to withdraw: ");
              System.out.print("Amount withdrawn is: " + formatter.format(activeAccount.withdraw(withdrawAmount)));
              break;
            case 3:
              // deposit.
              System.out.print("\n\n");
              double depositAmount = promptForDouble(0.0, 1000000.0, "Please enter the amount to deposit: ");
              System.out.print("Amount deposited is: " + formatter.format(activeAccount.deposit(depositAmount)));
              break;
            case 4:
              // display account details.
              System.out.print("\n\n");
              System.out.println("Account was created on: " + activeAccount.getDateCreated());
              System.out.println("Account monthly interest rate is: " + String.format("%.2f", activeAccount.getMonthlyInterestRate()));
              System.out.println("Account balance is: " + formatter.format(activeAccount.getBalance()));
              break;
            case 5:
              // exit, or work with a different account.
              exitCurrentAccount = true;
              break;
          }
        }
      }
    }
    System.out.println("Goodbye!");
  }

  // -----------------------------------MAIN METHOD END -------------------------------------------- //

  // ----------------------------------------------------------------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //
  // --------------------------------- METHOD DEFINITIONS HERE ------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //

  // This method prompts the user for an integer between the min and max parameters.
  //  Parametes:
  //    int min - this is the minimum integer the user may enter.
  //    int max - this is the maximum integer the user may enter.
  //    String msg - this is a String to prompt the user with.
  public static int promptForInt(int min, int max, String msg) {
    Scanner input = new Scanner(System.in);
    int id;
    do {
      System.out.print(msg);
      try {
        id = input.nextInt();
        if (id < min || id > max) {
          System.out.println("Invalid");
        }
      }
      catch(Exception e) {
        // This consumes the existing input so that we don't have an infinite loop!
        String s = input.nextLine().toLowerCase();
        if (s.equals("exit")) {
          exitProgram = true;
          // set id to 0 to terminate loop.
          id = 0;
        }
        else {
          System.out.println("Invalid");
          // set id to 10 so that the loop repeats
          id = max + 1;
        }
      }
    } while (id < min || id > max);

    return id;
  }

  // This method prompts the user for an double between the min and max parameters.
  //  Parametes:
  //    double min - this is the minimum double the user may enter.
  //    double max - this is the maximum double the user may enter.
  //    String msg - this is a String to prompt the user with.
  public static double promptForDouble(double min, double max, String msg) {
    Scanner input = new Scanner(System.in);
    double d;
    do {
      System.out.print(msg);
      try {
        d = input.nextDouble();
        if (d < min || d > max) {
          System.out.println("Invalid");
        }
      }
      catch(Exception e) {
        // This consumes the existing input so that we don't have an infinite loop!
        input.nextLine();
        System.out.println("Invalid");
        // set id to 10 so that the loop repeats
        d = max + 1.0;
      }
    } while (d < min || d > max);

    return d;
  }

  // This method prints the menu. There are no parameters.
  public static void printMenu() {
    System.out.print("\n\n" + "Main Menu" + "\n\n\n");
    System.out.print("1. Check Balance\n" + "2. Withdraw\n" + "3. Deposit\n" + "4. Account Information\n" + "5. Exit (choose a different account)\n");
  }

  // ----------------------------------------------------------------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //
  // --------------------------------- CLASS DEFINITIONS HERE -------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //
  // ----------------------------------------------------------------------------------------------- //

  //--------------------------------- CLASS ACCOUNT START ------------------------------------------ //
  static class Account {
    // set data fields
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    // no arg constructor that creates object with default values above.
    public Account() {
    }

    // constructor that creates object with a specific id and balance.
    public Account(int id, double balance) {
      this.id = id;
      this.balance = balance;
      // I would set the interest rate here but, the directions actually didn't specify what I should set it to.
      // I will leave the default value for the interest rate, 0. When the user request info on the account, it will give them this value.
    }

    // Accessor method to get the account id.
    public int getId() {
      return this.id;
    }

    // Accessor method to get the account balance.
    public double getBalance() {
      return this.balance;
    }

    // Accessor method to get the account annual interest rate.
    public double getAnnualInterestRate() {
      return this.annualInterestRate;
    }

    // Accessor method to get the account monthly interest rate.
    public double getMonthlyInterestRate() {
      return this.annualInterestRate/12;
    }

    // Accessor method to get the date the account was created.
    public Date getDateCreated() {
      return this.dateCreated;
    }

    // Mutator method to set the account id.
    public void setId(int id) {
      this.id = id;
    }

    // Mutator method to set the account balance.
    public void setBalance(double balance) {
      this.balance = balance;
    }

    // Mutator method to set the account annual interest rate.
    public void setAnnualInterestRate(double annualInterestRate) {
      this.annualInterestRate = annualInterestRate;
    }

    // Withdraw money from an account and return the amount withdrawn.
    public double withdraw(double amount) {
      if (amount > this.balance) {
        amount = this.balance;
      }
      this.balance -= amount;
      return amount;
    }

    // Deposit money into an account and return the amount desposited.
    public double deposit(double amount) {
      this.balance += amount;
      return amount;
    }
  }
  //--------------------------------- CLASS ACCOUNT END -------------------------------------------- //

}
