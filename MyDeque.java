public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
  }

  public int size() {
    if (start == end) //empty list
      return 0;

    if (start < end) //normal list
      return end - start + 1;

    return start + end; //double ended list
  }

  public String toString() {
    String output = "{";

    for (int i = start; i < data.length; ++i)
      output += data[i] + " ";

    for (int i = end; i < start; ++i)
      output += data[i] + " ";

    output += "}";

    return output;
  }
}
