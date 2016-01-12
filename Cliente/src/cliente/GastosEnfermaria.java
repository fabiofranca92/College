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
public class GastosEnfermaria {
     public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
        
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        
        Scanner s = new Scanner(System.in);
         System.out.println("Dia de Hoje : (dd)");
        int dia = s.nextInt();
        System.out.println("Mes: (mm)");
        int mes = s.nextInt();
        System.out.println("Ano: (yyyy)");
        int ano = s.nextInt();
        System.out.println("Indique o ID do Ato");
        int id = s.nextInt();
        System.out.println("Produto(1) ou Medicamento(2)");
        int resp = s.nextInt();
        if (resp==1){
        System.out.println("Indique o id do produto");
        int idpro = s.nextInt();
        System.out.println("Indique a quantidade");
        int quantidade = s.nextInt();
        System.out.println(g.adicionar_gastosProdutos(id, idpro, quantidade,dia,mes,ano));
        }else if (resp == 2){
         System.out.println("Indique o id do medicamento");
        int idmed = s.nextInt();
        System.out.println("Indique a quantidade");
        int quantidade = s.nextInt();
        System.out.println(g.adicionar_gastosMedicamentos(id, idmed, quantidade,dia,mes,ano));
        }
     }
}
