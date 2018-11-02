package ru.sqta.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;
import ru.sqta.pft.mantis.tests.TestBase;

import java.io.File;
import java.io.IOException;

public class FttpHelper extends TestBase {
  private final ApplicationManager app;
  private FTPClient ftp;

  public FtpHelper(ApplicationManager app) {
    this.app = app;
    ftp = new FTPClient();
  }

  public void upload(File file, String target, String backup) throws IOException {
    ftp.connect(app.getProperty("ftp.host"));
    
  }
}
