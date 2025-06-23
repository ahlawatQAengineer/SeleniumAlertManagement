package com.selenium.tests;

import com.selenium.base.BaseTest;
import com.selenium.pages.JavaScriptAlertsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompareElementText extends BaseTest {

    private JavaScriptAlertsPage jsPage;
    @Test
    public  void getTextOfElement() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");


        jsPage = new JavaScriptAlertsPage(driver);
        WebElement elementTogetText = driver.findElement(JavaScriptAlertsPage.JS_ALERT_BUTTON);
        String text =  jsPage.getTextOfElement(elementTogetText);
        System.out.println("<-----"+text +"---->");
        Thread.sleep(1000);
        elementTogetText.click();
        Thread.sleep(1000);

        handleAlert(true);
        Thread.sleep(1000);


    }

    public static void elementWait(WebElement inputElement){

         WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf( inputElement));
    }








    }











