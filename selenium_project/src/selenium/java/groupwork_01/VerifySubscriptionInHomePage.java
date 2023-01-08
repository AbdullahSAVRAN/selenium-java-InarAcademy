package groupwork_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifySubscriptionInHomePage {
    WebDriver driver;
    @BeforeSuite
    public void setUpSuite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        File file = new File("/Users/a.savran/Downloads/CRX-Extractor-Downloader.crx");
        options.addExtensions(file);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeTest
    public void setUpTest(){

        driver.get("http://automationexercise.com");
    }
    @Test(priority = 1)
    public void isHomePageVisible(){

        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
    }
    @Test(priority = 2)
    public void scroolTheBottomOfPage(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }
    @Test(priority = 3)
    public void verifySubscriptionText(){
        String message = driver.findElement(By.cssSelector("div[class='single-widget'] h2")).getText();
        Assert.assertEquals(message,"SUBSCRIPTION");
    }
    @Test(priority = 4)
    public void enterEmailAndClickArrowButton(){
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("savran@gmail.com");
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();
    }
    @Test(priority = 5)
    public void verifySuccessMessage(){
        List<WebElement> message = driver.findElements(By.cssSelector("div[class='footer-widget'] div[class='container']"));
        boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("You have been successfully subscribed!"));
        Assert.assertFalse(isVisible);
    }
    @AfterSuite
    public void afterTest(){
        driver.quit();
    }
}
