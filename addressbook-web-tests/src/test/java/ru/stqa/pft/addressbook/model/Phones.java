package ru.stqa.pft.addressbook.model;

public class Phones {
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String faxPhone;

  public Phones(String homePhone, String mobilePhone, String workPhone, String faxPhone) {
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.faxPhone = faxPhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }
}
