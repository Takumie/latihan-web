/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.controller;

import com.ferdy.bootcamp.latihan.perpustakaan.model.Buku;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */

@WebServlet(urlPatterns="/buku/new")
public class BukuAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/buku/tambahBuku.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Buku buku = new Buku();
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
    }
    
    
}
