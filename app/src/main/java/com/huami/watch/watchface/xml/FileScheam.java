package com.huami.watch.watchface.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.text.TextUtils;

public enum FileScheam {
    ASSET("@asset/"), SDCARD("@sdcard/"), FILE("@file/"), DEFAULT("error");
    private final String mDes;
    private final static String FILE_PATH_PATTERN = "^@(asset|sdcard|file)";
    private final static String ASSET_PREFIX = "@asset/";
    private final static String SDCARD_PREFIX = "@sdcard/";
    private final static String FILE_PREFIX = "@file/";
    private FileScheam(String des) {
        this.mDes = des;
    }

    public String getDescription() {
        return mDes;
    }

    /**
     * get FilePrefix depend on des
     * 
     * @param des
     * @return
     */
    public static FileScheam getFilePreFix(String des) {
        FileScheam[] filePrefixs = FileScheam.values();
        for (FileScheam filePrefix : filePrefixs) {
            if (filePrefix.getClass().equals(des)) {
                return filePrefix;
            }
        }
        return DEFAULT;
    }

    /**
     * @param context
     * @param filePath
     * @return
     */
    public InputStream getInputStream(Context context, String filePath) {
        InputStream inputStream = null;
        switch (this) {
            case ASSET:
                try {
                    inputStream = context.getAssets().open(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case SDCARD:
                String path = Utils.getSDCardRootPath(context);
                File file = new File(path, filePath);
                try {
                    inputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case FILE:
                // TODO:
                break;
            default:
                break;
        }
        return null;
    }
    
    /**
     * 
     * @param path [a-z][A-Z][0-9]-_ 
     * @return
     */
    public static boolean checkPathValid(String path){
        //TODO:should check path valid
        return true;
    }
    

    /**
     * 
     * @param filePath
     * @return file      return path prefix and path
     */
    public static String[] splitFilePathPrefix(String filePath){
        if(TextUtils.isEmpty(filePath)){
            return null;
        }
        Pattern r = Pattern.compile(FILE_PATH_PATTERN);
        Matcher m = r.matcher(filePath);
        
        if(m.lookingAt()){
            int endIndex = m.end();
            if(endIndex>= filePath.length()|| endIndex <=0){
                return null;
            }
            String result[] = new String[2];
            result[0] = m.group();
            result[1] = filePath.substring(endIndex,filePath.length());
            return result;
        }
        return null;
    }
    
}
