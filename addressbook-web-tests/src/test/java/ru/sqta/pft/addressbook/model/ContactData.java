package ru.sqta.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String mobilePhone;
  private String homePhone;
  private String workPhone;
  private String email;
  private String allPhones;

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getallEmails() {
    return allEmails;
  }

  public ContactData withallEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  private String email2;
  private String email3;
  private String allEmails;
  private String companyname;
  private String year;
  private String address;
  private String group;

  public String getAllPhones() {
    return allPhones;
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

  public String getMobilePhone() {
    return mobilePhone;
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

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withMobilePhone(String mobilephone) {
    this.mobilePhone = mobilephone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withCompanyname(String companyname) {
    this.companyname = companyname;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
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
