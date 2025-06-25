package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffPage {

    private final WebDriver driver;

    private static final String url = "https://www.rediff.com/";

    private static By redifffMail = By.xpath("//div[@class = \"toplinks\"]/a[contains(text(),\"Rediffmail\")]");
    private static By rediffMoney = By.xpath("//div[@class = \"toplinks\"]/a[contains(text(),\"Rediffmail\")]/following-sibling::a[contains(text(),\"Money\")]");






    public RediffPage(WebDriver driver) {
        this.driver = driver;
    }

    public void elementClick(String input){

        if(input.equals("mail")){
            driver.findElement(redifffMail).click();
        } else if (input.equals("money")) {
            driver.findElement(rediffMoney).click();
        }

    }
}
