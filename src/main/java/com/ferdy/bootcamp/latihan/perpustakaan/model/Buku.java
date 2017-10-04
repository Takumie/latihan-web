/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.model;

import lombok.Data;

/**
 *
 * @author LENOVO
 */

@Data
public class Buku {
    private Integer id;
    private String judulBuku;
    private Integer tahunTerbit;
    private String pengarang;
    private Integer jumlahBuku;   
    
}
