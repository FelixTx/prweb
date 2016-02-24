/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centrale.prweb;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FT
 */
@WebServlet(name = "identify", urlPatterns = {"/identify"})
public class identify extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            System.out.println("doget");
            jspcalling("index.jsp", request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("dopost");
        if (request.getParameter("login").equals("moi") && request.getParameter("password").equals("1234")){
            jspcalling("page.jsp", request, response);
        }
        else {
            jspcalling("index.jsp", request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

protected static void jspcalling(String page, HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            response.setHeader("Content-Type","text/html;charset=UTF-8");
            dispatcher.include(request,response);
        } catch (IOException ex){
            Logger.getLogger(identify.class).log(Level.SEVERE,null,ex);    
        } catch (ServletException ex){
         Logger.getLogger(identify.class).log(Level.SEVERE,null,ex);
        }
    }
}
