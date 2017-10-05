/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdy.bootcamp.latihan.perpustakaan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LENOVO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pengunjung {
    private Integer id;
    private String nama;
    private String alamat;    
    
}
