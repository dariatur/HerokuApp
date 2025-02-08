package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortableDataTableTest {
    private WebDriver driver = new ChromeDriver();

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void checkFirstTableLastNameField(){
        WebElement elem = null;

        for(int i = 1; i < 5; i++){
            elem = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+i+"]/td[1]"));
            Assert.assertFalse(elem.getText().isEmpty());
        }

    }

    @Test
    public void checkFirstTableEmailField(){
        WebElement elem = null;

        for(int i = 1; i < 5; i++){
            elem = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+i+"]/td[3]"));
            Assert.assertTrue(elem.getText().contains("@"));
        }

    }

    @Test
    public void checkSecondTableDueField(){
        List<WebElement> dueElements = driver.findElements(By.cssSelector(".dues"));

        for (int i = 1; i < dueElements.size(); i++) {
            Assert.assertTrue(dueElements.get(i).getText().startsWith("$"));
        }
    }
}
