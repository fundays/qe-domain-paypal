package com.sandbox.testdatas;

import com.sandbox.custom.CommonReadCSV;

public class MyaccountHomeTestData extends CommonReadCSV {


    public String getHasTransaction() {
        return hasTransaction;
    }

    public void setHasTransaction(String hasTransaction) {
        this.hasTransaction = hasTransaction;
    }

    public String hasTransaction;

}
