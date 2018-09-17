package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("mobile"),contactData.getMobilephone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("company"),contactData.getCompanyname());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("1");
    click(By.xpath("//div[@id='content']/form/select/option[3]"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("July");
    click(By.xpath("//div[@id='content']/form/select[2]/option[8]"));
    type(By.name("byear"),contactData.getYear());
  }
}
