import java.util.Arrays;

public class Calculator {
  public static double eval(String s) {
    String[] elements = s.split(" "); //split all the elements into an array
    MyDeque<String> calc = new MyDeque<String>(); //will only be used for adding, getting, and removing from last
    for (int i = 0; i < elements.length; ++i) {
      calc.addLast(elements[i]); //add whatever to the deque

      try {
        //If it's a double, go back to the start.
        //If it's an operator, it will throw an exception and will be catched.
        Double.parseDouble(calc.getLast());
      }

      catch (NumberFormatException e) {
        double result = 0.0;
        String operation = calc.removeLast(); //removeLast deletes the operator, but also returns it
        if (operation.equals("+")) {
          //I count from num2 to num1 because we're accessing from right to left. (cont.d)
          double num2 = Double.parseDouble(calc.removeLast());
          double num1 = Double.parseDouble(calc.removeLast());
          result = num1 + num2; //(resm.d) so it makes sense here!
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

        calc.addLast(result + ""); //add the result back to the stack
      }
    }

    return Double.parseDouble(calc.getLast()); //after the last calc.addLast(result + "") is run, we know the calculation is done.
  }
}
