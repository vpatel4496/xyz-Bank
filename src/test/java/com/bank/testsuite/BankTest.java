package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"Sanity","Regression"})

    public void bankManagerShouldAddCustomerSuccessfully(){
        //
        homePage.clickOnBankManagerButton();
        //
        bankManagerLoginPage.clickOnAddCustomerButton();
        //
        addCustomerPage.enterFirstName("Nirav");
        //
        addCustomerPage.enterLastName("Modi");
        //
        addCustomerPage.enterPostCode("SW1V 3JD");
        //
        addCustomerPage.clickOnAddCustomerButton();
        // Pop Up Displayed
        switchToAlert();
        // Verify the message customer added successfully.
        String expectedMessage = "Customer added successfully";
        String actualMessage = getTextFromAlert().substring(0, 27);
        Assert.assertEquals(actualMessage,expectedMessage,"Customer added successfully");
        // Click On Ok button on popup
        acceptAlert();
    }
    @Test(groups = {"Sanity","Smoke","Regression"})

    public void bankManagerShouldOpenAccountSuccessfully(){
        homePage.clickOnBankManagerButton();
        openAccountPage.clickOnOpenAccountButton();
        openAccountPage.verifyCustomerName("2");
        openAccountPage.selectCurrencyFromVisibleList("Pound");
        openAccountPage.clickOnProcessButton();
        // Pop up displayed
        switchToAlert();
        // Verify the message Account created successfully.
        String expectedMessage = "Account created successfully";
        String actualMessgae = getTextFromAlert().substring(0, 28);
        Assert.assertEquals(actualMessgae,expectedMessage,"Account created successfully");
        // Click On ok Button.
        acceptAlert();
    }
    @Test(groups = {"Smoke","Regression"})

    public void customerShouldLoginAndLogoutSuceessfully(){
        customerLoginPage.ClickOnCustomerTab();
        openAccountPage.verifyCustomerName("2");
        customerLoginPage.ClickOnLogInButton();
        customerLoginPage.verifyLogOutTabDisplayed();
        customerLoginPage.clickOnLogOutTab();
        customerLoginPage.verifyYourNameDisplayed();
    }

    @Test(groups = {"Smoke","Regression"})

    public void customerShouldDepositMoneySuccessfully(){
        customerLoginPage.ClickOnCustomerTab();
        openAccountPage.verifyCustomerName("2");
        customerLoginPage.ClickOnLogInButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount();
        accountPage.clickOnDeposit1Tab();
        accountPage.verifyDepositSuccessful();
    }
    @Test(groups = {"Regression"})

    public void customerShouldWithdrawMoneySuccessfully(){
        customerLoginPage.ClickOnCustomerTab();
        openAccountPage.verifyCustomerName("2");
        customerLoginPage.ClickOnLogInButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount();
        accountPage.clickOnWithdrawButton();
        accountPage.verifyMessageTransactionSuccessful();
    }
}
