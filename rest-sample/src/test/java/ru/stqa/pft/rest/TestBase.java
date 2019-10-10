package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

public class TestBase {

  protected void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      System.out.println("Ignored because of issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  private boolean isIssueOpen(int issueId) {
    String json = RestAssured.get("https://bugify.stqa.ru/api/issues/"+issueId+".json").asString();
    JsonElement issues = new JsonParser().parse(json).getAsJsonObject().get("issues");
    JsonElement issue = issues.getAsJsonArray().get(0);
    String issue_state = issue.getAsJsonObject().get("state_name").toString();
    return issue_state.contains("Open");
  }
}
