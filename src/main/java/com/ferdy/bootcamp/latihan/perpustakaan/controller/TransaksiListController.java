/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.controller;

import com.ferdy.bootcamp.latihan.perpustakaan.dao.TransaksiDao;
import com.ferdy.bootcamp.latihan.perpustakaan.model.Transaksi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */

@WebServlet(urlPatterns = {"/transaksi/","/transaksi/list"})
public class TransaksiListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
            List<Transaksi> listTransaksi = new TransaksiDao().daftarTransaksi();
            req.setAttribute("listTransaksi", listTransaksi);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.getRequestDispatcher("/pages/transaksi/listTransaksi.jsp").forward(req, resp);
    }
    
}
