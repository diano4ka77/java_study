package ru.sqta.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.sqta.pft.mantis.model.User;

public class AdministrationHelper extends HelperBase{

  public AdministrationHelper(ApplicationManager app) {
    super(app);
  }

  public void manageUsers(User user) {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", user.getId()))).click();
  }

  public void resetPassword() {
    wd.findElement(By.cssSelector("input[value='Сбросить пароль']")).click();
  }
}
