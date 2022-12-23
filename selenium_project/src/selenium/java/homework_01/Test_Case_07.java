package homework_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_07 {
    public static void main(String[] args) throws InterruptedException {
        //LOGIN IN THE PAGE AND SELECT THE FIRST ITEM'S EDIT ORDER BUTTON
        //CHANGE CUSTOMER NAME AND PRESS THE UPDATE BUTTON

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.cssSelector("input[type='image']")).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("PAUL WALKER");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();


    }
}
