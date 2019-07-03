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

  public void fillContactInfo(Names names,  AddressData addressData, Phones phones,  Emails emails) {
    fillContactNames(names);

    fillContactAddress(addressData);
    fillContactPhones(phones);
    fillContactEmails(emails);
  }


  public void fillContactEmails(Emails newContact) {
    type(By.name("email"), newContact.getEmail1());
  }

  public void fillContactPhones(Phones newContact) {
    type(By.name("home"), newContact.getHomePhone());
    type(By.name("mobile"), newContact.getMobilePhone());
  }

  public void fillContactAddress(AddressData newContact) {
    type(By.name("address"), newContact.getAddress());
  }



  public void fillContactNames(Names newContact) {
    type(By.name("firstname"), newContact.getFirstName());
    type(By.name("middlename"), newContact.getMiddleName());
    type(By.name("lastname"), newContact.getLastName());
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }
}
