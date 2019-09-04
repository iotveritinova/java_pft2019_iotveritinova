package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInsertionToGroupTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    //is there any contact?
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov"));
    }
    //is there any group?
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testContactInsertionToGroup() throws Exception {
    //choose group and contact
    GroupData group = app.db().groups().iterator().next();
    ContactData contact = app.db().contacts().iterator().next();
    app.goTo().contactPage();
    //is choosen contact already added in choosen group?
    if (contact.getGroups() == contact.inGroup(group).getGroups()) {
      app.contact().removeFromGroup(contact, group);
    }
    //Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contactBefore = getContact(contact, before);
    //adding contact to group
    app.contact().addToGroup(contact, group);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    ContactData contactAfter = getContact(contact, after);
    //проверка групп
    //  assertThat(getGroupsListAsIs(after), equalTo(getGroupsListPlus(before, contact, group)));
    System.out.println("summary log:");
    System.out.println("groups of selected contact " + contact.getGroups());
    System.out.println("groups of initial contact " + contactBefore.getGroups());
    System.out.println("groups of expectedly changedcontact " + contactBefore.inGroup(group).getGroups());
    System.out.println("groups of really changed contact " + contactAfter.getGroups());
    //System.out.println(contactBefore.getGroups().size());
    //System.out.println(contactAfter.getGroups().size());
    //assertThat(contactBefore.getGroups().size(), equalTo(contactAfter.getGroups().size() - 1));
    assertThat(contactBefore.inGroup(group).getGroups(), equalTo(contactAfter.getGroups()));
  }

  private ContactData getContact(ContactData contact, Contacts contacts) {
    return contacts.stream().filter((c) -> c.equals(contact)).findFirst().get();
  }
}
