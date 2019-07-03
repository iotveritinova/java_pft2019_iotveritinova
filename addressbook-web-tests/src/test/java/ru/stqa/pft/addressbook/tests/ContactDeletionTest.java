package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  private WebDriver wd;
  private boolean acceptNextAlert = true;

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();

    //acceptNextAlert = true;
    app.getContactHelper().deleteSelectedContacts();    app.getContactHelper().selectContact();
    acceptAlert();
    app.getContactHelper().returnToHomePage();
  }

 // private void acceptAlert() {
   // Alert alert = wd.switchTo().alert();
    //alert.accept();
  //}
  private String acceptAlert() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}


