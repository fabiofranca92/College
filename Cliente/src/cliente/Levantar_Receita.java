/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import Interface.Utentes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class Levantar_Receita {
      public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
    Gestor g;
        Utentes u ;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        u = (Utentes) registry.lookup("Utente");
        Scanner s = new Scanner(System.in);
        Date data = new Date();
        System.out.println("Insira o dia de Hoje : ");
        int dia = s.nextInt();
        
        System.out.println("Insira o mes : ");
        int mes = s.nextInt();
        System.out.println("Insira o ano : ");
        int ano = s.nextInt();
       
        System.out.println("Indique o seu ID");
        int id = s.nextInt();
        HashSet<String> cons = new HashSet<>();

        cons.addAll(g.levantar_receita(id,dia,mes,ano));
        
        Iterator<String> it = cons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
       
}
}