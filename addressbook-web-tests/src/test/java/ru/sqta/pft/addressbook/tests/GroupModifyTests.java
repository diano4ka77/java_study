package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

public class GroupModifyTests extends TestBase{

    @Test
    public void testGroupModify() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().editSelectedGroup();
      app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
      app.getGroupHelper().submitGroupModify();
      app.getGroupHelper().returnToGroupPage();
      app.getSessionHelper().logout();
    }
}
