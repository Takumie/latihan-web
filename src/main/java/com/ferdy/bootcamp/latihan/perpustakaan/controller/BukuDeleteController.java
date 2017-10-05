/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.controller;

import com.ferdy.bootcamp.latihan.perpustakaan.dao.BukuDao;
import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet(urlPatterns = "/buku/delete")
public class BukuDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer kodeBuku  = Integer.valueOf(req.getParameter("kodeBuku"));
        try {
            new BukuDao().delete(kodeBuku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/buku/");
    }
    
}
