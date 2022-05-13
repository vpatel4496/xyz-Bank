package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement deposit;

    public void clickOnDepositTab(){
        Reporter.log("Click On Deposit Tab " + deposit.toString() + "<br>" );
        clickOnElement(deposit);
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement credit;

    public void enterAmount(){
        Reporter.log("Enter Amount " + credit.toString()+ "<br>" );
        sendTextToElement(credit,"100");
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement deposit1;

    public void clickOnDeposit1Tab(){
    Reporter.log("Click On Deposit Tab " + deposit1.toString() + "<br>" );
    clickOnElement(deposit1);
    }
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessful;

    public void verifyDepositSuccessful(){
        Reporter.log("Verify Deposit Sucessful " + verifyMessageTransactionSuccessful.toString() + "<br>" );
        String expectedMessage = "Deposit Successful";
        String actualMessage = getTextFromElement(depositSuccessful);
        Assert.assertEquals(actualMessage,expectedMessage,"Deposit Successful");
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawl;

    public void clickOnWithdrawlTab(){
        Reporter.log("Click on Withdrawl Tab " + withdrawl.toString() + "<br>" );
        clickOnElement(withdrawl);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterAmount;

    public void enterWithdrawlAmount(){
        sendTextToElement(enterAmount,"50");
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement clickOnWithdrawButton;

    public void clickOnWithdrawButton(){
        Reporter.log("Click on Withdraw Button " + clickOnWithdrawButton.toString() + "<br>" );
        clickOnElement(clickOnWithdrawButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement verifyMessageTransactionSuccessful;

    public void verifyMessageTransactionSuccessful(){
        String expectedMessage = "Transaction successful";
        String actualMessage = getTextFromElement(verifyMessageTransactionSuccessful);
        Assert.assertEquals(actualMessage,expectedMessage,"Transaction successful");

    }
}
