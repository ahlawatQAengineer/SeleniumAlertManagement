package com.selenium.tests;

import com.selenium.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxesTest extends BaseTest {





    @Test
    public  void moveToCheckBoxPage() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com");

        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element =  driver.findElement(By.xpath("//li[./a[contains(text(), \"Checkbox\")]]/a"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        System.out.println("Clicked on checkbox link");
        Thread.sleep(2000);
        WebElement checkBox1  = driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][1]/following-sibling::input"));

        boolean isFirstElement = checkBox1.isSelected();
        boolean isSecondElement = checkBox2.isSelected();

        if(isFirstElement){
            System.out.println("Checkbox1 is checked");
        }else{
            checkBox1.click();
        }

        Thread.sleep(2000);

        if(isSecondElement){
            System.out.println("Checkbox2 is checked");
            checkBox2.click();
        }

        Thread.sleep(3000);

    }












}
