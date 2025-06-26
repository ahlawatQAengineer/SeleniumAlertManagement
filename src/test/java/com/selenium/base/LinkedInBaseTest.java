package com.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class LinkedInBaseTest {
    
    protected WebDriver linkedInDriver;
    protected WebDriverWait linkedInWait;
    
    @BeforeMethod
    public void setUpLinkedIn() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        linkedInDriver = new ChromeDriver(options);
        linkedInWait = new WebDriverWait(linkedInDriver, Duration.ofSeconds(15));
        linkedInDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Execute script to remove webdriver property
        ((JavascriptExecutor) linkedInDriver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    }
    
    @AfterMethod
    public void tearDownLinkedIn() {
        if (linkedInDriver != null) {
            linkedInDriver.quit();
        }
    }
    
    /**
     * Wait for element to be clickable
     */
    protected WebElement waitForElementClickable(By locator) {
        return linkedInWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be visible
     */
    protected WebElement waitForElementVisible(By locator) {
        return linkedInWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be present
     */
    protected WebElement waitForElementPresent(By locator) {
        return linkedInWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Click on element
     */
    protected void clickElement(By locator) {
        WebElement element = waitForElementClickable(locator);
        element.click();
    }
    
    /**
     * Enter text in element
     */
    protected void enterText(By locator, String text) {
        WebElement element = waitForElementClickable(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Wait for page to load completely
     */
    protected void waitForPageLoad() {
        linkedInWait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }
    
    /**
     * Wait for specific time
     */
    protected void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 