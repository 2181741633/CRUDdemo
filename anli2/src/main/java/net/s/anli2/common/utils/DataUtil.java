package net.s.anli2.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatData2String(Date date){ //data 转换成字符串
        if (date !=null){
            return simpleDateFormat.format(date);
        }
        return null;
    }

    public static Date parsetString2Data(String str){  //字符串转换成data
        if (str !=null){
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
