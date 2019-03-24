import java.util.NoSuchElementException;

public class MyDeque<E> {
  private E[] data;
  private int size, start, end; //initialize all to 0

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

    //Would never get run if end > start (normal list, start = 0)
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

    //Would never get run if end > start (normal list, start = 0)
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

    //Would never get run if end > start (normal list, start = 0)
    for (int i = 0; i < start; ++i) {
      output[newArrIdx] = data[i];
      ++newArrIdx;
    }

    end = newArrIdx - 1; //-1 because the for loop adds an extra one
    data = output;
  }

  public void addFirst(E element) {
    if (element == null)
      throw new NullPointerException("Not allowed to add null!");

    ++size;

    //Case: empty list
    if (data[0] == null) {
      data[0] = element;
      start = 0;
      end = 0;
    }

    //Case: an element is at 0 but start is still at 0, start has to move to end of list
    else if (start == 0 && data[0] != null) {
      data[data.length - 1] = element;
      start = data.length -1;
    }

    //Case: list is full, need to resize
    else if (start - 1 == end) {
      resize();
      data[data.length - 1] = element;
      start = data.length - 1;
    }

    //Normal case, should happen most of the time
    else {
      data[start - 1] = element;
      --start;
    }
  }

  public void addLast(E element) {
    if (element == null)
      throw new NullPointerException("Not allowed to add null!");

    ++size;

    //Case: empty list
    if (data[0] == null) {
      data[0] = element;
      start = 0;
      end = 0;
    }

    //Case: an element is at 0 but end is still at 0, end has to move in front of 0
    else if (end == 0 && data[0] != null) {
      data[1] = element;
      end = 1;
    }

    //Case: list is full, need to resize
    else if (end + 1 == start || end + 1 == data.length) {
      resize();
      data[end + 1] = element;
      ++end;
    }

    //Normal case, should happen most of the time
    else {
      data[end + 1] = element;
      ++end;
    }
  }

  public E removeFirst() {
    if (size() == 0)
      throw new NoSuchElementException("You can't remove something from nothing.");

    --size;

    E temp = data[start]; //need to return this
    data[start] = null;
    ++start;
    if (start == data.length) //go to other side not data.length (out of range)
      start = 0;

    return temp;
  }

  public E removeLast() {
    if (size() == 0)
      throw new NoSuchElementException("You can't remove something from nothing.");

    --size;

    E temp = data[end]; //need to return this
    data[end] = null;
    --end;
    if (end == -1) //go to other side not -1
      end = data.length - 1;

    return temp;
  }
}
