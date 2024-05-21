/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatabuku;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.databukuimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lab Informatika
 */
public class databukuDAO implements databukuimplement{
    Connection connection;
    
    final String select = "SELECT * FROM sewa_buku";
    final String insert = "INSERT INTO sewa_buku (id, nama, judul, jenis, nomor, durasi, total) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String update = "UPDATE sewa_buku SET id=?, nama=?, judul=?, jenis=?, nomor=?, durasi=?, total=? WHERE id=?";
    final String delete = "DELETE FROM sewa_buku WHERE id=?";
    
    public databukuDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(databuku b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJudul());
            statement.setString(4, b.getJenis());
            statement.setString(5, b.getNomor());
            statement.setInt(6, b.getDurasi());
            statement.setInt(7, b.getTotal());
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(databuku b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJudul());
            statement.setString(4, b.getJenis());
            statement.setString(5, b.getNomor());
            statement.setInt(6, b.getDurasi());
            statement.setInt(7, b.getTotal());
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<databuku> getAll(){
        List<databuku> db = null;
        try{
            db = new ArrayList<databuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                databuku bk = new databuku();
                bk.setId(rs.getInt("ID"));
                bk.setNama(rs.getString("Nama Pemilik"));
                bk.setJudul(rs.getString("Judul Buku"));
                bk.setJenis(rs.getString("Jenis Buku"));
                bk.setNomor(rs.getString("Nomor Telepon"));
                bk.setDurasi(rs.getInt("Durasi Sewa"));
                bk.setTotal(rs.getInt("Total Biaya"));
                db.add(bk);
            }
        }catch(SQLException ex){
            Logger.getLogger(databukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
    
}
