package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactData(new ContactData("Petr", "Petrovich", "Petrov", "Sadovaya st.,2,204b", "999-999", "8-999-111-22-33", "email@mail.ru","test1"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }


}
