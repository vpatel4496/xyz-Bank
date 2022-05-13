package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customer;

    public  void ClickOnCustomerTab(){
        Reporter.log("Click On Customer " + customer.toString() + "<br>" );
        clickOnElement(customer);
    }
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement logIn;

    public void ClickOnLogInButton(){
        Reporter.log("Click On LogIn " + logIn.toString() + "<br>" );
        clickOnElement(logIn);
    }
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOut;

    public void verifyLogOutTabDisplayed(){
        Reporter.log("Verify Log Out Tab " + logOut.toString() + "<br>" );
        verifyThatElementIsDisplayed(logOut);
    }
    public void clickOnLogOutTab(){
        Reporter.log("Click On Log Out Tab " + logOut.toString() + "<br>" );
        clickOnElement(logOut);
    }
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourName;

    public void verifyYourNameDisplayed(){
        Reporter.log("Verify your Name Displayed " + yourName.toString() + "<br>" );
        String expectedMessage = "Your Name :";
        String actualMessage = getTextFromElement(yourName);
        Assert.assertEquals(actualMessage,expectedMessage,"Your Name :");
    }
}
