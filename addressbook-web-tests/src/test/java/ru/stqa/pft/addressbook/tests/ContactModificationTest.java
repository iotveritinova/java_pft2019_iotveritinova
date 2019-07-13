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
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov"));
    }
  }

  @Test
  public void testContactModification() throws Exception {

    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withFirstName("changedName").withLastName("changedSurname");
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
