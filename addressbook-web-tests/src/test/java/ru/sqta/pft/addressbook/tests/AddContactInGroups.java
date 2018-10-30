package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactInGroups extends TestBase {

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
  }

  @Test
  public void testsAddContactInGroup() {
    Groups group = app.db().groups();
    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    Groups groupOfContactBefore = contact.getGroups();
    if (groupOfContactBefore.size() < group.size()) {
      group.removeAll(groupOfContactBefore);
      int groupIndex = group.iterator().next().getId();
      app.goTo().homePage();
      app.contact().addInSelectGroup(contactId, groupIndex);
      app.goTo().homePage();
    } else {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
      int groupIndex = app.db().groups().stream()
              .mapToInt(GroupData::getId).max().getAsInt();
      app.goTo().homePage();
      app.contact().addInSelectGroup(contactId, groupIndex);
      app.goTo().homePage();
    }
    ContactData contactWithGroup = app.db().contacts().stream()
            .filter((c) -> c.equals(contact))
            .findFirst().get();
    Groups groupOfContactAfter = contactWithGroup.getGroups();
    GroupData groupForContact = groupOfContactAfter.stream()
            .filter(g -> !(groupOfContactBefore.contains(g)))
            .findFirst().get();
    assertThat(groupOfContactAfter, equalTo(groupOfContactBefore.withAdded(groupForContact)));
  }
}
