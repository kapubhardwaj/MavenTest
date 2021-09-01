package test;

import Setup.OpenBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
            return true;
        } else {
            return false;
        }
    }

}