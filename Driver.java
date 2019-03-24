public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> rofl = new MyDeque<Integer>();

    rofl.addFirst(1);
    rofl.addLast(69);
    rofl.addLast(3100);
    rofl.addLast(3300);
    System.out.println(rofl.removeFirst());
    System.out.println(rofl.removeLast());
    System.out.println(rofl.getFirst());
    System.out.println(rofl.getLast());
    System.out.println(rofl.size());
    System.out.println(rofl);
    System.out.println(rofl.toStringDebug());
  }
}
