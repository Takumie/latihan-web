/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.dao;

import com.ferdy.bootcamp.latihan.perpustakaan.config.KoneksiDatabase;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Buku;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Pengunjung;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Transaksi;
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
public class TransaksiDao {

    public void pinjamBuku(Transaksi x) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        String sql = "insert into perpus.transaksi (buku_id, pengunjung_id, tanggal_pinjam) VALUES (?,?,now())";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x.getBuku().getId());
        preparedStatement.setInt(2, x.getPengunjung().getId());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = "update perpus.buku SET jumlah_buku = ? WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x.getBuku().getJumlahBuku() - 1);
        preparedStatement.setInt(2, x.getBuku().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
        connection.close();
    }

    public List<Transaksi> daftarTransaksi() throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "SELECT b.id as id_buku, b.judul_buku as judul_buku, b.jumlah_buku as jumlah_buku, b.pengarang as nama_pengarang, b.tahun_terbit as tahun_terbit, p.id as id_pengunjung, p.nama as nama_pengunjung,p.alamat as alamat_pengunjung, t.id as id_transaksi, t.tanggal_pinjam as tanggal_pinjam, t.tanggal_kembali as tanggal_kembali FROM perpus.buku b JOIN perpus.transaksi t ON b.id = t.buku_id JOIN perpus.pengunjung p ON t.pengunjung_id = p.id";

        List<Transaksi> listTransaksi = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            Transaksi transaksi = new Transaksi();

            transaksi.setBuku(new Buku(
                    resultSet.getInt("id_buku"),
                    resultSet.getString("judul_buku"),
                    resultSet.getInt("jumlah_buku"),
                    resultSet.getString("nama_pengarang"),
                    resultSet.getInt("tahun_terbit")
            ));

            transaksi.setPengunjung(new Pengunjung(
                    resultSet.getInt("id_pengunjung"),
                    resultSet.getString("nama_pengunjung"),
                    resultSet.getString("alamat_pengunjung")
            ));
            transaksi.setId(resultSet.getInt("id_transaksi"));
            transaksi.setTanggalPinjam(resultSet.getDate("tanggal_pinjam"));
            transaksi.setTanggalKembali(resultSet.getDate("tanggal_kembali"));
            
            listTransaksi.add(transaksi);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listTransaksi;
    }
}
