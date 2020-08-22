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
public class Skill {
    private int id;
    private String name;

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " "+name+"\n";
    }
    
    
    
    public Object[] toObjects(){
        return new Object[]{id,name};
    }
}
