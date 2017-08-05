package com.sandbox.testpages;

import com.sandbox.custom.JavaCSV;
import com.sandbox.testdatas.ReadDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataProviderTest {

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
        ArrayList<String[]> readLines = csvReader.readCSV("src/test/resources/DataProviderTestFile.csv");
        List<Object> items = new ArrayList<Object>();
        for (int row = 0; row < readLines.size(); row++) {
            ReadDataProvider testdata = new ReadDataProvider();
            testdata.setProjectName(readLines.get(row)[0]);
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

    @Test(dataProvider = "provider")
    public void print(String phrase, String target) {
        Assert.assertEquals(phrase+" "+target,"This is a test for data object provider");
        System.out.print(phrase +" "+ target+" embedded test.");
    }

    @Test(dataProvider = "ReadCSV")
    public void print(ReadDataProvider data) {
        Assert.assertEquals(data.getProjectName(),"Payment");
        System.out.print("ProjectName: " + data.getProjectName() + "\nCaseId: " + data.getTestCaseId() + "\nUserName: " + data.getUsername() + "\nPassword: " + data.getPassword());
    }

}