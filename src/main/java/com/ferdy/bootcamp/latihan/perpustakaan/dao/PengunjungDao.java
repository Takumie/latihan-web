/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.dao;

import com.ferdy.bootcamp.latihan.perpustakaan.config.KoneksiDatabase;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Pengunjung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author LENOVO
 */
public class PengunjungDao {

    public List<Pengunjung> findAll() throws SQLException {
        List<Pengunjung> listPengunjung = new ArrayList<>();
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "SELECT id, nama, alamat FROM perpus.pengunjung";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Pengunjung pengunjung = new Pengunjung();
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
            listPengunjung.add(pengunjung);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listPengunjung;
    }
    
    public void save(){
    
    }
    
    public void update(){
    
    }
    
    public void hapus(){
    
    }

    public Pengunjung findById(Integer x) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "SELECT id, nama, alamat FROM perpus.pengunjung WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, x);
        ResultSet resultSet = statement.executeQuery();
        
        Pengunjung pengunjung = new Pengunjung();
        if (resultSet.next()) {
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return pengunjung;
    }
    
    
}
