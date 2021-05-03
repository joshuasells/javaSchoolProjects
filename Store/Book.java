/**
 * Book.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

public class Book extends Item {

  // Variables
  private String authors;
  private String edition;
  private String publisher;
  int pubYear;

  // Constuctor
  public Book(String title, double price, String authors, String edition, String publisher, int pubYear) {
    super(title, price);
    this.authors = authors;
    this.edition = edition;
    this.publisher = publisher;
    this.pubYear = pubYear;
  }

  // ----------------GET and SET methods-------------- //

  public String getAuthors() {
    return this.authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public String getEdition() {
    return this.edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getPubYear() {
    return this.pubYear;
  }

  public void setPubYear(int pubYear) {
    this.pubYear = pubYear;
  }
}