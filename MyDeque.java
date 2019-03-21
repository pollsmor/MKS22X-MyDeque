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

    //Loop from start to end of the list (unless null is reached)
    for (int i = start; i < data.length && data[i] != null; ++i)
      output += data[i] + " ";

    //Would never get run if start > end
    for (int i = end; i < start && data[i] != null; ++i)
      output += data[i] + " ";

    output += "}";

    return output;
  }

  public E getFirst() {
    return data[start];
  }

  public E getLast() {
    return data[end];
  }
}
