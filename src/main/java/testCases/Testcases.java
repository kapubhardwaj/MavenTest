package testCases;

import Setup.OpenBrowser;
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
    Close close;


    @BeforeClass()
public void initiateDrivers() throws IOException {
    WebDriver driver = openBrowser();
        basePage= new BasePage(driver);
        driver.get(BasePage.p.getProperty("url"));
        buynow=new BuyNow(driver);
        checkoutPopUp=new CheckoutPopUp(driver);
        orderSummary= new OrderSummary(driver);
        paymentoptions = new PaymentOptions(driver);

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
    }


@AfterTest
    public void close(){
        close.close();
}
}
