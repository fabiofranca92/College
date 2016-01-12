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
public class FazerEncomendaProdutos {
    
    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
    
    Scanner s = new Scanner(System.in);
        Gestor g;
        Utentes u;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
       ;
        
        System.out.println("Id do Produto:");
         int id = s.nextInt();
       
        System.out.println("Quantidade:");
        int quantidade = s.nextInt();
        System.out.println("Dia de Hoje : (dd)");
        int dia = s.nextInt();
        System.out.println("Mes: (mm)");
        int mes = s.nextInt();
        System.out.println("Ano: (yyyy)");
        int ano = s.nextInt();
        
        g.fazerEncomendaProd(id ,quantidade , dia, mes,ano);
}
}
