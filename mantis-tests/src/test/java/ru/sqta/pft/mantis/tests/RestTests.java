package ru.sqta.pft.mantis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;
import ru.sqta.pft.mantis.model.IssueBugify;
import java.io.IOException;
import java.util.Set;
import static org.testng.Assert.assertEquals;


public class RestTests extends TestBase{

  @Test
  public void testCreateIssue() throws IOException {
    Set<IssueBugify> oldIssues = app.rest().getIssues();
    IssueBugify newIssue = new IssueBugify().withSubject("Test for issue").withDescription("Test description for issue");
    int issueId = app.rest().createIssue(newIssue);
    Set<IssueBugify> newIssues = app.rest().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  @Test
  public void test() throws IOException {
    int id = 2;
    String json = app.rest().getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues/" + id + ".json")).returnContent().asString();
    System.out.println(json);
  }
}
