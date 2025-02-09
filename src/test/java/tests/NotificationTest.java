package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationTest {

    @Test
    public void notificationTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@href='/notification_message']")).click();
        String messageText = driver.findElement(By.id("flash-messages")).getText().split("\n")[0];

        Assert.assertEquals(messageText, "Action successful");
    }
}
