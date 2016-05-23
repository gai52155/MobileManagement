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
public class Model_admin 
{
    private int id;
    private String username;
    private String password;

    void setid(int i) {
        this.id = i;
    }

    void setusername(String i) {
        this.username = i;
    }

    void setpassword(String i) {
        this.password = i;
    }

    int getid() {
        return id;
    }

    String getusername() {
        return username;
    }

    String getpassword() {
        return password;
    }
}
