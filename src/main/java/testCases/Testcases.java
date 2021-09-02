package testCases;

import Setup.OpenBrowser;
import net.bytebuddy.implementation.bind.annotation.This;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.*;

import java.io.IOException;

import static Setup.OpenBrowser.openBrowser;

public class Testcases {

    public static WebDriver driver;
    BasePage basePage;
    BuyNow buynow;
    CheckoutPopUp checkoutPopUp;
    OrderSummary orderSummary;
    PaymentOptions paymentoptions;
    CardDetails cardDetails;
    Close close;


    @BeforeClass()
public void initiateDrivers() throws IOException {
    WebDriver driver = openBrowser();
        basePage= new BasePage(driver);
        buynow=new BuyNow(driver);
        checkoutPopUp=new CheckoutPopUp(driver);
        orderSummary= new OrderSummary(driver);
        paymentoptions = new PaymentOptions(driver);
        cardDetails= new CardDetails(driver);
        close=new Close(driver);



}

    @Test (priority = 1 ,  groups= {"Regression", "Smoke"})
    public void BuyNowButton(){
    buynow.BuyNowClick();
    OpenBrowser.implicitWait(5);
    Assert.assertTrue(OpenBrowser.waitForvisibilityOfElementLocated("//div[text()='CHECKOUT']"));
    }

    @Test (priority = 2 ,  groups= {"Regression"})
    public void verifyName(){
        Assert.assertTrue(checkoutPopUp.verifyName());
    }

    @Test (priority = 3 ,  groups= {"Regression"})
    public void verifyCity(){
        Assert.assertTrue(checkoutPopUp.verifyCity());
    }


    @Test (priority = 4 ,  groups= {"Regression"})
    public void verifyEmail(){
        Assert.assertTrue(checkoutPopUp.verifyEmail());
    }

    @Test (priority = 5 ,  groups= {"Regression"})
    public void verifyPhone(){
        Assert.assertTrue(checkoutPopUp.verifyPhone());
    }

    @Test (priority = 6 ,  groups= {"Regression"})
    public void VerifyAddress(){
        Assert.assertTrue(checkoutPopUp.verifyAddress());
    }

    @Test (priority = 7 ,  groups= {"Regression"})
    public void verifyPostalCode(){
        Assert.assertTrue(checkoutPopUp.verifyPostalCode());
    }

    @Test(priority = 8, groups = {"Regression","Smoke"})
    public void verifyOrderSummaryPopup(){
        checkoutPopUp.OrderSummary();
        Assert.assertTrue(OpenBrowser.waitForvisibilityOfElementLocated("//a[@class='button-main-content']"));
    }
    @Test(priority = 9, groups = {"Regression"})
    public void verifyOrderSummaryPage(){
        Assert.assertTrue(orderSummary.verifyPrice());
        Assert.assertTrue(orderSummary.verifyProductName());
    }
    @Test(priority = 10, groups = {"Regression","Smoke"})
    public void verifyContinueButton(){
        Assert.assertTrue(orderSummary.clickOnContinueButton());
    }

    @Test(priority = 11, groups = {"Regression"})
    public void VerifyBackButtonFunctionality(){
    paymentoptions.clickOnBackButton();
    Assert.assertTrue(paymentoptions.verifylandedPage());
    OpenBrowser.wait(2);
    Assert.assertTrue(orderSummary.clickOnContinueButton());
        OpenBrowser.wait(2);

    }
    @Test(priority = 12, groups = {"Regression","Smoke"})
    public void verifyCardDetails(){
        cardDetails.enterCardNumber(BasePage.p.getProperty("cardnumber"));
        cardDetails.enterExpiry(BasePage.p.getProperty("expiry"));
        cardDetails.enterCVV(BasePage.p.getProperty("cvv"));
        cardDetails.clickOnPayButton();
        Assert.assertTrue(cardDetails.clickOnPayButton());
    }
    @Test(priority = 13, groups = {"Regression","Smoke"})
    public void verifyValidOTPcase(){
        cardDetails.verifyValidOTP();
        cardDetails.clickonOKButton();
        String expected_message="Thank you for your purchase.";
        Assert.assertEquals(cardDetails.PurchaseConfirmation().getText(), expected_message);
    }

    @Test(priority = 14, groups = {"Regression"})
    public void verifyInvalidOTPcase(){
        this.BuyNowButton();
        this.verifyName();
        this.verifyCity();
        this.verifyEmail();
        this.verifyPhone();
        this.verifyPostalCode();
        this.verifyOrderSummaryPopup();
        this.verifyContinueButton();
        cardDetails.enterCardNumber(BasePage.p.getProperty("cardnumber"));
        cardDetails.enterExpiry(BasePage.p.getProperty("expiry"));
        cardDetails.enterCVV(BasePage.p.getProperty("cvv"));
        cardDetails.clickOnPayButton();
        cardDetails.verifyInvalidOTP();
        String expected_message="Your card got declined by the bank";
        Assert.assertEquals(cardDetails.InvalidOTPCase().getText(),expected_message);
    }

    @Test(priority = 15, groups = {"Regression"})
    public void VerifyCancelButtonFunctionality(){
        this.BuyNowButton();
        this.verifyName();
        this.verifyCity();
        this.verifyEmail();
        this.verifyPhone();
        this.verifyPostalCode();
        this.verifyOrderSummaryPopup();
        this.verifyContinueButton();
        cardDetails.enterCardNumber(BasePage.p.getProperty("cardnumber"));
        cardDetails.enterExpiry(BasePage.p.getProperty("expiry"));
        cardDetails.enterCVV(BasePage.p.getProperty("cvv"));
        cardDetails.clickOnPayButton();
        cardDetails.cancelButtonFunctionality();
        Assert.assertEquals(cardDetails.Purchasecancelled().getText(), "Transaction failed");

    }


    @AfterTest
    public void close(){
        close.close();
}
}
