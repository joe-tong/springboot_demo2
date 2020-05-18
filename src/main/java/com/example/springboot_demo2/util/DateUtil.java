package com.example.springboot_demo2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {
    }

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat NUMERIC_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

    public static String formatDate(Date date) {
        if (date == null)
            return "";
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static String formatNumericDate(Date date) {
        if (date == null)
            return "";
        return NUMERIC_DATE_FORMAT.format(date);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateStr);
    }

}
