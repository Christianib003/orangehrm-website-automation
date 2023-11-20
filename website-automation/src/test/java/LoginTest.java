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

        // create a WebDriverWait instance that waits for driver for a max of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // use the created instance to wait for the presence of a certain element
        WebElement usernameField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));

        usernameField.sendKeys("admin");

        WebElement passowrdField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passowrdField.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginBtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
