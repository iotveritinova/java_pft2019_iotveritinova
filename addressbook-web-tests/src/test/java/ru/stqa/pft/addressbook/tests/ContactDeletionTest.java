package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {
  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContactData("Petr", "Petrovich", "Petrov", "Sadovaya st.,2,204b", "999-999", "8-999-111-22-33", "email@mail.ru", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getAlertHelper().isAlertPresent();
    app.getAlertHelper().acceptAlert();
    app.getContactHelper().returnToHomePage();
  }
}


