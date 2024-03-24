package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavAngryTest {

    @Test
    void testPriceCheckMainPageShoppingPage() {
        WebDriver webDriver = new ChromeDriver();
        final String login = "standard_user";
        final String password = "secret_sauce";
        final String itemToBuy = "Sauce Labs Bike Light".toLowerCase().replaceAll(" ", "-");
        webDriver.get("https://www.saucedemo.com/");
        webDriver.findElement(By.id("user-name")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("login-button")).click();
        String expectedResult = webDriver.findElement(
                By.xpath("//button[contains(@name, '" + itemToBuy + "')]/../div")).getText();
        webDriver.findElement(By.xpath("//button[@id='add-to-cart-" + itemToBuy + "']")).click();
        webDriver.findElement(By.className("shopping_cart_link")).click();
        String actualResult = webDriver.findElement(
                By.xpath("//button[contains(@name, '" + itemToBuy + "')]/../div")).getText();

        Assert.assertEquals(actualResult, expectedResult);
        webDriver.quit();
    }

    @Test
    void testDoubleClickButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        String expectedText = "You have done a double click";

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text() = 'Buttons']")).click();
        WebElement clickable = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver)
                .doubleClick(clickable)
                .perform();

        String actualText = driver.findElement(By.id("doubleClickMessage")).getText();

        Assert.assertEquals(actualText, expectedText);

        driver.quit();
    }

    @Test
    void testMainPageBannerTitlesText() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        List<String> expectedBannerTitles = new ArrayList<>(Arrays.asList("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"));
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));

        List<String> actualBannerTitles = WebElementToString(elementList);

        Assert.assertEquals(actualBannerTitles, expectedBannerTitles);
        Assert.assertTrue(actualBannerTitles.contains("Book Store Application"));

        driver.quit();
    }

    public static List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }

        return stringList;
    }
}