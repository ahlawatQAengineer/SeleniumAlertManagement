package com.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    
    protected static WebDriver driver;
    protected WebDriverWait wait;
    
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName());
        }
        
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Takes screenshot and attaches it to Allure report
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            FileUtils.copyFile(source, new File(destination));
            return FileUtils.readFileToByteArray(source);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
    
    /**
     * Wait for element to be clickable
     */
    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be visible
     */
    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be present
     */
    protected WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Get text from element with wait
     */
    protected String getElementText(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }
    
    /**
     * Click on element with wait
     */
    protected void clickElement(By locator) {
        WebElement element = waitForElementClickable(locator);
        element.click();
    }
    
    /**
     * Handle JavaScript alert
     */
    protected void handleAlert(boolean accept) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
    
    /**
     * Get alert text
     */
    protected String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
} 