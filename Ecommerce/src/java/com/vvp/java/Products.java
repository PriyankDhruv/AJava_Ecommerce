/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;
import java.util.HashMap;

/**
 *
 * @author PRIYANK DHRUV
 */
public class Products{
    
    int pid;
    int Stock;
    int Qty;
    double Price;
    String pNm;
    String images;
    
    static HashMap<Integer, Products>products = new HashMap<Integer, Products>();
    public Products(int pid, int Stock, double Price, String pNm){
        this.pid = pid;
        this.Stock = Stock;
        this.Price = Price;
        this.pNm = pNm;
    }
    
    public String getImages(){
        return images;
    }

    public void setImages(String images){
        this.images = images;
    }
    
    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getPNm() {
        return pNm;
    }

    public void setPNm(String pNm) {
        this.pNm = pNm;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public static HashMap<Integer, Products> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<Integer, Products> products) {
        Products.products = products;
    }
    
    public static void initData(){
        
        Products P1 = new Products(1, 5, 800.00, "Bag");
        Products P2 = new Products(2, 4, 6.00, "pen");
        Products P3 = new Products(3, 6, 80.00, "JAVA Complete Referance");
        products.put(new Integer(1), P1);
        products.put(new Integer(2), P2);
        products.put(new Integer(3), P3);
    }

   


}
