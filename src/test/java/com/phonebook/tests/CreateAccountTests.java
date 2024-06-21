package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

  SoftAssert softAssert = new SoftAssert();

  @BeforeMethod
  public void ensurePrecondition(){
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }


  @Test
  public void createAccountPositiveTest()  {

    logger.info("login with data - " + UserData.EMAIL + " *** " + UserData.PASSWORD);

    //  click on Login link
    app.getUser().clickOnLoginLink();
    //enter email
    app.getUser().fillRegisterLoginForm(new User()
        .setEmail(UserData.EMAIL)
        .setPassword(UserData.PASSWORD));
    //click on registration button
    app.getUser().click(By.name("registration"));

    //assert Sign Out button is present
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());


    // Registration
    //  enter email
    //  enter password
    //  click on Registration button
    // assert Sign Out button
  }

  @Test
  public void createAccountNegativTest()  {

    logger.info("login with data - " + UserData.EMAIL + " *** " + UserData.PASSWORD);

    //  click on Login link
    app.getUser().clickOnLoginLink();

    app.getUser().clearLoginRegisterForm();
    //enter email
    app.getUser().fillRegisterLoginForm(new User()
        .setEmail(UserData.EMAIL)
        .setPassword(UserData.PASSWORD));
    //click on registration button
    app.getUser().click(By.name("registration"));

    //assert Error message is present
//    assert Alert is present
    softAssert.assertTrue(app.getUser().isAlertPresent());
//    Assert.assertTrue(isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
    softAssert.assertTrue(app.getUser().isError409Present());
    softAssert.assertAll();

  }


}
