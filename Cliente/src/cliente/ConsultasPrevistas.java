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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author fabiofranca
 */
public class ConsultasPrevistas {
     public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
        Utentes u ;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        System.out.printf("Escolha o Parametro:\n1- ID Médico\n2-Especialidade\n3-ID Utente");
        Scanner s = new Scanner(System.in);
        int x= s.nextInt();
        if(x == 1){
        HashSet<String> cons = new HashSet<>();
        System.out.println("ID Medico :");
        int idmedico = s.nextInt();
        cons.addAll(g.consprevIDMEDICO(idmedico));
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
       
          
        }else if(x == 2){
            System.out.println("Especialidade :");
        String especialidade = s.next();
           HashSet<String> cons = new HashSet<>();
       
        cons.addAll(g.consprevEspecialidade(especialidade));
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
 
        }else if(x == 3){
             HashSet<String> cons = new HashSet<>();
       System.out.println("ID Utente :");
        int idutente = s.nextInt();
        cons.addAll(g.consprevIDUtente(idutente));
        Iterator<String> it = cons.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
            
          
        }else{
            System.out.print("Indisponivel");
        }
}
}