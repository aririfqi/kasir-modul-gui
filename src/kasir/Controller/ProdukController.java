/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.Controller;

import java.util.ArrayList;
import kasir.Model.Produk;

/**
 *
 * @author AudiAdyan
 */
public class ProdukController {
    private ArrayList<Produk> listProduk = new ArrayList<Produk>();
    
    public void addProduk(Produk produk) {
        listProduk.add(produk);
    }
    
    public ArrayList<Produk> getAllProduk() {
        return listProduk;
    }
}
