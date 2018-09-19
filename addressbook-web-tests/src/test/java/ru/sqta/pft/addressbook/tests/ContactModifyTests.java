package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactModifyTests extends TestBase{

  private ContactData contactData;

  @Test
  public void testContactModify() throws Exception {
    app.getContactHelper().editContact();
    app.getContactHelper().modifyContactForm(new ContactData("","","", "","", "","", "Chelyabinsk city"));
    app.getContactHelper().submitContactModify();
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }
}


