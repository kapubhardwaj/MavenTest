package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class BuyNow extends BasePage {

    public BuyNow(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1,this);
    }

    @FindBy(xpath = "//a[normalize-space()='BUY NOW']")
    WebElement BuyNowButton;

    public void BuyNowClick(){
        driver.get(BasePage.p.getProperty("url"));
        BuyNowButton.click();
    }

}
