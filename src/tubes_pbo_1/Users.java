/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_pbo_1;
import java.util.ArrayList;
/**
 *
 * @author MSI
 */
public class Users {
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private double saldo;
    private ArrayList <Profile> profile;
    public Users(int id, String name, String username, String email, String password, double saldo){
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.saldo = saldo;
    }
    public Users(String name, String username, String email, String password){
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public Users(){
        
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPass(){
        return password;
    }
    public double getAmount(){
        return saldo;
    }
    public ArrayList<Profile> getProfile(){
        return profile;
    }
    public void addProfile(Profile p){
        profile.add(p);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
}
