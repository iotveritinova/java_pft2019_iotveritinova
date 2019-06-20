package ru.stqa.pft.addressbook;

public class Names {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;

  public Names(String firstName, String middleName, String lastName, String nickname) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
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

  public String getNickname() {
    return nickname;
  }
}
