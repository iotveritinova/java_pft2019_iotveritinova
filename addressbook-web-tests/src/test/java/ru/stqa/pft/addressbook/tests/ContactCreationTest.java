package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactInfo(new Names("Petr", "Petrovich", "Petrov"),  new AddressData("Sadovaya st.,2,204b"), new Phones("999-999", "8-999-111-22-33"), new Emails("email@mail.ru"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }


}
