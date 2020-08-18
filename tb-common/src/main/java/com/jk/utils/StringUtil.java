package com.jk.utils;

public class StringUtil {

    public static Boolean isEmpty(String value){
        if (value == null || "".equals(value) || value.length() <= 0){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean isNotEmpty(String value){
        if (!isEmpty(value)){
            return true;
        }else {
            return false;
        }
    }


}
