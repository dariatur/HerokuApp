package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest {

    @Test
    public void checkTyposTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/typos");

        String correctText = "Sometimes you'll see a typo, other times you won't.";
        String actualResult = driver.findElement(By.xpath("//p[2]")).getText();

        Assert.assertEquals(actualResult, correctText, "It has a typo");
    }

}
