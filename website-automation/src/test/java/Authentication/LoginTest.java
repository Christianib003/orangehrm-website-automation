package Authentication;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        // create a WebDriverWait instance that waits for driver for a max of 3 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // use the created instance to wait for the presence of a certain element
        WebElement usernameField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
        usernameField.sendKeys("admin");

        WebElement passowrdField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passowrdField.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginBtn.click();

        // check if the user is redirected to the dashboard page
        WebElement dashboardNavBtn = wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")));
        String dashboardNavClass = dashboardNavBtn.getAttribute("class");
        assertTrue(dashboardNavClass.contains("active"));

        boolean isActive = dashboardNavClass.contains("active");
        if (!isActive)
            System.out.println("Oops! The user was not redirected to the dashboard page.");
        else
            System.out.println("Yees! The user was redirected to the dashboard page.");

        Thread.sleep(2000);
        driver.quit();
    }
}
