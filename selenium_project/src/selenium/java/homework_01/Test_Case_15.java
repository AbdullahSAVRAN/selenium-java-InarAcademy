package homework_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_15 {
    public static void main(String[] args) throws InterruptedException {
        //LOGIN IN THE ORDER PAGE
        //UPDATE ADDRESS INFORMATION AND PAYMENT INFORMATION
        //PRESS THE RESET BUTTON AND RESET ALL ITEMS
        //PRESS THE LOGOUT BUTTON AND LOGOUT THIS WEBSITE

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath(("//*[@id=\"ctl00_menu\"]/li[3]/a"))).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("PAUL WALKER");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("CANKAYA");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("ANKARA");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("TURKEY");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("1234567890");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("05/23");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='reset']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ctl00_logout")).click();

    }
}
