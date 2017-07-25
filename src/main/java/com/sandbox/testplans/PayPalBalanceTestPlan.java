package com.sandbox.testplans;

import com.sandbox.custom.CommonTestLocators;
import com.sandbox.testpages.HomeTestPage;
import com.sandbox.testpages.PayPalBalanceTestPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class PayPalBalanceTestPlan extends CommonTestLocators {
    public PayPalBalanceTestPage payPalBalanceTestPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        payPalBalanceTestPage = new PayPalBalanceTestPage();
    }

    @Test(groups = {"ui", "qe", "regression"})
    public void testAccesstoPaypalBalanceFromHomePage() {
        // Logon to Home Page
        // Click lnk [Details]
        // Check web URL changes to "https://www.sandbox.paypal.com/myaccount/wallet/balance";
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, dependsOnMethods = {"testAccesstoPaypalBalanceFromHomePage"})
    public void testLnkDisplayAddMoney() {
        // Check lnk Add money present on the page
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, dependsOnMethods = {"testAccesstoPaypalBalanceFromHomePage"})
    public void testLnkDisplayWithdrawMoney() {
        // Check lnk Withdraw money present on the page
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, dependsOnMethods = {"testAccesstoPaypalBalanceFromHomePage"})
    public void testLnkDisplayManageCurrencies() {
        // Check lnk Manage Currencies present on the page
        Assert.assertTrue(true);
    }

    @AfterTest
    public void clean(){
        payPalBalanceTestPage.driver.close();
        System.out.print("driver.close");
    }
}
