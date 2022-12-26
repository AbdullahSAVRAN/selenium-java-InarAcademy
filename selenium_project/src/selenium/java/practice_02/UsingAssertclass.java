package practice_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UsingAssertclass {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Assert.assertFalse((driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).isSelected()));
        System.out.println(driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).isSelected());
        driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).click();
        System.out.println(driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.findElement(By.id("divpaxinfo")).click();
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(("input[id*='SeniorCitizenDiscount']"))).isSelected(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
