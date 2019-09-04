package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemovalFromGroupTest extends TestBase {
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
    //is choosen contact already added in choosen group?
    //is choosen contact already added in all groups?
  }

  @Test
  public void testContactRemovalFromGroup() throws Exception {
    //choose group and contact
    GroupData group = app.db().groups().iterator().next();
    ContactData contact = app.db().contacts().iterator().next();
    app.goTo().contactPage();
    //is choosen contact not yet in choosen group?
    if (contact.getGroups() != contact.inGroup(group).getGroups()) {
      app.contact().addToGroup(contact, group);
    }
    Contacts before = app.db().contacts();
    ContactData contactBefore = contact.getContact(before);
    //adding contact to group
    app.contact().removeFromGroup(contact, group);
    Contacts after = app.db().contacts();
    ContactData contactAfter = contact.getContact(after);
    assertThat(contactBefore.getGroups().size(), equalTo(contactAfter.getGroups().size() + 1));
    assertThat(contactBefore.getGroups().contains(group), equalTo(!contactAfter.getGroups().contains(group)));
    assertThat(contactBefore.getGroups(), equalTo(contactAfter.inGroup(group).getGroups()));
  }

}
