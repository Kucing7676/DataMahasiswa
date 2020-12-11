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
public class MainProgram {
    //Atribut
    int i;
    
    //Method
    Input in = new Input();
    Database db = new Database();
    void mainMenu(){
        System.out.println("<<---------------------------------------------------->>");
        System.out.println("Main menu :");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampil Data");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan: ");
        in.input_Menu();
    }
    void pilihan(){
        while(true){
            mainMenu();
            if (in.no_Menu == 1){
                while(true){
                    System.out.println("<<---------------------------------------------------->>");
                    System.out.print("Masukkan NIM yang akan ditambah: ");
                    in.input_Nim();
                    System.out.println("<<---------------------------------------------------->>");
                    System.out.print("Masukkan Nama yang akan ditambah: ");
                    in.input_Nama();
                    System.out.println("<<---------------------------------------------------->>");
                    System.out.println("Masukkan Tanggal Lahir yang akan ditambah: ");
                    in.input_Lahir();
                    System.out.println("<<---------------------------------------------------->>");
                    System.out.println("Jenis Kelamin: ");
                    System.out.println("1. Laki - Laki");
                    System.out.println("2. Perempuan");
                    System.out.print("Masukkan Jenis Kelamin sesuai nomor: ");
                    in.input_Gender();
                    System.out.print("Tambahkan ke Data Mahasiswa?(y/n): ");
                    in.input_Yakin();
                    if ("y".equals(in.yakin)){
                        db.data_Nim.add(in.nim);
                        db.data_Nama.add(in.nama);
                        db.data_TglLhr.add(in.tgl_Lahir);
                        if (in.gender == 1){
                            db.data_Gender.add(0);
                        } else if (in.gender == 2){
                            db.data_Gender.add(1);
                        } else {
                            continue;
                        }
                        System.out.println("<-- DATA BERHASIL DITAMBAHKAN! -->");
                        break;
                    } else {
                        System.out.println("<-- DIBATALKAN -->");
                        break;
                    }
                }
                System.out.println(db.data_Nim + ", " + db.data_Nama + ", " + db.data_TglLhr + ", " + db.data_Gender);
            } else if (in.no_Menu == 2){
                while(true){
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    in.input_Nim();
                    this.i = Collections.binarySearch(db.data_Nim, in.nim);
                    System.out.println("Data yang akan dihapus:");
                    System.out.println("Nama            : " + db.data_Nama.get(this.i));
                    System.out.println("Tanggal Lahir   : " + db.data_TglLhr.get(this.i));
                    System.out.println("Jenis Kelamin   : " + jns_Kel());
                    System.out.print("Hapus Data?(y/n): ");
                    in.input_Yakin();
                    if ("y".equals(in.yakin)){
                        db.data_Nim.remove(this.i);
                        db.data_Nama.remove(this.i);
                        db.data_TglLhr.remove(this.i);
                        db.data_Gender.remove(this.i);
                        System.out.println("<-- DATA BERHASIL DIHAPUS! -->");
                        break;
                    } else {
                        break;
                    }
                }
                System.out.println(db.data_Nim + ", " + db.data_Nama + ", " + db.data_TglLhr + ", " + db.data_Gender);
            } else if (in.no_Menu == 3){
                while(true){
                    System.out.println("<<---------------------------------------------------->>");
                    System.out.println("Kriteria Pencarian:");
                    System.out.println("1. Berdasarkan Jenis Kelamin");
                    System.out.println("2. Berdasarkan NIM");
                    System.out.println("3. Keluar");
                    System.out.print("Pilih: ");
                    in.input_Kriteria();
                    if (in.no_Kriteria == 1){
                        System.out.println("<<---------------------------------------------------->>");
                        System.out.println("Jenis Kelamin:");
                        System.out.println("1. Laki - Laki");
                        System.out.println("2. Perempuan");
                        System.out.println("3. Keluar");
                        System.out.print("Pilih:  ");
                        in.input_Gender();
                        if (in.gender == 1){
                            for (this.i = 0; this.i < db.data_Gender.size(); this.i++){
                                if (db.data_Gender.get(this.i)  == 0){
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println(db.data_Nim.get(this.i) + ", " + db.data_Nama.get(this.i) + ", " + db.data_TglLhr.get(this.i) + ", " + jns_Kel());
                                }
                            }
                            break;
                        } else if (in.gender == 2){
                            for (this.i = 0; this.i < db.data_Gender.size(); this.i++){
                                if (db.data_Gender.get(this.i)  == 1){
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println(db.data_Nim.get(this.i) + ", " + db.data_Nama.get(this.i) + ", " + db.data_TglLhr.get(this.i) + ", " + jns_Kel());
                                }
                            }
                            break;
                        } else {
                            break;
                        }
                    } else if (in.no_Kriteria == 2){
                        System.out.println("<<---------------------------------------------------->>");
                        System.out.print("Masukkan NIM yang ingin dicari: ");
                        in.input_Nim();
                        this.i = 0;
                        this.i = Collections.binarySearch(db.data_Nim, in.nim);
                        if (this.i == -1){
                            System.out.println("<-- DATA TIDAK DITEMUKAN! -->");
                            break;
                        } else {
                            System.out.println("<-- DATA DITEMUKAN! -->");
                            System.out.println("Nama            : " + db.data_Nama.get(this.i));
                            System.out.println("Tanggal Lahir   : " + db.data_TglLhr.get(this.i));
                            System.out.println("Jenis Kelamin   : " + jns_Kel());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (in.no_Menu == 4){
                for (this.i = 0; this.i < db.data_Nim.size(); this.i++){
                    if (db.data_Gender.get(this.i) == 0){
                        String kel = "Laki - Laki";
                    }
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println(db.data_Nim.get(this.i) + ", " + db.data_Nama.get(this.i) + ", " + db.data_TglLhr.get(this.i) + ", " + jns_Kel());
                }
                System.out.println("<<---------------------------------------------------->>");
                System.out.println("Jumlah Total Mahasiswa: " + db.data_Nim.size());
            } else {
                break;
            }
        }
    }
    String jns_Kel(){
        if (db.data_Gender.get(this.i) == 0){
            String kel = "Laki - Laki";
            return kel;
        } else {
            String kel = "Perempuan";
            return kel;
        }
    }
}