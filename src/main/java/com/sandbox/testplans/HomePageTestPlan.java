package com.sandbox.testplans;

import com.sandbox.custom.CommonLocators;
import com.sandbox.testpages.HomeTestPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePageTestPlan extends CommonLocators {
    public HomeTestPage testPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        testPage = new HomeTestPage();
    }

    @Test
    public void launchHome(){
        testPage.launchHome();
        String currentURL=testPage.driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://www.sandbox.paypal.com/us/home");
        System.out.println("Launch Home success");
    }

    @Test
    public void homePageWebElementExist(){
    Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.login)));
    Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.signUp)));
    String center_block_test=testPage.driver.findElement(By.cssSelector(testPage.center_block_text)).getText();
    Assert.assertEquals(center_block_test,"Global Purchase Protection.\nMusic to Your Ears.");
    }

    @Test
    public void switchToSignInPage(){
        // click LoginIntoYourAccount,  switch to signin Page
        testPage.driver.findElement(By.cssSelector(testPage.login)).click();
        testPage.implictlyWait(10);
        String currentTitle=testPage.driver.getTitle();
        Assert.assertEquals(currentTitle,"Log in to your PayPal account");
    }

    @Test
    public void signInPageWebElementExist() {
        Assert.assertTrue(testPage.isElementPresent(By.id(input_user)));
        Assert.assertTrue(testPage.isElementPresent(By.id(input_pwd)));
    }

    @AfterTest
    public void clean() {
        testPage.driver.close();
        System.out.print("driver.close");
    }
}
