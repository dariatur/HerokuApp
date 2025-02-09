package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputTest {

    @Test
    public  void herokuAppTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys("20");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "20");

        inputField.sendKeys(Keys.ARROW_UP);
        String actualText2 = inputField.getAttribute("value");
        Assert.assertEquals(actualText2, "21");
    }
}
