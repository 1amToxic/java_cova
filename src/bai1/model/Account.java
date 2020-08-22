/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.model;

/**
 *
 * @author lamit
 */
public class Account {
    private String username;
    private String password;
    private int role;

    public Account(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int checkUserLogin(Account u){
        if(this.username.equals(u.username) && this.password.equals(u.password)){
            return this.role;
        }
        else return -1;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
    
}
