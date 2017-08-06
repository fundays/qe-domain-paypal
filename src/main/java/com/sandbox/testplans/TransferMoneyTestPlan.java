package com.sandbox.testplans;

import com.sandbox.custom.CommonLocators;
import com.sandbox.testpages.TransferMoneyTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TransferMoneyTestPlan extends CommonLocators {
    public TransferMoneyTestPage testPage;

/*
*   Deprecate this testplan as paypal sandbox transfer function was in maintainance
 */

    //    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        testPage = new TransferMoneyTestPage();
    }

    //    @Test(groups = {"ui", "qe"})
    public void testInputBoxExistense() {
        testPage.accessPage(testPage.Transfer_Page);
        new WebDriverWait(testPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.id(testPage.friends)));
        Assert.assertTrue(testPage.isElementPresent(By.id(testPage.friends)));

    }

    //    @Test(groups = {"ui", "qe"}, dependsOnMethods = {"testInputBoxExistense"})
    public void testActivateNextBtn() {
        testPage.driver.findElement(By.id(testPage.friends)).sendKeys(friend);
        testPage.implictlyWait(10);
        Assert.assertTrue(testPage.isElementPresent(By.xpath(testPage.next)));
        testPage.driver.findElement(By.xpath(testPage.next)).click();
    }

    //    @Test(groups = {"func", "qe", "regression"}, dependsOnMethods = {"testInputBoxExistense", "testActivateNextBtn"})
    public void transferMoneyToFriend() {
        new WebDriverWait(testPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.name(testPage.name_amount)));
        testPage.driver.findElement(By.name(testPage.name_amount)).sendKeys("100");
        testPage.driver.findElement(By.className(testPage.submitAmt)).click();
        testPage.implictlyWait(20);
        testPage.driver.findElement(By.xpath(testPage.sendMoneyNow)).click();
        testPage.implictlyWait(20);
        Assert.assertTrue(testPage.isElementPresent(By.xpath(testPage.successHeader)));
    }

    //    @AfterTest
    public void clean() {
        testPage.driver.close();
    }
}
