package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileDownloadTest {
    private WebDriver driver;

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void fileDownloadTest(){
        driver.findElement(By.xpath("//a[6]")).click();
        File folder = new File("/Users/mac/Downloads");
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("text.txt")) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
    }
}
