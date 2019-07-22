package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.app.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static ApplicationManager app;

  static {
    try {
      app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method method, Object[] parameters) {
    logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(parameters));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method method) {
    logger.info("Stop test " + method.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  protected Set<Groups> getGroupsListPlus(Contacts contactsList, ContactData contact, GroupData group) {
    Set<Groups> groupsList = new HashSet<Groups>();
    for (ContactData s : contactsList) {
      if (s.getId() != contact.getId()) {
        groupsList.add(s.getGroups());
      } else {
        groupsList.add(s.inGroup(group).getGroups());
      }
    }
    return groupsList;
  }

  protected Set<Groups> getGroupsListAsIs(Contacts contactsList) {
    Set<Groups> groupsList = new HashSet<Groups>();
    for (ContactData s : contactsList) {
      groupsList.add(s.getGroups());
    }
    return groupsList;
  }
}
