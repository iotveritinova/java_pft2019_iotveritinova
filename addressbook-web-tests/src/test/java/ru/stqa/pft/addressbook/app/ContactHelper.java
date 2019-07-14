package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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


  public void fillContactData(ContactData newContact, boolean creation) {
    type(By.name("firstname"), newContact.getFirstName());
    type(By.name("middlename"), newContact.getMiddleName());
    type(By.name("lastname"), newContact.getLastName());
    type(By.name("address"), newContact.getAddress());
    type(By.name("home"), newContact.getHomePhone());
    type(By.name("mobile"), newContact.getMobilePhone());
    type(By.name("email"), newContact.getEmail1());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContact.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNew() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']",id))).click();
  }

  public void initContactModificationById(int id) {
    click(By.cssSelector(String.format("a[href='edit.php?id=%s'",id)));
  }

  public void submitUpdateContact() {
    click(By.name("update"));
  }

  public boolean isThereAContract() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void create(ContactData contactData) {
    addNew();
    fillContactData(contactData, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    isAlertPresent();
    acceptAlert();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactData(contact, false);
    submitUpdateContact();
    contactCache = null;
    returnToHomePage();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return new Contacts(contactCache);
  }

  public int count() {
    return wd.findElements(By.cssSelector("tr[name=entry]")).size();
  }
}
