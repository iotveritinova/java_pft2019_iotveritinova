package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov").withAddress("\n" + "  г.Москва, ул.(Большая) Садовая\n" + "\n" + ";22/33,\n" + "  кв \"18\" БjhgБ\n" + "  "));
    }
  }

  @Test
  public void testContactAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }


}