package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class Login extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        int row = 0;
        
        DBCommand connect = new DBCommand();
        
        // getCount
        try{ row = connect.getCount(username, pass); }
        catch(Exception e){ System.out.println("Get count error : "+e); }
        
        if(row==0)
        {
            session.setAttribute("error", "ID OR PASSWORD Incorrect");
            response.sendRedirect("page/login.jsp");
        }
        else
        {
            //set Model
            Model_admin a = new Model_admin();
            String data[] = new String[3];
             try
             {
                 a = connect.setAdmin(username, pass);
                 data = connect.getData(a);
             }catch (SQLException e) { System.out.println("SET OT GET error : "+e); }

             connect.close();
             
            session.setAttribute("user", data[1]);
            response.sendRedirect("index.jsp");
        }
    }
}
