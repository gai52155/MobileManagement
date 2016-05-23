package controller;

/**
 *
 * @author Katawut
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCommand {
    
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public static final String URL = "jdbc:mysql://rd.promptnow.com:3306/trainee";
    public static final String USER = "trainee";
    public static final String PASSWORD = "trainee2016";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    

    public DBCommand()
    {
        try
        {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            st = conn.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(":Error : " + e);
        }
    }
    
    public int getCount(String username,String pass) throws SQLException
    {
        String query = "SELECT * FROM admin WHERE admin_username = '"+username+"' AND admin_password = '"+pass+"'";
        rs = st.executeQuery(query);
        rs.next();
        int rowCount = rs.getInt(1);

        return rowCount;
    }
    
    public int gethistoryCount(String date1,String date2) throws SQLException
    {
        String query = "select COUNT(*) from history where borrow_datetime between '"+date1+"' and '"+date2+" 23:59:59'";
        rs = st.executeQuery(query);
        rs.next();
        int rowCount = rs.getInt(1);

        return rowCount;
    }
    
    public int getdeviceCount(String series) throws SQLException
    {
        String query = "SELECT COUNT(*) FROM mobile WHERE device_series = '"+series+"'";
        rs = st.executeQuery(query);
        rs.next();
        int rowCount = rs.getInt(1);

        return rowCount;
    }
    
    
    public Model_admin setAdmin(String username,String pass) throws SQLException
    {
        Model_admin a = new Model_admin();
        try
        {
            String query = "SELECT * FROM admin WHERE admin_username = '"+username+"' AND admin_password = '"+pass+"'";
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
               a.setid(rs.getInt(1));
               a.setusername(rs.getNString(2));
               a.setpassword(rs.getNString(3));
            }
        }
        catch(Exception e)
        {
            System.out.println("Set data Error : "+e);
        }
        
        return a;
    }
    
    public Model_history[] sethistory(int n, String date1, String date2)
    {
        Model_history[] a = new Model_history[n];
        
        try
        {
            String query = "SELECT * FROM history WHERE borrow_datetime BETWEEN '"+date1+"' AND '"+date2+" 23:59:59'"; 
           rs = st.executeQuery(query);
            int i=0;
            
            while(rs.next())
            {
               a[i] = new Model_history(); 
                
               a[i].setid(rs.getInt("history_id"));
               a[i].setimei(rs.getNString("imeis"));
               a[i].setemp_id(rs.getInt("employee_ids"));
               a[i].setborrow_date(rs.getDate("borrow_datetime").toString());
               a[i].setlattidude(rs.getDouble("lat"));
               a[i].setlongtidude(rs.getDouble("long"));
               
               i++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Set data Error : "+e);
        }
        return a;
    }
    
    public Model_device[] setdevice(int n, String series)
    {
        Model_device[] a = new Model_device[n];
        
        try
        {
            String query = "SELECT * FROM mobile WHERE device_series = '"+series+"'"; 
           rs = st.executeQuery(query);
            int i=0;
            
            while(rs.next())
            {
               a[i] = new Model_device(); 
                
               a[i].setimei(rs.getNString("imei"));
               a[i].setdevice_name(rs.getNString("device_name"));
               a[i].setdevice_type(rs.getNString("device_type"));
               a[i].setdevice_series(rs.getNString("device_series"));
               a[i].setversion(rs.getNString("version"));
               a[i].setcolor(rs.getNString("color"));
               a[i].setdpi_h(rs.getNString("dpi_h"));
               a[i].setdpi_w(rs.getNString("dpi_w"));
               a[i].setos(rs.getNString("os"));
               a[i].setlattidude(rs.getNString("lat"));
               a[i].setlongtidude(rs.getNString("long"));
               a[i].setstatus(rs.getNString("status"));
               a[i].setdate(rs.getDate("update_datetime").toString());
               a[i].settime(rs.getTime("update_datetime").toString());
               
               i++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Set data Error : "+e);
        }
        return a;
    }
    
    public String[] getData(Model_admin a) throws SQLException
    {
        int n = 0, j=0;
        String data[] = new String[3];
       
            int temp = a.getid();
            
            //get:ID
            data[0] =  Integer.toString(temp);
            //get:Username
            data[1] = a.getusername();
            //get:Password
            data[2] = a.getpassword();
            
        return data;
    }
    
    public String[] gethistoryData(int i, Model_history[] a) throws SQLException
    {
        int all = i*6;
        int n = 0, j=0;
        String data[] = new String[all];
        
        while(n<all)
        {
            data[n] =  Integer.toString(a[j].getid());
            n++;
            
            data[n] = a[j].getimei();
            n++;
            
            data[n] = Integer.toString(a[j].getemp_id());
            n++;
            
            data[n] = a[j].getborrow_date();
            n++;
            
            data[n] = Double.toString(a[j].getlattidude());
            n++;
            
            data[n] = Double.toString(a[j].getlongtidude());
            n++;
            
            j++;
        }
        
        return data;
    }
    
    public String[] getdeviceData(int i, Model_device[] a) throws SQLException
    {
        int all = i*14;
        int n = 0, j=0;
        String data[] = new String[all];
        
        while(n<all)
        {
            data[n] = a[j].getimei(); //1
            n++;
            
            data[n] = a[j].getdevice_name(); //2
            n++;
            
            data[n] = a[j].getdevice_type(); //2
            n++;
            
            data[n] = a[j].getdevice_series(); //3
            n++;
            
            data[n] = a[j].getversion(); //4
            n++;
            
            data[n] = a[j].getcolor(); //5
            n++;
            
            data[n] = a[j].getdpi_h(); //6
            n++;
            
            data[n] = a[j].getdpi_w(); //7
            n++;
            
            data[n] = a[j].getos(); //8
            n++;
            
            data[n] = a[j].getlattidude(); //9
            n++;
            
            data[n] = a[j].getlongtidude(); //10
            n++;
            
            data[n] = a[j].getstatus(); //11
            n++;
            
            data[n] = a[j].getdate(); //12
            n++;
            
            data[n] = a[j].gettime(); //13
            n++;
                        
            j++;
        }
        
        return data;
    }
    
    public String insertemployee(String identify, String prefixth, String prefixen, 
                                 String nameth, String nameen, String lastnameth, String lastnameen, String nickname)
    {
        String m = "";
        try
        {
        String sql = "INSERT INTO employee "
                        +  " VALUES ('" + identify + "', '" + prefixth +"', '" + nameth +"', '" + lastnameth +"', '" 
                        + nickname +"', '" + prefixen +"', '" + nameen +"', '" + lastnameen +"')";
                st.executeUpdate(sql);
                m = "Insert " + nameen + " complete";
        }
        catch(Exception e)
        {
            m = ("Insert Error : "+e);
        }
        return m;
    }
    
    public void close()
    {
        try {
            if(rs != null) {
            rs.close();
            rs = null;
            }
            if(st != null) {
            st.close();
            st = null;
            }
            if(conn != null) {
            conn.close();
            conn = null;
            }
            } catch (SQLException e) {}
    }
}
