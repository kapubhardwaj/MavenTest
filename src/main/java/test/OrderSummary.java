package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OrderSummary extends BasePage {
    public OrderSummary(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//td[@class='table-amount text-body']")
    WebElement Price;
    @FindBy(xpath = "//span[@class='item-name']")
    WebElement ProductName;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueButton;


    public Boolean verifyPrice() {
        if (Price.isDisplayed()) {
            Price.getText();
            System.out.println(Price);
            return true;
        } else {
            return false;
        }
    }
    public Boolean verifyProductName() {
        if (ProductName.isDisplayed()) {
            ProductName.getText();
            System.out.println(ProductName);
            return true;
        } else {
            return false;
        }
    }

    public Boolean clickOnContinueButton(){
        if (ContinueButton.isDisplayed()) {
            ContinueButton.click();
            return true;
        } else {
            return false;
        }
    }
}