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

public class AddToCartFromRecommendedItems {
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
        public void scroolTheBottomOfPage(){
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.END).perform();
        }
        @Test(priority = 2)
    public void isRecommendedItemsVisible(){
            List<WebElement> message =  driver.findElements(By.cssSelector(".recommended_items"));
            boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("RECOMMENDED ITEMS"));
            Assert.assertFalse(isVisible);
}
    @Test(priority = 3)
    public void AddToCartRecommendedProduct(){
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[72]")).click();
    }
    @Test(priority = 4)
    public void clickOnViewCartButton(){
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
    }

    @Test(priority = 5)
    public void verifyProductDisplayedInCartPage(){
        List<WebElement> message =  driver.findElements(By.cssSelector("#product-4"));
        boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("Stylish Dress"));
        Assert.assertFalse(isVisible);
    }
    @AfterSuite
    public void afterTest() {
        driver.quit();
    }


}
