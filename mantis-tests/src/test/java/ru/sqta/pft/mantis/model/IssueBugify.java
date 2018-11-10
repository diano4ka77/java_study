package ru.sqta.pft.mantis.model;

import java.util.Objects;

public class IssueBugify {

  private String subject;
  private int id;
  private String description;

  public String getSubject() {
    return subject;
  }

  public IssueBugify withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public int getId() {
    return id;
  }

  public IssueBugify withId(int id) {
    this.id = id;
    return this;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IssueBugify that = (IssueBugify) o;
    return id == that.id &&
            Objects.equals(subject, that.subject) &&
            Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, id, description);
  }

  public IssueBugify withDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return "Issue{" +
            "subject='" + subject + '\'' +
            ", id=" + id +
            ", description='" + description + '\'' +
            '}';
  }
}
