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
public class AddToCart extends HttpServlet {

    public void init(ServletConfig cfg){
        Products.initData();
    }
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList cartObj = null;
        try {
          HttpSession session = request.getSession();
          int pid = Integer.parseInt(request.getParameter("pid"));
          int qty = Integer.parseInt(request.getParameter("qty"));
         
          if(session.getAttribute("cart") == null)
          {
              cartObj = new ArrayList();
          }
          else
          {
              cartObj = (ArrayList)session.getAttribute("cart");
          }
              SelectedProduct sp = new SelectedProduct(pid, qty);
              cartObj.add(sp);
              
              session.setAttribute("cart", cartObj);
              response.sendRedirect("Products.html");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          
        finally { 
            out.close();
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

   
    // </editor-fold>
}
