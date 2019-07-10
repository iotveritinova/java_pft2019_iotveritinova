package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContactData("Petr", "Petrovich", "Petrov", "Sadovaya st.,2,204b", "999-999", "8-999-111-22-33", "email@mail.ru", "[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editSelectedContacts();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "changedName", "changedPatronim", "changedSurname", "new address", "888-000-000", "777-77-22-22", "newEmail@mail.ru", null);
    app.getContactHelper().fillContactData(contact, false);
    app.getContactHelper().submitUpdateContact();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    //проверка количества записей
    Assert.assertEquals(after.size(), before.size());
    //проверка списков с записями
    before.remove(before.size() - 1);
    before.add(contact);
    //сортировка списка
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //сравнение списков
    Assert.assertEquals(before,after);
  }
}
