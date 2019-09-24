package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    String adminlogin = "administrator";
    String adminpass = "root";
    UserData user = app.db().userData().iterator().next();
    String username = user.getUsername();
    String email = user.getEmail();
    String newPassword = "newpassword000";
    app.registration().login(adminlogin, adminpass);
    app.registration().initPasswordReset(username);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String passwordResetLink = findPasswordResetLink(mailMessages, email);
    app.registration().finish(passwordResetLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
  }

  private String findPasswordResetLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
