package controller;

import com.promptnow.model.ModelAdmin;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class Login extends BaseService {
    @Override
    void process(DBCommand connect) throws Exception {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        int row = 0;

        // getCount
        try {
            row = connect.getCount(username, pass);
        } catch (Exception e) {
            System.out.println("Controller : Get count error : " + e);
        }
        
        if (row == 0) {
            connect.close();
            System.out.println("COME ON!");
            request.setAttribute("error", "ID OR PASSWORD Incorrect");
            
            request.getServletContext().getRequestDispatcher("/page/login.jsp").forward(request, response);
        } else {
            //set Model
            ModelAdmin a = new ModelAdmin();
            String data[] = new String[3];
            try {
                a = connect.setAdmin(username, pass);
                data = connect.getData(a);
            } catch (SQLException e) {
                System.out.println("SET OT GET error : " + e);
            }
            connect.close();
            session.setAttribute("user", data[1]);
            response.sendRedirect("../index.jsp");
        }
    }
}
