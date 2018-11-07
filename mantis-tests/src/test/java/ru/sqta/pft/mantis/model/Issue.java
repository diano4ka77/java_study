package ru.sqta.pft.mantis.model;

public class Issue {

  private String summary;
  private int id;
  private Project project;
  private String description;

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Project getProject() {
    return project;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return "Issue{" +
            "summary='" + summary + '\'' +
            ", id=" + id +
            ", project=" + project +
            ", description='" + description + '\'' +
            '}';
  }
}
