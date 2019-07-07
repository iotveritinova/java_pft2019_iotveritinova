package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContactData("Petr", "Petrovich", "Petrov", "Sadovaya st.,2,204b", "999-999", "8-999-111-22-33", "email@mail.ru", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().editSelectedContacts();
    app.getContactHelper().fillContactData(new ContactData("changedName", "changedPatronim", "changedSurname", "new address", "888-000-000", "777-77-22-22", "newEmail@mail.ru", null), false);
    app.getContactHelper().submitUpdateContact();
    app.getContactHelper().returnToHomePage();
  }

}
