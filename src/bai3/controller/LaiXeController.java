/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.controller;

import bai3.model.LaiXe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class LaiXeController {
    String path = "LX.DAT";
    public ArrayList<LaiXe> getAllLaiXe(){
        ArrayList<LaiXe> listLaiXe = new ArrayList<LaiXe>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o;
            while((o = ois.readObject())!=null){
                listLaiXe.add((LaiXe) o);
            }
            ois.close();
        } catch (Exception e){
            
//            e.printStackTrace();
        }
        return listLaiXe;
    }
    public void saveToFile(ArrayList<LaiXe> listLaiXe){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println(listLaiXe.size());
            for(LaiXe lx : listLaiXe){
                oos.writeObject(lx);
            }
            oos.close();
        } catch (Exception e){
//            e.printStackTrace();
        }
        
    }
}
