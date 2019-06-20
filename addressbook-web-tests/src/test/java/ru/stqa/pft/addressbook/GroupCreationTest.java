package com.example.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.GroupData;
import ru.stqa.pft.addressbook.TestBase;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();

  }

}
