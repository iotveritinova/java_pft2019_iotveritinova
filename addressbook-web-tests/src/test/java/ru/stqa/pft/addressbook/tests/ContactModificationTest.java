package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModificationFullContactData() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editSelectedContacts();
    app.getContactHelper().changeContactData(new ContactData("changedName","changedPatronim","changedSurname","new address","888-000-000","777-77-22-22","newEmail@mail.ru"));
    app.getContactHelper().submitUpdateContact();
    app.getContactHelper().returnToHomePage();
  }
  @Test
  public void testContactModificationPartOfContactData() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editSelectedContacts();
    app.getContactHelper().changeContactDataFieldValue("address","new address for housewarming party!!!!");
    app.getContactHelper().changeContactDataFieldValue("lastname","changedLastName");
    app.getContactHelper().changeContactDataFieldValue("mobile","000-000-000");
    app.getContactHelper().submitUpdateContact();
    app.getContactHelper().returnToHomePage();
  }
}
