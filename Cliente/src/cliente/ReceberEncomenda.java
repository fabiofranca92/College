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
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class ReceberEncomenda {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
        Utentes u;
        System.out.println("Encomenda de Produtos(1) ou Medicamentos(2) ");
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        Scanner s = new Scanner(System.in);
        int enc = s.nextInt();
        g = (Gestor) registry.lookup("GestaoUtentes");
        if (enc == 1) {
            System.out.println("Indique o ID da Encomenda que chegou :");

            int idencomenda = s.nextInt();
            g.receberEncomendaProd(idencomenda);
        }else{
        
        System.out.println("Indique o ID da Encomenda que chegou :");

        int idencomenda = s.nextInt();
        g.receberEncomenda(idencomenda);
    }
}
}