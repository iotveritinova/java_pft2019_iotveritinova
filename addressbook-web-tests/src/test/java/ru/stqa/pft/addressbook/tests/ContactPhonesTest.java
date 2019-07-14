package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTest extends TestBase {
  @BeforeMethod
  //must be edited!!!
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov"));
    }
  }
  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomePhone(),equalTo(contactInfoFromEditForm.getHomePhone()));
    assertThat(contact.getMobilePhone(),equalTo(contactInfoFromEditForm.getMobilePhone()));
    assertThat(contact.getWorkPhone(),equalTo(contactInfoFromEditForm.getWorkPhone()));

  }
}
