package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

public class TeaPartyGroupTest extends BaseTest {

    @Test
    public void idDemoTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        WebElement loginPassword = driver.findElement(By.name("password"));
        loginPassword.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();

    }

    @Test
    public void tgSprinkleSystemTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://project-atlas.dev/");
        WebElement button = driver.findElement(By.xpath("//a[@href = '/dashboard']"));
        button.click();

        WebElement text = driver.findElement(By.name("email"));
        text.sendKeys("userFirst@yopmail.com");

        text = driver.findElement(By.name("password"));
        text.sendKeys("User@1");

        button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        String resultText = element.getText();
        Assert.assertEquals(resultText,"server_errors.UserNotFound");

        driver.quit();
    }
    @Test
    public void tgDemoTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        WebElement loginPassword = driver.findElement(By.name("password"));
        loginPassword.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();
        String allItemsText = menu.getText();
        Assert.assertEquals(allItemsText, "Open Menu");
        driver.quit();
        }

    @Test
    public void testTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement textBox = driver.findElement(By.id("user-name"));
        textBox.sendKeys("visual_user");

        WebElement textBox2 = driver.findElement(By.id("password"));
        textBox2.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        String nMenu = menu.getText();
        assert menu.getText().equals(nMenu) : "All Items";
        menu.click();
    }
}
