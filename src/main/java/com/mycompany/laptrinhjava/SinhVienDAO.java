/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SinhVienDAO extends KetNoiDB{
    public static List<SinhVien> findAll() {
        List<SinhVien> result = new ArrayList<>();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null ;
        String sql = "SELECT * FROM sinhvien order by mssv";
        try {
            c= getConnection();
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("mssv"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setNganh(rs.getString("nganh"));
                sv.setKhoa(rs.getString("khoa"));
                result.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(c != null){
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    return result ;
    }
    
    public static void themSV(String mssv, String hoTen, String gioiTinh, String ngaySinh, String nganh, String khoa){
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into sinhvien values(?,?,?,?,?,?)";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, mssv);
            ps.setString(2, hoTen);
            ps.setString(3, gioiTinh);
            ps.setString(4, ngaySinh);
            ps.setString(5, nganh);
            ps.setString(6, khoa);
            ps.executeUpdate();
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
    
}
     
        public static void nhapKetQua(String maMH, String MSSV,String diem,String namHoc, String hocKi,String diemChu){
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into ketqua values(?,?,?,?,?,?);";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.setString(2, MSSV);
            ps.setString(3, diem);
            ps.setString(4, namHoc);
            ps.setString(5, hocKi);
            ps.setString(6, diemChu);
            ps.executeUpdate();
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
    
}
        
        public static KetQua kiemTraKetQua(String maMH, String MSSV,String namHoc, String hocKi){
        KetQua kq = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs =null ;
        String sql = "select * from ketqua where mamh like ? and mssv like ?  and namhoc like ? and hocki like ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.setString(2, MSSV);
            ps.setString(3, namHoc);
            ps.setString(4, hocKi);
            rs=ps.executeQuery();
            while(rs.next()){
                kq=new KetQua();
                kq.setMaMH(rs.getString("mamh"));
                kq.setMSSV(rs.getString("mssv"));
                kq.setNamHoc(rs.getString("namhoc"));
                kq.setHocKi(rs.getString("hocki"));
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
        return kq;
}
        
        public static List<BangDiem> layBangDiemTheoMSSV(String mssv,String namHoc, String hocKi){
        List<BangDiem> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs =null ;
        String sql = "select a.mamh,b.tenmh,a.diem,a.diemchu from ketqua a,monhoc b,sinhvien c "
                + "where a.mamh=b.mamh and a.mssv = c.mssv and a.hocki = ? and a.namhoc = ? and c.mssv= ?;";
                
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, hocKi);
            ps.setString(2, namHoc);
            ps.setString(3, mssv);
            rs=ps.executeQuery();
            while(rs.next()){
                BangDiem bd =new BangDiem();
                bd.setMaMH(rs.getString("mamh"));
                bd.setTenMH(rs.getString("tenmh"));
                bd.setDiem(rs.getFloat("diem"));
                bd.setDiemChu(rs.getString("diemchu"));
                result.add(bd);
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
        return result ;
        }
        
        
        public static void xoaSV(String mssv){
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "delete from sinhvien where mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, mssv);
            ps.executeUpdate();
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
        }
        
    public static List<SinhVien> timKiemSV(String mssv, String hoten,String index){
        List<SinhVien> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select * from sinhvien where  mssv like ? or hoten like ? limit 5 offset ?";
        int i = (Integer.parseInt(index)-1)*5;
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1,"%"+mssv+"%");
            ps.setString(2,"%"+hoten+"%");
            ps.setInt(3,i);
            rs=ps.executeQuery();
            while(rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("mssv"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setNganh(rs.getString("nganh"));
                sv.setKhoa(rs.getString("khoa"));
                result.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return result ;
        }
    
    
    public static void suaDiem(String mssv,String mamh,String diem,String diemChu){
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "update ketqua set diem = ?,diemchu=? where mamh = ? and mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, diem);
            ps.setString(2, diemChu);
            ps.setString(3, mamh);
            ps.setString(4, mssv);
            ps.executeUpdate();
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
    }
    
    public static void xoaDiem(String mssv,String mamh){
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "delete from ketqua where mamh = ? and mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, mamh);
            ps.setString(2, mssv);
            ps.executeUpdate();
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
    }
    
     public static void suaSV(String mssv,String hoten,String gioitinh,String ngaysinh,String nganh,String khoa){
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "update sinhvien set hoten=?,gioitinh=?,ngaysinh=?,nganh=?,khoa=? where mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, hoten);
            ps.setString(2, gioitinh);
            ps.setString(3, ngaysinh);
            ps.setString(4, nganh);
            ps.setString(5, khoa);
            ps.setString(6, mssv);
            ps.executeUpdate();
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
    }
   
    public static List<MonHoc> layMonHoc(){
        List<MonHoc> result = new ArrayList<>();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null ;
        String sql = "select * from monhoc";
        try {
            c= getConnection();
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("mamh"));
                mh.setTenMH(rs.getString("tenmh"));
                result.add(mh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(c != null){
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    return result ;
    }
    
    public static List<KetQua> layKQCuaSV(String mssv){
        List<KetQua> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs =null ;
        String sql = "SELECT * FROM ketqua where mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, mssv);
            rs=ps.executeQuery();
            while(rs.next()){
                KetQua kq =new KetQua();
                kq.setMaMH(rs.getString("mamh"));
                kq.setMSSV(rs.getString("mssv"));
                kq.setDiem(rs.getFloat("diem"));
                kq.setNamHoc(rs.getString("namhoc"));
                kq.setHocKi(rs.getString("hocki"));
                result.add(kq);
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
        return result;
    }
    
    public static List<SinhVien> lay5SV(String index) {
        List<SinhVien> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "SELECT * FROM sinhvien order by mssv limit 5 offset ?";
        int indexI = (Integer.parseInt(index)-1)*5;
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setInt(1,indexI);
            rs=ps.executeQuery();
            while(rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("mssv"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setNganh(rs.getString("nganh"));
                sv.setKhoa(rs.getString("khoa"));
                result.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    return result ;
    }
    
    public static String layTongSoSV(){
        String tongSV = null;
        Connection c = null;
        Statement st = null;
        ResultSet rs = null ;
        String sql = "Select count(mssv) from sinhvien";
        try {
            c= getConnection();
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                tongSV = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(c != null){
                try {
                    c.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return tongSV;
    }
    
    public static String layTongSoSVTimKiem(String searchTXT){
        String tongSV = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "Select count(mssv) from sinhvien where mssv like ? or hoten like ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, "%"+searchTXT+"%");
            ps.setString(2, "%"+searchTXT+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                tongSV = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return tongSV;
    }
    public static SinhVien laySV(String mssv){
        SinhVien sv = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select * from sinhvien where mssv = ?";
        try {
            c= getConnection();
            ps=c.prepareStatement(sql);
            ps.setString(1, mssv);
            rs=ps.executeQuery();
            while(rs.next()){
                sv=new SinhVien();
                sv.setMSSV(rs.getString("mssv"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setGioiTinh(rs.getString("gioitinh"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setNganh(rs.getString("nganh"));
                sv.setKhoa(rs.getString("khoa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    return sv ;
    }
}

