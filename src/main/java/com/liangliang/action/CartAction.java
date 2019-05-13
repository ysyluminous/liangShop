package com.liangliang.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liangliang.entity.MsProductInfo;
import com.liangliang.entity.OnLine;
import com.liangliang.entity.cart.Cart;
import com.liangliang.entity.cart.CartItem;
import com.liangliang.service.MsProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @ClassName CartAction
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/5/13 10:18
 * @Version 1.0
 **/

@Controller
@RequestMapping("cart")
public class CartAction {
    @Autowired
    MsProductInfoService msProductInfoService;



    @RequestMapping("toCart")
    public String toCart(HttpServletRequest request, HttpServletResponse response){

//        HttpSession session=request.getSession();
//        Cart cart= (Cart) session.getAttribute("cart");
//        if(cart==null){
//            cart=new Cart();
//        }
//        CartItem cartItem=new CartItem();
//        cartItem.setBuyNum(buyNum);
//        cartItem.setProduct(product);
//        //计算小计
//        double subTotal=product.getMiaoshaPrice()*buyNum;
//        cartItem.setSubTotal(subTotal);
//
//        HashMap<String, CartItem> cartItems= cart.getCartItems();
//        double newSubTotal=0;
//        if(cartItems.containsKey(pidStr)){
//            CartItem item= cartItems.get(pidStr);
//            //修改数量
//            int oldBuyNum= item.getBuyNum();
//            oldBuyNum=oldBuyNum+buyNum;
//            item.setBuyNum(oldBuyNum);
//            //修改小计
//            double oldSubTotal= item.getSubTotal();
//            newSubTotal=buyNum*product.getMiaoshaPrice();
//            oldSubTotal=oldSubTotal+newSubTotal;
//            item.setSubTotal(oldSubTotal);
//        }else{
//            cartItems.put(pidStr, cartItem);
//            newSubTotal=buyNum*product.getMiaoshaPrice();
//        }
//
//        //计算 总计
//        double total=cart.getTotal()+newSubTotal;
//        cart.setTotal(total);
//        cart.setCartItems(cartItems);
//        session.setAttribute("cart", cart);
//        request.getRequestDispatcher("cart.jsp").forward(request, response);
        return "order/cart";
    }




    @RequestMapping(value = "addProductToCard",method = RequestMethod.POST)
    public String addProductToCard(HttpServletRequest request, HttpServletResponse response,Integer productId,Integer num)
            throws ServletException, IOException {

        OnLine onLine = (OnLine) request.getSession().getAttribute("onLine");
        if (onLine == null) {
            HashMap<String, Object> map = new HashMap<>();

            //删除成功
            map.put("success",false);
            map.put("msg","请登录");
            response.setContentType("text/html;charset=utf-8");

            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(map));
            PrintWriter out = response.getWriter();
            //返回信息
            out.print(jsonObject);
            out.flush();
            out.close();

        }
        //获取商品编号

        //购买数量
        MsProductInfo product= msProductInfoService.queryProductById(productId);
        HttpSession session=request.getSession();
        Cart cart= (Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }
        CartItem cartItem=new CartItem();
        cartItem.setBuyNum(num);
        cartItem.setProduct(product);
        //计算小计
        double subTotal=product.getMiaoshaPrice()*num;
        cartItem.setSubTotal(subTotal);

        HashMap<String, CartItem> cartItems= cart.getCartItems();
        double newSubTotal=0;
        if(cartItems.containsKey(productId.toString())){
            CartItem item= cartItems.get(productId.toString());
            //修改数量
            int oldBuyNum= item.getBuyNum();
            oldBuyNum=oldBuyNum+num;
            item.setBuyNum(oldBuyNum);
            //修改小计
            double oldSubTotal= item.getSubTotal();
            newSubTotal=num*product.getMiaoshaPrice();
            oldSubTotal=oldSubTotal+newSubTotal;
            item.setSubTotal(oldSubTotal);
        }else{
            cartItems.put(productId.toString(), cartItem);
            newSubTotal=num*product.getMiaoshaPrice();
        }

        //计算 总计
        double total=cart.getTotal()+newSubTotal;
        cart.setTotal(total);
        cart.setCartItems(cartItems);
        session.setAttribute("cart", cart);




        request.setCharacterEncoding("UTF-8");//防止乱码

        HashMap<String, Object> map = new HashMap<>();

            //删除成功
            map.put("success",true);
            map.put("msg","添加成功");
        response.setContentType("text/html;charset=utf-8");

        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(map));
        PrintWriter out = response.getWriter();
        //返回信息
        out.print(jsonObject);
        out.flush();
        out.close();



//        request.getRequestDispatcher("cart.jsp").forward(request, response);
        return "redirect:order/cart";
    }

}
