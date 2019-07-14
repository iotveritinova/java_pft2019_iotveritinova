package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCommunicationDataTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov")
              .withHomePhone("+7(111)").withMobilePhone("222-222").withWorkPhone("33 333 33")
              .withEmail1("email@mail.ru").withEmail2("e_mail-2@mail.ru").withEmail3("e_ma.il-3@mail.ru")
              .withAddress("\n" + "\n" + "  г.Москва, ул.(Большая) Садовая\n" + "\n" + "         \n" + ";22/33,\n" + "  кв \"18\" БjhgБ\n" + "  "));
    }
  }

  @Test
  public void testContactCommunicationData() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(mergeAddress(contact), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals("")).map(ContactCommunicationDataTest::cleanedPhones).collect(Collectors.joining("\n"));
  }

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress().split("\n"))
            .stream().filter((s) -> !s.equals(""))
            .map(ContactCommunicationDataTest::cleanedAddress).filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

  public static String cleanedAddress(String address) {
    return address.replaceAll("^[' ']{1,}", "").replaceAll("[' ']{1,}$", "").replaceAll("[' ']{2,}", " ");
  }

}