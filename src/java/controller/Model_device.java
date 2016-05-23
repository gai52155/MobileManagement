/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Katawut
 */
public class Model_device 
{
    private String imei;
    private String device_name;
    private String device_type;
    private String device_series;
    private String version;
    private String color;
    private String dpi_h;
    private String dpi_w;
    private String os;
    private String lattidude;
    private String longtidude;
    private String status;
    private String date;
    private String time;
    
    void setimei(String i) { this.imei = i; }
    
    void setdevice_name(String i) { this.device_name = i; }
    
    void setdevice_type(String i) { this.device_type = i; }
    
    void setdevice_series(String i) { this.device_series = i; }
    
    void setversion(String i) { this.version = i; }
    
    void setcolor(String i) { this.color = i; }
    
    void setdpi_h(String i) { this.dpi_h = i; }
    
    void setdpi_w(String i) { this.dpi_w = i; }
    
    void setos(String i) { this.os = i; }
    
    void setlattidude(String i) { this.lattidude = i; }
    
    void setlongtidude(String i) { this.longtidude = i;}
    
    void setstatus(String i) { this.status = i; }
    
    void setdate(String i) { this.date = i; }
    
    void settime(String i) { this.time = i; }
    
    String getimei() { return imei; }

    String getdevice_name() { return device_name; }
    
    String getdevice_type() { return device_type; }
    
    String getdevice_series() { return device_series; }

    String getversion() { return version; }
    
    String getcolor() { return color; }

    String getdpi_h() { return dpi_h; }
    
    String getdpi_w() { return dpi_w; }

    String getos() { return os; }
    
    String getlattidude() { return lattidude; }

    String getlongtidude() { return longtidude; }
    
    String getstatus() { return status; }
    
    String getdate() { return date; }

    String gettime() { return time; }
}
