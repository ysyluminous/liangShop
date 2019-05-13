package com.liangliang.entity.cart;

import java.util.HashMap;

/**
 * @ClassName Cart
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/5/13 10:15
 * @Version 1.0
 **/
public class Cart {
    private HashMap<String,CartItem> cartItems=new HashMap<String,CartItem>();

    private double total;//总计
    public HashMap<String, CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(HashMap<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}