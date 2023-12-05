/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhjava;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class SinhVien {
    private String MSSV, hoTen , gioiTinh, nganh, khoa;
    private Date ngaySinh;

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNganh() {
        return nganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
}
