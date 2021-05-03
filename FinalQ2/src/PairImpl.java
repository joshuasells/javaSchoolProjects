import java.util.ArrayList;

public class PairImpl<E, T> implements Pair<E, T> {

  private E first;
  private T second;

  // Constructor
  public PairImpl(E first, T second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public E getFirst() {
    return this.first;
  }

  @Override
  public T getSecond() {
    return this.second;
  }

  @Override
  public String toString() {
    return this.first.toString() + ":" + this.second.toString();
  }


  public static void main(String[] args) throws Exception {
      // Create an ArrayList and populate with Pairs.
      ArrayList<Pair<String, Integer>> fruits = new ArrayList<>();
      fruits.add(new PairImpl<String,Integer>("apple", 20));
      fruits.add(new PairImpl<String,Integer>("banana", 10));
      fruits.add(new PairImpl<String,Integer>("orange", 50));

      for (int i = 0; i < fruits.size(); i++) {
        System.out.println(fruits.get(i).toString());
      }
  }
}
