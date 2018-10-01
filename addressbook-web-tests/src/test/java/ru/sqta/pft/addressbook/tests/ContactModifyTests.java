package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactModifyTests extends TestBase{

  private ContactData contactData;

  @Test
  public void testContactModify() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Testname", "Middlenametest", "Lastnametest", "789456123", "test@gmail.com", "Testcompanyname", "1990", null, "test1"));
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData(null,null,null, null,null, null,null, "Chelyabinsk city", null), false);
    app.getContactHelper().submitContactModify();
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }
}


