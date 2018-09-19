package ru.sqta.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobilephone;
  private final String email;
  private final String companyname;
  private final String year;
  private final String address;

  public ContactData(String firstname, String middlename, String lastname, String mobilephone, String email, String companyname, String year, String address) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.email = email;
    this.companyname = companyname;
    this.year = year;
    this.address = address;
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
}
