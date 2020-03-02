/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Interface.NewInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author jejek
 */
public class NewClient {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        int pilihan;
        System.out.println("================================================");
        System.out.println("=               PROGRAM ASET KANTOR            =");
        System.out.println("================================================");
        System.out.println("=               1. Tambah Barang               =");
        System.out.println("=               2. Daftar Barang               =");
        System.out.println("=               3. Hapus Barang                =");
        System.out.println("=               4. Update Barang               =");
        System.out.println("================================================");
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih menu : ");
        pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                try {
                    String Nama_Barang, Ruangan, In, Out;
                    int ID_Barang, Jumlah, ID = 0;
                    NewInterface jdbcl = (NewInterface) Naming.lookup("rmi://10.0.46.4:212/Create");
                    System.out.print("No. Barang : ");
                    ID_Barang = input.nextInt();
                    System.out.print("Nama Barang : ");
                    Nama_Barang = input.next();
                    System.out.print("Jumlah : ");
                    Jumlah = input.nextInt();
                    System.out.print("Ruangan : ");
                    Ruangan = input.next();
                    System.out.print("Tanggal masuk (YYYY-MM-DD): ");
                    In = input.next();
                    Date Tgl_Masuk = Date.valueOf(In);//converting string into sql date  
                    System.out.print("Tanggal keluar (YYYY-MM-DD): ");
                    Out = input.next();
                    Date Tgl_Keluar = Date.valueOf(Out);//converting string into sql date  

                    String hasil = jdbcl.Create(ID_Barang, Nama_Barang, Jumlah, Ruangan, Tgl_Masuk, Tgl_Keluar);
                    System.out.println(hasil);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    String Nama_Barang, Ruangan, Tgl_Masuk, Tgl_Keluar;
                    int ID_Barang = 0, Jumlah;
                    NewInterface jdbcl = (NewInterface) Naming.lookup("rmi://10.0.46.4:212/Read");

                    ArrayList hasil = jdbcl.Read();

                    System.out.println(hasil);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    int ID_Barang;
                    NewInterface jdbcl = (NewInterface) Naming.lookup("rmi://10.0.46.4:212/Delete");
                    System.out.print("ID Barang : ");
                    ID_Barang = input.nextInt();

                    String hasil = jdbcl.Delete(ID_Barang);
                    System.out.println(hasil);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    String Nama_Barang, Ruangan, In, Out;
                    int ID_Barang, Jumlah;
                    NewInterface jdbcl = (NewInterface) Naming.lookup("rmi://10.0.46.4:212/Update");
                    System.out.print("Kode Barang : ");
                    ID_Barang = input.nextInt();
                    System.out.print("Nama Barang : ");
                    Nama_Barang = input.next();
                    System.out.print("Jumlah : ");
                    Jumlah = input.nextInt();
                    System.out.print("Ruangan : ");
                    Ruangan = input.next();
                    System.out.print("Tanggal masuk (YYYY-MM-DD): ");
                    In = input.next();
                    Date Tgl_Masuk = Date.valueOf(In);
                    System.out.print("Tanggal keluar (YYYY-MM-DD): ");
                    Out = input.next();
                    Date Tgl_Keluar = Date.valueOf(Out);

                    String hasil = jdbcl.Update(ID_Barang, Nama_Barang, Jumlah, Ruangan, Tgl_Masuk, Tgl_Keluar);
                    System.out.println(hasil);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
