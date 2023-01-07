package groupwork_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterWhileCheckout {

    WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        File file = new File("/Users/a.savran/Downloads/CRX-Extractor-Downloader.crx");
        options.addExtensions(file);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void setUpTest() {
        driver.get("http://automationexercise.com");
    }

    @Test(priority = 1)
    public void isHomePageVisible() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @Test(priority = 2)
    public void AddProducts() {
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();

    }

    @Test(priority = 3)
    public void clickContinueAndCartButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        driver.findElement(By.cssSelector("header[id='header'] li:nth-child(3) a:nth-child(1)")).click();
    }

    @Test(priority = 4)
    public void clickProceedToCheckoutButton() {
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
    }

    @Test(priority = 5)
    public void clickRegisterLoginButton() {
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
    }

    @Test(priority = 6)
    public void enterNameEmailAndClickSignUp() {
        driver.findElement(By.name("name")).sendKeys("Abdullah SAVRAN");
        driver.findElement(By.xpath("//div[3]/div/form/input[3]")).sendKeys("savranabdullah88@gmail.com");
        driver.findElement(By.xpath("//div[3]/div/form/button")).click();
    }

    @Test(priority = 7)
    public void verifyENTERACCOUNTINFORMATIONIsVisible() {
        String message = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).getText();
        Assert.assertEquals(message, "ENTER ACCOUNT INFORMATION");
    }

    @Test(priority = 8)
    public void fillDetails() {
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("1234567890");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByVisibleText("15");
        Select select1 = new Select(driver.findElement(By.id("months")));
        select1.selectByVisibleText("February");
        Select select2 = new Select(driver.findElement(By.id("years")));
        select2.selectByVisibleText("1997");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//div[1]/form/div[6]")).click();
        driver.findElement(By.xpath("//div[1]/form/div[7]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Abdullah");
        driver.findElement(By.id("last_name")).sendKeys("SAVRAN");
        driver.findElement(By.id("company")).sendKeys("Inar");
        driver.findElement(By.id("address1")).sendKeys("Cankaya");
        Select select3 = new Select(driver.findElement(By.id("country")));
        select3.selectByVisibleText("Canada");
        driver.findElement(By.id("state")).sendKeys("Vancouver");
        driver.findElement(By.id("city")).sendKeys("tefen");
        driver.findElement(By.id("zipcode")).sendKeys("1234");
        driver.findElement(By.id("mobile_number")).sendKeys("0555");
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
    }

    @Test(priority = 9)
    public void verifyACCOUNTCREATEDIsVisible() {
        String confirmMessage = driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals(confirmMessage, "ACCOUNT CREATED!");
    }

    @Test(priority = 10)
    public void clickContinueButton() {
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
    }

    @Test(priority = 11)
    public void verifyLoggedInAsUsernameIsVisible() {
        String accountText = driver.findElement(By.xpath("//div[2]/div/ul/li[10]/a")).getText();
        Assert.assertEquals(accountText, "Logged in as Abdullah SAVRAN");
    }


    @Test(priority = 12)
    public void clickCartButton() {
        driver.findElement(By.cssSelector("header[id='header'] li:nth-child(3) a:nth-child(1)")).click();
    }

    @Test(priority = 13)
    public void clickProceedToCheckOutButton() {
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
    }
/*
   @Test(priority = 14)
    public void verifyAddressDetails() {
        String address = driver.findElement(By.cssSelector("ul[id='address_delivery'] li:nth-child(2)")).getText();
        Assert.assertTrue(address.isEmpty(), "Cankaya");
        String address1 = driver.findElement(By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode")).getText();
        Assert.assertTrue(address1.isEmpty(), "tefen Vancouver 1234");
        String address2 = driver.findElement(By.cssSelector("#address_delivery > li.address_country_name")).getText();
        Assert.assertTrue(address2.isEmpty(), "Canada");
    }
*/
    @Test(priority = 15)
    public void commentTextAreaAndClickPlaceHolderButton() {
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("please get my orders fast");
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
    }

    @Test(priority = 16)
    public void enterPaymentDetails() {
        driver.findElement(By.cssSelector("input[name='name_on_card']")).sendKeys("cart1");
        driver.findElement(By.cssSelector("input[name='card_number']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("input[placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("01");
        driver.findElement(By.cssSelector("input[placeholder='YYYY']")).sendKeys("2030");
    }

    @Test(priority = 17)
    public void clickPayAndConfirmButton() {
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test(priority = 18)
    public void verifySuccessMessage() {
        String successMessage = driver.findElement(By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p")).getText();
        Assert.assertEquals(successMessage, "Congratulations! Your order has been confirmed!");
    }

    @Test(priority = 19)
    public void clickDeleteAccountButton() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
    }

    @Test(priority = 20)
    public void verifyACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        String deleteMessage = driver.findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
        Assert.assertEquals(deleteMessage, "ACCOUNT DELETED!");
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
    }
    @AfterSuite
    public void afterTest() {
        driver.quit();
    }

}