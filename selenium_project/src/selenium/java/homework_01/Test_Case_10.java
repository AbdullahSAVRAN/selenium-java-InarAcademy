package homework_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_10 {
    public static void main(String[] args) {
        //LOGIN IN THE ORDER PAGE
        //UPDATE PRODUCT INFORMATION

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath(("//*[@id=\"ctl00_menu\"]/li[3]/a"))).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")).sendKeys("MyMoney");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("1");
        driver.findElement(By.name("name=\"ctl00$MainContent$fmwOrder$txtTotal\"")).sendKeys("500");


    }
}
