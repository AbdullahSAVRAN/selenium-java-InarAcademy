package groupwork_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewCategoryProducts {

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
    public void verifyCategory(){
        List<WebElement> message =  driver.findElements(By.cssSelector(".left-sidebar"));
        boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("CATEGORY"));
        Assert.assertFalse(isVisible);
    }
    @Test(priority = 2)
    public void clickOnWomenAndDress(){
        driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();
        driver.findElement(By.cssSelector("a[href='/category_products/1']")).click();
    }
    @Test(priority = 3)
    public void verifyPage() {
        String message = driver.findElement(By.xpath("//h2[normalize-space()='Women - Dress Products']")).getText();
        Assert.assertEquals(message, "WOMEN - DRESS PRODUCTS");
    }
    @Test(priority = 4)
    public void clickOnMenAndTshirts(){
        driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Tshirts'])[1]")).click();
    }
    @Test(priority = 5)
    public void verifyMenPage(){
        String message = driver.findElement(By.xpath("//h2[normalize-space()='Men - Tshirts Products']")).getText();
        Assert.assertEquals(message,"MEN - TSHIRTS PRODUCTS");
    }
    @AfterSuite
    public void afterTest() {
        driver.quit();
    }
}


