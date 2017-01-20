package com.huami.watch.watchface.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by jinliang on 17/1/20.
 */


@XStreamAlias("WatchFace")
public class WatchFace {


    @XStreamAlias("name")
    private String  name ;

    @XStreamAlias("name_zh")
    private String name_zh;

    @XStreamAlias("version")
    private String version ;


    @XStreamAlias("Backguard-list")
    private BackguardContainer backguardContainer;


}
