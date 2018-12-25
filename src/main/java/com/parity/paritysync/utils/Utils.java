package com.parity.paritysync.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Component
public class Utils {

    public final static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    /**
     * 十六进制字符串转double
     *
     * @param value 十六进制字符串
     * @return
     */
    public Double toDouble(String value) {

        value = value.substring(2);

        double ret = 0;

        for (int i = 0; i < value.length(); i++) {
            ret += Character.getNumericValue(value.charAt(i)) * Math.pow(16, (value.length() - 1 - i));
        }
        return ret;
    }

    /**
     * 十六进制字符串转String
     *
     * @param value 十六进制字符串
     * @return
     */
    public String toString(String value) {

        value = value.substring(2);

        BigDecimal ret = new BigDecimal(0);

        BigDecimal bg = new BigDecimal(16);

        for (int i = 0; i < value.length(); i++) {
            ret = ret.add(bg.pow((value.length() - 1 - i)).multiply(BigDecimal.valueOf(Character.getNumericValue(value.charAt(i)))));
        }
        return ret.toString();
    }
}
