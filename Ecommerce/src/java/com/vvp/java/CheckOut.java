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
public class CheckOut extends HttpServlet {
   
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
               
            if(request.getParameter("payment_mode").equals("Cash On Delivery")){
                
                HttpSession session = request.getSession();
                if(session.getAttribute("cart") == null){
                    
                    out.print("Your Cart is Empty.");
                    return;
                }else{
                    
                    double grandTotal = 0;
                    out.print("<html>");
                    out.print("<body>");
                    out.print("<center>" + "<h2>" + "Customer Details: " + "</h2>" + "</center>");
                    out.print("<br/>" + "Customer Name: " + request.getParameter("Name"));
                    out.print("<br/>" + "Mobile Number: " + request.getParameter("ContactNo."));
                    out.print("<br/>" + "Address:       " + request.getParameter("Address"));
                    out.print("<br/>" + "Payment Mode:  " + request.getParameter("payment_mode"));
                    out.print("<br/>" + "<br/>");
                    out.print("<table border = '1'>");
                    out.print("<tr>");
                    out.print("<td>" + "ID:" + "</td>");
                    out.print("<td>" + "ProductName:" + "</td>");
                    out.print("<td>" + "Quantity:" + "</td>");
                    out.print("<td>" + "Price per Unit:" + "</td>");
                    out.print("<td>" + "Sub-Total:" + "</td>");
                    out.print("</tr>");
                    ArrayList CartObj = (ArrayList)session.getAttribute("cart");
                    
                    for(int i=0; i<CartObj.size(); i++){
                    
                        SelectedProduct Stmp = (SelectedProduct)CartObj.get(i);
                        Products P = (Products)Products.products.get(new Integer(Stmp.getPid()));
                        double subTotal = P.getPrice() * Stmp.getQty(); 
                        if(P.Stock >= P.Qty){
                        
                            P.Stock = P.Stock - P.Qty;
                            Products.products.put(Stmp.getPid(), P);
                            out.print("<tr>");
                            out.print("<td>" + P.getPid() + "</td>");
                            out.print("<td>" + P.getPNm() + "</td>");
                            out.print("<td>" + Stmp.getQty() + "</td>");
                            out.print("<td>" + P.getPrice() + "</td>");
                            out.print("<td>" + subTotal + "</td>");
                            grandTotal = grandTotal + subTotal;
                        }else{
                        
                            
                        }
                        
                            
                    }    
                    out.print("</table><br/>" + "Grand Total : " + grandTotal);
                    out.print("</body>");
                    out.print("</html>");
                }
                session.removeAttribute("cart");
                
        }else{
            
            out.print("Coming Soon....");
        }
            
            
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
