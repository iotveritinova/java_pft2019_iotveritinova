package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper extends BaseHelper {
  public AlertHelper(WebDriver wd) {
    super(wd);
  }

  public void acceptAlert() {
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
