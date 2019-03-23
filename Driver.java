public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> rofl = new MyDeque<Integer>();

    System.out.println(rofl.size());
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    System.out.println(rofl);
    System.out.println(rofl.toStringDebug());
  }
}
