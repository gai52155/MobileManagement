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
public class Model_history
{
    private int id;
    private String imei;
    private int emp_id;
    private String borrow_date;
    private double lattidude;
    private double longtidude;

    void setid(int i) {
        this.id = i;
    }

    void setimei(String i) {
        this.imei = i;
    }

    void setemp_id(int i) {
        this.emp_id = i;
    }
    
    void setborrow_date(String i) {
        this.borrow_date = i;
    }

    void setlattidude(double i) {
        this.lattidude = i;
    }

    void setlongtidude(double i) {
        this.longtidude = i;
    }

    int getid() {
        return id;
    }

    String getimei() {
        return imei;
    }

    int getemp_id() {
        return emp_id;
    }
    
    String getborrow_date() {
        return borrow_date;
    }

    double getlattidude() {
        return lattidude;
    }

    double getlongtidude() {
        return longtidude;
    }
}
