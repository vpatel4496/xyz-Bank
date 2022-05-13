package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;

    public void clickOnAddCustomerButton(){
        clickOnElement(addCustomer);
    }
}
