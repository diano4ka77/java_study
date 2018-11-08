package ru.sqta.pft.mantis.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.sqta.pft.mantis.appmanager.HelperBase;
import ru.sqta.pft.mantis.model.MailMessage;
import ru.sqta.pft.mantis.model.User;

import java.io.IOException;
import java.util.List;

public class ResetPasswordTests extends TestBase {

  private static SessionFactory sessionFactory;

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      ex.printStackTrace();
      throw new ExceptionInInitializerError(ex);
    }
  }

  @Test
  public void resetPasswordTest() throws IOException {
      List<User> users = app.db().users();
//    Временно закомментировано
//    Session session = sessionFactory.openSession();
//    session.beginTransaction();
//    List<User> users = session.createQuery("from User").list();
//    for (User user : users) {
//      System.out.println(user);
//    }
//    session.getTransaction().commit();
//    session.close();
    if (users.size() > 1) {
      User user = users.get(1);
      if (user.getId() == 1) {
        while (user.getId() == 1) {
//          Вот здесь зацикливается
          user = users.listIterator().next();
        }
      }
      app.registration().login("administrator", "root");
      app.admin().manageUsers(user);
      app.admin().resetPassword();
      List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
      String email = user.getEmail();
      String password = "password";
      String confirmationLink = findConfirmationLink(mailMessages, email);
      app.registration().finish(confirmationLink, password);
      Assert.assertTrue(app.newSession().login(user.getUsername(), password));
    } else {
      System.out.println("В системе всего лишь один пользователь - администратор");
    }
  }


  public  String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
