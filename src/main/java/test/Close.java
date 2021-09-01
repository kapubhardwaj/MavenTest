package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Close extends BasePage{

    public Close(WebDriver driver1) throws IOException {
        super(driver1);
        PageFactory.initElements(driver1,this);
    }

    public void close() {
        driver.close();
    }
}
