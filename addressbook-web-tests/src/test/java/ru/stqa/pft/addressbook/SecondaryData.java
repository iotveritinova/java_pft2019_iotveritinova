package ru.stqa.pft.addressbook;

public class SecondaryData {
  private final String secAddress;
  private final String secPhone;
  private final String notes;

  public SecondaryData(String secAddress, String secPhone, String notes) {
    this.secAddress = secAddress;
    this.secPhone = secPhone;
    this.notes = notes;
  }

  public String getSecAddress() {
    return secAddress;
  }

  public String getSecPhone() {
    return secPhone;
  }

  public String getNotes() {
    return notes;
  }
}
