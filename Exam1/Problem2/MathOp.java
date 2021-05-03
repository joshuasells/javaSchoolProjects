/**
 * MathOp
 */
public class MathOp implements IMathOp {

  @Override
  public int add(int num1, int num2) {
    return num1 + num2;
  }

  @Override
  public int subtract(int num1, int num2) {
    return num1 - num2;
  }

  @Override
  public int multiply(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public int divide(int num1, int num2) {
    try {
      return num1 / num2;
    }
    catch (Exception e) {
      System.out.println("Division by zero error!");
      return -1;
    }
  }
}
