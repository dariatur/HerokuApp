package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest {
    private WebDriver driver;

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void fileUploadTest(){
        driver.findElement(By.id("file-upload")).sendKeys("/Users/mac/workspace/qa-automated/Lesson17/src/test/resources/chromedriver");
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))).getText();

        Assert.assertEquals(text, "File Uploaded!");
    }
}
