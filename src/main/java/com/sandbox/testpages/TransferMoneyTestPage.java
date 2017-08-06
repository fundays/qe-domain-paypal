package com.sandbox.testpages;

import com.sandbox.custom.CommonPageUtils;


public class TransferMoneyTestPage extends CommonPageUtils {

    public String Transfer_Page = "https://www.sandbox.paypal.com/myaccount/transfer/send";
    public String name_amount = "amount";
    public String friends = "recipient";
    public String next = "//input[@value='Next']";
    public String submitAmt = "submitButtonWrapper_1ntyrs8";
    public String sendMoneyNow = "//button[@data-nemo='send']";
    public String successHeader = "//h2[@class='successHeader']";

}
