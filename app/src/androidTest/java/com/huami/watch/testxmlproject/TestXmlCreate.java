package com.huami.watch.testxmlproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.huami.watch.watchface.test.model.ChinaBean;
import com.huami.watch.watchface.utils.LogUtils;
import com.thoughtworks.xstream.XStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinliang on 17/1/20.
 */

@RunWith(AndroidJUnit4.class)
public class TestXmlCreate {

    private Context appContext ;
    @Before
    public void getAppContext(){
        appContext = InstrumentationRegistry.getTargetContext();
    }

     private static final String TAG = TestXmlCreate.class.getSimpleName();
    @Test
    public void test(){


//        XStream stream = new XStream();
//        hstream.processAnnotations(TestBean.class);//这里需要注解是你自己根据xml写的bean类(下面附代码解释xml)
//        TestBean result = (TestBean) stream.fromXML(xmlStr);

        ChinaBean bean =new  ChinaBean() ;
        bean.setDn("db");

        List<ChinaBean.CityBean> cityBeanList = new ArrayList<ChinaBean.CityBean>();

        ChinaBean.CityBean  cityBean ;

        for (int i = 0; i <10 ; i++) {
            cityBean = new ChinaBean.CityBean();
            cityBean.setName("cityname_"+ i);
            cityBean.setAge(i);
            cityBean.setYear(2000+i);
            cityBean.setProv("beijing_"+ i);
            cityBeanList.add(cityBean);
        }

        bean.setCity(cityBeanList);



        XStream stream =new XStream();
        stream.autodetectAnnotations(true);
        String result =  stream.toXML(bean);
        LogUtils.sysPrint(TAG,"result:"+ result);


        LogUtils.sysPrint(TAG,"------------------------------");


        XStream parseStream = new XStream() ;
        parseStream.processAnnotations(ChinaBean.class);

        String filePath   = "watchface.xml" ;

        try {
            InputStream inputStream = appContext.getAssets().open(filePath);

            parseStream.fromXML(inputStream);
            ChinaBean newChinaBean = (ChinaBean) parseStream.fromXML(result);

            LogUtils.sysPrint(TAG,"db："+ newChinaBean.getDn());

            LogUtils.sysPrint(TAG,"size："+ newChinaBean.getCity().size());

            for (ChinaBean.CityBean  newCityBean:  newChinaBean.getCity()
                 ) {

                LogUtils.sysPrint(TAG,newCityBean.toString());



            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
