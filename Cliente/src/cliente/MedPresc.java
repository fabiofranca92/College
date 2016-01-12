/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import Interface.Medicos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class MedPresc {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g = null;
        Registry registry;
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        
        Medicos m = (Medicos) registry.lookup("Medicos");
        g = (Gestor) registry.lookup("GestaoUtentes");
        HashSet<String> cons = new HashSet<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o id do medicamento que quer procurar");
        int idmedicamento = s.nextInt();
        cons.addAll(g.MedPresc(idmedicamento));
        Iterator<String> it = cons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            
        }
    }
}
