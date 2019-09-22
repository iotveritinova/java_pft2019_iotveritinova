package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {
  @Test
  public void testChangePassword() throws IOException {
    String adminlogin = "administrator";
    String adminpass = "root";
    String username = "userForPassChange";
    String password = "password";
    app.mail().start();
    String email = "userForPassChange@localhost.localdomain";
    app.goTo().login(adminlogin, adminpass);
    // переходит на страницу управления пользователями,
    //app.goTo().click(By.cssSelector("a[href='/mantisbt-2.22.0/manage_overview_page.php']"));
    //app.goTo().click(By.cssSelector("a[href='/mantisbt-2.22.0/manage_user_page.php']"));
    // выбирает заданного пользователя и нажимает кнопку Reset Password
    app.goTo().initPasswordReset(username);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String passwordResetLink = findPasswordResetLink(mailMessages, email);
    //app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(username, password));


    //st2
    // ui
    // Отправляется письмо на адрес пользователя,
    // тесты должны получить это письмо,
    // извлечь из него ссылку для смены пароля,
    // пройти по этой ссылке и изменить пароль.
    //st3
    // http
    // проверить, что пользователь может войти в систему с новым паролем.
    app.mail().stop();
  }

  private String findPasswordResetLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


}
