package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData().withFirstname("Testname").withMiddlename("Middlenametest").withLastname("Lastnametest").withMobilephone("789456123").withEmail("test@gmail.com").withCompanyname("Testcompanyname").withYear("1990").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.closeAlert();
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
    //app.session().logout();
  }

}