package com.sandbox.testplans;

import com.sandbox.testpages.UserLogonTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.sandbox.custom.CommonTestLocators;

import java.io.IOException;

public class UserLogonTestPlan extends CommonTestLocators {

    public UserLogonTestPage userLogonTestPage;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        userLogonTestPage = new UserLogonTestPage();
    }

    @BeforeClass
    public void initPage() {
        userLogonTestPage.accessUserLogonTestPage();
    }


    @Test(groups = {"ui", "func"}, priority=0)
    public void testInputBoxUser() {
        Assert.assertTrue(userLogonTestPage.isElementPresent(By.id(Logon_locator_user)));
    }


    @Test(groups = {"ui", "func"}, priority=1)
    public void testInputBoxPassword() {
        Assert.assertTrue(userLogonTestPage.isElementPresent(By.id(Logon_locator_pwd)));
    }

    @Test(groups = {"ui", "func"}, priority=3)
    public void testMockTrue() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "regression"}, priority=2)
    public void testUserLogon() {
        userLogonTestPage.logonWithCredentials();
        try {
            new WebDriverWait(userLogonTestPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator_Logout)));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false, "Logon Failed");
        }
    }

    @AfterTest
    public void clean() {
        userLogonTestPage.driver.close();
    }
}

