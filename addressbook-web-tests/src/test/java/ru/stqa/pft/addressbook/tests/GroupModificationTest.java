package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {


  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupUpdate();
    app.getGroupHelper().fillGroupForm(new GroupData("changedGroup1", "test2", "test3"));
    app.getGroupHelper().submitGroupUpdate();
    app.getGroupHelper().returnToGroupPage();

  }

}