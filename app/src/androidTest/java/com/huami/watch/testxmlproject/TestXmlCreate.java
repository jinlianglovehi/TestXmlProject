package com.huami.watch.testxmlproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.huami.watch.watchface.model.WatchFaceInfoModule;
import com.huami.watch.watchface.model.WatchFaceModule;
import com.huami.watch.watchface.model.WatchFaceModuleItem;
import com.huami.watch.watchface.utils.LogUtils;
import com.huami.watch.watchface.utils.XmlModuleUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
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
//    @Test
    public void test(){



    }



    @Test
    public void test02(){


        try {
           WatchFaceModule watchFace  = XmlModuleUtils.getModelFromInputStream(appContext.getAssets().open("watchface_simple.xml"),WatchFaceModule.class);
            if (watchFace!=null){
                LogUtils.sysPrint(TAG,watchFace.toString());

//                LogUtils.sysPrint(TAG,"----watchFaceItemSize:"+ watchFace.getWatchFaceItemList().size());
//
//                List<WatchFaceModuleItem> list = watchFace.getWatchFaceItemList();
//                for (WatchFaceModuleItem item  : list
//                     ) {
//                    LogUtils.sysPrint(TAG,item.toString());
//
//                }

            }else {

                LogUtils.sysPrint(TAG," is null ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
