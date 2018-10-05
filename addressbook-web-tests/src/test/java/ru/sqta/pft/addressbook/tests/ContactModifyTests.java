package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModifyTests extends TestBase{

  private ContactData contactData;

  @Test
  public void testContactModify() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Testname", "Middlenametest", "Lastnametest", "789456123", "test@gmail.com", "Testcompanyname", "1990", null, "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Testname1",null,"Lastnametest1", null,null, null,null, "Chelyabinsk city", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModify();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    app.getSessionHelper().logout();
  }
}


