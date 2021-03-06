package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModifyTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData().withFirstname("Testname").withMiddlename("Middlenametest").
              withLastname("Lastnametest").withMobilePhone("789456123").withEmail("test@gmail.com").withCompanyname("Testcompanyname").withYear("1990").withGroup("test1"));
    }
  }

  @Test
  public void testContactModify() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Testname1").withLastname("Lastnametest1").withAddress("Chelyabinsk city");
    app.contact().modify(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(
            before.without(modifiedContact).withAdded(contact)));
  }
}