import java.util.Arrays;

public class Calculator {
  public static double eval(String s) {
    String[] elements = s.split(" ");
    char[] operators = new char[elements.length / 2]; //e.g. 9 elements, 4 are operators
    double[] nums = new double[elements.length - operators.length]; // 9 - 4 = 5;
    int opsIdx = 0;
    int numsIdx = 0;

    for (int i = 0; i < elements.length; ++i) {
      try {
        nums[numsIdx] = Double.parseDouble(elements[i]);
        ++numsIdx;
      }

      catch (NumberFormatException e) {
        operators[opsIdx] = elements[i].charAt(0);
      }
    }
    
    System.out.println(Arrays.toString(elements));
    System.out.println(Arrays.toString(operators));
    System.out.println(Arrays.toString(nums));
    return 1.0;
  }
}
