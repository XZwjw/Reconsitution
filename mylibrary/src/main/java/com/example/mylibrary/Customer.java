package com.example.mylibrary;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Description:顾客
 * Created by wangjiawang on 2018/8/28.
 * complete
 */
public class Customer {
    private String mName;
    private Vector mRentals = new Vector(); //Vector表示可变大小数组的序列容器。

    public Customer(String mName) {
        this.mName = mName;
    }

    public void addRental(Rental arg) {
        mRentals.addElement(arg);
    }

    public String getName() {
        return mName;
    }

    /**
     * 这是一个生成订单的函数
     * 设计的不好:
     *  不符合面向对象精神
     *  statement中做了本来属于其他类该做的事情
     * @return
     */
    public String statement() {
        double totalAmount = 0; //总数
        int frequentRenterPoints = 0;   //频繁的点击点
        Enumeration rentals = mRentals.elements();
        String result = "Rental Record for "+getName()+"\n";
        while (rentals.hasMoreElements()) {
            double thisAmout = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line
            switch (each.getmMovie().getmPriceCode()) {
                case Movie.REGULAR:
                    thisAmout += 2;
                    if(each.getmDaysRented() > 2) {
                        thisAmout += (each.getmDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmout += each.getmDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmout += 1.5;
                    if(each.getmDaysRented() > 3) {
                        thisAmout += (each.getmDaysRented() - 3) * 1.5;
                    }
                    break;

            }
            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if((each.getmMovie().getmPriceCode() == Movie.NEW_RELEASE) && each.getmDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += "\t" +each.getmMovie().getmTitle() +"\t"+String.valueOf(thisAmout) +"\n";
            totalAmount += thisAmout;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
        result += "You earned "+String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
