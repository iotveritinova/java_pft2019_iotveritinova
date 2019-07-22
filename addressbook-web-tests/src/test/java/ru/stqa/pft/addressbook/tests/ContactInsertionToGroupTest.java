package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.Set;

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
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    //adding contact to group
    app.contact().addToGroup(contact, group);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(contact).withAdded(contact.inGroup(group))));
    //проверка групп
    Set<Groups> befG = new HashSet<Groups>();
    Set<Groups> afG = new HashSet<Groups>();
    for (ContactData s : after) {
      System.out.println(s);
      System.out.println(s.getGroups());
      afG.add(s.getGroups());
    }
    for (ContactData s : before) {
      System.out.println(s);
      System.out.println(s.getGroups());
      if (s.getId() != contact.getId()) {
        befG.add(s.getGroups());
      } else {
        befG.add(s.inGroup(group).getGroups());
      }
    }
    assertThat(afG, equalTo(befG));
    //after.stream().map((p) -> p.getGroups()).collect(Collectors.toSet()),
  }
}
