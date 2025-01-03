/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes_pbo_1;

/**
 *
 * @author MSI
 */
public class Profile {
    
    private String  name;
    private int idUser, id;
    public Profile(int id, String name, int idUser){
        this.id = id;
        this.name = name;
        this.idUser = idUser;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getIdUser(){
        return idUser;
    }
    public void setName(String name){
        this.name = name;
    }
}
