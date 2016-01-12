/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author fabiofranca
 */
public class EncomendasPrevistasProd {
    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
       
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        HashSet<String> cons = new HashSet<>();      
        cons.addAll(g.verEncomendasPro());
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
}
}
