package com.huami.watch.watchface.model;

import com.huami.watch.watchface.model.submodel.Backguard;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by jinliang on 17/1/20.
 *
 *  container 容器
 */


@XStreamAlias("Backguard-list")
public class BackguardContainer {

    @XStreamAlias("default")
    private int  defaultInt ;

    @XStreamAlias("Backguard-list")
    private List<Backguard> list ;


    public int getDefaultInt() {
        return defaultInt;
    }

    public void setDefaultInt(int defaultInt) {
        this.defaultInt = defaultInt;
    }

    public List<Backguard> getList() {
        return list;
    }

    public void setList(List<Backguard> list) {
        this.list = list;
    }
}
