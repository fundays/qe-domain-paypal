package com.sandbox.testplans;

import com.sandbox.custom.CommonLocators;
import com.sandbox.custom.JavaCSV;
import com.sandbox.testdatas.MyaccountHomeTestData;
import com.sandbox.testpages.MyaccountHomeTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyaccountHomeTestPlan extends CommonLocators {

    public MyaccountHomeTestPage testPage;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        testPage = new MyaccountHomeTestPage();
        testPage.launchHome();
    }

    @DataProvider(name = "ReadData")
    public Iterator<Object[]> caseData() throws Exception {
        JavaCSV csvReader = new JavaCSV();
        ArrayList<String[]> readLines = csvReader.readCSV("src/test/resources/MyaccountHomeTestData.csv");
        List<Object> items = new ArrayList<Object>();
        for (int row = 0; row < readLines.size(); row++) {
            MyaccountHomeTestData testdata = new MyaccountHomeTestData();
            testdata.setProjectName(readLines.get(row)[0]);
            testdata.setTestCaseId(readLines.get(row)[1]);
            testdata.setUsername(readLines.get(row)[2]);
            testdata.setPassword(readLines.get(row)[3]);
            testdata.setHasTransaction(readLines.get(row)[4]);
            items.add(testdata);
        }
        List<Object[]> homePageTestData = new ArrayList<Object[]>();
        for (Object item : items) {
            homePageTestData.add(new Object[]{item});
        }
        return homePageTestData.iterator();
    }

    @Test(groups = {"UI", "QE", "Regression"},dataProvider = "ReadData")
    public void testUserLogon(MyaccountHomeTestData data) {
        testPage.logonWithCredentials(data.getUsername(), data.getPassword());
        try {
            new WebDriverWait(testPage.driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator_Logout)));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false, "Logon Failed");
        }
    }


    @Test(groups = {"UI", "QE", "Regression"},dependsOnMethods = "testUserLogon")
    public void testGreetingMsg() {
        String welcomeMsg = testPage.driver.findElement(By.cssSelector(testPage.welcomeMsg)).getText();
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.welcomeMsg)));
        Assert.assertEquals(welcomeMsg, "Hi again, en!");
    }

    @Test(groups = {"UI", "QE", "Regression"},dependsOnMethods = "testUserLogon")
    public void testPayPalBalance() {
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.btn_addMoney)));
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.transferToYourBank)));
        Assert.assertEquals(testPage.driver.findElement(By.cssSelector(testPage.balance_amt)).getText(), "$1,993.99");
    }

    @Test(groups = {"UI", "QE", "Regression"},dependsOnMethods = "testUserLogon")
    public void testElementDisplayPayOrSendMoney() {
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.payOrSendMoney)));
    }

    @Test(groups = {"UI", "QE", "Regression"},dependsOnMethods = "testUserLogon")
    public void testSectionBankAndCards() {
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.bankAndCards)));
        Assert.assertTrue(testPage.isElementPresent(By.cssSelector(testPage.lnkBankOrCard)));
    }

    @Test(groups = {"UI", "QE", "Regression"}, dataProvider = "ReadData",dependsOnMethods = "testUserLogon")
    public void testCompletedTransaction(MyaccountHomeTestData data) {
        // to be updated for formatter
        WebElement page_balance = testPage.driver.findElement(By.cssSelector(testPage.balance_amt));
        float page_balance_amt = testPage.formatBalance(page_balance);
        float net_amt_total = 0;
        float positive_amt_total = 0;
        float cal_paypal_balance = 0;
        // Get all net amount and calculate total amt
        try {
            if (data.hasTransaction == "rue") {
                List<WebElement> net_amts = testPage.driver.findElements(By.cssSelector(testPage.net_amt_list));
                for (WebElement net_amt : net_amts) {
                    net_amt_total += testPage.formatBalance(net_amt);
                }
                // Get all positive amount and calculate total amt
                List<WebElement> positive_amts = testPage.driver.findElements(By.cssSelector(testPage.positive_amt_list));
                for (WebElement positive_amt : positive_amts) {
                    positive_amt_total += testPage.formatBalance(positive_amt);
                }
                cal_paypal_balance = positive_amt_total - net_amt_total;
                Assert.assertEquals(page_balance_amt, cal_paypal_balance);
            } else {
                System.out.println("cal_paypal_balance: " + cal_paypal_balance);
                System.out.println("page_paypal_balance: " + page_balance_amt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @AfterTest
    public void clean() {
        testPage.driver.close();
    }
}

