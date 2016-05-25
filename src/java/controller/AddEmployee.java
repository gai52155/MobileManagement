package controller;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class AddEmployee extends BaseService 
{
    @Override
    void process(DBCommand connect) throws Exception 
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
        
        
        String message = connect.insertemployee(identify, prefixth, prefixen, 
                                                nameth, nameen, lastnameth, 
                                                lastnameen, nickname);
        
        request.setAttribute("message", message);
        request.getServletContext().getRequestDispatcher("/page/addemployee.jsp").forward(request, response);
    }
}
