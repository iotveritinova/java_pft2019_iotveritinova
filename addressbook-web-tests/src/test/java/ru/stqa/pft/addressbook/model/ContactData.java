package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String email1;
  private final int id;
  private String group;


  public int getId() {
    return id;
  }

  public ContactData(int id, String firstName, String middleName, String lastName, String address, String homePhone, String mobilePhone, String email1, String group) {
    this.id=id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.email1 = email1;
    this.group = group;
  }

  @Override
  public String toString() {
    return "ContactData{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", id=" + id + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, id);
  }

  public ContactData(String firstName, String middleName, String lastName, String address, String homePhone, String mobilePhone, String email1, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.email1 = email1;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
