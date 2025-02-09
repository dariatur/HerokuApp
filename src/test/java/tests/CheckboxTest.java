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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void firstCheckboxTest(){
        WebElement firstCheckbox = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);

        Assert.assertFalse(firstCheckbox.isSelected());

        if (!firstCheckbox.isSelected()){
            firstCheckbox.click();
        }

        Assert.assertTrue(firstCheckbox.isSelected());
    }

    @Test
    public void secondCheckboxTest(){
        WebElement secondCheckbox = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);

        Assert.assertTrue(secondCheckbox.isSelected());

        if (secondCheckbox.isSelected()){
            secondCheckbox.click();
        }

        Assert.assertFalse(secondCheckbox.isSelected());
    }

}
