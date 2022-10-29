/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.Model;

/**
 *
 * @author AudiAdyan
 */
public class Produk {
    private String nama;
    private int harga;
    
    public Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getHarga() {
        return harga;
    }
}
