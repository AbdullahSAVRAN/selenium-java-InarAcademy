package homework_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_12 {
    public static void main(String[] args) {
        //LOGIN IN THE ORDER PAGE
        //UPDATE PAYMENT INFORMATION

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath(("//*[@id=\"ctl00_menu\"]/li[3]/a"))).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("1234567890");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("05/23");

    }
}
