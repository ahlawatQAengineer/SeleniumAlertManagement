package com.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class RediffBaseTest {
   protected static WebDriver driver;
   protected static WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");


        driver =new ChromeDriver(options);
        wait  = new WebDriverWait(driver, Duration.ofSeconds(5));

    }



    @AfterMethod
    public void tearDown(){

        if(driver != null){
            driver.quit();
            System.out.println("<--------- All windows Closed -------->");
        }
    }

}
