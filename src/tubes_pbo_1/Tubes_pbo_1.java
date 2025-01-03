/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes_pbo_1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class Tubes_pbo_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        login login = new login();
        
        login.setVisible(true);
//        Scanner sc = new Scanner(System.in);
//        DbUsers dbu = new DbUsers();
//        DBDuit dbd = new DBDuit();
//        Users u = new Users();
//        int input;
//        double inputDuit;
//        String note;
//        while(true){
//            int count = 0;
//            System.out.println("username : ");
//            String username = sc.next();
//            System.out.println("Pass");
//            String pass = sc.next();
//            System.out.println("");
//            dbu.login(username, pass);
//            
//    //        Users u = new Users("Riza", "riz", "mriza@ha.ha", "123");
//    //        System.out.println(dbu.register(u));
//    //        dbu.addProfile("WOWOWO", dbu.getUser().getId());
//            System.out.println(dbu.getUser().getUsername()+"'s Profile : ");
//            for(Profile p:dbu.getProfile()){
//                count+=1;
//                System.out.print(count+". ");
//                System.out.println(p.getName());
//            }
//            while(true){
//                System.out.println("Select Profile : ");
//                int select_profile = sc.nextInt();
//                boolean selectProfile = dbu.selectProfile(dbu.getProfile().get(select_profile-1).getId());
//                if(selectProfile){
//                    System.out.println("Welcome "+dbu.getLoginProfile().getName());
//                    boolean loop1 = true;
//                    while(loop1){
//                        System.out.println("Uang Kamu "+dbu.getUser().getAmount());
//                        System.out.println("1. tambah income");
//                        System.out.println("2. tambah expenses");
//                        System.out.println("3. list income expense");
//                        System.out.println("4. Keluar");
//                        input = sc.nextInt();
//                        System.out.println("");
//                        System.out.println("");
//                        switch(input){
//                            case 1 : 
//                                System.out.println("Masukkan Note");
//                                sc.nextLine();
//                                note = sc.nextLine();
//                                System.out.println("Masukkan income");
//                                inputDuit = sc.nextDouble();
//                                System.out.println(dbd.addIncome(note, inputDuit, dbu)?"Berhasil":"Gagal");
//                                System.out.println("");
//                                System.out.println("");
//                                break;
//                            case 2 : 
//                                System.out.println("Masukkan Note");
//                                sc.nextLine();
//                                note = sc.nextLine();
//                                System.out.println("Masukkan expense");
//                                inputDuit = sc.nextDouble();
//                                System.out.println(dbd.addOutcome(note, inputDuit, dbu)?"Berhasil":"Gagal");
//                                System.out.println("");
//                                System.out.println("");
//                                break;
//                            case 3 : 
//                                System.out.println("List income");
//                                for(Duit d:dbd.getIncome(dbu)){
//                                    System.out.println(d.id+". "+d.name+" "+d.amount);
//                                }
//                                System.out.println("");
//                                System.out.println("List expense");
//                                for(Duit d:dbd.getOutcome(dbu)){
//                                    System.out.println(d.id+". "+d.name+" "+d.amount);
//                                }
//                                break;
//                            case 4: 
//                                loop1 = false;
//                                break;
//                            default:
//                                System.out.println("unavailable yet.");
//                                break;
//                        }
//                    }
//                    
//                }
//                else{
//                    System.out.println("unavailable");
//                }
//            }
//        }
//        
    }
    
}
