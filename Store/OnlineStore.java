/**
 * OnlineStore.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

import java.util.*;
import java.io.*;
import java.text.ParseException;

public class OnlineStore {

  // Variables
  private ItemInventory inventory;

  // ----------------GET and SET methods-------------- //

  public ItemInventory getInventory() {
    return this.inventory;
  }

  // Function getType() - this function get the name of the class that a Item object is from.
  private static String getType(Item item) {
    if(item instanceof Book) {
      return "book";
    }
    else if(item instanceof MusicCD) {
      return "music";
    }
    else {
      return "software";
    }
  }

  // Function start() - this function brings the store online and interacts with the user.
  // This creates an ItemInventory object, loads data into it via the public load() function, and provides and interface for the user.
  public void start() throws IOException, ParseException {
    // Firstly, we load the file and populate an ItemInventory object.
    inventory = ItemInventory.load("store.txt");

    // Create Scanner.
    Scanner input = new Scanner(System.in);

    // Set Boolean for loop control.
    boolean exit = false;

    while(!exit) {
      printMenu();
      int method = promptForInt(1, 5, input);

      // if method is 5, then exit program.
      if(method == 5) {
        exit = true;
      }
      else {
        // Display header first.
        System.out.println("\n");
        displayHeader();
        switch(method) {
          case 1:
            for (ItemEntry itemEntry : inventory.getEntries()) {
              displayInfo(itemEntry);
            }
            break;
          case 2:
            for (ItemEntry itemEntry : inventory.getEntries()) {
              if (itemEntry.getItem() instanceof MusicCD) {
                displayInfo(itemEntry);
              }
            }
            break;
          case 3:
            for (ItemEntry itemEntry : inventory.getEntries()) {
              if (itemEntry.getItem() instanceof Book) {
                displayInfo(itemEntry);
              }
            }
            break;
          case 4:
            for (ItemEntry itemEntry : inventory.getEntries()) {
              if (itemEntry.getItem() instanceof Software) {
                displayInfo(itemEntry);
              }
            }
            break;
        }
        System.out.println("-----------------------------------------------------------------\n\n");
      }
    }

    

  }

  // promptForInt() - this function prompt the user for an interger and validates the input.
  public static int promptForInt(int min, int max, Scanner input) {
    int num;
    do {
      try {
        num = input.nextInt();
        if (num < min || num > max) {
          System.out.print("Invalid. Enter 1-5: ");
        }
      }
      catch(Exception e) {
        // This consumes the existing input so that we don't have an infinite loop!
        input.nextLine();
        System.out.print("Invalid. Enter 1-5: ");
        num = max + 1;
      }
    } while (num < min || num > max);

    return num;
  }

  // printMenu() - this function print the main menu for the user.
  public static void printMenu() {
    System.out.println("Welcome to eMart");
    System.out.println("  1) Show all items");
    System.out.println("  2) Show only music CD");
    System.out.println("  3) Show only books");
    System.out.println("  4) Show only software");
    System.out.println("  5) Exit Program");
    System.out.print("Your choice: ");
  }

  // displayHeader() - this function display's the Main header to the user.
  public static void displayHeader() {
    System.out.println("-----------------------------------------------------------------");
    System.out.printf("%-30s %10s %10s %10s\n", "Title", "Type", "Price", "Quantity");
    System.out.println("-----------------------------------------------------------------");
  }

  // displayInfo() - this function display's the Information to the user.
  public static void displayInfo(ItemEntry itemEntry) {
    Item item = itemEntry.getItem();
    System.out.printf("%-30s %10s %10.2f %10d\n",
      item.getTitle(), OnlineStore.getType(item), item.getPrice(), itemEntry.getQuantity());
  }
}
