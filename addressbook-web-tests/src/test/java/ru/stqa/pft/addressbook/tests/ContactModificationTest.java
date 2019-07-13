package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (!app.contact().isThereAContract()) {
      app.contact().create(new ContactData("Petr", "Petrovich", "Petrov", "Sadovaya st.,2,204b", "999-999", "8-999-111-22-33", "email@mail.ru", "[none]"), true);
    }
  }

  @Test
  public void testContactModification() throws Exception {

    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "changedName", "changedPatronim", "changedSurname", "new address", "888-000-000", "777-77-22-22", "newEmail@mail.ru", null);
    int index = before.size() - 1;
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    //проверка количества записей
    Assert.assertEquals(after.size(), before.size());
    //проверка списков с записями
    before.remove(0);
    before.add(contact);
    //сортировка списка
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //сравнение списков
    Assert.assertEquals(before, after);
  }


}
