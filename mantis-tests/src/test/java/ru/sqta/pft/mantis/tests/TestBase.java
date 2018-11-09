package ru.sqta.pft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ObjectRef;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.sqta.pft.mantis.appmanager.ApplicationManager;
import ru.sqta.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_defaults_inc.php"), "config_defaults_inc.php", "config_defaults_inc.php.bak");
  }

  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (app.db().validateUser(issueId)) {
      IssueData issue = app.soap().getIssueById(issueId);
      if (issue.getResolution().getName().equals("fixed")) {
        return false;
      } else {
        return true;
      }
    } else {
      System.out.println("Задачи с заданным идентификатором не существует");
      //Предположим, что тест игнорируется, если идентификатор задачи указан неверно
      return true;
    }
  }


  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_defaults_inc.php.bak", "config_defaults_inc.php");
    app.stop();
  }
}
