/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhjava;

/**
 *
 * @author DELL
 */
public class KetQua { 
    
    private double diem;
    private String namHoc, hocKi,maMH,MSSV ;

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }

    public double getDiem() {
        return diem;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public String getHocKi() {
        return hocKi;
    }
}
