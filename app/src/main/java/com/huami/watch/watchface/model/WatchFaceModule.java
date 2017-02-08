package com.huami.watch.watchface.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by jinliang on 17/1/20.
 */


// name="Golden Rooster" name_zh="金鸡报晓" version="1.0"

@XStreamAlias("WatchFace")
public class WatchFaceModule {

    @XStreamAsAttribute()
    @XStreamAlias("name")
    private String  name ;

    @XStreamAsAttribute()
    @XStreamAlias("zh_name")
    private String zhname;

    @XStreamAsAttribute()
    @XStreamAlias("version")
    private String version ;


    @XStreamImplicit(itemFieldName = "WatchFaceItem")//节点注解(必须写)
    private List<WatchFaceModuleItem> watchFaceItemList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public List<WatchFaceModuleItem> getWatchFaceItemList() {
        return watchFaceItemList;
    }

    public void setWatchFaceItemList(List<WatchFaceModuleItem> watchFaceItemList) {
        this.watchFaceItemList = watchFaceItemList;
    }

    @Override
    public String toString() {
        return "WatchFaceModule{" +
                "name='" + name + '\'' +
                ", zhname='" + zhname + '\'' +
                ", version='" + version + '\'' +
                ", watchFaceItemList=" + watchFaceItemList +
                '}';
    }
}
