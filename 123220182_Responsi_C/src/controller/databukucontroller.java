/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Lab Informatika
 */
public class databukucontroller {
    MainView frame;
    databukuimplement impldatabuku;
    List<databuku> db;
    
    public databukucontroller (MainView frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        db = impldatabuku.getAll();
    }
    
    public void isiTabel(){
        db = impldatabuku.getAll();
        modeltabeldatabuku mb = new modeltabeldatabuku(db);
        frame.getTabelDatabuku().setModel(mb);
    }
    
    public void insert(){
        databuku db = new databuku();
        db.setId(Integer.parseInt(frame.getjTextId().getText()));
        db.setNama(frame.getjTextNama().getText());
        db.setJudul(frame.getjTextJudul().getText());
        db.setJenis(frame.getjTextJenis().getText());
        db.setNomor(frame.getjTextNomor().getText());
        db.setDurasi(Integer.parseInt(frame.getjTextDurasi().getText()));
        if (db.getDurasi() <= 2){
            db.setTotal(db.getDurasi()*10000);
        
        }else{
            int waktu;
            waktu = db.getDurasi() - 2;
            db.setTotal((waktu*15000)+20000);
        }
        impldatabuku.insert(db);
    }
    
    public void update(){
        databuku db = new databuku();
        db.setId(Integer.parseInt(frame.getjTextId().getText()));
        db.setNama(frame.getjTextNama().getText());
        db.setJudul(frame.getjTextJudul().getText());
        db.setJenis(frame.getjTextJenis().getText());
        db.setNomor(frame.getjTextNomor().getText());
        db.setDurasi(Integer.parseInt(frame.getjTextDurasi().getText()));
        if (db.getDurasi() <= 2){
            db.setTotal(db.getDurasi()*10000);
        
        }else{
            int waktu;
            waktu = db.getDurasi() - 2;
            db.setTotal((waktu*15000)+20000);
        }
        impldatabuku.update(db);
    }
    
    public void delete(){
        Integer id = frame.getjTextId().getText();
        impldatabuku.delete(id);
    }
}
