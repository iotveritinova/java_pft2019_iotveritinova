package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Войти']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Войти']"));
  }

  public void initPasswordReset(String username) {
    click(By.linkText("Управление"));
    click(By.linkText("Управление пользователями"));
    click(By.linkText(username));
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }
}
