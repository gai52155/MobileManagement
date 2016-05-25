/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promptnow.model;

/**
 *
 * @author Katawut
 */
public class ModelDevice 
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
    
    public void setimei(String i) { this.imei = i; }
    
    public void setdevice_name(String i) { this.device_name = i; }
    
    public void setdevice_type(String i) { this.device_type = i; }
    
    public void setdevice_series(String i) { this.device_series = i; }
    
    public void setversion(String i) { this.version = i; }
    
    public void setcolor(String i) { this.color = i; }
    
    public void setdpi_h(String i) { this.dpi_h = i; }
    
    public void setdpi_w(String i) { this.dpi_w = i; }
    
    public void setos(String i) { this.os = i; }
    
    public void setlattidude(String i) { this.lattidude = i; }
    
    public void setlongtidude(String i) { this.longtidude = i;}
    
    public void setstatus(String i) { this.status = i; }
    
    public void setdate(String i) { this.date = i; }
    
    public void settime(String i) { this.time = i; }
    
    public String getimei() { return imei; }

    public String getdevice_name() { return device_name; }
    
    public String getdevice_type() { return device_type; }
    
    public String getdevice_series() { return device_series; }

    public String getversion() { return version; }
    
    public String getcolor() { return color; }

    public String getdpi_h() { return dpi_h; }
    
    public String getdpi_w() { return dpi_w; }

    public String getos() { return os; }
    
    public String getlattidude() { return lattidude; }

    public String getlongtidude() { return longtidude; }
    
    public String getstatus() { return status; }
    
    public String getdate() { return date; }

    public String gettime() { return time; }
}
