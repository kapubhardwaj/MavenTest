package test;

import Setup.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class PaymentOptions extends BasePage{
    public PaymentOptions(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1,this);
    }

    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumber;
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDate;
    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement Cvv;
    @FindBy(xpath = "//a[@class='list with-promo']")
    WebElement CreditCardButton;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNowButton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement OTP;
    @FindBy(xpath = "//a[@class='header-back']")
    WebElement Backbutton;
    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement headerOrder;


        public void clickOnBackButton(){
            OpenBrowser.wait(2);
            Backbutton.click();
            OpenBrowser.wait(2);

        }
    public Boolean verifylandedPage() {

        String header = headerOrder.getText();
        if (header.equalsIgnoreCase("Order Summary")) {

            return true;
        } else {
            return false;
        }

    }

}
