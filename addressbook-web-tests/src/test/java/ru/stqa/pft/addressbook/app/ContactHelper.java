package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends BaseHelper {



  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }


  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])"));
  }


  public void fillContactData(ContactData newContact) {
    type(By.name("firstname"), newContact.getFirstName());
    type(By.name("middlename"), newContact.getMiddleName());
    type(By.name("lastname"), newContact.getLastName());
    type(By.name("address"), newContact.getAddress());
    type(By.name("home"), newContact.getHomePhone());
    type(By.name("mobile"), newContact.getMobilePhone());
    type(By.name("email"), newContact.getEmail1());

  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }
}
