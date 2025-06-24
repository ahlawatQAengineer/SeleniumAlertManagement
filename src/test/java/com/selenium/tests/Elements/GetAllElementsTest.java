package com.selenium.tests.Elements;

import com.selenium.base.BaseTest;
import com.selenium.pages.ElementHomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetAllElementsTest extends BaseTest {
private ElementHomePage elementPage;



@Test
public void printAllElement(){
    elementPage = new ElementHomePage(driver);

    List<WebElement> myElements = new ArrayList<>();
    elementPage.launchURL();

    WebElement element  = driver.findElement(ElementHomePage.defaultElement);
    myElements =  elementPage.findElements(element);

    for(WebElement abc :  myElements){
        System.out.println("Xpath of the selected element is : " + abc);
    }
    System.out.println("<----------------------------------------->");
    System.out.println("<----------------------------------------->");
}

@Test
public void matchElementsText(){
    elementPage = new ElementHomePage(driver);
    elementPage.launchURL();
    WebElement element1 =  driver.findElement(ElementHomePage.siblingPreceding);
    WebElement element2  = driver.findElement(ElementHomePage.siblingfFollowing);
    WebElement element3 =  driver.findElement(ElementHomePage.precedingSiblingBYParent);
    String a = elementPage.getTextOfElements(element1);
    String b = elementPage.getTextOfElements(element3);
    String c =  elementPage.getTextOfElements(element2);


    Assert.assertEquals(a,b);

    if(Objects.equals(elementPage.getTextOfElements(element1), elementPage.getTextOfElements(element3))){

        System.out.println("Text of the two elements matched and they are " +elementPage.getTextOfElements(element1)+ "&" +elementPage.getTextOfElements(element3) );
    }


    System.out.println("This has no matches" + c);


}

}
