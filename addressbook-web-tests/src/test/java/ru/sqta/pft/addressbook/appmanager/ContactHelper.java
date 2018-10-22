package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import java.util.List;

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

  public void selectContact(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void deleteChoose() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void delete(ContactData contact) {
    selectContact(contact.getId());
    deleteChoose();
    contactCache = null;
  }


  public void edit(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void modify(ContactData contact) {
    edit(contact.getId());
    fillContactForm(contact, false);
    submitContactModify();
    contactCache = null;
  }

  public void submitContactModify() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("mobile"),contactData.getMobilephone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("company"),contactData.getCompanyname());
    attach(By.name("photo"), contactData.getPhoto());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("1");
    click(By.xpath("//div[@id='content']/form/select/option[3]"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("July");
    click(By.xpath("//div[@id='content']/form/select[2]/option[8]"));
    type(By.name("byear"),contactData.getYear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
   }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElements(By.tagName("td")).get(2).getText();
      String lastname = element.findElements(By.tagName("td")).get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return new Contacts(contactCache);
  }
}
