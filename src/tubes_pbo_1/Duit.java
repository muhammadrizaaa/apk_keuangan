/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_pbo_1;

/**
 *
 * @author MSI
 */
abstract public class Duit {
    protected int id;
    protected int id_profile;
    protected String name, profileName;
    protected double amount;
    protected String date;
    public Duit(int id, String name, double amount, String date, int id_profile, String profileName){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.id_profile = id_profile;
        this.profileName = profileName;
    }
    abstract public int getId();
    abstract public String getName();
    abstract public double getAmount();
    abstract public int getProfile();
    abstract public String getProfileName();
    abstract public String getDate();
}
