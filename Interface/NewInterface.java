/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jejek
 */
public interface NewInterface extends Remote {
    //ArrayList Select(int No_induk) throws RemoteException;

    public String Create(int ID_Barang, String Nama_Barang, int Jumlah, String Ruangan, Date Tgl_Masuk, Date Tgl_Keluar) throws RemoteException;

    ArrayList Read() throws RemoteException;

    public String Update(int ID_Barang, String Nama_Barang, int Jumlah, String Ruangan, java.sql.Date Tgl_Masuk, java.sql.Date Tgl_Keluar) throws RemoteException;

    public String Delete(int ID_Barang) throws RemoteException;
}
