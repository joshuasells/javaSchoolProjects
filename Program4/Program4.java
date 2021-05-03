import java.util.Scanner;

/**
 * Program4
 */
public class Program4 {

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    System.out.print("Which type of bag do you want?  ");

    // Declare variables.
    Scanner input = new Scanner(System.in);
    String choice;
    IBag<String> bag;

    
    // Prompt for the type of bag. Repeats if answer is invalid.
    do {
      System.out.print("sorted/unsorted: ");
      choice = input.nextLine();
    }
    while (!choice.equalsIgnoreCase("sorted") && !choice.equalsIgnoreCase("unsorted"));


    // Creates sorted or unsorted bag based on user input.
    if (choice.equalsIgnoreCase("sorted")) {
      bag = new SortedBag<>();
    }
    else {
      bag = new UnsortedBag<>();
    }

    
    // Add items to bag based on user input.
    System.out.print("\nHow many items to put in the bag?");
    int howMany = input.nextInt();
    input.nextLine();
    String item;

    for (int i = 1; i <= howMany; i++) {
      System.out.print("Enter item " + i + ": ");
      item = input.nextLine();
      bag.add(item);
    }


    // Check if items are in bag.
    System.out.println("\nYou can check if something is in the bag.");
    String checkItem;
    while (true) {
      System.out.print("Check for (type done to stop: ");
      checkItem = input.nextLine();
      if (checkItem.equalsIgnoreCase("done")) {
        break;
      }
      if (bag.contains(checkItem)) {
        System.out.println("Yes, it's in the bag.");
      }
      else {
        System.out.println("No, it's not in the bag.");
      }
    }


    // Empty the bag and close Scanner.
    System.out.println("\nLet's remove stuff from the bag:");
    while (!bag.empty()) {
      System.out.println("Removing item: " + bag.remove());
    }
    input.close();
  }
}