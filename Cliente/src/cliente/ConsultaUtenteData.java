/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Consulta;
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
public class ConsultaUtenteData {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g = null;
        Utentes u = null;
        Consulta c = null;
        Registry registry;
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        Scanner s = new Scanner(System.in);
        Date data = new Date();
        System.out.println("Insira o dia : ");
        int dia = s.nextInt();
        
        System.out.println("Insira o mes : ");
        int mes = s.nextInt();
        System.out.println("Insira o ano : ");
        int ano = s.nextInt();
        
        data = new Date(ano - 1900, mes - 1, dia, 23, 00);
        g = (Gestor) registry.lookup("GestaoUtentes");
        u = (Utentes) registry.lookup("Utente");
        c= (Consulta) registry.lookup("Consulta");
        HashSet<String> cons = new HashSet<>();

        cons.addAll(g.consultasDATA(data));
        Iterator<String> it = cons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
