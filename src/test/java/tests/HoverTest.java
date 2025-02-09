package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
    private WebDriver driver = null;
    private Actions action = null;
    private List<WebElement> hoverElements = null;

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        action = new Actions(driver);
        hoverElements = driver.findElements(By.xpath("//*[@alt='User Avatar']"));
    }

    @Test
    public void hoverUsernameTest(){
        String username = "";
        int i = 1;

        for (WebElement elem : hoverElements){
            action.moveToElement(elem).perform();
            username = driver.findElement(By.xpath("(//*[@class='figcaption']/h5)["+i+"]")).getText();
            Assert.assertEquals(username, "name: user" + i++);
        }
    }

    @Test
    public void userProfileTest(){
        String message = "";
        int i = 1;

        for (WebElement elem : hoverElements){
            action.moveToElement(elem).perform();
            driver.findElement(By.xpath("(//*[@class='figcaption']/a)["+ (i++) +"]")).click();
            message = driver.findElement(By.tagName("h1")).getText();
            Assert.assertEquals(message, "Not Found");
            driver.navigate().back();
        }
    }
}
