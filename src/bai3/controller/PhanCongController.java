/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.controller;

import bai3.model.BangPhanCong;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class PhanCongController {
    String path = "PHANCONg.DAT";
    public ArrayList<BangPhanCong> getAllPhanCong(){
        ArrayList<BangPhanCong> listPhanCong = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o;
            while((o = ois.readObject())!=null){
                listPhanCong.add((BangPhanCong) o);
            }
            ois.close();
        } catch (Exception e){
            
        }
        return listPhanCong;
    }
    public void saveToFile(ArrayList<BangPhanCong> listPhanCong){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(BangPhanCong pc : listPhanCong){
                oos.writeObject(pc);
            }
            oos.close();
        } catch (Exception e){
            
        }
        
    }
    
}

