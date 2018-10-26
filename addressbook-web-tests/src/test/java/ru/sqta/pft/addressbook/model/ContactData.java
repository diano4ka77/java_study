package ru.sqta.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "firstname")
  private String firstname;
  @Transient
  private String middlename;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "mobile")
  @Type(type =  "text")
  private String mobilephone;
  @Column(name = "email")
  @Type(type =  "text")
  private String email;
  @Transient
  private String companyname;
  @Transient
  private String year;
  @Column(name = "address")
  @Type(type =  "text")
  private String address;

 @Transient
  private String group;
  @Column(name = "photo")
  @Type(type =  "text")
  private String photo;
  @Transient
  private String allPhones;
  @Column(name = "email2")
  @Type(type =  "text")
  private String email2;
  @Column(name = "email3")
  @Type(type =  "text")
  private String email3;
  @Transient
  private String allEmails;
  @Column(name = "home")
  @Type(type =  "text")
  private  String homePhone;
  @Column(name = "work")
  @Type(type =  "text")
  private  String workPhone;

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withallPhones(String allPhones) {
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

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withallEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getAbsolutePath();
    return this;
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

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
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
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(mobilephone, that.mobilephone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(workPhone, that.workPhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, mobilephone, email, address, homePhone, workPhone);
  }
}
