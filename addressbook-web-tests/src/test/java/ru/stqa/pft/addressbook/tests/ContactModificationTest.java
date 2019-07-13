package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("changedName").withLastName("changedSurname");
    app.contact().modify(modifiedContact.getId(), contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(((Contacts) before).without(modifiedContact).withAdded(contact)));
  }


}
