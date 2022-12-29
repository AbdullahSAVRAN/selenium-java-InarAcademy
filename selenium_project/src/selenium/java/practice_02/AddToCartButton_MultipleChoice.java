package practice_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddToCartButton_MultipleChoice {
    public static void main(String[] args) throws InterruptedException {
        //ADD MULTIPLE CHOICE ON THE PACKET

        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;

                }

            }

        }
        Thread.sleep(10000);
        driver.quit();
    }

}


