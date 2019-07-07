package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().isAlertPresent();
    app.getNavigationHelper().acceptAlert();


    app.getContactHelper().returnToHomePage();
  }
}


