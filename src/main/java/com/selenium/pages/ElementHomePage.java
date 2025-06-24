package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementHomePage {

    private  WebDriver driver;
    private static final String homePageUrl = "https://the-internet.herokuapp.com/";
    public static final
    By defaultElement =  By.xpath("//*[@id='content']/ul/li");

    public static final
    By contextElement = By.xpath("//*[@id='content'']/ul/li[6]/a");

    public static  final
    By siblingfFollowing  = By.xpath("//*[@id='content']/ul/li[6]/following-sibling::li[1]");


    public static final
    By siblingPreceding = By.xpath(
            "//li[.//a[contains(text(), 'Context')]]/preceding-sibling::li[1]");

    public static final
    By precedingSiblingBYParent = By.xpath("//a[contains(text(), 'Context')]/parent::li/preceding-sibling::li[1]");



    public ElementHomePage (WebDriver driver){

    this.driver = driver;
}

public List<WebElement> findElements (WebElement element){
   List<WebElement> allElements = new ArrayList<>();
    allElements =     driver.findElements(defaultElement);

    return allElements;
}



public  void launchURL(){
    driver.navigate().to(homePageUrl);
}

public String  getTextOfElements(WebElement element){

     return  element.getText();

}











}
