package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class AddEmployee extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        String identify = request.getParameter("identify");
        String prefixth = request.getParameter("prefixth");
        String prefixen = "";
        switch (prefixth) {
            case "นาย":
                prefixen = "Mr.";
                break;
                
            case "นางสาว":
                prefixen = "Miss.";
                break;
                
            default:
                prefixen = "Mrs.";
                break;
        }
        String nameth = request.getParameter("nameth");
        String nameen = request.getParameter("nameen");
        String lastnameth = request.getParameter("lastnameth");
        String lastnameen = request.getParameter("lastnameen");
        String nickname = request.getParameter("nickname");
        
        DBCommand connect = new DBCommand();
        
        String message = connect.insertemployee(identify, prefixth, prefixen, 
                                                nameth, nameen, lastnameth, 
                                                lastnameen, nickname);
        connect.close();
        
        session.setAttribute("message", message);
        response.sendRedirect("page/addemployee.jsp");
    }
}
