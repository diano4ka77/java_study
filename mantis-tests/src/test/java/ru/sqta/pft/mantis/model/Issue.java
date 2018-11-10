package ru.sqta.pft.mantis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Objects;

@Entity
@Table(name = "mantis_bug_table")
public class Issue {

  @Transient
  private String summary;
  @Id
  private int id;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Issue issue = (Issue) o;
    return id == issue.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Transient
  private Project project;
  @Transient
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
