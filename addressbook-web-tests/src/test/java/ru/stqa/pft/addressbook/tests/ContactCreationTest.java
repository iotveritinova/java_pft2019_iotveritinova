package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstName("Petr").withLastName("Petrov");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    //проверка количества записей
    Assert.assertEquals(after.size(), before.size() + 1);
    //проверка списков с записями
    before.add(contact);
    //сортировка списка
    Comparator<? super ContactData> byId = (Comparator<ContactData>) (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //сравнение списков
    Assert.assertEquals(before, after);

  }


}
