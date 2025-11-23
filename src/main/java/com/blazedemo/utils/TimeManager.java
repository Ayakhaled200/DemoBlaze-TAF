package com.blazedemo.utils;

import javax.xml.crypto.Data;
import java.time.Instant;

public class TimeManager {
    //screenshots - logsfiles - reports
    public static String getCurrentTimeStamp(){
        return new java.text.SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new java.util.Date());
    }

    //unique timestamp for each data
    public static String getSimpleTimeStamp(){
        return Long.toString(System.currentTimeMillis());
    }
}
