package com.huami.watch.testxmlproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.huami.watch.watchface.model.WatchFaceModule;
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

        WatchFaceModule watchFace = new WatchFaceModule();
        watchFace.setZhname("<description><![CDATA[iOS的氛围[夜星]\n" +
                "特征\n" +
                "在一个4解锁风格[股票，指纹识别，幻灯片，IOS]\n" +
                "流星动画家和锁屏\n" +
                "有吸引力的图标，改编自iOS和MIUI8\n" +
                "状态栏的ios长相\n" +
                "其他\n" +
                "\n" +
                "报告错误，请求或者只是想打个招呼 : 2821368478@qq/deuge7746@gmail.com\n" +
                "\n" +
                "iOS Ambiance [Night star]\n" +
                "featute\n" +
                "4 unlocker style in one[stock,fingerprint,slide,ios]\n" +
                "falling star animation home and lockscreen\n" +
                "attractive icons,adapted from ios and miui8\n" +
                "statusbar ios looks\n" +
                "other\n" +
                "\n" +
                "report bug,request or just want to say hi : 2821368478@qq/deuge7746@gmail.com]]></description>");

       String result =  XmlUtils.transforWatchFaceToXml(watchFace);
        LogUtils.print(TAG, "testToString:"+ result);



       WatchFaceModule resultWatchFace  = XmlUtils.getWatchFaceFromXmlString(result);
        LogUtils.print(TAG, "result:"+ resultWatchFace.toString());



    }


}
