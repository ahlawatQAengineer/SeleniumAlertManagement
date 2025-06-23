package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertsPage {
    
    private WebDriver driver;
    
    // Page URL
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    
    // Locators
    public static final
    By JS_ALERT_BUTTON = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private static final
    By JS_CONFIRM_BUTTON = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private static final
    By JS_PROMPT_BUTTON = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    
    // Alternative XPaths as requested
    private static final
    By JS_CONFIRM_BUTTON_XPATH1 = By.xpath("/html/body/div[2]/div/div/ul/li[2]/button");

    private static final
    By JS_CONFIRM_BUTTON_XPATH2 = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    private static final By JS_CONFIRM_BUTTON_CSS = By.cssSelector("#content > div > ul > li:nth-child(2) > button");
    
    // Result text locator
    private static final
    By RESULT_TEXT = By.id("result");
    
    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Navigate to the JavaScript alerts page
     */
    public void navigateToPage() {
        driver.get(PAGE_URL);
    }
    
    /**
     * Click on JS Alert button
     */
    public void clickJSAlert() {
        driver.findElement(JS_ALERT_BUTTON).click();
    }
    
    /**
     * Click on JS Confirm button using the first XPath
     */
    public void clickJSConfirm() {
        driver.findElement(JS_CONFIRM_BUTTON).click();
    }
    
    /**
     * Click on JS Confirm button using alternative XPath 1
     */
    public void clickJSConfirmXPath1() {
        driver.findElement(JS_CONFIRM_BUTTON_XPATH1).click();
    }
    /**
     * Click on JS Confirm button using alternative XPath 2
     */
    public void clickJSConfirmXPath2() {
        driver.findElement(JS_CONFIRM_BUTTON_XPATH2).click();
    }
    
    /**
     * Click on JS Confirm button using CSS selector
     */
    public void clickJSConfirmCSS() {
        driver.findElement(JS_CONFIRM_BUTTON_CSS).click();
    }
    
    /**
     * Click on JS Prompt button
     */
    public void clickJSPrompt() {
        driver.findElement(JS_PROMPT_BUTTON).click();
    }
    
    /**
     * Get the result text
     */
    public String getResultText() {
        return driver.findElement(RESULT_TEXT).getText();
    }
    
    /**
     * Check if result text contains "Cancel"
     */
    public boolean isResultContainsCancel() {
        String resultText = getResultText();
        return resultText.contains("Cancel");
    }
    
    /**
     * Get page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Get current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTextOfElement(WebElement element){

        return element.getText();
    }
} 