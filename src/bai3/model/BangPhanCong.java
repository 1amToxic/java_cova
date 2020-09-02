/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.model;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author lamit
 */
public class BangPhanCong implements Serializable{
    private LaiXe laiXe;
    private ArrayList<Pair<Tuyen,Integer>> danhSachTuyen;

    public BangPhanCong(LaiXe laiXe, ArrayList<Pair<Tuyen, Integer>> danhSachTuyen) {
        this.laiXe = laiXe;
        this.danhSachTuyen = danhSachTuyen;
    }

    public LaiXe getLaiXe() {
        return laiXe;
    }
    
    public ArrayList<Pair<Tuyen, Integer>> getDanhSachTuyen() {
        return danhSachTuyen;
    }

    public void setDanhSachTuyen(ArrayList<Pair<Tuyen, Integer>> danhSachTuyen) {
        this.danhSachTuyen = danhSachTuyen;
    }
    public Object[] toObjects(){
        return new Object[]{laiXe.getHoTen(),danhSachTuyen.size()};
    }
    public Object[] toObjects1(){
        int sum = 0;
        for(Pair<Tuyen,Integer> p : danhSachTuyen){
            sum+=p.getKey().getKhoangCach()*p.getValue();
        }
        return new Object[]{laiXe.getHoTen(),sum};
    }
}
