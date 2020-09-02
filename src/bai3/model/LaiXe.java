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
public class LaiXe implements Serializable{
    private int maLX;
    private String hoTen;
    private String diaChi;
    private String trinhDo;

    public LaiXe() {
    }
    
    public LaiXe(int maLX, String hoTen, String diaChi, String trinhDo) {
        this.maLX = maLX;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.trinhDo = trinhDo;
    }

    public int getMaLX() {
        return maLX;
    }

    public void setMaLX(int maLX) {
        this.maLX = maLX;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }
    public Object[] toObjects(){
        return new Object[]{maLX,hoTen,diaChi,trinhDo};
    }
    
}
