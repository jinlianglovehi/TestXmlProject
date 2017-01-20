package com.huami.watch.watchface.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.util.Xml;

public class XmlParser {
    
   
    
    /**
     * 
     * @param context
     * @param filePath file path pattern :
     *                 @asset/   asset path
     *                 @sdcard/  sdcard path
     *                 @file/    app file path
     */
    
    public static void loadXmlResoure(Context context,String filePath){
        String splitPath[] = FileScheam.splitFilePathPrefix(filePath);
        if(splitPath == null || splitPath.length <2 || splitPath[0] == null || splitPath[1] == null){
            return;
        }
        if(!FileScheam.checkPathValid(splitPath[1])){
            return;
        }
        
        //TODO example
        XmlPullParser parser = Xml.newPullParser();
        FileScheam fileScheam = FileScheam.getFilePreFix(splitPath[0]);
        try {
            parser.setInput(fileScheam.getInputStream(context, splitPath[1]), "UTF-8");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
    

}
