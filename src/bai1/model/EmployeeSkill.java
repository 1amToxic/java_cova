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
public class EmployeeSkill {
    private int eid;
    private String sid;

    public EmployeeSkill(int eid, String sid) {
        this.eid = eid;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return eid +" " + sid + "\n";
    }
    
    
}
