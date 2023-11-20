import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));

        usernameField.sendKeys("admin");

        WebElement passowrdField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passowrdField.sendKeys("admin123");

        Thread.sleep(2000);
        driver.quit();
    }
}
