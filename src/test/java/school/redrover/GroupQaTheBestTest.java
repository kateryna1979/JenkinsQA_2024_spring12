package school.redrover;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;
import java.time.Duration;


public class GroupQaTheBestTest extends BaseTest {
    @Test
    public void kmFirstTest() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        getDriver().get("https://automationintesting.online");
        getDriver().findElement(By.id("name")).sendKeys("John Doe");
        getDriver().findElement(By.id("email")).sendKeys("johndoe@gmail.com");
        getDriver().findElement(By.id("phone")).sendKeys("12345678900");
        getDriver().findElement(By.id("subject")).sendKeys("Test Subject");
        getDriver().findElement(By.id("description")).sendKeys("Hello World Hello World");
        getDriver().findElement(By.id("submitContact")).click();

        Assert.assertEquals("Thanks for getting in touch John Doe!", getDriver().findElement(By.cssSelector(
                "#root > div > div > div.row.contact > div:nth-child(2) > div > h2")).getText());
    }
}