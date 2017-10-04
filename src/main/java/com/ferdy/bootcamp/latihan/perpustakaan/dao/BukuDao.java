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
import java.sql.SQLException;
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

    public void update() {
    }

    public void delete() {
    }

    public List<Buku> findAll() {
        return null;
    }

    public Buku findById(Integer idBuku) {
        return null;
    }
}
