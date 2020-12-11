/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;

/**
 *
 * @author Lenovo
 */
import java.util.*;
public class Input {
    //Atribut
    int no_Menu, no_Kriteria, gender, hari, bulan, tahun;
    String nim, nama, yakin;
    Date tgl_Lahir;
            
    //Method
    Scanner input = new Scanner(System.in);
    void input_Menu(){
        this.no_Menu = input.nextInt();
    }
    void input_Kriteria(){
        this.no_Kriteria = input.nextInt();
    }
    void input_Nim(){
        this.nim = input.next().toUpperCase();
    }
    void input_Nama(){
        this.nama = input.next();
    }
    void input_Lahir(){
        System.out.print("Hari(dd): ");
        this.hari = input.nextInt();
        System.out.print("Bulan(mm): ");
        this.bulan = input.nextInt();
        System.out.print("Tahun(yyyy): ");
        this.tahun = input.nextInt();
        this.tgl_Lahir = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
        System.out.println("Anda lahir tanggal: " + this.tgl_Lahir);
    }
    void input_Gender(){
        this.gender = input.nextInt();
    }
    void input_Yakin(){
        this.yakin = input.next().toLowerCase();
    }
}