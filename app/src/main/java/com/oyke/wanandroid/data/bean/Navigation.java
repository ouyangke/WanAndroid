package com.oyke.wanandroid.data.bean;

import java.util.List;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/1/4 4:37
 */
public class Navigation {

    /**
     * articles : []
     * cid : 272
     * name : 常用网站
     */

    private int cid;
    private String name;
    private List<Article> articles;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
