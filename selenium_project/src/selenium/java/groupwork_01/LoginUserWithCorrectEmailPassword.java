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

public class LoginUserWithCorrectEmailPassword {


    WebDriver driver;
    @BeforeSuite
    public void setUpSuite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        File file = new File("/Users/a.savran/Downloads/CRX-Extractor-Downloader.crx");
        options.addExtensions(file);
        driver = new ChromeDriver(options);
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
    public void clickSignUpLoginButton(){
        driver.findElement(By.cssSelector("a[href='/login']")).click();
    }
    @Test(priority = 3)
    public void verifyLoginToYourAccountsVisible(){
        List<WebElement> message = driver.findElements(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div"));
        boolean isVisible = message.stream().anyMatch(m -> m.getText().equals("Login to your account"));
        Assert.assertFalse(isVisible);
     }
     @Test(priority = 4)
    public void enterCorrectEmailPassword(){
        driver.findElement(By.name("email")).sendKeys("savran@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
     }
     @Test(priority = 5)
    public void verifyLoggedInAsUsernameVisible(){
        String loginmessage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText();
        Assert.assertEquals(loginmessage,"Logged in as savran");
     }
     @Test(priority = 6)
    public void DeleteAccount(){
         driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
     }
     @Test(priority = 7)
    public void verifyACCOUNTDELETEDVisible(){
         String deleteMessage = driver.findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
         Assert.assertEquals(deleteMessage, "ACCOUNT DELETED!");
     }
    @AfterSuite
    public void afterTest(){
        driver.quit();

    }

}
