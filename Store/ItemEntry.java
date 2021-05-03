/**
 * ItemEntry.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

public class ItemEntry {

  // Variables
  private Item item;
  private int quantity;

  // Constuctor
  public ItemEntry(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  // ----------------GET and SET methods-------------- //

  public Item getItem() {
    return this.item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}