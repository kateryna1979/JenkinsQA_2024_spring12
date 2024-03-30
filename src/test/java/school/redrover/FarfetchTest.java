package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FarfetchTest {

    @Test
    public void FarfetchTest () {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.farfetch.com/designers/women");

        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Valentino");
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).click();

//        Thread.sleep (  1000);

        driver.get("https://www.farfetch.com/shopping/women/items.aspx");

        driver.findElement(By.xpath("//input[@data-component='SearchInputControlled']")).sendKeys("YSL Heels");
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).click();


       driver.quit();
    }
}
