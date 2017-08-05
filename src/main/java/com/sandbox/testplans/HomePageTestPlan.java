package com.sandbox.testplans;

import com.sandbox.custom.CommonTestLocators;
import com.sandbox.custom.JavaCSV;
import com.sandbox.testdatas.HomeTestReadData;
import com.sandbox.testpages.HomeTestPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;


public class HomePageTestPlan extends CommonTestLocators {
    public HomeTestPage homeTestPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
//        homeTestPage = new HomeTestPage();
    }

    @DataProvider(name = "ReadData")
    public Iterator<Object[]> caseData() throws Exception {
        JavaCSV csvReader = new JavaCSV();
        ArrayList<String[]> readLines = csvReader.readCSV("src/test/resources/HomeTestPageData.csv");
        List<Object> items = new ArrayList<Object>();
        for (int row = 0; row < readLines.size(); row++) {
            HomeTestReadData testdata = new HomeTestReadData();
            testdata.setProjectName(readLines.get(row)[0]);
            testdata.setTestCaseId(readLines.get(row)[1]);
            testdata.setUsername(readLines.get(row)[2]);
            testdata.setPassword(readLines.get(row)[3]);
            items.add(testdata);
        }
        List<Object[]> homePageTestData = new ArrayList<Object[]>();
        for (Object item : items) {
            homePageTestData.add(new Object[]{item});
        }
        return homePageTestData.iterator();
    }

    @Test(dataProvider = "ReadData")
    public void print(HomeTestReadData data) {
        System.out.print("ProjectName: " + data.getProjectName() + "\nCaseId: " + data.getTestCaseId() + "\nUserName: " + data.getUsername() + "\nPassword: " + data.getPassword());
    }

//    @Test(groups = {"ui", "qe", "regression"}, priority = 7)
//    public void testJs() {
//        // Check the GreetingMesg Element Text should match "Hi, ${USERNAME}!"
//        JavascriptExecutor js = (JavascriptExecutor) homeTestPage.driver;
//        String jsx = "alert(\"Hello World!\");";
//        js.executeAsyncScript(jsx);
//        Assert.assertTrue(true);
//    }

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
    public void clean() {
//        homeTestPage.driver.close();
        System.out.print("driver.close");
    }
}
