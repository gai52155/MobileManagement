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
public class ModelAdmin 
{
    private int id;
    private String username;
    private String password;

    public void setid(int i) {
        this.id = i;
    }

    public void setusername(String i) {
        this.username = i;
    }

    public void setpassword(String i) {
        this.password = i;
    }

    public int getid() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }
}
