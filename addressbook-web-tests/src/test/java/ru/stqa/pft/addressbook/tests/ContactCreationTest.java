package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Petr").withLastName("Petrov");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    //проверка количества записей
    Assert.assertEquals(after.size(), before.size() + 1);
    //проверка списков с записями
    before.add(contact);
    //сравнение списков
    Assert.assertEquals(before, after);

  }


}
