XStream的jar包的下载。
下载jar包请点击这里

下载完成之后里面包含了 xstream.jar 和 xapp3.jar。

Xstream序列化XML时可以允许用户使用不同的XML解析器，用户可以使用一个标准的JAXP DOM解析器或自Java6集成StAX解析器。这样用户就不需要依赖xpp3.jar。

 //XStream xstream = new XStream();//需要XPP3库
 //XStream xstream = new XStream(new DomDriver());//不需要XPP3库
 //XStream xstream = new XStream(new StaxDriver());//不需要XPP3库开始使用Java6
由于也有许多版本了，而我开始下载的是1.4.8版本的。导入之后总是报错。后来看网上说是1.4.8要java8支持，没考证，不过的确换成1.4.7就可以了，而且看版本使用统计 1.4.7也的确是使用人数最多的。

使用
我们拿到那个内容的xml字符串之后。可以同过下面几句代码将内容转为javaBean

 XStream stream = new XStream();
 stream.processAnnotations(TestBean.class);//这里需要注解是你自己根据xml写的bean类(下面附代码解释xml)
 TestBean result = (TestBean) stream.fromXML(xmlStr);
实例1
xml内容为：

<china dn="day">
    <city prov= "西安">
        <name>陕西</name>
        <age>18</age>
        <year>2016</year>
    </city>
    <city prov= "郑州">
        <name>河南</name>
        <age>20</age>
        <year>2016</year>
    </city>
    <city prov= "石家庄">
        <name>河北</name>
        <age>22</age>
        <year>2016</year>
    </city>
    <city prov= "三亚">
        <name>海南</name>
        <age>88</age>
        <year>2016</year>
    </city>
</china>
首先这个xml串，是有一个List 集合，然后因为有dn=“day”的属性，相当于和List同级有一个 字段

然后每一个city 里面 有 prov 、name、age、year 等字段参数。

我们编写一个javabean ：

@XStreamAlias("china")//类注解(必须写)
public class ChinaBean {

    @XStreamAsAttribute()
     @XStreamAlias("dn") //属性注解
    private String dn;
    @XStreamImplicit(itemFieldName = "city")//节点注解(必须写)
    private List<CityBean> city;
    //省略dn 和 city 的 getter 和 setter 方法

    public static class CityBean {
        //值不用注解
        private int year;
        private String name;
        private int age;
        @XStreamAsAttribute() @XStreamAlias("prov")//属性是必须用注解声明的
        private String prov;

      //省略getter 和setter 方法
    }

}
如果xml的数据再复杂点
如：点我获取天气预报的xml内容

其实也没复制多少，和上面的差不多，只不过多了好几个属性。

itdadao

那么我们对照着写出这个天气预报的bean

@XStreamAlias("china")//这里用到注解(必须写)
public class TestBean {

    @XStreamAsAttribute() @XStreamAlias("dn")
    private String dn;
    /**
     * tem2 : -20
     * tem1 : -8
     * quName : 黑龙江
     * cityname : 哈尔滨
     * pyName : heilongjiang
     * stateDetailed : 多云
     * state2 : 1
     * state1 : 1
     * windState : 西北风3-4级转小于3级
     */
    @XStreamImplicit(itemFieldName = "city")//节点注解(必须写)
    private List<CityBean> city;

   //省略getter setter方法

    public static class CityBean {
        @XStreamAsAttribute() @XStreamAlias("tem2")
        private int tem2;
        @XStreamAsAttribute() @XStreamAlias("tem1")
        private int tem1;
        @XStreamAsAttribute() @XStreamAlias("quName")
        private String quName;
        @XStreamAsAttribute() @XStreamAlias("cityname")
        private String cityname;
        @XStreamAsAttribute() @XStreamAlias("pyName")
        private String pyName;
        @XStreamAsAttribute() @XStreamAlias("stateDetailed")
        private String stateDetailed;
        @XStreamAsAttribute() @XStreamAlias("state2")
        private int state2;
        @XStreamAsAttribute() @XStreamAlias("state1")
        private int state1;
        @XStreamAsAttribute() @XStreamAlias("windState")
        private String windState;

       //省略getter setter方法
    }

}
我们从上面两个栗子看到，有属性和有值的xml的解析方式，那么其他的类型应该也都是大同小异了。

XStream的几种注解
Xstream注解常用知识：

@XStreamAlias("message") 别名注解  作用目标: 类,字段
@XStreamImplicit 隐式集合
@XStreamImplicit(itemFieldName="part")  作用目标: 集合字段
@XStreamConverter(SingleValueCalendarConverter.class) 注入转换器  作用目标: 对象
@XStreamAsAttribute 转换成属性  作用目标: 字段
@XStreamOmitField 忽略字段  作用目标: 字段
Auto-detect Annotations 自动侦查注解
xstream.autodetectAnnotations(true);
自动侦查注解与XStream.processAnnotations(Class[] cls)的区别在于性能.自动侦查注解将缓存所有类的类型.
参考了 XStream教程，点击查看教程



##### 使用教程

> http://x-stream.github.io/tutorial.html
