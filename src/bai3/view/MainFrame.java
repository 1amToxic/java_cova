/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.view;

import bai3.controller.LaiXeController;
import bai3.controller.TuyenController;
import bai3.model.*;
import bai3.controller.PhanCongController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lamit
 */
public class MainFrame extends javax.swing.JFrame {
    int idLaiXe=10000,idTuyen=100;
    ArrayList<LaiXe> listLaiXe;
    ArrayList<Tuyen> listTuyen;
    ArrayList<BangPhanCong> listBangPhanCong;
    LaiXeController laixeController = new LaiXeController();
    TuyenController tuyenController = new TuyenController();
    PhanCongController phanCongController = new PhanCongController();
    DefaultTableModel modelLaiXe,modelTuyen,modelPhanCong,modelSort,modelThongke;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        listLaiXe = laixeController.getAllLaiXe();
        listTuyen = tuyenController.getAllTuyen();
        listBangPhanCong = phanCongController.getAllPhanCong();
        modelLaiXe = (DefaultTableModel) tableLaixe.getModel();
        modelTuyen = (DefaultTableModel) tableTuyen.getModel();
        modelPhanCong = (DefaultTableModel) tablePhanCong.getModel();
        modelSort = (DefaultTableModel) tableSort.getModel();
        modelThongke = (DefaultTableModel) tableThongke.getModel();
        addToRow();
    }
    private void addToRow(){
        cbbLx.removeAllItems();
        cbbTuyen.removeAllItems();
        modelLaiXe.setRowCount(0);
        modelTuyen.setRowCount(0);
        modelPhanCong.setRowCount(0);
        modelSort.setRowCount(0);
        modelThongke.setRowCount(0);
        for(LaiXe lx : listLaiXe){
            cbbLx.addItem(lx.getMaLX()+"");
            modelLaiXe.addRow(lx.toObjects());
        }
        for(Tuyen t : listTuyen){
            cbbTuyen.addItem(t.getMaTuyen()+"");
            modelTuyen.addRow(t.toObjects());
        }
        //tab3
        for(BangPhanCong pc : listBangPhanCong){
            modelSort.addRow(pc.toObjects());
            for(Pair<Tuyen,Integer> p : pc.getDanhSachTuyen()){
                Object[] o = new Object[]{pc.getLaiXe().getMaLX(),pc.getLaiXe().getHoTen(),p.getKey().getMaTuyen(),
                    p.getValue()};
                modelPhanCong.addRow(o);
            }
            modelThongke.addRow(pc.toObjects1());
        }
        if(listLaiXe.size()>0){
            idLaiXe = listLaiXe.get(listLaiXe.size()-1).getMaLX();
        }
        if(listTuyen.size()>0){
           idTuyen = listTuyen.get(listTuyen.size()-1).getMaTuyen();
        }
    }
    private void deleteLaiXe(int maLX){
        int index = 0;
        for(BangPhanCong phanCong : listBangPhanCong){
            if(phanCong.getLaiXe().getMaLX() == maLX){
                listBangPhanCong.remove(phanCong);
                return;
            }
        }
    }
    private void editTuyen(Tuyen tuyen){
        for(BangPhanCong phanCong : listBangPhanCong){
            ArrayList<Pair<Tuyen,Integer>> listPair = new ArrayList<>();
            listPair = phanCong.getDanhSachTuyen();
            for(Pair<Tuyen,Integer> p : phanCong.getDanhSachTuyen()){
                if(p.getKey().getMaTuyen() == tuyen.getMaTuyen()){
                    int index = listPair.indexOf(p);
                    listPair.remove(p);
                    listPair.add(index ,new Pair<>(tuyen,p.getValue()));
                    break;
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLaixe = new javax.swing.JTable();
        btnAddLaixe = new javax.swing.JButton();
        btnDelelteLaixe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfHoten = new javax.swing.JTextField();
        tfDiachi = new javax.swing.JTextField();
        cbbTrinhDo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTuyen = new javax.swing.JTable();
        btnAddTuyen = new javax.swing.JButton();
        btnEditTuyen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfKhoangcach = new javax.swing.JTextField();
        tfDiemdung = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePhanCong = new javax.swing.JTable();
        cbbLx = new javax.swing.JComboBox<>();
        cbbTuyen = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        tfSoluot = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSort = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableThongke = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setText("jTextField1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableLaixe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Lai xe", "Ho ten", "Dia chi", "Trinh do"
            }
        ));
        jScrollPane1.setViewportView(tableLaixe);

        btnAddLaixe.setText("Add");
        btnAddLaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLaixeActionPerformed(evt);
            }
        });

        btnDelelteLaixe.setText("Delete");
        btnDelelteLaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelelteLaixeActionPerformed(evt);
            }
        });

        jLabel1.setText("Họ tên");

        jLabel2.setText("Địa chỉ");

        jLabel3.setText("Trình độ");

        cbbTrinhDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "F" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(btnAddLaixe))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelelteLaixe)
                            .addComponent(cbbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(95, 95, 95)
                                .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelelteLaixe)
                            .addComponent(btnAddLaixe))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lai Xe", jPanel2);

        tableTuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Tuyen", "Khoang cach", "So diem dung"
            }
        ));
        tableTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTuyenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTuyen);

        btnAddTuyen.setText("Add");
        btnAddTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTuyenActionPerformed(evt);
            }
        });

        btnEditTuyen.setText("Edit");
        btnEditTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTuyenActionPerformed(evt);
            }
        });

        jLabel4.setText("Khoảng cách");

        jLabel5.setText("Số điểm dừng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAddTuyen)
                        .addGap(82, 82, 82)
                        .addComponent(btnEditTuyen))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(85, 85, 85)
                            .addComponent(tfDiemdung, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfKhoangcach, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfKhoangcach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDiemdung, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(149, 149, 149)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddTuyen)
                            .addComponent(btnEditTuyen))))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tuyen", jPanel3);

        tablePhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma lai xe", "Ho ten", "Ma tuyen", "So luot"
            }
        ));
        jScrollPane3.setViewportView(tablePhanCong);

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(cbbLx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(cbbTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(tfSoluot, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButton5)
                .addGap(178, 178, 178))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(tfSoluot, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phan Cong", jPanel4);

        tableSort.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "So luong tuyen"
            }
        ));
        jScrollPane4.setViewportView(tableSort);

        jButton1.setText("Sort by name");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Sort by Tuyen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton1)
                        .addGap(80, 80, 80)
                        .addComponent(jButton3)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sap xep", jPanel5);

        tableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "Khoang cach(don vi)"
            }
        ));
        jScrollPane5.setViewportView(tableThongke);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong ke", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddLaixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLaixeActionPerformed
        String hoten,diachi,trinhdo;
        hoten = tfHoten.getText();
        diachi = tfDiachi.getText();
        trinhdo = cbbTrinhDo.getSelectedItem().toString();
        LaiXe lx = new LaiXe(idLaiXe+1, hoten, diachi, trinhdo);
        listLaiXe.add(lx);
        addToRow();
    }//GEN-LAST:event_btnAddLaixeActionPerformed

    private void btnDelelteLaixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelelteLaixeActionPerformed
        int index = tableLaixe.getSelectedRow();
        deleteLaiXe(listLaiXe.get(index).getMaLX());
        listLaiXe.remove(index);
        addToRow();
    }//GEN-LAST:event_btnDelelteLaixeActionPerformed

    private void btnAddTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTuyenActionPerformed
        int khoangCach,diemdung;
        khoangCach = Integer.parseInt(tfKhoangcach.getText());
        diemdung = Integer.parseInt(tfDiemdung.getText());
        Tuyen t = new Tuyen(idTuyen+1, khoangCach, diemdung);
        listTuyen.add(t);
        addToRow();
    }//GEN-LAST:event_btnAddTuyenActionPerformed

    private void btnEditTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTuyenActionPerformed
        int index = tableTuyen.getSelectedRow();
        int idPrevious = listTuyen.get(index).getMaTuyen();
        listTuyen.remove(index);
        int khoangCach,diemdung;
        khoangCach = Integer.parseInt(tfKhoangcach.getText());
        diemdung = Integer.parseInt(tfDiemdung.getText());
        Tuyen t = new Tuyen(idPrevious, khoangCach, diemdung);
        listTuyen.add(index, t);
        editTuyen(t);
        addToRow();
    }//GEN-LAST:event_btnEditTuyenActionPerformed

    private void tableTuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTuyenMouseClicked
        int index = tableTuyen.getSelectedRow();
        Tuyen t = listTuyen.get(index);
        tfKhoangcach.setText(t.getKhoangCach()+"");
        tfDiemdung.setText(t.getSoDiemDung()+"");
    }//GEN-LAST:event_tableTuyenMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        laixeController.saveToFile(listLaiXe);
        tuyenController.saveToFile(listTuyen);
        phanCongController.saveToFile(listBangPhanCong);
    }//GEN-LAST:event_formWindowClosing

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int maLx = Integer.parseInt(cbbLx.getSelectedItem().toString());
        int maT = Integer.parseInt(cbbTuyen.getSelectedItem().toString());
        LaiXe laixe = new LaiXe();
        Tuyen tuyen = new Tuyen();
        for(LaiXe lx : listLaiXe){
            if(lx.getMaLX() == maLx){
                laixe = lx;
                break;
            }
        }
        for(Tuyen t : listTuyen){
            if(t.getMaTuyen() == maT){
                tuyen = t;
                break;
            }
        }
        boolean exist = false;
        for(BangPhanCong pc : listBangPhanCong){
            if(pc.getLaiXe().getMaLX() == maLx){
                ArrayList<Pair<Tuyen,Integer>> list = pc.getDanhSachTuyen();
                for(Pair<Tuyen,Integer> p : list){
                    if(p.getKey().getMaTuyen() == tuyen.getMaTuyen()){
                        JOptionPane.showMessageDialog(this, "Không thể thêm tuyến này cho lái xe này!!!");
                        return;
                    }
                }
                list.add(new Pair<>(tuyen,Integer.parseInt(tfSoluot.getText())));
                pc.setDanhSachTuyen(list);
                exist = true;
                break;
            }
        }
        if(!exist){
            ArrayList<Pair<Tuyen,Integer>> list = new ArrayList<>();
            list.add(new Pair<>(tuyen,Integer.parseInt(tfSoluot.getText())));
            listBangPhanCong.add(new BangPhanCong(laixe, list));
        }
        addToRow();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Collections.sort(listBangPhanCong,new SortByName());
        addToRow();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Collections.sort(listBangPhanCong,new SortByTuyen());
        addToRow();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLaixe;
    private javax.swing.JButton btnAddTuyen;
    private javax.swing.JButton btnDelelteLaixe;
    private javax.swing.JButton btnEditTuyen;
    private javax.swing.JComboBox<String> cbbLx;
    private javax.swing.JComboBox<String> cbbTrinhDo;
    private javax.swing.JComboBox<String> cbbTuyen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableLaixe;
    private javax.swing.JTable tablePhanCong;
    private javax.swing.JTable tableSort;
    private javax.swing.JTable tableThongke;
    private javax.swing.JTable tableTuyen;
    private javax.swing.JTextField tfDiachi;
    private javax.swing.JTextField tfDiemdung;
    private javax.swing.JTextField tfHoten;
    private javax.swing.JTextField tfKhoangcach;
    private javax.swing.JTextField tfSoluot;
    // End of variables declaration//GEN-END:variables
}
class SortByName implements Comparator<BangPhanCong>{

    @Override
    public int compare(BangPhanCong t, BangPhanCong t1) {
        return t.getLaiXe().getHoTen().compareTo(t1.getLaiXe().getHoTen());
    }
    
}
class SortByTuyen implements Comparator<BangPhanCong>{

    @Override
    public int compare(BangPhanCong t, BangPhanCong t1) {
        return t1.getDanhSachTuyen().size() -t.getDanhSachTuyen().size() ;
    }
    
}