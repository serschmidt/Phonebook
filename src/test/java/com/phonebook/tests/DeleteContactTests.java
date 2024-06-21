package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

  @BeforeMethod
  public void precondition(){

    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }

    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User()
        .setEmail(UserData.EMAIL)
        .setPassword(UserData.PASSWORD));
    app.getUser().clickOnLoginButton();

    app.getContact().clickOnAddLink();
    //  enter name
    app.getContact().fillAddContactForm(new Contact()
        .setName(ContactData.NAME)
        .setLastName(ContactData.LAST_NAME)
        .setPhone(ContactData.PHONE)
        .setEmail(ContactData.EMAIL)
        .setAddress(ContactData.ADDRESS)
        .setDescription(ContactData.DESC));
    //click on save
    app.getContact().clickOnSaveButton();
    //
  }

  @Test
  public void deleteContactPositiveTest(){
    //get size of contacts before delete

    int sizeBefore = app.getContact().sizeOfContacts();
    //click on Card
    app.getContact().removeContact();
    app.getContact().pause(1000);
    int sizeAfter = app.getContact().sizeOfContacts();

    Assert.assertEquals(sizeAfter,sizeBefore -1);
  }


}
