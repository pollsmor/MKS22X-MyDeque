public class DequeDriver {
  public static void main(String[] args) {
    MyDeque<Integer> rofl = new MyDeque<Integer>();

    rofl.addFirst(69);
    rofl.addFirst(70);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(1);
    rofl.addFirst(3);
    System.out.println("Size: " + rofl.size());
    System.out.println(rofl);
    System.out.println(rofl.toStringDebug());
  }
}
