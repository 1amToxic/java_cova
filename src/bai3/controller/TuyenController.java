/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.controller;

import bai3.model.Tuyen;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author lamit
 */
public class TuyenController {
    String path = "TUYEN.DAT";
    public ArrayList<Tuyen> getAllTuyen(){
        ArrayList<Tuyen> listTuyen = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o;
            while((o = ois.readObject())!=null){
                listTuyen.add((Tuyen) o);
            }
            ois.close();
        } catch (Exception e){
//            e.printStackTrace();
        }
        return listTuyen;
    }
    public void saveToFile(ArrayList<Tuyen> listTuyen){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Tuyen t : listTuyen){
                oos.writeObject(t);
            }
            oos.close();
        } catch (Exception e){
//            e.printStackTrace();
        } 
        
    }
}
