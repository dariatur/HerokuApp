package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest {
    private WebDriver driver = new ChromeDriver();
    private Select select = null;
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        select = new Select(driver.findElement(By.id("dropdown")));
    }

    @Test
    public void checkAllElementsTest(){
        int size = select.getOptions().size();
        Assert.assertEquals(size, 3);
    }

    @Test
    public void checkFirstOptionTest(){
        select.selectByIndex(0);
        Assert.assertEquals(select.getOptions().get(0).isSelected(), true);
    }

    @Test
    public void checkSecondOptionTest(){
        select.selectByIndex(1);
        Assert.assertEquals(select.getOptions().get(1).isSelected(), true);
    }

}
