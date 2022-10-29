/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import kasir.Model.Order;
import kasir.Model.Produk;

/**
 *
 * @author AudiAdyan
 */
public class BerandaController {
    private final String filePath = "src/kasir/Struk.txt";
    private final int lebarStruk = 50;
    private ArrayList<Order> orders = new ArrayList<Order>();
    
    public void addListItem(Produk produk) {
        orders.add(new Order(produk));
    }
    
    public Order getLastOrders() {
        return orders.get(orders.size() - 1);
    }
    
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    public void clearOrders() {
        orders.clear();
    }
    
    public int getTotalHarga() {
        int total = 0;
        for(Order order : orders) {
            total += order.getHargaTotal();
        }
        return total;
    }
    
    public boolean printStruk() {
        if(orders.size() == 0) {
            return false;
        } else {
            String struk = 
                    getTimes(lebarStruk) + "\n" +
                    centerText("Struk Belanja", lebarStruk) + "\n" +
                    getTimes(lebarStruk) + "\n" +
                    String.format("|%-20s %3s   %9s   %9s|\n", "Barang", "Jlh", "Satuan", "Total");
        
            for(Order order : orders) {
                struk += String.format("|%-20s %3d   Rp %6d   Rp %6d|\n", order.getProduk().getNama(), order.getJumlah(), order.getProduk().getHarga(), order.getHargaTotal());
            }

            struk +=
                    getTimes(lebarStruk) + "\n" +
                    String.format("|%-20s %27d|\n", "Total Barang", orders.size()) +
                    String.format("|%-20s %20s %6d|\n", "Total Harga", "Rp", getTotalHarga()) +
                    getTimes(lebarStruk);

            try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath, false))) {
                out.write(struk);
                out.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
    }
    
    private String getTimes(int x) {
        String line = "";
        for(int i = 0; i < x; i++) {
            if(i == 0 || i == x-1) {
                line += "+";
            } else {
                line += "-";
            }
        }
        return line;
    }
    
    private String centerText(String text, int x) {
        String temp = "";
        int y = x - text.length();
        for(int i = 0; i <= y; i++) {
            if(i == 0 || i == y) temp += "|";
            else if(i == y/2) temp += text;
            else temp += " ";
        }
        return temp;
    }
}
