package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov").withAddress("\n" + "\n" + "  г.Москва, ул.(Большая) Садовая\n" + "\n" + "         \n" + ";22/33,\n" + "  кв \"18\" БjhgБ\n" + "  "));
    }
  }

  @Test
  public void testContactAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(mergeAddress(contact), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress().split("\n"))
            .stream().filter((s) -> !s.equals("")).map(ContactAddressTest::cleaned)
            .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address) {
    return address.replaceAll("^[' ']{1,}", "").replaceAll("[' ']{1,}$", "").replaceAll("[' ']{2,}", " ");
  }

}