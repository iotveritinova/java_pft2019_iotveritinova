package ru.stqa.pft.addressbook.model;

public class JobData {
  private final String jobTitle;
  private final String jobCompany;

  public JobData(String jobTitle, String jobCompany) {
    this.jobTitle = jobTitle;
    this.jobCompany = jobCompany;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public String getJobCompany() {
    return jobCompany;
  }
}
