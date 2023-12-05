/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class KetNoiDB {
  
    public static Connection getConnection() {
		try {
			String URL = "jdbc:mysql://localhost:3306/qlsv";
			String USER = "root";
			String PASS = "2801";
			return DriverManager.getConnection(URL, USER,PASS );
		} catch ( SQLException e) {
			return null;
		}
	}
}
