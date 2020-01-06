package com.oyke.wanandroid.data.bean;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/1/4 3:14
 */
public class Banner {

    /**
     * desc : 享学~
     * id : 29
     * imagePath : https://wanandroid.com/blogimgs/fa432a45-66af-4c9f-b0ea-c824be3f37c9.png
     * isVisible : 1
     * order : 0
     * title : ​&ldquo;如果面试时大家都说真话&hellip;&rdquo;
     * type : 0
     * url : https://mp.weixin.qq.com/s/fEXcTfVafpljmtzzpNENVg
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
