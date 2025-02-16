package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicControlsTest {
    private WebDriver driver;
    private SoftAssert softAssert;

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }

    @Test
    public void firstInputCheck(){
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();

        softAssert.assertEquals(text, "It's gone!");
        softAssert.assertTrue(driver.findElements(By.xpath("//*[@id=\"checkbox\"]/input")).isEmpty());
        softAssert.assertAll();
    }

    @Test
    public void secondInputCheck(){
        WebElement input = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        softAssert.assertFalse(input.isEnabled());
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"input-example\"]/button"), "Disable"));

        softAssert.assertEquals(driver.findElement(By.id("message")).getText(), "It's enabled!");
        softAssert.assertTrue(input.isEnabled());
        softAssert.assertAll();
    }
}
