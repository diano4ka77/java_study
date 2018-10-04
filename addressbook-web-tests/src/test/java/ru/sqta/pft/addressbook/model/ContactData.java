package ru.sqta.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobilephone;
  private final String email;
  private final String companyname;
  private final String year;
  private final String address;
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String mobilephone, String email, String companyname, String year, String address, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.email = email;
    this.companyname = companyname;
    this.year = year;
    this.address = address;
    this.group = group;
  }

  public ContactData(int id, String firstname, String middlename, String lastname, String mobilephone, String email, String companyname, String year, String address, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.email = email;
    this.companyname = companyname;
    this.year = year;
    this.address = address;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail() {
    return email;
  }

  public String getCompanyname() {
    return companyname;
  }

  public String getYear() {
    return year;
  }

  public String getAddress() {
    return address;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
