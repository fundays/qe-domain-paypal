package com.sandbox.testdatas;

import com.sandbox.custom.CommonReadCSV;

public class DataProviderTestData extends CommonReadCSV {

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String city;
    private String code;
    private String domainName;
}
