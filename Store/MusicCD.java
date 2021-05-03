/**
 * MusicCD.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

import java.util.*;

public class MusicCD extends Item {

  // Variables
  private String artists;
  private Date releaseDate;
  private String label;
  private String recordCompany;
  private int totalLength;
  private String genres;

  // Constuctor
  public MusicCD(String title, double price, String artists, Date releaseDate, String label, String recordCompany, int totalLength, String genres) {
    super(title, price);
    this.artists = artists;
    this.releaseDate = releaseDate;
    this.label = label;
    this.recordCompany = recordCompany;
    this.totalLength = totalLength;
    this.genres = genres;
  }

  // ----------------GET and SET methods-------------- //

  public String getArtists() {
    return this.artists;
  }

  public void setArtists(String artists) {
    this.artists = artists;
  }

  public Date getReleaseDate() {
    return this.releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getRecordCompany() {
    return this.recordCompany;
  }

  public void setRecordCompany(String recordCompany) {
    this.recordCompany = recordCompany;
  }

  public int getTotalLength() {
    return this.totalLength;
  }

  public void setTotalLength(int totalLength) {
    this.totalLength = totalLength;
  }

  public String getGenres() {
    return this.genres;
  }

  public void setGenres(String genres) {
    this.genres = genres;
  }
}