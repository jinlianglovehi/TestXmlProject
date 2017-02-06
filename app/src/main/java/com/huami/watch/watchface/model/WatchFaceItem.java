package com.huami.watch.watchface.model;

/**
 * Created by jinliang on 17/2/4.
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 子元素
 */

@XStreamAlias("WatchFaceItem")
public class WatchFaceItem {

    /**
     *
     *  <WatchFaceItem type="backguard" config="@drawable/watchface_default_fourteen_bg_2" config_list="@watchface_config/background_list_0" />
     <WatchFaceItem type="graduation" config="@assets/graduation/01" preview="@assets/graduation/01/preview.png" mask="@drawable/watchface_custom_switch_focus_graduation_fg" config_list="@watchface_config/graduation_list_0" />
     <WatchFaceItem type="timehand" x="160" y="160" width="320" height="320" config="@assets/timehand/02" preview="@drawable/hand_preview_13" mask="@assets/timehand/watchface_custom_select_timehand_fg_0.png" config_list="@watchface_config/timehand_list_0" />
     <WatchFaceItem type="datawidget" x="52" y="118" width="84" height="84" dataType="10" model="0" preview="@assets/datawidget/preview_10_0.png" mask="@assets/datawidget/mask_0_fg.png " config_list="@watchface_config/widget_list_0" />
     <WatchFaceItem type="datawidget" x="119" y="187" width="84" height="84" dataType="1" model="0" preview="@assets/datawidget/preview_1_0.png" mask="@assets/datawidget/mask_1_fg.png " config_list="@watchface_config/widget_list_1" />
     <WatchFaceItem type="datawidget" x="184" y="118" width="84" height="84" dataType="4" model="0" preview="@assets/datawidget/preview_4_0.png" mask="@assets/datawidget/mask_2_fg.png " config_list="@watchface_config/widget_list_2" />
     */

    @XStreamAsAttribute()
    @XStreamAlias("type")
    private String type ;

    @XStreamAsAttribute()
    @XStreamAlias("config")
    private String config ;

    @XStreamAsAttribute()
    @XStreamAlias("configlist")
    private String configlist ;

    @XStreamAsAttribute()
    @XStreamAlias("preview")
    private String preview ;

    @XStreamAsAttribute()
    @XStreamAlias("mask")
    private String mask ;

    @XStreamAsAttribute()
    @XStreamAlias("x")
    private int x ;

    @XStreamAsAttribute()
    @XStreamAlias("y")
    private int y ;

    @XStreamAsAttribute()
    @XStreamAlias("width")
    private int width ;

    @XStreamAsAttribute()
    @XStreamAlias("height")
    private int height ;

    @XStreamAsAttribute()
    @XStreamAlias("dataType")
    private int dataType ;

    @XStreamAsAttribute()
    @XStreamAlias("model")
    private int model ;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfiglist() {
        return configlist;
    }

    public void setConfiglist(String configlist) {
        this.configlist = configlist;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "WatchFaceItem{" +
                "type='" + type + '\'' +
                ", config='" + config + '\'' +
                ", config_list='" + configlist + '\'' +
                ", preview='" + preview + '\'' +
                ", mask='" + mask + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", dataType=" + dataType +
                ", model=" + model +
                '}';
    }

}
