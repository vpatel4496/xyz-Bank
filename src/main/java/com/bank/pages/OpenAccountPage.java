package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    public OpenAccountPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManager;

    public void clickOnBankManagerButton(){
        clickOnElement(bankManager);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccount;

    public void clickOnOpenAccountButton(){
        clickOnElement(openAccount);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;

    public void verifyCustomerName(String value){
        Reporter.log("Verify Customer Name " + searchCustomer.toString() + "<br>" );
        selectByValueFromDropDown(searchCustomer,"2");
    }

    @FindBy(xpath = "//select[@id='currency']")
    WebElement pound;

    public void selectCurrencyFromVisibleList(String currency){
        Reporter.log("Select Currency " + pound.toString() + "<br>" );
        selectByVisibleTextFromDropDown(pound, currency);
    }

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement clickProcess;

    public void clickOnProcessButton(){
        Reporter.log("Click On Process " + clickProcess.toString() + "<br>" );
        clickOnElement(clickProcess);
    }
}
