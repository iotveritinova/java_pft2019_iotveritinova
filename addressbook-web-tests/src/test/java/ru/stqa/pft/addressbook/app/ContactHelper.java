package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

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


  public void fillContactForm(ContactData newContact, boolean creation) {
    type(By.name("firstname"), newContact.getFirstName());
    type(By.name("middlename"), newContact.getMiddleName());
    type(By.name("lastname"), newContact.getLastName());
    type(By.name("address"), newContact.getAddress());
    type(By.name("home"), newContact.getHomePhone());
    type(By.name("mobile"), newContact.getMobilePhone());
    type(By.name("work"), newContact.getWorkPhone());
    type(By.name("email"), newContact.getEmail1());
    type(By.name("email2"), newContact.getEmail2());
    type(By.name("email3"), newContact.getEmail3());
    attach(By.name("photo"), newContact.getPhoto());
    if (creation) {
      if (newContact.getGroups().size() > 0) {
        Assert.assertTrue(newContact.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContact.getGroups().iterator().next().getName());
      }
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
    wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
  }

  public void initContactModificationById(int id) {
    click(By.cssSelector(String.format("a[href='edit.php?id=%s'", id)));
  }

  public void submitUpdateContact() {
    click(By.name("update"));
  }

  public boolean isThereAContract() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void create(ContactData contactData) {
    addNew();
    fillContactForm(contactData, true);
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
    fillContactForm(contact, false);
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
    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public int count() {
    return wd.findElements(By.cssSelector("tr[name=entry]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName).withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void displayGroupOnHomePage(GroupData group) {
    click(By.cssSelector(String.format("select[name=\"group\"] > option[value=\"%s\"]", group.getId())));
  }

  private void displayGroupOnHomePage(String groupName) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(String.format("%s", groupName));
  }

  private void selectGroupOnHomePage(GroupData group) {
    click(By.cssSelector(String.format("select[name=\"to_group\"] > option[value=\"%s\"]", group.getId())));
  }

  private void submitAddToGroup() {
    click(By.cssSelector("input[value='Add to']"));
  }

  public void addToGroup(ContactData contact, GroupData group) {
    displayGroupOnHomePage("[all]");
    selectContactById(contact.getId());
    selectGroupOnHomePage(group);
    submitAddToGroup();
    returnToHomePage();
  }

  public void removeFromGroup(ContactData contact, GroupData group) {
    displayGroupOnHomePage(group);
    selectContactById(contact.getId());
    submitRemovalFromGroup();
    returnToHomePage();
  }

  private void submitRemovalFromGroup() {
    click(By.cssSelector("input[name='remove']"));
  }
}
