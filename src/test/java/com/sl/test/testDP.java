package com.sl.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDP {

    @Test(dataProvider = "dp")
    public void TestUser(String strName, String strRole) {
    }

    @DataProvider
    public String[][] dp() {
        return new String[][] {
                new String[] { "karthick", "TM" },
                new String[] { "Krishna", "DM" },
        };
    }
}


