package com.huami.watch.watchface.utils;

/**
 * Created by jinliang on 17/2/4.
 */

import com.huami.watch.watchface.model.WatchFace;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * xml 处理工具类
 */
public class XmlUtils {

    private static final String TAG = XmlUtils.class.getSimpleName();


    /**
     * 从xml 文件中获取watchFace
     * @param filePath
     * @return
     */
    public static WatchFace getWatchFaceFromXmlFilePath(String filePath){

        LogUtils.print(TAG, "getWatchFaceFromXmlFilePath");
        File file = new File(filePath);
        if(!file.exists()){
            LogUtils.print(TAG, "getWatchFaceFromXmlPath file is not exist ");
           return  null;
        }
        WatchFace watchFace = null ;
        try {
            InputStream inputStream =new FileInputStream(filePath);
            watchFace = getWatchFaceFromInputStream(inputStream);
            printWatchFaceStatus(watchFace);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LogUtils.print(TAG, "getWatchFaceFromXmlPath error ");
            return  null ;
        }
        return  watchFace;

    }


    /**
     * 按照输入流方式获取watchFace
     *
     * @param inputStream
     * @return
     */
    public static WatchFace getWatchFaceFromInputStream(InputStream inputStream ){


        LogUtils.print(TAG, "getWatchFaceFromInputStream");
        if(inputStream==null){
            LogUtils.print(TAG, "getWatchFaceFromInputStream");
            return null;
        }
        WatchFace watchFace  = null;
        if(inputStream!=null) {
            XStream xstream = new XStream();
            xstream.processAnnotations(WatchFace.class);
//            xstream.aliasField("name_zh", WatchFace.class, "zhName");
            watchFace = (WatchFace) xstream.fromXML(inputStream);
        }

        printWatchFaceStatus(watchFace);

        return  watchFace;
    }


    /**
     * 从 string 类型的xml格式抓换成为model
     * @param xmlString
     * @return
     */
    public static WatchFace getWatchFaceFromXmlString(String xmlString){


        LogUtils.print(TAG, "getWatchFaceFromXmlString");
        WatchFace watchFace = null ;
        if(xmlString==null){
            LogUtils.print(TAG, "getWatchFaceFromXmlString:xmlString is null ");
           return watchFace ;
        }else {
            XStream xStream = new XStream();

            xStream.processAnnotations(WatchFace.class);
            watchFace = (WatchFace) xStream.fromXML(xmlString);
            if(watchFace!=null){
                LogUtils.print(TAG, "getWatchFaceFromXmlString_watchFace:"+watchFace.toString());
            }else{
                LogUtils.print(TAG, "getWatchFaceFromXmlString watchFace is null ");

            }
        }

        return watchFace ;

    }



    /**
     * watch to xml 内容
     * @param watchFace
     * @return
     */
    public static String transforWatchFaceToXml(WatchFace watchFace){
        XStream stream =new XStream();
        stream.autodetectAnnotations(true);
        String result =  stream.toXML(watchFace);
        return result ;
    }


    // ########### 辅助log的打印  #############

    /**
     * 判断输出的是 watchFace 是否为空
     * @return
     */
    public static void printWatchFaceStatus(WatchFace watchFace){
        if(watchFace==null){
            LogUtils.print(TAG, "printWatchFaceStatus: watchFace is null ");
        }else {
            LogUtils.print(TAG, "printWatchFaceStatus: watchFace:"+ watchFace.toString());
        }

    }



}