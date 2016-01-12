/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ConsultarStock {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        Gestor g = null;
        Registry registry;
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        System.out.printf("Deseja consultar stock de Medicamentos(1) ou Produtos(2) ?\nInsira o numero correspondente:");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i == 1) {

            HashSet<String> cons = new HashSet<>();

            cons.addAll(g.consultarStockMedicamentos());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }


        } else {
            HashSet<String> cons = new HashSet<>();

            cons.addAll(g.consultarStockProdutos());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }


        }
    }
}
