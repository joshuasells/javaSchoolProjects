public class App {

  public static String twice(String s) {
    if (s.length() == 1) {
      return String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(0));
    }
    else {
      return String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(0)) + twice(s.substring(1));
    }
  }
  public static void main(String[] args) throws Exception {
    System.out.println(twice("I Love Java"));;
  }
}
