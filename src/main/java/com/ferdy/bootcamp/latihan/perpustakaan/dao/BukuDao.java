/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.dao;

import com.ferdy.bootcamp.latihan.perpustakaan.config.KoneksiDatabase;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Buku;
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
public class BukuDao {

    public void save(Buku x) throws SQLException {
        KoneksiDatabase koneksiDb = new KoneksiDatabase();
        DataSource dataSource = koneksiDb.getDataSource();
        Connection connection = dataSource.getConnection();
        
        //language=Postgresql
        String sql = "INSERT INTO perpus.buku (judul_buku, tahun_terbit,pengarang, jumlah_buku) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, x.getJudulBuku());
        statement.setInt(2, x.getTahunTerbit());
        statement.setString(3, x.getPengarang());
        statement.setInt(4, x.getJumlahBuku());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Buku x) throws SQLException {
        KoneksiDatabase koneksiDb = new KoneksiDatabase();
        DataSource dataSource = koneksiDb.getDataSource();
        Connection connection = dataSource.getConnection();
        
        //language=Postgresql
        String sql = "UPDATE perpus.buku SET judul_buku=?, tahun_terbit=?, pengarang=?, jumlah_buku=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, x.getJudulBuku());
        statement.setInt(2, x.getTahunTerbit());
        statement.setString(3, x.getPengarang());
        statement.setInt(4, x.getJumlahBuku());
        statement.setInt(5, x.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idBuku) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "delete from perpus.buku where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, idBuku);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
        
    }

    public List<Buku> findAll() throws SQLException {
        List<Buku> listBuku = new ArrayList<>();

        //inisialisasi koneksi ke database
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        
        //execute database query
        String sql = "select * from perpus.buku order by id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Buku buku = new Buku();
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            listBuku.add(buku);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listBuku;
    }

    public Buku findById(Integer idBuku) throws SQLException {
        //inisialisasi koneksi ke database
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        
        //execute database query
        String sql = "select * from perpus.buku where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idBuku);
        ResultSet resultSet = statement.executeQuery();
        Buku buku = new Buku();
        if (resultSet.next()){ 
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return buku;
    }
}
