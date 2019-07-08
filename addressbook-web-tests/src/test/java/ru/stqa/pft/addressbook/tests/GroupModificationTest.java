package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {


  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    int before = app.getGroupHelper().addGroupCount();
    app.getGroupHelper().selectGroup(before-1);
    app.getGroupHelper().initGroupUpdate();
    app.getGroupHelper().fillGroupForm(new GroupData("changedGroup1", "test2", "test3"));
    app.getGroupHelper().submitGroupUpdate();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().addGroupCount();
    Assert.assertEquals(after, before);

  }

}