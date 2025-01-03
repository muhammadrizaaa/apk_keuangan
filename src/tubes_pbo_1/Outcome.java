/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_pbo_1;

/**
 *
 * @author MSI
 */
public class Outcome extends Duit {
    public Outcome(int id, String name, double amount, String date, int id_profile, String profileName){
        super(id, name, amount, date, id_profile, profileName);
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public double getAmount() {
        return super.amount;
    }

    @Override
    public int getProfile() {
        return super.id_profile;
    }
    
    @Override
    public String getProfileName() {
        return super.profileName;
    }
    
    @Override
    public String getDate() {
        return super.date;
    }
}
