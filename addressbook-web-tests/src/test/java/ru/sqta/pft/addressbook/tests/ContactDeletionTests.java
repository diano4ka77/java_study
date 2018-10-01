package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Testname", "Middlenametest", "Lastnametest", "789456123", "test@gmail.com", "Testcompanyname", "1990", null, "test1"));
     }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.closeAlert();
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }

}