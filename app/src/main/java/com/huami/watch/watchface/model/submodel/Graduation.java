package com.huami.watch.watchface.model.submodel;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by jinliang on 17/1/20.
 */

@XStreamAlias("Graduation")
public class Graduation {

    @XStreamAlias("value")
    private String value ;

    @XStreamAlias("preview")
    private String preview ;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
