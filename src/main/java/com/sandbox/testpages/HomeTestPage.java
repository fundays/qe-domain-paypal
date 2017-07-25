package com.sandbox.testpages;

import com.sandbox.custom.CommonUtilsTestPage;

public class HomeTestPage extends CommonUtilsTestPage {
    // Here to define locators or Methods for this Page
    public String home_locator_Login = "ul-btn";

    @Override
    // Override to print log for page url
    public void accessPage(String page_URL) {
        System.out.println("Logon Page" + page_URL);
        driver.get(page_URL);
        this.logonWithCredentials();
    }

}
