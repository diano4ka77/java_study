package ru.sqta.pft.mantis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class User {

  private String username;
  private String realname;
  private String email;
  private String password;

  @Id
  private int id;

  public int getId() {
    return id;
  }

  public User withId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User withUsername(String username) {
    this.username = username;
    return this;
  }

  public String getRealname() {
    return realname;
  }

  public User withRealname(String realname) {
    this.realname = realname;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User withPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id == user.id &&
            Objects.equals(username, user.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, id);
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", id=" + id +
            '}';
  }
}
