package homework_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_02 {
    public static void main(String[] args) {
        //TRY TO LOGIN >>> VALID USERNAME && WRONG PASSWORD

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("123456");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        System.out.println(driver.findElement(By.id("ctl00_MainContent_status")).getText());
    }
}
