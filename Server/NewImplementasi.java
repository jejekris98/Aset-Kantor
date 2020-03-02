/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Interface.NewInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

/**
 *
 * @author user
 */
class NewImplementasi extends UnicastRemoteObject implements NewInterface {

    public NewImplementasi() throws RemoteException {
        super();
    }

    public ArrayList Read() throws RemoteException {

        ArrayList asetkantor = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asetkantor", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM asets");

            while (rs.next()) {
                System.out.println("No Barang: " + rs.getInt("ID_Barang"));
                asetkantor.add("No. Barang : " + rs.getInt("ID_Barang"));
                asetkantor.add("Nama : " + rs.getString("Nama_Barang"));
                asetkantor.add("Jumlah : " + rs.getInt("Jumlah"));
                asetkantor.add("Ruangan : " + rs.getString("Ruangan"));
                asetkantor.add("Tanggal Masuk: " + rs.getString("Tgl_Masuk"));
                asetkantor.add("Tanggal Keluar : " + rs.getString("Tgl_Keluar"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return asetkantor;
    }

    @Override
    public String Create(int ID_Barang, String Nama_Barang, int Jumlah, String Ruangan, Date Tgl_Masuk, Date Tgl_Keluar) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asetkantor", "root", "");
            Statement st = con.createStatement();
            String sql = "insert into asets value('" + ID_Barang + "','" + Nama_Barang + "','" + Jumlah + "','" + Ruangan + "','" + Tgl_Masuk + "','" + Tgl_Keluar + "')";
            st.executeUpdate(sql);

            System.out.println("Client Menambahkan");
            System.out.println("ID Barang: " + ID_Barang);
            System.out.println("Nama Barang: " + Nama_Barang);
            System.out.println("Jumlah: " + Jumlah);
            System.out.println("Ruangan: " + Ruangan);
            System.out.println("");
            return "Data berhasil ditambahkan";
        } catch (Exception e) {
            return (e.toString());
        }
    }

    @Override
    public String Delete(int ID_Barang) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asetkantor", "root", "");
            Statement st = con.createStatement();
            String sql = "DELETE FROM asets WHERE ID_Barang = '" + ID_Barang + "'";
            st.executeUpdate(sql);

            System.out.println("ID Barang: " + ID_Barang);
            return "Data ID: " + ID_Barang + " berhasil dihapus";

        } catch (Exception e) {
            return (e.toString());
        }
    }

    @Override
    public String Update(int ID_Barang, String Nama_Barang, int Jumlah, String Ruangan, java.sql.Date Tgl_Masuk, java.sql.Date Tgl_Keluar) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asetkantor", "root", "");
            Statement st = con.createStatement();
            String sql = "UPDATE asets SET Nama_Barang='" + Nama_Barang + "',Jumlah='" + Jumlah + "',Ruangan='" + Ruangan + "',Tgl_Masuk='" + Tgl_Masuk + "',Tgl_Keluar='" + Tgl_Keluar + "' WHERE ID_Barang='" + ID_Barang + "'  ";
            st.executeUpdate(sql);

            System.out.println("Client Mengupdate");
            System.out.println("ID Barang: " + ID_Barang);
            System.out.println("Nama Barang: " + Nama_Barang);
            System.out.println("Jumlah: " + Jumlah);
            System.out.println("Ruangan: " + Ruangan);
            System.out.println("Tanggal Masuk: " + Tgl_Masuk);
            System.out.println("Tanggal Keluar" + Tgl_Keluar);
            System.out.println("");
            return "Data berhasil diupdate";
        } catch (Exception e) {
            return (e.toString());
        }
    }

}
