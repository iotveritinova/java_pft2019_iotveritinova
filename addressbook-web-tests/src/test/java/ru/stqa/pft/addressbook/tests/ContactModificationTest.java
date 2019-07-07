package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editSelectedContacts();
    app.getContactHelper().changeContactFieldValue(new ContactData("changedName","changedPatronim","changedSurname","new address","888-000-000","777-77-22-22","newEmail@mail.ru"));
    app.getContactHelper().updateContact();
    app.getContactHelper().returnToHomePage();
  }
}
