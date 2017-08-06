package com.sandbox.testplans;

import com.sandbox.custom.JavaCSV;
import com.sandbox.testdatas.DataProviderTestData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderTestPlan {

    @BeforeSuite
    public void startUp() {
        System.out.print("Test begin");
    }

    @DataProvider(name = "provider")
    public Object[][] provideData() {
        return new Object[][]{{"This is a test", "for data object provider"}};
    }

    @DataProvider(name = "ReadCSV")
    public Iterator<Object[]> caseData() throws Exception {
        JavaCSV csvReader = new JavaCSV();
        ArrayList<String[]> readLines = csvReader.readCSV("src/test/resources/DataProviderTestData.csv");
        List<Object> items = new ArrayList<Object>();
        for (int row = 0; row < readLines.size(); row++) {
            DataProviderTestData testdata = new DataProviderTestData();
            testdata.setDomainName(readLines.get(row)[0]);
            testdata.setTestCaseId(readLines.get(row)[1]);
            testdata.setUsername(readLines.get(row)[2]);
            testdata.setPassword(readLines.get(row)[3]);
            items.add(testdata);
        }
        List<Object[]> readDataProvider = new ArrayList<Object[]>();
        for (Object item : items) {
            readDataProvider.add(new Object[]{item});
        }
        return readDataProvider.iterator();
    }

    @Test(dataProvider = "provider",priority = 1)
    public void test1(String phrase, String target) {
        Assert.assertEquals(phrase + " " + target, "This is a test for data object provider");
        System.out.print(phrase + " " + target + " embedded test.");
    }

    @Test(dataProvider = "ReadCSV",priority = 0)
    public void testFromCSV(DataProviderTestData data) {
        Assert.assertEquals(data.getDomainName(), "DataTest");
        System.out.print("DomainName: " + data.getDomainName() + "\nCaseId: " + data.getTestCaseId() + "\nCity: " + data.getUsername() + "\nCode: " + data.getPassword());
    }

    @AfterSuite
    public void close() {
        System.out.print("Test close");
    }
}