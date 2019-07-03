package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String email1;


  public ContactData(String firstName, String middleName, String lastName, String address, String homePhone, String mobilePhone, String email1) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.email1 = email1;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail1() {
    return email1;
  }
}
