package com.example.tests;



import org.testng.annotations.*;
import ru.stqa.pft.addressbook.TestBase;

public class GroupDeletionTest extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {

    gotoGroupPage();
    selectGroup();
    deleteSelectegGroups();
    returnToGroupPage();

  }


}
