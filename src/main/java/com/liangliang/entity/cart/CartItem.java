package com.liangliang.entity.cart;

import com.liangliang.entity.MsProductInfo;

/**
 * @ClassName CartItem
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/5/13 10:15
 * @Version 1.0
 **/
public class CartItem {
    private MsProductInfo product;//商品

    private int buyNum;//个数

    private double subTotal;//小计

    public MsProductInfo getProduct() {
        return product;
    }

    public void setProduct(MsProductInfo product) {
        this.product = product;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
