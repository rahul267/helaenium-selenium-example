package com.epam.healenium.tests;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicTest {
    public WebDriver delegate;
    public SelfHealingDriver driver;
    @BeforeAll
    public static void classInit() {
      // System.setProperty("webdriver.http.factory", "jdk-http-client");
      // WebDriverManager.chromedriver().setup();
       // System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
    }
    @BeforeEach
    public void testInit() {

      //  driver = new EdgeDriver();
        delegate = new ChromeDriver(); // declare delegate
        driver = SelfHealingDriver.create(delegate); // create Self-healing driver
    }
    @AfterEach
    public void testCleanup() {
        driver.quit();
    }
    @Test
    public void assertFormSent() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var localPage = new LocalPage(driver);
        localPage.navigate();

        // wait.until(d -> driver.findElement(By.id("firstName")).isDisplayed());
        driver.findElement(By.id("firstName")).sendKeys("rahul");
        driver.findElement(By.id("lastName")).sendKeys("kumar");
        driver.findElement(By.id("email")).sendKeys("dog@gmail.com");
        driver.findElement(By.id("address")).sendKeys("2b 015");
        driver.findElement(By.id("address2")).sendKeys("Sun city Gloria");
        new Select(driver.findElement(By.id("country"))).selectByIndex(1);
    }
}