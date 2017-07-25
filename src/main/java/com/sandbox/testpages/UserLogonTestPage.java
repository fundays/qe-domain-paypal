package com.sandbox.testpages;

import com.sandbox.custom.CommonUtilsTestPage;


public class UserLogonTestPage extends CommonUtilsTestPage {
    // Here to define locators or Methods for this Page
    public String Logon_Page = "https://www.sandbox.paypal.com/signin?country.x=US&locale.x=en_US";
    public void accessUserLogonTestPage() {
        driver.get(Logon_Page);
    }
}
