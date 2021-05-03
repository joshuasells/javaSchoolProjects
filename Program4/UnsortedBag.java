import java.util.ArrayList;

/**
 * UnsortedBag
 */
public class UnsortedBag<E> implements IBag<E> {

  // Variables
  private ArrayList<E> data;

  // Constructor
  public UnsortedBag() {
    data = new ArrayList<>();
  }

  // Add method
  @Override
  public void add(E item) {
    this.data.add(item);
  }

  // Remove method
  @Override
  public E remove() {
    E item = this.data.get(0);
    this.data.remove(item);
    return item;
  }

  // Contains Method
  @Override
  public boolean contains(E item) {
    for (int i = 0; i < this.data.size(); i++) {
      if (this.data.contains(item)) {
        return true;
      }
    }
    return false;
  }

  // Empty method
  @Override
  public boolean empty() {
    return this.data.size() == 0;
  }


}