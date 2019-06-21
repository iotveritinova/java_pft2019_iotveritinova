package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactInfo(new Names("Petr", "Petrovich", "Petrov", "Petya"), new JobData("qa engeneer", "Roga&Kopyta"), new AddressData("Sadovaya st.,2,204b"), new Phones("999-999", "8-999-111-22-33", "123-123", "123-123-123"), new BdayData("7", "July", "1997"), new Emails("email@mail.ru", "email2@mail.ru", "email3@mail.ru", "petrov.ru"), new AdayData("1", "January", "1111"), new SecondaryData("secondary address", "222-222", "some notes"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }


}
