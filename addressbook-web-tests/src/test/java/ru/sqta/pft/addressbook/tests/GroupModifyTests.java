package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

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
      app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
      app.getGroupHelper().submitGroupModify();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());
      app.getSessionHelper().logout();
    }
}
