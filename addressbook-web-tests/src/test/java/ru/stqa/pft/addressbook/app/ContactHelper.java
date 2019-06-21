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

  public void fillContactInfo(Names names, JobData jobData, AddressData addressData, Phones phones, BdayData Bday, Emails emails, AdayData Aday, SecondaryData secondaryData) {
    fillContactNames(names);
    fillContactJob(jobData);
    fillContactAddress(addressData);
    fillContactPhones(phones);
    fillContactEmails(emails);
    fillContactBday(Bday);
    fillContactAday(Aday);
    fillContactSecondaryInfo(secondaryData);
  }

  public void fillContactAday(AdayData adayData) {
    dropdownListChoice(By.name("aday"), By.xpath("(//option[@value='1'])[2]"), adayData.getDay());
    dropdownListChoice(By.name("amonth"), By.xpath("(//option[@value='January'])[2]"), adayData.getMonth());
    type(By.name("ayear"),adayData.getYear());
  }

  public void fillContactBday(BdayData bdayData) {
    dropdownListChoice(By.name("bday"), By.xpath("//option[@value='7']"), bdayData.getDay());
    dropdownListChoice(By.name("bmonth"), By.xpath("//option[@value='July']"), bdayData.getMonth());
    type(By.name("byear"), bdayData.getYear());
  }


  public void fillContactSecondaryInfo(SecondaryData secondaryData) {
    type(By.name("address2"), secondaryData.getSecAddress());
    type(By.name("phone2"), secondaryData.getSecPhone());
    type(By.name("notes"), secondaryData.getNotes());
  }

  public void fillContactEmails(Emails emails) {
    type(By.name("email"), emails.getEmail1());
    type(By.name("email2"), emails.getEmail2());
    type(By.name("email3"), emails.getEmail3());
    type(By.name("homepage"), emails.getHomepage());
  }

  public void fillContactPhones(Phones phones) {
    type(By.name("home"), phones.getHomePhone());
    type(By.name("mobile"), phones.getMobilePhone());
    type(By.name("work"), phones.getWorkPhone());
    type(By.name("fax"), phones.getFaxPhone());
  }

  public void fillContactAddress(AddressData addressData) {
    type(By.name("address"), addressData.getAddress());
  }

  public void fillContactJob(JobData jobData) {
    type(By.name("title"), jobData.getJobTitle());
    type(By.name("company"), jobData.getJobCompany());
  }

  public void fillContactNames(Names names) {
    type(By.name("firstname"), names.getFirstName());
    type(By.name("middlename"), names.getMiddleName());
    type(By.name("lastname"), names.getLastName());
    type(By.name("nickname"), names.getNickname());
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }
}
