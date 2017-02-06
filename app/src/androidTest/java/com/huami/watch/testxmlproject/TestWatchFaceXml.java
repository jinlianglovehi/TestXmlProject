package com.huami.watch.testxmlproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.huami.watch.watchface.model.WatchFace;
import com.huami.watch.watchface.utils.LogUtils;
import com.huami.watch.watchface.utils.XmlUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jinliang on 17/2/6.
 */

@RunWith(AndroidJUnit4.class)
public class TestWatchFaceXml {

    private Context appContext ;
    @Before
    public void getAppContext(){
        appContext = InstrumentationRegistry.getTargetContext();
    }

    private static final String TAG = TestXmlCreate.class.getSimpleName();



    @Test
    public void testToString(){

        WatchFace watchFace = new WatchFace();
        watchFace.setZhname("你好");

       String result =  XmlUtils.transforWatchFaceToXml(watchFace);
        LogUtils.print(TAG, "testToString:"+ result);



       WatchFace resultWatchFace  = XmlUtils.getWatchFaceFromXmlString(result);
        LogUtils.print(TAG, "result:"+ resultWatchFace.toString());



    }


}
