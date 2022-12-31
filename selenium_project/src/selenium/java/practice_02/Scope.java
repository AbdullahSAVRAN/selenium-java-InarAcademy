package practice_02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());
       /* for(int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++){
            String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
           columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        Thread.sleep(5000);
       */
    }
}

