package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link. 7. Print the current url.
 * 8. Navigate back to the login page. 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field. 12. Click on Login Button.
 * 13. Close the browser.
 */

public class OrangeHrmLive {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static String browser = "Chrome"; //declared globally
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EdgeDriver")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        Thread.sleep(5000);
        //get current url after click on Forgot password link
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        //Refresh the page
        driver.navigate().refresh();


        //Enter Email ID field
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter Password field
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Click on Login button
        Thread.sleep(5000);
        driver.findElement(By.className("orangehrm-login-button")).click();


        //Close the driver
        driver.quit();
    }

}
