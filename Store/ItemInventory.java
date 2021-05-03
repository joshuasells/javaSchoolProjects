/**
 * ItemInventory.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

import java.util.*;
import java.io.*;
import java.text.*;

public class ItemInventory {

  // Variables
  private ArrayList<ItemEntry> entries = new ArrayList<>();

  // Constructor
  private ItemInventory() {
  }

  // ----------------GET and SET methods-------------- //

  public ArrayList<ItemEntry> getEntries() {
    return this.entries;
  }

  // Function load() - This static function scans a file and injects the data in the correct areas within the objects of the program.
  public static ItemInventory load(String fileName) throws IOException, ParseException {
    // Create new File, Scanner, and ItemInventory object.
    // We will use these to read the file, populate into objects, and then add it to the ItemInventory object and return it at the end of the function.
    File file = new File(fileName);
    Scanner input = null;
    try {
      input = new Scanner(file);
    }
    catch (IOException e) {
      System.out.println("The file could not be found");
      System.exit(1);
    }
    ItemInventory itemInventory = new ItemInventory();

    // Scan a line if it exists.
    while(input.hasNextLine()) {
      String line = input.nextLine();
      // Separate data into a String array called data.
      String[] data = line.split("\\|");

      // Assign type and title first. This is the same no matter the type of item.
      // Declare price, double, itemEntry for use in switch statment.
      String type = data[0];
      String title = data[1];
      double price;
      int quantity;
      ItemEntry itemEntry;

      // We now have to figure out the type of item and populate the rest of the contents into variables.
      // Then we can create an object MusicCD, Book, or Software.
      // After that we can create an ItemEntry object that points to the Item.
      switch(type) {
        case "music":
          String artists = data[2];

          // Break date into 3 parts for month, day, and year.
          String[] dateParts = data[3].split("/");
          String month = dateParts[0];
          String day = dateParts[1];
          String year = dateParts[2];
          // if day or month is single digit, then add leading 0
          if(month.length() == 1) {
            month = "0" + month;
          }
          if(day.length() == 1) {
            day = "0" + day;
          }

          String date = month + "/" + day + "/" + year;
          Date releaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);

          String label = data[4];
          String recordCompany = data[5];
          int totalLength = Integer.parseInt(data[6]);
          String genres = data[7];
          price = Double.parseDouble(data[8]);
          quantity = Integer.parseInt(data[9]);

          // Create MusicCD.
          MusicCD musicCD = new MusicCD(title, price, artists, releaseDate, label, recordCompany, totalLength, genres);
          // Assign ItemEntry.
          itemEntry = new ItemEntry(musicCD, quantity);
          // Finally we break out of this case.
          break;
        
        case "book":
          String authors = data[2];
          String edition = data[3];
          String publisher = data[4];
          int pubYear = Integer.parseInt(data[5]);
          price = Double.parseDouble(data[6]);
          quantity = Integer.parseInt(data[7]);

          // Create Book.
          Book book = new Book(title, price, authors, edition, publisher, pubYear);
          // Assign ItemEntry.
          itemEntry = new ItemEntry(book, quantity);
          break;

        case "software":
          String version = data[2];
          price = Double.parseDouble(data[3]);
          quantity = Integer.parseInt(data[4]);

          // Create Software.
          Software software = new Software(title, price, version);
          // Assign ItemEntry.
          itemEntry = new ItemEntry(software, quantity);
          break;

        default:
          itemEntry = null;
      }

      // Finally we add this ItemEntry to the ItemInventory variable entries.
      itemInventory.entries.add(itemEntry);
    }

    // Close scanner.
    input.close();

    // return the ItemInventory object.
    return itemInventory;
  }
}