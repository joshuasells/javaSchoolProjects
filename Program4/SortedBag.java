import java.util.ArrayList;

/**
 * SortedBag
 */
public class SortedBag<E extends Comparable<E>> implements IBag<E> {

  // Variables
  private ArrayList<E> data;

  // Constructor
  public SortedBag() {
    data = new ArrayList<>();
  }

  // Add method
  @Override
  public void add(E item) {
    int low = 0;
    int high = this.data.size() - 1;

    this.add(item, low, high);
  }

  // Recursive helper method for the add method above
  private void add(E item, int low, int high) {
    // If the list has been exhausted, that means low is the correct index to add the item.
    if (low > high) {
      this.data.add(low, item);
      return;
    }
    
    int midIndex = (low + high) / 2;
    E mid = this.data.get(midIndex);
    if (mid.compareTo(item) > 0) {
      // Recursively call the add method with a sublist of the original.
      this.add(item, low, midIndex - 1);
    }
    else if (mid.compareTo(item) == 0) {
      // If the middle element matches the item we are adding, then add it at the midIndex value.
      this.data.add(midIndex, item);
    }
    else {
      // Recursively call the add method with a sublist of the original.
      this.add(item, midIndex + 1, high);
    }
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
    if (this.empty()) {
      return false;
    }

    int low = 0;
    int high = this.data.size() - 1;
    return this.contains(item, low, high);
  }

  // Recursive helper method for the contains method above.
  private boolean contains(E item, int low, int high) {
    // If the list is exhaused, then return false. The item is not in the list.
    if (low > high) {
      return false;
    }

    int midIndex = (low + high) / 2;
    E mid = this.data.get(midIndex);
    if (mid.compareTo(item) > 0) {
      // Recursively call the contains method with a sublist of the original.
      return this.contains(item, low, midIndex -1);
    }
    else if (mid.compareTo(item) == 0) {
      // The item is in the list.
      return true;
    }
    else {
      // Recursively call the contains method with a sublist of the original.
      return this.contains(item, midIndex + 1, high);
    }
  }

  // Empty method
  @Override
  public boolean empty() {
    return this.data.size() == 0;
  }
}