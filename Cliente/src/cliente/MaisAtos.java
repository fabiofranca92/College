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
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class MaisAtos {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g = null;
        Registry registry;       
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        Scanner s = new Scanner(System.in);
        System.out.println("Deseja saber mais atos de um medico(1) ou enfermeiro(2) ?");
        int i = s.nextInt();
        if (i == 1) {
            HashSet<String> cons = new HashSet<>();
            
            cons.addAll(g.MedAtos());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
              
            }


        }
        HashSet<String> cons = new HashSet<>();
        
        cons.addAll(g.EnfAtos());
        Iterator<String> it = cons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
           
        }

    }
}