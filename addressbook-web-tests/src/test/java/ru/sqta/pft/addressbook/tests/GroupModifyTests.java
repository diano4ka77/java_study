package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModifyTests extends TestBase{

    @Test
    public void testGroupModify() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size() - 1);
      app.getGroupHelper().editSelectedGroup();
      GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", null, null);
      app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupModify();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      app.getSessionHelper().logout();
    }
}
