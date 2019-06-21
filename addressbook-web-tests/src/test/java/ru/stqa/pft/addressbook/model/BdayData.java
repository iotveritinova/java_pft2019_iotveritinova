package ru.stqa.pft.addressbook.model;

public class BdayData {
  private final String day;
  private final String month;
  private final String year;

  public BdayData(String day, String month, String year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}
