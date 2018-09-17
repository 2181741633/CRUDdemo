package net.s.anli1.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
    public static  String getId(){
        String idval = null;
        String dataFormt = sdf.format(new Date());
        idval = dataFormt+ UUID.randomUUID().toString().replace("-","").substring(12);
        return idval;
    }
   /* public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(getId());
        }
    }*/
}
