package com.oyke.wanandroid.data.api;

import com.oyke.wanandroid.data.BasePage;
import com.oyke.wanandroid.data.BaseResponse;
import com.oyke.wanandroid.data.bean.Article;
import com.oyke.wanandroid.data.bean.Banner;
import com.oyke.wanandroid.data.bean.HotKey;
import com.oyke.wanandroid.data.bean.Navigation;
import com.oyke.wanandroid.data.bean.Project;
import com.oyke.wanandroid.data.bean.Tree;
import com.oyke.wanandroid.data.bean.User;
import com.oyke.wanandroid.data.bean.Website;
import com.oyke.wanandroid.data.bean.WxArticleItem;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Description:    玩android API
 * Author:         oyke
 * CreateDate:     2020/1/1 9:47
 */
public interface ApiService {
    /**
     * 获取公众号列表
     */
    @GET("/wxarticle/chapters/json")
    Observable<BaseResponse<List<WxArticleItem>>> getWxArticle();

    /**
     * 查看某个公众号的历史数据
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    Observable<BaseResponse<BasePage<Article>>> getWxArticleDetail(@Path("id") int id, @Path("page") int page);

    /**
     * 在某个公众号中搜索文章
     */
    @GET("/wxarticle/list/{id}/{page}/json?k={key}")
    Observable<BaseResponse<BasePage<Article>>> searchWxArticleDetail(@Path("id") int id, @Path("page") int page, @Path("key") String key);

    /**
     * 获取最新项目列表
     */
    @GET("/article/listproject/{page}/json")
    Observable<BaseResponse<BasePage<Project>>> getProjects(@Path("page") int page);

    /**
     * 获取首页文章列表
     */
    @GET("/article/list/{page}/json")
    Observable<BasePage<Article>> getHomeArticles(@Path("page") int page);

    /**
     * 获取banner
     */
    @GET("/banner/json")
    Observable<BaseResponse<List<Banner>>> getBanner();

    /**
     * 获取常用网站
     */
    @GET("/friend/json")
    Observable<BaseResponse<List<Website>>> getWebsites();

    /**
     * 获取搜索热词
     */
    @GET("/hotkey/json")
    Observable<BaseResponse<List<HotKey>>> getHotkeys();

    /**
     * 获取置顶文章
     */
    @GET("/article/top/json")
    Observable<BaseResponse<List<Article>>> getTopArticles();

    /**
     * 获取知识体系
     */
    @GET("/tree/json")
    Observable<BaseResponse<List<Tree>>> getTrees();

    /**
     * 获取知识体系下的文章
     */
    @GET("/article/list/{page}/json?cid={cid}")
    Observable<BaseResponse<BasePage<Article>>> getTreeArticles(@Path("page") int page, @Path("cid") int cid);

    /**
     * 按作者昵称搜索文章
     */
    @GET("/article/list/{page}/json?author={author}")
    Observable<BaseResponse<BasePage<List<Article>>>> searchArticlesByAuthor(@Path("page") int page, @Path("author") String author);

    /**
     * 获取导航数据
     */
    @GET("/navi/json")
    Observable<BaseResponse<List<Navigation>>> getNavigations();

    /**
     * 获取项目分类
     */
    @GET("/project/tree/json")
    Observable<BaseResponse<List<Tree>>> getProjectTree();

    /**
     * 获取某一分类下的项目列表
     */
    @GET("/project/list/{page}/json?cid={cid}")
    Observable<BaseResponse<BasePage<List<Project>>>> getProjectsByCid(@Path("page") int page, @Path("cid") int cid);

    /**
     * 登录
     */
    @POST("/user/login")
    Observable<BaseResponse<User>> login(@Field("username") String userName, @Field("password") String password);

    /**
     * 注册
     */
    @POST("/user/register")
    Observable<BaseResponse<String>> register(@Field("username") String userName, @Field("password") String password, @Field("repassword") String rePassword);

    /**
     * 退出
     */
    @GET("/user/logout/json")
    Observable<BaseResponse<String>> loginOut();

    /**
     * 获取文章收藏列表
     */
    @GET("/lg/collect/list/{page}/json")
    Observable<BaseResponse<BasePage<List<Article>>>> getArticleCollects(@Path("page") int page);

