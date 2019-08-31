package com.lh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by laiHom on 2019/8/31.
 */
public class DateUtil {
    public static String getCurrentDateStr() throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(date);
    }
}
