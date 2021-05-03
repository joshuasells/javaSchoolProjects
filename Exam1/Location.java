import java.util.Scanner;

/**
 * Location
 */
public class Location {

  // Variables
  public int row;
  public int column;
  public double maxValue;

  // Constructor
  public Location(int row, int column, double maxValue) {
    this.row = row;
    this.column = column;
    this.maxValue = maxValue;
  }

  // Methods

  //locateLargest - gets the maximum value in a 2D array.
  public static Location locateLargest(double[][] a) {
    double max = a[0][0];
    int row = 0;
    int column = 0;

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > max) {
          max = a[i][j];
          row = i;
          column = j;
        }
      }
    }
    Location location = new Location(row, column, max);
    return location;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns in the array: ");
    int row = input.nextInt();
    int column = input.nextInt();
    input.nextLine();

    System.out.println("Enter the array:");
    double[][] matrix = new double[row][column];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }

    Location location = Location.locateLargest(matrix);
    System.out.println("The location of the largest element is " + location.maxValue + " at (" + location.row + ", " + location.column + ")");

    input.close();
  }
}