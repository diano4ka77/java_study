package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("Mike2").withLastname("Smith2")
              .withAddress("Canada"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
    ContactData contact = app.db().contacts().iterator().next();
    if (contact.getGroups().size() == 0) {
      app.contact().addInSelectGroup(contact.getId(), app.db().groups().iterator().next().getId());
      app.goTo().homePage();
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    Groups group = app.db().groups();
    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    Groups groupOfContactBefore = contact.getGroups();
    if (!groupOfContactBefore.isEmpty()) {
      int groupIndex = groupOfContactBefore.iterator().next().getId();
      app.goTo().homePage();
      app.contact().deleteFromSelectGroup(contactId, groupIndex);
      app.goTo().homePage();
    }
    ContactData contactWithoutGroup = app.db().contacts().stream()
            .filter((c) -> c.equals(contact))
            .findFirst().get();
    Groups groupOfContactAfter = contactWithoutGroup.getGroups();
    GroupData groupForContact = groupOfContactBefore
            .stream().filter(g -> !(groupOfContactAfter.contains(g)))
            .findFirst().get();
    assertThat(groupOfContactAfter, equalTo(groupOfContactBefore.without(groupForContact)));
  }
}