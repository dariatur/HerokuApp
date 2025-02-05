package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {
    private WebDriver driver = new ChromeDriver();

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    @Test
    public void firstCheckboxTest(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement firstCheckbox = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);

        Assert.assertEquals(firstCheckbox.isSelected(), false);

        if (!firstCheckbox.isSelected()){
            firstCheckbox.click();
        }

        Assert.assertEquals(firstCheckbox.isSelected(), true);
    }
    @Test
    public void secondCheckboxTest(){
        WebElement secondCheckbox = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);

        Assert.assertEquals(secondCheckbox.isSelected(), true);

        if (secondCheckbox.isSelected()){
            secondCheckbox.click();
        }

        Assert.assertEquals(secondCheckbox.isSelected(), false);
    }

}
