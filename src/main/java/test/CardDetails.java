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

import javax.smartcardio.Card;
import java.io.IOException;

public class CardDetails extends BasePage {
    public CardDetails(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//a[@class='list with-promo']")
    WebElement CreditCardButton;
    @FindBy(xpath = "//input[@name=\"cardnumber\"]")
    WebElement CardNumber;
    @FindBy(xpath = "//input[@placeholder=\"MM / YY\"]")
    WebElement Expiry;
    @FindBy(xpath = "//input[@placeholder=\"123\"]")
    WebElement CVV;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNowButton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement OTPfield;
    @FindBy(xpath = "//button[@name='cancel']")
    WebElement CancelButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement OKButton;
    @FindBy(xpath = "//span[normalize-space()='Thank you for your purchase.']")
    WebElement purchaseConfirmation;
    @FindBy(xpath = "//span[normalize-space()='Your card got declined by the bank']")
    WebElement InvalidOtpCase;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement Cancelbutton;


    public void enterCardNumber(String cardNumber) {
        CreditCardButton.click();
        OpenBrowser.wait(2);
        CardNumber.click();
        CardNumber.sendKeys(cardNumber);
    }

    public void enterExpiry(String expiry) {
        Expiry.click();
        Expiry.sendKeys(expiry);
    }

    public void enterCVV(String cvv) {
        CVV.click();
        CVV.sendKeys(cvv);
    }

    public Boolean clickOnPayButton() {
        if (PayNowButton.isDisplayed()) {
            PayNowButton.click();
            System.out.println("CLicked on Paybutton successfully");
            return true;
        } else {
            return false;
        }

    }

    public void verifyValidOTP(){

        OpenBrowser.wait(5);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));
        OpenBrowser.wait(2);
        OTPfield.sendKeys(BasePage.p.getProperty("ValidOtp"));
        OpenBrowser.wait(2);
    }

    public void clickonOKButton(){
        OKButton.click();
    }

    public WebElement PurchaseConfirmation() {
        OpenBrowser.wait(5);
        driver.switchTo().defaultContent();
        OpenBrowser.wait(5);
        return purchaseConfirmation;
    }


    public void verifyInvalidOTP(){

        OpenBrowser.wait(5);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));
        OpenBrowser.wait(2);
        OTPfield.sendKeys(BasePage.p.getProperty("InvalidOtp"));
        OpenBrowser.wait(1);
        OKButton.click();
        driver.switchTo().window(this.driver.getWindowHandle());
        driver.switchTo().frame(0);
        OpenBrowser.wait(5);
    }

    public WebElement InvalidOTPCase() {
        return InvalidOtpCase;
    }

    public void cancelButtonFunctionality(){
        OpenBrowser.wait(5);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Cancelbutton.click();
        driver.switchTo().window(this.driver.getWindowHandle());
        driver.switchTo().frame(0);
        OpenBrowser.wait(5);
    }
    @FindBy(xpath = "//span[normalize-space()='Transaction failed']")
    WebElement purchasecancelled;

    public WebElement Purchasecancelled() {
        return purchasecancelled;
    }




}