/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhjava;

import static com.mycompany.laptrinhjava.KetNoiDB.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class TaiKhoanDAO extends KetNoiDB{
    public static TaiKhoan kiemTraTaiKhoan(String taiKhoan,String matKhau){
        TaiKhoan acc = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs =null ;
        String sql = "select * from taikhoan where taikhoan = ? and matkhau = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            rs=ps.executeQuery();
            while(rs.next()){
              acc = new TaiKhoan();
              acc.setId(rs.getLong("id"));
              acc.setTaiKhoan(rs.getString("taikhoan"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(c != null){
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return acc;
    }
}
