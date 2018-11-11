package ru.sqta.pft.mantis.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import ru.sqta.pft.mantis.model.IssueBugify;

import java.io.IOException;
import java.util.Set;

public class RestHelper {

  private ApplicationManager app;

  public RestHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<IssueBugify> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json?limit=2000"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<IssueBugify>>(){}.getType());
  }

  public Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public int createIssue(IssueBugify newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("http://bugify.stqa.ru/api/issues.json?limit=2000")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  public String getIssueById(int id) throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues/" + id + ".json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("state_name").getAsString();
  }
}
