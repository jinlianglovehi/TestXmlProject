package com.huami.watch.watchface.test.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by jinliang on 17/1/20.
 */
@XStreamAlias("china")//类注解(必须写)
public class ChinaBean {

    @XStreamAsAttribute() @XStreamAlias("dn") //属性注解
    private String dn;
    @XStreamImplicit(itemFieldName = "city")//节点注解(必须写)
    private List<CityBean> city;
    //省略dn 和 city 的 getter 和 setter 方法


    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public static class CityBean {
        //值不用注解
        private int year;
        private String name;
        private int age;
        @XStreamAsAttribute()
        @XStreamAlias("prov")//属性是必须用注解声明的
        private String prov;

        //省略getter 和setter 方法


        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        @Override
        public String toString() {
            return "CityBean{" +
                    "year=" + year +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", prov='" + prov + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ChinaBean{" +
                "dn='" + dn + '\'' +
                ", city=" + city +
                '}';
    }
}
