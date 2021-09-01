package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage  {
    public WebDriver driver;
    public static Properties p;

    public BasePage(WebDriver driver1) throws IOException {

        p = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/resources/config.properties");
        p.load(fis);
        String url = p.getProperty("url");

        this.driver=driver1;
        PageFactory.initElements(driver, this);
    }
}