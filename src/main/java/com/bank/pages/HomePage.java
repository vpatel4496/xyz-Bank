package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManager;

    public void clickOnBankManagerButton(){
        Reporter.log("Click On Bank Manager " + bankManager.toString() + "<br>" );
        clickOnElement(bankManager);
    }
}
