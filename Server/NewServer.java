/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author user
 */
public class NewServer {

    public NewServer() throws RemoteException {
        super();
    }

    public static void main(String[] arg) throws RemoteException {
        Registry regristry = LocateRegistry.createRegistry(212);

        NewImplementasi tambah = new NewImplementasi();
        regristry.rebind("Create", (Remote) tambah);
        NewImplementasi hapus = new NewImplementasi();
        regristry.rebind("Delete", (Remote) hapus);
        NewImplementasi lihat = new NewImplementasi();
        regristry.rebind("Read", (Remote) lihat);
        NewImplementasi up = new NewImplementasi();
        regristry.rebind("Update", (Remote) up);
        System.out.println("Server ready....");

    }
}
