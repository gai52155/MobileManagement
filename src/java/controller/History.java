package controller;

import com.promptnow.model.ModelHistory;

/**
 * Servlet implementation class LoginController
 */
public class History extends BaseService 
{
    @Override
    void process(DBCommand connect) throws Exception 
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String date1 = request.getParameter("start_time");
        String date2 = request.getParameter("last_time");
        int n = 0; //COUNT
        
        try { n = connect.gethistoryCount(date1, date2); } catch(Exception e){ System.out.println("GetCount Error: "+e); }
        System.out.println(n);
        if(n==0)
        {
            request.setAttribute("data", 0);
            request.getServletContext().getRequestDispatcher("/page/history.jsp").forward(request, response);
        }
        else
        {
            ModelHistory model[] = new ModelHistory[n];
            String data[] = new String [n*6];

            try
            {
                model = connect.sethistory(n, date1, date2);
                data = connect.gethistoryData(n, model);
            }
            catch(Exception e){ System.out.println("SET OR GET Error : "+e);}
            
            request.setAttribute("history", data);
            request.getServletContext().getRequestDispatcher("/page/history.jsp").forward(request, response);
        }
    }
}
