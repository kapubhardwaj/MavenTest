package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class  OpenBrowser {
    public static WebDriver driver;
    public static WebDriver openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
    public static Properties p;

    public OpenBrowser(WebDriver driver1) throws IOException {
        this.driver=driver1;
        PageFactory.initElements(driver, this);
    }


    public static boolean isDisplayedElement(String xpath){
        boolean flag =false;
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if(element.isDisplayed())
            {
                flag=true;
            }
        }catch (NoSuchElementException e){
            flag = false;
        }
        return flag;
    }
    public static void implicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static boolean waitForvisibilityOfElementLocated(String location){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(location)));
        return true;
    }
}
