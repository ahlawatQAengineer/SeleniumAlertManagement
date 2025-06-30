package com.selenium.tests.Interface;

import com.selenium.base.BaseTest;
import com.selenium.pages.JavaScriptAlertsPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("JavaScript Alerts Management")
@Feature("Alert Handling")
public class JavaScriptAlertsTest extends BaseTest {
    
    private JavaScriptAlertsPage alertsPage;





    @Test(description = "Test JavaScript Confirm Alert with Dismiss")
    @Story("User dismisses JavaScript confirm alert")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Navigate to JavaScript alerts page, click on JS Confirm button, dismiss the alert, and verify result contains 'Cancel'")
    public void testJavaScriptConfirmAlertDismiss() throws InterruptedException {
        // Initialize page object
        alertsPage = new JavaScriptAlertsPage(driver);
        
        // Navigate to the page
        alertsPage.navigateToPage();
        
        // Verify page title
        String pageTitle = alertsPage.getPageTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("The Internet"), "Page title should contain 'The Internet");
        
        // Click on JS Confirm button using the requested XPath
        clickElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button"));
        Thread.sleep(1000);
        
        // Wait for alert and dismiss it
        handleAlert(false); // false means dismiss/cancel
        
        // Wait for result element and get text
        String resultText = getElementText(By.id("result"));
        System.out.println(resultText);
        
        // Verify result contains "Cancel"
        Assert.assertTrue(resultText.contains("Cancel"), 
            "Result text should contain 'Cancel' but found: " + resultText);
        
        // Additional verification using page object method
        Assert.assertTrue(alertsPage.isResultContainsCancel(), 
            "Result should contain 'Cancel' according to page object method");
    }






    @Test(enabled = false, description = "Test JavaScript Confirm Alert with Accept")
    @Story("User accepts JavaScript confirm alert")
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to JavaScript alerts page, click on JS Confirm button, accept the alert, and verify result contains 'Ok'")
    public void testJavaScriptConfirmAlertAccept() {
        // Initialize page object
        alertsPage = new JavaScriptAlertsPage(driver);
        
        // Navigate to the page
        alertsPage.navigateToPage();
        
        // Click on JS Confirm button using alternative XPath
        clickElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        
        // Wait for alert and accept it
        handleAlert(true); // true means accept/ok
        
        // Wait for result element and get text
        String resultText = getElementText(By.id("result"));
        
        // Verify result contains "Ok"
        Assert.assertTrue(resultText.contains("Ok"), 
            "Result text should contain 'Ok' but found: " + resultText);
    }





    
    @Test(enabled = false, description = "Test JavaScript Alert with Accept")
    @Story("User accepts JavaScript alert")
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to JavaScript alerts page, click on JS Alert button, accept the alert, and verify result")
    public void testJavaScriptAlertAccept() {
        // Initialize page object
        alertsPage = new JavaScriptAlertsPage(driver);
        
        // Navigate to the page
        alertsPage.navigateToPage();
        
        // Click on JS Alert button
        clickElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        
        // Wait for alert and accept it
        handleAlert(true);
        
        // Wait for result element and get text
        String resultText = getElementText(By.id("result"));
        
        // Verify result contains "You successfully clicked an alert"
        Assert.assertTrue(resultText.contains("You successfully clicked an alert"), 
            "Result text should contain 'You successfully clicked an alert' but found: " + resultText);
    }







    
    @Test(enabled = false, description = "Test JavaScript Confirm Alert using CSS Selector")
    @Story("User uses CSS selector to click JS Confirm button")
    @Severity(SeverityLevel.MINOR)
    @Description("Navigate to JavaScript alerts page, click on JS Confirm button using CSS selector, dismiss the alert")
    public void testJavaScriptConfirmAlertWithCSS() {
        // Initialize page object
        alertsPage = new JavaScriptAlertsPage(driver);
        
        // Navigate to the page
        alertsPage.navigateToPage();
        
        // Click on JS Confirm button using CSS selector
        clickElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
        
        // Wait for alert and dismiss it
        handleAlert(false);
        
        // Wait for result element and get text
        String resultText = getElementText(By.id("result"));
        
        // Verify result contains "Cancel"
        Assert.assertTrue(resultText.contains("Cancel"), 
            "Result text should contain 'Cancel' but found: " + resultText);
    }







    @Test(enabled = false, description = "Test Page Elements Presence")
    @Story("Verify all alert buttons are present on the page")
    @Severity(SeverityLevel.MINOR)
    @Description("Navigate to JavaScript alerts page and verify all three alert buttons are present")
    public void testPageElementsPresence() {
        // Initialize page object
        alertsPage = new JavaScriptAlertsPage(driver);
        
        // Navigate to the page
        alertsPage.navigateToPage();
        
        // Verify all three buttons are present
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).isDisplayed(),
            "JS Alert button should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).isDisplayed(),
            "JS Confirm button should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).isDisplayed(),
            "JS Prompt button should be displayed");
    }
} 