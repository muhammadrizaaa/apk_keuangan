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
public class DbUsers {
    private Connection conn;
    private final Koneksi k = new Koneksi();
    private Users s;
    private Profile p;
    public boolean register(Users s) throws SQLException{
        conn = k.getConnection();
        String query = "INSERT INTO users(name, username, email, password) VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, s.getName());
        ps.setString(2, s.getUsername());
        ps.setString(3, s.getEmail());
        ps.setString(4, s.getPass());
        System.out.println(s.getName());
        if(this.UserTaken(s.getUsername(), s.getEmail())){
            ps.close();
            conn.close();
            return false;
        }else{
            int checkRow = ps.executeUpdate();
            ps.close();
            conn.close();
            return checkRow == 1;
        }
    }
    public boolean login(String username, String pass) throws SQLException{
        conn = k.getConnection();
        String q = "SELECT * FROM `users` WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            s = new Users(rs.getInt("id"), rs.getNString("name"), rs.getString("username"),
                    rs.getString("email"), rs.getString("password"), rs.getDouble("saldo"));
            rs.close();
            ps.close();
            return true;
        }
        else{
            rs.close();
            ps.close();
            return false;
        }
    }
    public boolean getProfile(int id) throws SQLException{
        conn = k.getConnection();
        String q = "SELECT * FROM profile WHERE id_user = ? AND id = ? ";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setInt(1, s.getId());
        ps.setInt(2, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            p = new Profile(rs.getInt("id"), rs.getString("name") , rs.getInt("id_user"));
            return true;
        }
        else{
            return false;
        }
    }
    
    public ArrayList<Profile> getProfile() throws SQLException{
        conn = k.getConnection();
        ArrayList <Profile> p = new ArrayList<>();
        String q = "SELECT * FROM profile WHERE id_user = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setInt(1, this.getUser().getId());
        ResultSet rs = ps.executeQuery();
        //now we put tha shi on the Array List dawg
        while(rs.next()){
            Profile p1 = new Profile(rs.getInt("id"), rs.getString("name"), rs.getInt("id_user"));
            p.add(p1);
        }
        rs.close();
        ps.close();
        return p;
    }
    public boolean createProfile(String name) throws SQLException{
        conn = k.getConnection();
        String q = "INSERT INTO profile (name, id_user) VALUES(?, ?) ";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, name);
        ps.setInt(2, s.getId());
        int checkRow = ps.executeUpdate();
        ps.close();
        conn.close();
        return checkRow == 1;
    }
    public boolean editProfile(String name) throws SQLException{
        conn = k.getConnection();
        String q = "UPDATE profile SET name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, name);
        ps.setInt(2, p.getId());
        int checkRow = ps.executeUpdate();
        ps.close();
        conn.close();
        this.p.setName(name);
        return checkRow == 1;
    }
    public void logoutProfile(){
        this.p = null;
    }
    public Profile getLoginProfile(){
        return p;
    }
    public Users getUser() throws SQLException{
        login(s.getUsername(), s.getPass());
        return s;
    }
    public boolean editUser(String name, String username) throws SQLException{
        conn = k.getConnection();
        if(!UserTaken(username)){
            String q = "UPDATE users SET name = ?, username = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setInt(3, s.getId());    
            int checkRow = ps.executeUpdate();
            ps.close();
            conn.close();
            this.s.setName(name);
            this.s.setUsername(username);
            return checkRow == 1;
        }
        return false;
    }
    public boolean UserTaken(String username, String email) throws SQLException{
        conn = k.getConnection();
        String q = "SELECT * FROM `users` WHERE username = ? OR email = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, username);
        ps.setString(2, email);
        ResultSet rs = ps.executeQuery();
        int rowCount = 0; // Counter to count rows
        while (rs.next()) {
            rowCount++;
        }
        rs.close();
        ps.close();
        conn.close();
        return rowCount>=1;
    }
        public boolean UserTaken(String username) throws SQLException{
        conn = k.getConnection();
        String q = "SELECT * FROM `users` WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        int rowCount = 0; // Counter to count rows
        while (rs.next()) {
            rowCount++;
        }
        rs.close();
        ps.close();
        return rowCount>=1;
    }
    public boolean addProfile(String name) throws SQLException{
        conn = k.getConnection();
        if(getProfile().size()<4){
            String q = "INSERT INTO profile(name, id_user) VALUEs(?, ?)";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setInt(2, s.getId());
            int checkRow = ps.executeUpdate();
            ps.close();
            return checkRow == 1;
        }
        else{
            return false;
        }
    }
    public boolean forceDeleteProfile(int idProfile) throws SQLException{
        conn = k.getConnection();
        DBDuit dbd = new DBDuit(this);
        double income = 0;
        double outcome = 0;
        ArrayList <Duit> incomeArr = dbd.getIncome(idProfile);
        ArrayList <Duit> outcomeArr = dbd.getOutcome(idProfile);
        for(Duit d:incomeArr){
            income += d.amount;
        }
        for(Duit d:outcomeArr){
            outcome += d.amount;
        }
        if(!dbd.updateSaldo(income*-1)){
            return false;
        }
        if(!dbd.updateSaldo(outcome)){
            return false;
        }
        dbd.updateSaldo(income*-1);
        String qDeleteIncome = "DELETE FROM income WHERE id_profile = ?";
        PreparedStatement psdi = conn.prepareStatement(qDeleteIncome);
        psdi.setInt(1, idProfile);
        psdi.executeUpdate();
        psdi.close();
        String qDeleteOutcome = "DELETE FROM outcome WHERE id_profile = ?";
        PreparedStatement psdo = conn.prepareStatement(qDeleteOutcome);
        psdo.setInt(1, idProfile);
        psdo.executeUpdate();
        psdo.close();
        String q = "DELETE FROM profile WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setInt(1, idProfile);
        int checkRow = ps.executeUpdate();
        ps.close();
        return checkRow == 1;
    }
}
