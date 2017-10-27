package com.spt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {

    public static String getDateTime(){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String t = f.format(c.getTime());
        //System.out.println(t);
        return t;
    }
}
