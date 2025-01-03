/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_pbo_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author MSI
 */
public class DBDuit {
    private Connection conn;
    DbUsers u;
    public DBDuit(DbUsers dbu){
        this.u = dbu;
    }
    private final Koneksi k = new Koneksi();
    public ArrayList <Duit> getIncome() throws SQLException{
        conn = k.getConnection();
        ArrayList <Duit> d = new ArrayList<>();
        String q = "SELECT i.id, i.name, i.qty, p.name AS profile_name, i.created_at\n" +
        "FROM income i\n" +
        "JOIN profile p ON i.id_profile = p.id\n" +
        "JOIN users u ON p.id_user = u.id\n" +
        "WHERE u.id = ?;";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setInt(1, u.getLoginProfile().getIdUser());
        ResultSet rs = ps.executeQuery();
        //now we put tha shi on the Array List dawg
        while(rs.next()){
            Income i = new Income(rs.getInt("id"), rs.getString("name"), rs.getDouble("qty"), rs.getString("created_at"),
                    u.getLoginProfile().getId(), rs.getString("profile_name"));
            d.add(i);
            System.out.println(i);
        }
        rs.close();
        ps.close();
        conn.close();
        return d;
    }
    public ArrayList <Duit> getOutcome() throws SQLException{
        conn = k.getConnection();
        ArrayList <Duit> d = new ArrayList<>();
        String q = "SELECT i.id, i.name, i.qty, p.name AS profile_name, i.created_at\n" +
        "FROM outcome i\n" +
        "JOIN profile p ON i.id_profile = p.id\n" +
        "JOIN users u ON p.id_user = u.id\n" +
        "WHERE u.id = ?;";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setInt(1, u.getLoginProfile().getIdUser());
        ResultSet rs = ps.executeQuery();
        //now we put tha shi on the Array List dawg
        while(rs.next()){
            Outcome o = new Outcome(rs.getInt("id"), rs.getString("name"), rs.getDouble("qty"), rs.getString("created_at"),
                    u.getLoginProfile().getId(), rs.getString("profile_name"));
            d.add(o);
        }
        rs.close();
        ps.close();
        conn.close();
        return d;
    }
    public boolean addIncome(String name, double amount) throws SQLException{
        conn = k.getConnection();
        if(updateSaldo(amount)){
            String q = "INSERT INTO income (name, qty, id_profile) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setDouble(2, amount);
            ps.setInt(3, u.getLoginProfile().getId());
            int checkrow = ps.executeUpdate();
            ps.close();
            return checkrow == 1;
        }
        return false;
    }
    public boolean addOutcome(String name, double amount) throws SQLException{
        conn = k.getConnection();
        if(updateSaldo(amount * -1)){
            String q = "INSERT INTO outcome (name, qty, id_profile) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setDouble(2, amount);
            ps.setInt(3, u.getLoginProfile().getId());
            int checkrow = ps.executeUpdate();
            ps.close();
            return checkrow == 1;
        }
            return false;
    }
    public boolean updateSaldo(double amount) throws SQLException{
        conn = k.getConnection();
        if(u.getUser().getAmount() + amount < 0){
            return false;
        }
        else{
            String q = "UPDATE `users` SET `saldo` = `saldo` + ? WHERE `users`.`id` = ?;";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setDouble(1, amount);
            ps.setInt(2, u.getUser().getId());
            int checkRow = ps.executeUpdate();
            ps.close();
            return checkRow == 1;
        }
    }
}
