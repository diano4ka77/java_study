package ru.sqta.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePrediction() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("Testname").
              withLastname("Lastnametest").withMobilephone("789456123").withEmail("test@gmail.com")
              .withAddress("Chelyabinsk").withGroup("test1"));
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }
  public static String cleaned(String address) {
    return address.replaceAll("\\s+", " ");
  }
}