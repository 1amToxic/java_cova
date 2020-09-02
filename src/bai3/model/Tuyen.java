/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.model;

import java.io.Serializable;

/**
 *
 * @author lamit
 */
public class Tuyen implements Serializable{
    private int maTuyen;
    private int khoangCach;
    private int soDiemDung;

    public Tuyen() {
    }

    
    
    public Tuyen(int maTuyen, int khoangCach, int soDiemDung) {
        this.maTuyen = maTuyen;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    
    
    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }
    public Object[] toObjects(){
        return new Object[]{maTuyen,khoangCach,soDiemDung};
    }
    
}
