package com.selenium.tests.Projects;

import com.selenium.base.RediffBaseTest;
import com.selenium.pages.RediffPage;
import org.testng.annotations.Test;



public class LaunchRediffTest extends RediffBaseTest {

    private RediffPage rediffPage;



    @Test
    public  void launchGoogle() throws InterruptedException {

        rediffPage = new RediffPage(driver);
        String url = "https://www.rediff.com/";
        driver.navigate().to(url);

        synchronized(wait) {
            wait.wait(500);

            String clickInput = "money";

            rediffPage.elementClick(clickInput);
            Thread.sleep(500);
        }
    }


    @Test
    public  void launchRediff() throws InterruptedException {

        rediffPage = new RediffPage(driver);
        String url = "https://www.rediff.com/";
        driver.navigate().to(url);

        synchronized(wait) {
            wait.wait(500);

            String clickInput = "mail";

            rediffPage.elementClick(clickInput);
            Thread.sleep(500);
        }
    }



}
