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
import java.util.Scanner;
import Interface.Utentes;

/**
 *
 * @author fabiofranca
 */
public class ConsultaMedica {
    
    
    public static void main(String args[]) throws RemoteException, NotBoundException {
           Gestor g = null;
           Registry registry;
           registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
           g = (Gestor) registry.lookup("GestaoUtentes");
           String x="";
       while ( !x.equals("s")){
           Scanner s = new Scanner(System.in);
           int idconsulta = g.getidConsulta();
           System.out.println("Indique o id do medico");
           int idmedico = s.nextInt();
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
           System.out.println(g.cria_consultaMedica( idmedico, idutente,dia,mes,ano,hora));
           System.out.printf("Deseja Sair? Sim (s) Nao (n)");
           x = s.next();
       }
       
     }
}
