package com.sandbox.testpages;

import com.sandbox.custom.CommonUtilsTestPage;


public class TransferMoneyTestPage extends CommonUtilsTestPage {
    // Here to define locators or Methods for this Page
    public String Transfer_Page = "https://www.sandbox.paypal.com/myaccount/transfer/send";
    public String name_amount = "amount"; // transfer amount
    public String friends = "recipient"; // to firends - email addr
    public String next = "//input[@value='Next']";  // Next
    public String submitAmt="submitButtonWrapper_1ntyrs8";
    public String sendMoneyNow="//button[@data-nemo='send']";
    public String successHeader="//h2[@class='successHeader']";
    public void accessTestPage() {
        driver.get(Transfer_Page);
    }


}
