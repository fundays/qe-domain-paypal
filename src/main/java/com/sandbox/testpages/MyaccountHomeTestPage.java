package com.sandbox.testpages;

import com.sandbox.custom.CommonPageUtils;
import org.openqa.selenium.WebElement;


public class MyaccountHomeTestPage extends CommonPageUtils {

    public String Logon_Page = "https://www.sandbox.paypal.com/signin?country.x=US&locale.x=en_US";

    // Header
    public String welcomeMsg = "#js_toggleProfileStatus > p";
    public String payOrSendMoney = "span.icon.icon-medium.icon-send-money";

    // PayPal Balance
    public String balance_amt = "span.vx_h2.enforceLtr";
    public String btn_addMoney = "#addFunds";
    public String transferToYourBank = "#withdrawFunds";

    // Bank and Cards Section
    public String bankAndCards = "h3[class^=fiModule-title]";
    public String lnkBankOrCard = "span[class*=link-add]";

    // Completed Transaction
    public String Completed_Transactions = "div[id^=txnDescription]>span[class^=transactionD]";
    public String net_amt_list = "span.netAmount.vx_h4";
    public String positive_amt_list = "span.isPositive.vx_h4";


    public void accessUserLogonTestPage() {
        driver.get(Logon_Page);
    }

    public Float formatBalance(WebElement e) {
        String balance = e.getText().replace("$", "");
        if (balance.contains(",")){
        balance = e.getText().replace(",", "");}
        return Float.valueOf(balance);
    }
}
