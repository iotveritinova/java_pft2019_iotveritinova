package ru.stqa.pft.addressbook.model;

public class Phones {
  private final String homePhone;
  private final String mobilePhone;

  public Phones(String homePhone, String mobilePhone) {
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }
}
