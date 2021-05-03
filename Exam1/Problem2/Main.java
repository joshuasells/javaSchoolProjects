import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("run:");
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    MathOp op = new MathOp();
    int num1, num2;
    while(!exit) {
      System.out.print("1)add, 2)sub, 3)multiply, 4) divide, 5) exit:");
      int choice = input.nextInt();
      input.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter operands:");
          num1 = input.nextInt();
          num2 = input.nextInt();
          input.nextLine();
          System.out.println(op.add(num1, num2));
          break;

        case 2:
          System.out.print("Enter operands:");
          num1 = input.nextInt();
          num2 = input.nextInt();
          input.nextLine();
          System.out.println(op.subtract(num1, num2));
          break;

        case 3:
          System.out.print("Enter operands:");
          num1 = input.nextInt();
          num2 = input.nextInt();
          input.nextLine();
          System.out.println(op.multiply(num1, num2));
          break;

        case 4:
          System.out.print("Enter operands:");
          num1 = input.nextInt();
          num2 = input.nextInt();
          input.nextLine();
          System.out.println(op.divide(num1, num2));
          break;

        case 5:
          exit = true;
          System.out.println("Bye!");
          break;
      
        default:
          System.out.println("Please Enter 1 - 5");
          break;
      }
    }
    input.close();
  }
}