    /**
     * 收藏站内文章
     */
    @POST("/lg/collect/{id}/json")
    Observable<BaseResponse<String>> favoriteInsideArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     */
    @POST("/lg/collect/add/json")
    Observable<BaseResponse<String>> favoriteOutsideArticle(@Field("title") String title, @Field("author") String author, @Field("link") String link);

    /**
     * 取消收藏(在文章列表)
     */
    @POST("/lg/uncollect_originId/{id}/json")
    Observable<BaseResponse<String>> unCollectInArticleList(@Path("id") int id);

    /**
     * 取消收藏(在我的收藏)
     */
    @POST("/lg/uncollect/{id}/json")
    Observable<BaseResponse<String>> unCollectInMyFavorite(@Path("id") int id);

    /**
     * 获取网站收藏列表
     */
    @GET("/lg/collect/usertools/json")
    Observable<BaseResponse<List<String>>> getWebsiteCollects();

    /**
     * 收藏网站
     */
    @POST("/lg/collect/addtool/json")
    Observable<BaseResponse<String>> favoriteWebsite(@Field("name") String name, @Field("link") String link);

    /**
     * 编辑收藏网站
     */
    @POST("/lg/collect/updatetool/json")
    Observable<BaseResponse<String>> editorWebsite(@Field("id") String id, @Field("name") String name, @Field("link") String link);

    /**
     * 删除收藏网站
     */
    @POST("/lg/collect/deletetool/json")
    Observable<BaseResponse<String>> deleteWebsite(@Field("id") String id);

    /**
     * 搜索
     */
    @POST("/article/query/{page}/json")
    Observable<BaseResponse<String>> search(@Path("page") int page, @Field("k") String k);

    /**
     * 添加TODO
     */
    @POST("/lg/todo/add/json")
    Observable<BaseResponse<String>> addTodo(@Field("title") String title, @Field("content") String content,
                                             @Field("date") String date, @Field("type") int type,
                                             @Field("priority ") int priority);

    /**
     * 更新TODO
     */
    @POST("/lg/todo/update/{id}/json")
    Observable<BaseResponse<String>> updateTodo(@Path("id") int id, @Field("title") String title,
                                                @Field("content") String content, @Field("date") String date,
                                                @Field("type") int type, @Field("priority ") int priority);

    /**
     * 删除TODO
     */
    @POST("/lg/todo/delete/{id}/json")
    Observable<BaseResponse<String>> deleteTodo(@Path("id") int id);

    /**
     * 更新TODO 完成状态
     */
    @POST("/lg/todo/done/{id}/json")
    Observable<BaseResponse<String>> doneTodo(@Path("id") int id, @Field("status") int status);

    /**
     * 获取TODO列表
     */
    @GET("/lg/todo/v2/list/{page}/json")
    Observable<BaseResponse<String>> getTodoList(@Path("id") int id);

    /**
     * 获取积分排行榜
     */
    @GET("/coin/rank/{page}/json")
    Observable<BaseResponse<String>> getCoinRank(@Path("page") int page);

    /**
     * 获取我的积分信息
     */
    @GET("/lg/coin/userinfo/json")
    Observable<BaseResponse<String>> getMyCoinInfo();

    /**
     * 获取我的积分记录
     */
    @GET("/lg/coin/list/{page}/json")
    Observable<BaseResponse<String>> getMyCoinRecord();

    /**
     * 获取广场列表
     */
    @GET("/user_article/list/{page}/json")
    Observable<BaseResponse<String>> getShareList(@Path("page") int page);

    /**
     * 获取分享人对应的列表数据
     */
    @GET("/user/{id}/share_articles/{page}/json")
    Observable<BaseResponse<String>> getShareListByPerson(@Path("id") int id, @Path("page") int page);

    /**
     * 获取我的分享列表
     */
    @GET("/user/lg/private_articles/{page}/json")
    Observable<BaseResponse<String>> getMyShareList(@Path("page") int page);

    /**
     * 删除我的分享
     */
    @POST("/lg/user_article/delete/{id}/json")
    Observable<BaseResponse<String>> deleteMyShareArticle(@Path("id") int id);

    /**
     * 分享文章
     */
    @POST("/lg/user_article/add/json")
    Observable<BaseResponse<String>> shareArticle(@Field("title") String title, @Field("link") String link);

}
