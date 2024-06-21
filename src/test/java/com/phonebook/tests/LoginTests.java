package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
//    System.out.println("Before Method");
  }
//
//  @AfterMethod
//  public void postcondition(){
//    System.out.println("Before Method");
//  }
//
//  @BeforeClass
//  public void beforeClassPrecondition(){
//    System.out.println("Before Class");
//  }
//
//  @AfterClass
//  public void afterClassPrecondition(){
//    System.out.println("After Class");
//  }
//
//  @BeforeTest
//  public void beforeTestPrecondition(){
//    System.out.println("Before Test");
//  }
//
//  @AfterTest
//  public void afterTestPrecondition(){
//    System.out.println("After Test");
//  }


  @Test(priority = 1)
  public void loginPositiveTest() {

    //click on Login link
    //enter email
    //enter password
    // login button
    // assert sign button is present

    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User()
        .setEmail(UserData.EMAIL)
        .setPassword(UserData.PASSWORD));
    app.getUser().clickOnLoginButton();

    //assert Sign Out button is present
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());


  }

  @Test(priority = 2)
  public void loginNegativeWithoutEmailTest() {

    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User().setPassword("Abc1234!"));
    app.getUser().clickOnLoginButton();

    //assert Sign Out button is present
    Assert.assertTrue(app.getUser().isAlertPresent());


  }

}
