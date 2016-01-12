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

/**
 *
 * @author fabiofranca
 */
public class ProdutosMedMinimo {
     public static void main(String args[]) throws RemoteException, NotBoundException {
        Gestor g = null;
        Registry registry;
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        System.out.println("Deseja consultar Medicamentos(1) ou Produtos(2) ");
        Scanner s = new Scanner(System.in);
        int d = s.nextInt();
        if(d==1){
            HashSet<String> cons = new HashSet<>();
       
        cons.addAll((g.consultarMedMin()));
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
            
        }else{
        HashSet<String> cons = new HashSet<>();
       
        cons.addAll(g.consultarProdMin());
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
       
}
     }
}