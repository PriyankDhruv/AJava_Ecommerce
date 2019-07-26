/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author PRIYANK DHRUV
 */
public class ViewCart extends HttpServlet {
 
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          HttpSession session = request.getSession();
          ArrayList cartObj = (ArrayList)session.getAttribute("cart");
          
          if(cartObj == null){
                out.print("Your cart is Empty !!");
          }else{
                    out.print("<table border = '1'>");
                    out.print("     <tr>");
                    out.print("         <td>" + "ID:" + "</td>");
                    out.print("         <td>" + "ProductName:" + "</td>");
                    out.print("         <td>" + "Quantity:" + "</td>");
                    out.print("         <td>" + "Price per unit:" + "</td>");
                    out.print("         <td>" + "Sub-Total:" + "</td>");
                    out.print("     </tr>");
                    double grandTotal = 0;
                for(int i=0; i<cartObj.size(); i++){
                    SelectedProduct tmp = (SelectedProduct)cartObj.get(i);
                    Products p =  (Products)Products.products.get(new Integer(tmp.pid));
                    double Price = p.getPrice();
                    double subTotal = Price * tmp.qty;
                    grandTotal = grandTotal + subTotal;
                    out.print("     <tr>");
                    out.print("         <td>" + (i+1) + "</td>");
                    out.print("         <td>" + p.pNm + "</td>");
                    out.print("         <td>" + tmp.qty + "</td>");
                    out.print("         <td>" + p.Price + "</td>");
                    out.print("         <td>" + subTotal + "</td>");
                    out.print("     </tr>");
                }
                    
                out.print("</table>");
                out.print("<br/>");
                out.println("\nGrand-Total: " + grandTotal);
          }
          
          out.println("<br/><br/>");
          out.println("<a href = 'checkout.html'>" + "<b>" + "CheckOut Details" + "</b>" + "</a>");
          
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
