/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lab Informatika
 */
public class modeltabeldatabuku extends AbstractTableModel{
    
    List<databuku> db;
    public modeltabeldatabuku(List<databuku>db){
        this.db = db;
    }

    @Override
    public int getRowCount() {
         return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama Penyewa";
            case 2:
                return "Judul Buku";
            case 3:
                return "Jenis Buku";
            case 4:
                return "Nomor Telepon";
            case 5:
                return "Durasi Biaya"; 
            case 6:
                return "Total Biaya"; 
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return db.get(row).getId();
            case 1:
                return db.get(row).getNama();
            case 2:
                return db.get(row).getJudul();
            case 3:
                return db.get(row).getJenis();
            case 4:
                return db.get(row).getNomor();
            case 5:
                return db.get(row).getDurasi(); 
            case 6:
                return db.get(row).getTotal(); 
            default:
                return null;
        }
    }
    
}


