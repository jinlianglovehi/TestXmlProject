package com.huami.watch.watchface.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by jinliang on 17/1/20.
 */

@XStreamAlias("Graduation-list")
public class GraduationContainer {


    /**
     * mask="@drawable/graduation_mask_13" default="0">
     */
    @XStreamAlias("mask")
    private String mask ;

    @XStreamAlias("default")
    private int defaultInt ;

}
