package groupwork_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ContactUsForm {
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
    public void clickContactUsbutton(){
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();
    }
    @Test(priority = 3)
        public void verifyGetInTouchVisible(){
           List<WebElement> message =  driver.findElements(By.cssSelector("title text-center"));
           boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("GET IN TOUCH"));
           Assert.assertFalse(isVisible);
        }
@Test(priority = 4)
    public void enterNameEmailSubjectMessage(){
        driver.findElement(By.name("name")).sendKeys("savran");
        driver.findElement(By.name("email")).sendKeys("savranabdullah1@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("about ads");
        driver.findElement(By.name("message")).sendKeys("How can I remove the ads that appear on the screen?");

    }
    @Test(priority = 5)
    public void clickSubmitButton(){
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
    }
    @Test(priority = 6)
        public void clickOkButton(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
     }
@Test(priority = 7)
    public void verifySuccessMessage(){
        List<WebElement> successmessage = driver.findElements(By.cssSelector(".status.alert.alert-success"));
        boolean isVisible = successmessage.stream().anyMatch(m -> m.getText().equals("Success! Your details have been submitted successfully."));
        Assert.assertTrue(isVisible);
}
@Test(priority = 8)
    public void clickHomeButton(){
        driver.findElement(By.cssSelector(" a[class='btn btn-success'] span")).click();
    }


    @Test(priority = 9)
    public void isHomePageVisibleAgain(){
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - Contact Us");
    }
    @AfterSuite
    public void afterTest(){
        driver.quit();
    }
}
