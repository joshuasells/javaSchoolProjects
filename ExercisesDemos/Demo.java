import java.util.Scanner;

/**
 * Exercise71045
 */
public class Demo {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    while (true) {
      System.out.print("Enter an integer to be reversed or hit enter to end program:");
      String number = input.nextLine();
      if (number == "") {
        input.nextLine();
        System.exit(1);
      }
      System.out.print("The reverse of " + number + " is ");
      reverseDisplay(Integer.parseInt(number));
    }
  } 
  
  public static void reverseDisplay(int value) {
    if (value < 10) {
      System.out.print(value + "\n");
    }
    else {
      System.out.print(value % 10);
      reverseDisplay(value / 10);
    }
  }
}