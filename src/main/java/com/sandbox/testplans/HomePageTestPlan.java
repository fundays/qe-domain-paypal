package com.sandbox.testplans;

import com.sandbox.custom.CommonTestLocators;
import com.sandbox.testpages.HomeTestPage;
import com.sandbox.testpages.TransferMoneyTestPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class HomePageTestPlan extends CommonTestLocators {
    public HomeTestPage homeTestPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
        homeTestPage = new HomeTestPage();
    }

    @DataProvider(name = "provider")
    public Object[][] provideData() {
        return new Object[][]{{"This is a test", "for data object provider"}};
    }

    @Test(dataProvider = "provider")
    public void print(String phrase, String target) {
        System.out.print(phrase + " " + target);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 6)
    public void testGreetingMsg() {
        // Check the GreetingMesg Element Text should match "Hi, ${USERNAME}!"
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 0)
    public void testElementDisplayPayOrSendMoney() {
        // Check element display - Pay Or Send Money
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 3)
    public void testElementGetThePaypalApp() {
        // Check element display - Get The Paypal App
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 2)
    public void testElementTakeMoreTimeToPay() {
        // Check element display - TakeMoreTimeToPay
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 4)
    public void testSectionBankAndCards() {
        // Check Section display - Bank And Cards
        Assert.assertTrue(true);
    }

    @Test(groups = {"ui", "qe", "regression"}, priority = 5)
    public void testSellingTools() {
        // Check Section display - Selling Tools
        Assert.assertTrue(true);
    }


    @Test(groups = {"ui", "qe", "regression"}, priority = 1)
    public void testMoreAboutYourAccount() {
        // Check Section display - More about your account
        Assert.assertTrue(true);
    }

    @AfterTest
    public void clean(){
        homeTestPage.driver.close();
        System.out.print("driver.close");
    }
}
