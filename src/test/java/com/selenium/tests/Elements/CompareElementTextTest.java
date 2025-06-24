package com.selenium.tests.Elements;

import com.selenium.base.BaseTest;
import com.selenium.pages.JavaScriptAlertsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.*;

public class CompareElementTextTest extends BaseTest {

    private JavaScriptAlertsPage jsPage;
    static ArrayList<String> elementTexts =  new ArrayList<>();
    static HashMap<String, Integer> newWordMap = new HashMap<>();
    static Set<String> newHashSet  = new HashSet<>();






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


        WebElement element2 = driver.findElement(JavaScriptAlertsPage.JS_CONFIRM_BUTTON);
        elementWait(element2);
        String text2 =  element2.getText();

        WebElement element3 =  driver.findElement(JavaScriptAlertsPage.JS_CONFIRM_BUTTON_XPATH1);
        elementWait(element3);
        String text3 = element3.getText();

         WebElement element4 = driver.findElement(JavaScriptAlertsPage.JS_CONFIRM_BUTTON_XPATH2);
         elementWait(element4);
         String text4 = element4.getText();

         WebElement element5 = driver.findElement(JavaScriptAlertsPage.JS_PROMPT_BUTTON);
         elementWait(element5);
         String text5  =  element5.getText();



        elementTexts.add(text);
        elementTexts.add(text2);
        elementTexts.add(text3);
        elementTexts.add(text4);
        elementTexts.add(text5);

        compareElementText();

        printWordsAndTheirValues();


    }

    public static void elementWait(WebElement inputElement){

         WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf( inputElement));
    }

    public static void compareElementText(){

        for (String abc : elementTexts ){
            String[] breakTheWord =  abc.trim().split("\\s+");

            for(String xyz : breakTheWord) {
                newWordMap.put(xyz, newWordMap.getOrDefault(xyz, 0)+1);
                System.out.println("The word -->" +xyz.toUpperCase(Locale.ROOT)+ " <---has been updated in the Hash Map");
                System.out.println("Count of the word -->" +xyz.toUpperCase(Locale.ROOT)+ " <-- is" +newWordMap.get(xyz));

            }
        }
    }


    public static void printWordsAndTheirValues(){

        newHashSet = newWordMap.keySet();
        for (String printValue:  newHashSet){
            System.out.println("The final word stored is --->  " +printValue+ "\n" + " And it is repeated  --> " + newWordMap.get(printValue)+ " times");

        }

    }








    }











