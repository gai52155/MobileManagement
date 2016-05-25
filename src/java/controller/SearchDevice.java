package controller;

import com.promptnow.model.ModelDevice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class LoginController
 */
public class SearchDevice extends BaseService {

    @Override
    void process(DBCommand connect) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String series = request.getParameter("series");
        int n = 0; //COUNT

        try {
            n = connect.getdeviceCount(series);
        } catch (Exception e) {
            System.out.println("GetCount Error: " + e);
        }
        System.out.println(n);
        ModelDevice model[] = new ModelDevice[n];
        String data[] = new String[n * 14];

        JSONObject obj[] = new JSONObject[n];
        JSONArray jsonArray = new JSONArray();

        try {
            model = connect.setdevice(n, series);
            data = connect.getdeviceData(n, model);
        } catch (Exception e) {
            System.out.println("SET OR GET Error : " + e);
        }

        try {
            for (int i = 0; i < n; i++) {

                obj[i] = new JSONObject();

                int col1 = 0 + (14 * i);
                int col2 = 1 + (14 * i);
                int col3 = 2 + (14 * i);
                int col4 = 3 + (14 * i);
                int col5 = 4 + (14 * i);
                int col6 = 5 + (14 * i);
                int col7 = 6 + (14 * i);
                int col8 = 7 + (14 * i);
                int col9 = 8 + (14 * i);
                int col10 = 9 + (14 * i);
                int col11 = 10 + (14 * i);
                int col12 = 11 + (14 * i);
                int col13 = 12 + (14 * i);
                int col14 = 13 + (14 * i);

                obj[i].put("imei", data[col1]);
                obj[i].put("device_name", data[col2]);
                obj[i].put("device_type", data[col3]);
                obj[i].put("device_series", data[col4]);
                obj[i].put("version", data[col5]);
                obj[i].put("color", data[col6]);
                obj[i].put("dpi_h", data[col7]);
                obj[i].put("dpi_w", data[col8]);
                obj[i].put("os", data[col9]);
                obj[i].put("lat", data[col10]);
                obj[i].put("long", data[col11]);
                obj[i].put("status", data[col12]);
                obj[i].put("date", data[col13]);
                obj[i].put("time", data[col14]);

                jsonArray.put(obj[i]);
            }
        } catch (JSONException e) {
            System.out.println("JSON ERROR : " + e);
        }
        response.getWriter().write(jsonArray.toString());
    }
}
