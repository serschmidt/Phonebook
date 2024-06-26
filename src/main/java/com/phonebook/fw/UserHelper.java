package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isSignOutButtonPresent(){
    return isElementPresent(By.xpath("//button[.='Sign Out']"));
  }

  public void fillRegisterLoginForm(User user) {
    type(By.name("email"), user.getEmail());
    //enter password
    type(By.name("password"), user.getPassword());
  }

  public void clickOnLoginLink(){
    click(By.cssSelector("[href='/login']"));
  }

  public boolean isError409Present() {
    return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
  }

  public void clickOnLoginButton() {
    click(By.name("login"));
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/login']"));
      }

  public void clickOnSignOutButton() {
    click(By.xpath("//button[.='Sign Out']"));
  }

  public void clearLoginRegisterForm() {
    User emptyUser = new User().setEmail("").setPassword("");
        fillRegisterLoginForm(emptyUser);
  }
}
