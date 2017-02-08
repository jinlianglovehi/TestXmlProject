package com.huami.watch.watchface.model;

/**
 * Created by jinliang on 17/2/8.
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 解析watchFaceInfo
 */
@XStreamAlias("watchfaceinfo")
public class WatchFaceInfoModule {


    @XStreamAlias("version")
    private String  version ;

    @XStreamAlias("id")
    private String id ;

    @XStreamAlias("author")
    private String author;

    @XStreamAlias("designer")
    private String designer ;

    @XStreamAlias("title")
    private String title ;

    @XStreamAlias("preview")
    private String preview ;

    @XStreamAlias("description")
    private String description ;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WatchFaceInfoModule{" +
                "version='" + version + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", designer='" + designer + '\'' +
                ", title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

//    <watchfaceinfo>
//    <version>1.0</version>
//    <id>wfe76afd</id>
//    <author>zhaoxingyan</author>
//    <designer>liguangsong</designer>
//    <title>金鸡报晓2</title>
//    <preview>preview.png</preview>
//    <description><![CDATA[test watchface description.]]></description>
//    </watchfaceinfo>




}
