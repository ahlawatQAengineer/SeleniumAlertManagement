package com.selenium.tests.Projects;

import com.selenium.base.ZetaBaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class NewSeleniumLaunchTest extends ZetaBaseTest {







        @Test
        public static void launchMyUrl() {

            String  url = "https://the-internet.herokuapp.com";
            driver.navigate().to(url);
            System.out.println("Url launched successfully");

        }

}
