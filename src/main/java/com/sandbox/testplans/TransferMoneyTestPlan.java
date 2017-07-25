package com.sandbox.testplans;

import com.sandbox.testpages.TransferMoneyTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.sandbox.custom.CommonTestLocators;


public class TransferMoneyTestPlan extends CommonTestLocators {
    public TransferMoneyTestPage transferMoneyTestPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        transferMoneyTestPage = new TransferMoneyTestPage();
    }

    @Test(groups = {"ui", "qe"})
    public void testInputBoxExistense() {
        transferMoneyTestPage.accessTestPage();
        transferMoneyTestPage.logonWithCredentials();
        new WebDriverWait(transferMoneyTestPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.id(transferMoneyTestPage.friends)));
        Assert.assertTrue(transferMoneyTestPage.isElementPresent(By.id(transferMoneyTestPage.friends)));

    }

    @Test(groups = {"ui", "qe"}, dependsOnMethods = {"testInputBoxExistense"})
    public void testActivateNextBtn() {
        transferMoneyTestPage.driver.findElement(By.id(transferMoneyTestPage.friends)).sendKeys(friend);
        transferMoneyTestPage.implictlyWait(10);
        Assert.assertTrue(transferMoneyTestPage.isElementPresent(By.xpath(transferMoneyTestPage.next)));
        transferMoneyTestPage.driver.findElement(By.xpath(transferMoneyTestPage.next)).click();
    }

    @Test(groups = {"func", "qe", "regression"}, dependsOnMethods = {"testInputBoxExistense", "testActivateNextBtn"})
    public void transferMoneyToFriend() {
        new WebDriverWait(transferMoneyTestPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.name(transferMoneyTestPage.name_amount)));
        transferMoneyTestPage.driver.findElement(By.name(transferMoneyTestPage.name_amount)).sendKeys("100");
        transferMoneyTestPage.driver.findElement(By.className(transferMoneyTestPage.submitAmt)).click();
        transferMoneyTestPage.implictlyWait(20);
        transferMoneyTestPage.driver.findElement(By.xpath(transferMoneyTestPage.sendMoneyNow)).click();
        transferMoneyTestPage.implictlyWait(20);
        Assert.assertTrue(transferMoneyTestPage.isElementPresent(By.xpath(transferMoneyTestPage.successHeader)));
    }

    @AfterTest
    public void clean() {
        transferMoneyTestPage.driver.close();
    }
}
