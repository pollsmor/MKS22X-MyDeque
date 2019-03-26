import java.util.Arrays;

public class Calculator {
  public static double eval(String s) {
    String[] elements = s.split(" ");
    MyDeque<String> calc = new MyDeque<String>();
    for (int i = 0; i < elements.length; ++i) {
      calc.addLast(elements[i]);

      try {
        Double.parseDouble(calc.getLast());
      }

      catch (NumberFormatException e) {
        double result = 0.0;
        String operation = calc.removeLast();
        if (operation.equals("+")) {
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 + num2;
        }

        else if (operation.equals("-")) {
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 - num2;
        }

        else if (operation.equals("*")) {
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 * num2;
        }

        else if (operation.equals("/")) {
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 / num2;
        }

        else if (operation.equals("%")) {
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 % num2;
        }

        calc.addLast(result + "");
      }
    }

    return Double.parseDouble(calc.getLast());
  }
}
