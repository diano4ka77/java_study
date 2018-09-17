package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Testname", "Middlenametest", "Lastnametest", "789456123", "test@gmail.com", "Testcompanyname", "1990"));
    app.getContactHelper().submitContactCreation();
    app.gotoHomePage();
    app.getSessionHelper().logout();
  }

}
