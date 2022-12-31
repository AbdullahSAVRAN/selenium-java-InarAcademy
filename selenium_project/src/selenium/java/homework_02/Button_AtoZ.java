package homework_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class Button_AtoZ {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        ArrayList<String> products = new ArrayList<>();
        int size = driver.findElements(By.cssSelector(".inventory_item_name")).size();
        for (int i = 1; i < size; i++) {
            //get unordered products names from page
            String name = driver.findElements(By.cssSelector(".inventory_item_name")).get(i).getText();

            //assign these products in ArrayList
            products.add(name);
        }
        // sort A to Z
        sort(products);
        Thread.sleep(4000);
        driver.quit();
    }
}
