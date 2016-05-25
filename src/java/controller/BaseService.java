/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Katawut
 */
abstract class BaseService extends HttpServlet{
    
    HttpServletRequest request;
    HttpServletResponse response;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        this.request = request;
        this.response= response;
        try{
            DBCommand connect =new DBCommand();
            process(connect);
            connect.close();
        }catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("page/error.jsp");
        }
    }    
    
   abstract void process(DBCommand connect) throws Exception;

   
}
