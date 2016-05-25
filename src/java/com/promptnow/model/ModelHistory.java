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
public class ModelHistory
{
    private int id;
    private String imei;
    private int emp_id;
    private String borrow_date;
    private double lattidude;
    private double longtidude;

    public void setid(int i) {
        this.id = i;
    }

    public void setimei(String i) {
        this.imei = i;
    }

    public void setemp_id(int i) {
        this.emp_id = i;
    }
    
    public void setborrow_date(String i) {
        this.borrow_date = i;
    }

    public void setlattidude(double i) {
        this.lattidude = i;
    }

    public void setlongtidude(double i) {
        this.longtidude = i;
    }

    public int getid() {
        return id;
    }

    public String getimei() {
        return imei;
    }

    public int getemp_id() {
        return emp_id;
    }
    
    public String getborrow_date() {
        return borrow_date;
    }

    public double getlattidude() {
        return lattidude;
    }

    public double getlongtidude() {
        return longtidude;
    }
}
