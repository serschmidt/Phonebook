package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver driver) {
    super(driver);
  }
  public void clickOnSaveButton() {
    //click on save
    click(By.cssSelector(".add_form__2rsm2>button"));
  }

  public void clickOnAddLink() {
    //click on Addlink
    click(By.cssSelector("[href='/add']"));
  }

  public void removeContact() {
    //click on card
    click(By.cssSelector(".contact-item_card__2SOIM"));
    //  click on Remove button
    click(By.xpath("//button[.='Remove']"));
  }

  public boolean isContactAdded(String text) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for (WebElement el: contacts) {
      if (el.getText().contains(text)) {
        return true;
      }
      return false;
    }
    return false;
  }

  public int sizeOfContacts(){
    if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
      return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()  ;
    }
    return 0;
  }


  public void fillAddContactForm(Contact contact) {
    //  enter name
    type(By.xpath("//input[1]"), contact.getName());
    // enter lastname
    type(By.xpath("//input[2]"), contact.getLastName());
    // enter phone
    type(By.xpath("//input[3]"), contact.getPhone());
    // enter email
    type(By.xpath("//input[4]"), contact.getEmail());
    // enter adress
    type(By.xpath("//input[5]"), contact.getAddress());
    // enter description
    type(By.xpath("//input[6]"), contact.getDescription());
  }

}
