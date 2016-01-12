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
public class AtoEnfermagem {
   public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g = null;
           Registry registry;
           registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
           g = (Gestor) registry.lookup("GestaoUtentes");
           String x="";
      
           
           Scanner s = new Scanner(System.in);
           
           System.out.println("Indique o id do enfermeiro");
           int idenfermeiro = s.nextInt();
           System.out.println("Indique o idutente");
           int idutente = s.nextInt();
          
            System.out.println("Insira o mes da consulta:");
            int mes = s.nextInt();
            System.out.println("Insira o dia ");
            int dia = s.nextInt();
            System.out.println("Insira o hora ");
            int hora = s.nextInt();
            System.out.println("Insira o ano ");
            int ano = s.nextInt();
           System.out.println(g.cria_consultaEnfermeiro( idenfermeiro, idutente,dia,mes,ano,hora));
          
           
       
       
        
}
}