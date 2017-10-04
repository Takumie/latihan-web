/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author LENOVO
 */
public class KoneksiDatabase {
    private final static String url="jdbc:postgresql://localhost:5432/Bootcamp_2";
    private final static String username="Bootcamp_2";
    private final static String password="ferdywardianto";
    
    public DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }
    
//    public static void main(String[] args) throws SQLException {
//        KoneksiDatabase konekDb = new KoneksiDatabase();
//        konekDb.getDataSource().getConnection();
//    }
}
