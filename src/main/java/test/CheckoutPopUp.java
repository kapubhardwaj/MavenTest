package test;

import Setup.OpenBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutPopUp extends BasePage {

    public CheckoutPopUp(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1,this);
    }

    @FindBy(xpath = "//tr[@class='table-content']//input[@value='Budi']")
    WebElement Name;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='budi@utomo.com']")
    WebElement Email;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='081808466410']")
    WebElement Phone;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='Jakarta']")
    WebElement City;
    @FindBy(xpath = "//tr[@class='table-content']//textarea")
    WebElement Address;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='10220']")
    WebElement PostalCode;
    @FindBy(xpath = "//div[text()='CHECKOUT']")
    WebElement CheckoutButton;

    public Boolean verifyName() {
        if (Name.isDisplayed()) {
            Name.clear();
            OpenBrowser.implicitWait(2);
            Name.sendKeys(BasePage.p.getProperty("name"));
            return true;
        }
        else{ return false; }
    }

    public Boolean verifyEmail() {
        if (Email.isDisplayed()) {
            Email.clear();
            OpenBrowser.implicitWait(2);
            Email.sendKeys(BasePage.p.getProperty("email"));
            return true;
        }
        else{ return false; }
    }
    public Boolean verifyPhone() {
        if (Phone.isDisplayed()) {
            Phone.clear();
            OpenBrowser.implicitWait(2);
            Phone.sendKeys(BasePage.p.getProperty("phone"));
            return true;
        }
        else{ return false; }
    }
    public Boolean verifyCity() {
        if (City.isDisplayed()) {
            City.clear();
            OpenBrowser.implicitWait(2);
            City.sendKeys(BasePage.p.getProperty("city"));

            return true;
        }
        else{ return false; }
    }

    public Boolean verifyAddress() {
        if (Address.isDisplayed()) {
            Address.clear();
            OpenBrowser.implicitWait(2);
            Address.sendKeys(BasePage.p.getProperty("address"));
            return true;
        }
        else{ return false; }
    }

    public Boolean verifyPostalCode() {
        if (PostalCode.isDisplayed()) {
            PostalCode.clear();
            OpenBrowser.implicitWait(2);
            PostalCode.sendKeys(BasePage.p.getProperty("postal"));
            return true;
        }
        else{ return false; }
    }

    public void OrderSummary(){
        CheckoutButton.click();
        driver.switchTo().frame(0);
    }


}
