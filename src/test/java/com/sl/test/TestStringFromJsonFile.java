package com.sl.test;

public class TestStringFromJsonFile {
    public  static void main (String[] args){
        LibReqRsData data = new LibReqRsData();
        String strData =data.ReadfileToString();
        System.out.println(strData);
    }
}
