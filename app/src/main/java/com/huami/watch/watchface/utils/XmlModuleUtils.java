package com.huami.watch.watchface.utils;

/**
 * Created by jinliang on 17/2/4.
 */

import com.huami.watch.watchface.model.WatchFaceModule;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * xml 处理工具类
 * 支持泛型实体类型
 */
public class XmlModuleUtils {

    private static final String TAG = XmlModuleUtils.class.getSimpleName();


    /**
     * 从xml 文件中获取 model
     * @param filePath
     * @return
     */
    public static <T> T getModelFromXmlFilePath(String filePath,Class<T> clss){

        LogUtils.print(TAG, "getModelFromXmlFilePath");
        File file = new File(filePath);
        if(!file.exists()){
            LogUtils.print(TAG, "getModelFromXmlFilePath file is not exist ");
           return  null;
        }
        T watchFace = null ;
        try {
            InputStream inputStream =new FileInputStream(filePath);
            watchFace = getModelFromInputStream(inputStream,clss);
            printWatchFaceStatus(watchFace);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LogUtils.print(TAG, "getModelFromXmlFilePath error ");
            return  null ;
        }
        return  watchFace;

    }


    /**
     * 按照输入流方式获取 model
     *
     * @param inputStream
     * @return
     */
    public static <T> T getModelFromInputStream(InputStream inputStream,Class<T> clss ){


        LogUtils.print(TAG, "getModelFromInputStream");
        if(inputStream==null){
            LogUtils.print(TAG, "getModelFromInputStream  inputStream is null ");
            return null;
        }
        T watchFace  = null;
        if(inputStream!=null) {
            try{
                XStream xstream = new XStream();
                xstream.processAnnotations(clss);
                watchFace = (T) xstream.fromXML(inputStream);
            }catch (CannotResolveClassException exception){
                LogUtils.print(TAG, "getModelFromInputStream CannotResolveClassException ");
                exception.printStackTrace();
              
            }catch(Exception e){
                LogUtils.print(TAG, "getModelFromInputStream other exception ");
                e.printStackTrace();
                
            }

        }

        printWatchFaceStatus(watchFace);

        return  watchFace;
    }


    /**
     * 从 string 类型的xml格式抓换成为model
     * @param xmlString
     * @return
     */
    public static <T> T getModelFromXmlString(String xmlString,Class<T> clss){


        LogUtils.print(TAG, "getModelFromXmlString");
        T  watchFace = null ;
        if(xmlString==null){
            LogUtils.print(TAG, "getModelFromXmlString:xmlString is null ");
           return watchFace;
        }else {
            XStream xStream = new XStream();
            xStream.processAnnotations(WatchFaceModule.class);
            watchFace = (T) xStream.fromXML(xmlString);
            if(watchFace!=null){
                LogUtils.print(TAG, "getModelFromXmlString_watchFace:"+watchFace.toString());
            }else{
                LogUtils.print(TAG, "getModelFromXmlString watchFace is null ");

            }
        }

        return watchFace ;

    }



    /**
     * watch to xml 内容
     * @param watchFace
     * @return
     */
    public static String transforWatchFaceToXml(WatchFaceModule watchFace){
        XStream stream =new XStream();
        stream.autodetectAnnotations(true);
        String result =  stream.toXML(watchFace);
        return result ;
    }


    // ########### 辅助log的打印  #############

    /**
     * 判断输出的是 Object 是否为空
     * @return
     */
    public static void printWatchFaceStatus(Object watchFace){
        if(watchFace==null){
            LogUtils.print(TAG, "printWatchFaceStatus: watchFace is null ");
        }else {
            LogUtils.print(TAG, "printWatchFaceStatus: watchFace:"+ watchFace.toString());
        }

    }



}
