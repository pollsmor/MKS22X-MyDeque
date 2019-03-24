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
    return size;
  }

  public String toString() {
    String output = "{";

    //Loop from start to end of the list (unless null is reached)
    for (int i = start; i < data.length && data[i] != null; ++i)
      output += data[i] + " ";

    //Would never get run if start > end
    for (int i = 0; i < start && data[i] != null; ++i)
      output += data[i] + " ";

    output += "}";

    return output;
  }

  //Includes null and visibly separates two sides of array
  public String toStringDebug() {
    String output = "{";

    for (int i = start; i < data.length; ++i)
      output += data[i] + "(" + i + ")" + " ";

    output += "} / {";

    //Would never get run if start > end
    for (int i = 0; i < start; ++i)
      output += data[i] + "(" + i + ")" + " ";

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

    end = newArrIdx;
    data = output;
  }

  public void addFirst(E element) {
    if (element == null)
      throw new NullPointerException("Not allowed to add null!");

    ++size;

    if (start == 0) {
      if (end != data.length - 1) {
        data[data.length - 1] = element;
        start = data.length - 1;
        end = data.length - 1;
      }

      else {
        resize();
        data[data.length - 1] = element;
        start = data.length - 1;
      }
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

  public void addLast(E element) {
    if (element == null)
      throw new NullPointerException("Not allowed to add null!");

    ++size;

    if (end == data.length - 1) {
        data[0] = element;
        end = 0;
    }

    else if (end + 1 == start) {
      resize();
      data[end + 1] = element;
      ++end;
    }

    else {
      data[end + 1] = element;
      ++end;
    }
  }

  public E removeFirst() {
    if (size() == 0)
      throw new NoSuchElementException("You can't remove something from nothing.");

    --size;

    E temp = data[start];
    data[start] = null;
    data[start] = null;
    ++start;
    if (start == data.length)
      start = 0;

    return temp;
  }

  public E removeLast() {
    if (size() == 0)
      throw new NoSuchElementException("You can't remove something from nothing.");

    --size;

    E temp = data[end];
    data[end] = null;
    --end;
    if (end == -1)
      end = data.length - 1;

    return temp;
  }
}
