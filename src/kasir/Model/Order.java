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
public class Order {
    private Produk produk;
    private int jumlah = 1;
    
    public Order(Produk produk) {
        this.produk = produk;
    }
    
    public void addJumlah() {
        jumlah++;
    }
    
    public void minJumlah() {
        if(jumlah > 0) jumlah--;
    }
    
    public Produk getProduk() {
        return produk;
    }
    
    public int getJumlah() {
        return jumlah;
    }
    
    public int getHargaTotal() {
        return produk.getHarga()*jumlah;
    }
}
