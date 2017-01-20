package com.huami.watch.watchface.xml;

import android.content.Context;
import android.os.Environment;

public class Utils {
    
    public static String getSDCardRootPath(Context context){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            if(Environment.getExternalStorageDirectory().canRead()){
                return Environment.getExternalStorageDirectory().getPath();
            }
        }
        return null;
    }
}
