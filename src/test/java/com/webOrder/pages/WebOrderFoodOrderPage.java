package com.webOrder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

public class WebOrderFoodOrderPage {
    public WebOrderFoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    WebDriver driver= DriverHelper.getDriver();
    @FindBy(xpath = "//input[@name='Email']")
    WebElement username;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement signUpButton;
    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement GroupOrderBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement nextButton;
    @FindBy(xpath = "//textarea[@name='InviteNote']")
    WebElement messageBox;
    @FindBy(xpath = "//textarea[@id='InviteList']")
    WebElement messageBox2;
    @FindBy(xpath = "//select[@name='ConfirmAddressID']")
    WebElement myHouse;
    @FindBy(xpath = "//div[@id='addressPreview']")
    WebElement address;
    @FindBy(xpath = "//button[@id='createGroupOrder']")
    WebElement createGroupButton;
    @FindBy(xpath = "//h1")
    WebElement header;
    public void signInButton(String username,String password) throws InterruptedException {
        Thread.sleep(2000);
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        signUpButton.click();
    }
    public void validateTitle(String titlee){
        Assert.assertEquals(titlee,driver.getTitle().trim());
    }
    public void ClickGroupNextButton() throws InterruptedException {
        GroupOrderBox.click();
        Thread.sleep(2000);
        nextButton.click();
    }
    public void provideMessage(String text){
      this.messageBox.sendKeys(text);
    }
    public void provideEmails(String email1,String email2){
      this.messageBox2.sendKeys(email1+" , "+email2);
    }
   public void deliveryAddress(String house,String adress) throws InterruptedException {
      Thread.sleep(2000);
      BrowserUtils.selectBy(myHouse,house,"text");
      Thread.sleep(2000);
     Assert.assertTrue(address.getText().contains(adress));
   }
   public void clickButton() throws InterruptedException {
        createGroupButton.click();
   }
public boolean header(String headerpage){
     return BrowserUtils.getText(header).contains(headerpage);
}


}
