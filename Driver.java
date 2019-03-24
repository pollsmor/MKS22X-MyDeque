public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> rofl = new MyDeque<Integer>();

    rofl.addLast(69);
    rofl.addLast(70);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(1);
    rofl.addLast(3);
    System.out.println("Size: " + rofl.size());
    System.out.println(rofl);
    System.out.println(rofl.toStringDebug());
  }
}
