package com.example.mylibrary;

/**
 * Description:影片类
 * Created by wangjiawang on 2018/8/28.
 * complete
 */
public class Movie {
    public static final int CHILDRENS = 2;  //儿童片
    public static final int REGULAR = 0;     //定期
    public static final int NEW_RELEASE = 1;    //新片
//    public static final int test = 11;      //测试第一次提交推送未merge develop时做修改修改，可忽略

    private String mTitle;      //片名
    private int mPriceCode;  //价格

    public Movie(String mTitle, int mPriceCode) {
        this.mTitle = mTitle;
        this.mPriceCode = mPriceCode;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmPriceCode() {
        return mPriceCode;
    }

    public void setmPriceCode(int mPriceCode) {
        this.mPriceCode = mPriceCode;
    }
}
