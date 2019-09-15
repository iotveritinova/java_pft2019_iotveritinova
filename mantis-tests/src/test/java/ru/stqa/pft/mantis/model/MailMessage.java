package ru.stqa.pft.mantis.model;

public class MailMessage {
  private final String to;
  private final String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
