package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.closeAlert();
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }

}