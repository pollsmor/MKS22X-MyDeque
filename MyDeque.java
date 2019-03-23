import java.util.NoSuchElementException;

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

  //Includes null and visibly separates two sides of array
  public String toStringDebug() {
    String output = "{";

    for (int i = start; i < data.length; ++i)
      output += data[i] + " ";

    output += "} / {";

    //Would never get run if start > end
    for (int i = end; i < start; ++i)
      output += data[i] + " ";

    output += "}";

    return output;
  }

  public E getFirst() {
    if (size() == 0)
      throw new NoSuchElementException("You can't get something from nothing.");

    return data[start];
  }

  public E getLast() {
    if (size() == 0)
      throw new NoSuchElementException("You can't get something from nothing.");

    return data[end];
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] output = (E[])new Object[data.length * 2];
    int newArrIdx = 0;

    for (int i = start; i < data.length; ++i) {
      output[newArrIdx] = data[i];
      ++newArrIdx;
    }

    //Would never get run if start > end
    for (int i = end; i < start; ++i) {
      output[newArrIdx] = data[i];
      ++newArrIdx;
    }

    data = output;
  }

  public void addFirst(E element) {
    if (start == 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }

    else if (start - 1 == end) {
      resize();
      data[data.length - 1] = element;
      start = data.length - 1;
    }

    else {
      data[start - 1] = element;
      --start;
    }
  }
}
