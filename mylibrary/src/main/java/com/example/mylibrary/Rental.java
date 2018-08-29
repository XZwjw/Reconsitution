package com.example.mylibrary;

/**
 * Description:租赁
 * Created by wangjiawang on 2018/8/28.
 * complete
 */
public class Rental {
    private Movie mMovie;
    private int mDaysRented;

    public Rental(Movie mMovie, int mDaysRented) {
        this.mMovie = mMovie;
        this.mDaysRented = mDaysRented;
    }

    public Movie getmMovie() {
        return mMovie;
    }

    public int getmDaysRented() {
        return mDaysRented;
    }
}
