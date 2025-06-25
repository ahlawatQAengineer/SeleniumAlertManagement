package com.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.selenium.base.BaseTest.driver;

public class ZetaBaseTest {
    protected static WebDriver driver ;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--headless-false");

        driver = new ChromeDriver(options);

    }



    @AfterMethod
    public void tearDown(){

        if(driver != null){
            driver.quit();
        }

    }


}
