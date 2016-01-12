/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Receita;
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
public class PassarReceita {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
        Utentes u;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        u = (Utentes) registry.lookup("Utente");

        String str = "";


        Scanner s = new Scanner(System.in);
        int x = 0;
        System.out.println("Indique o id do Medico");
        int idmedico = s.nextInt();
        System.out.println("Indique o id do Utente");
        int id = s.nextInt();
        while (str.equals("n") == false) {
            String str1 = "n";
            System.out.println("Introduza a quantidade ");
            x = s.nextInt();
            while (str1.equals("n") == true) {
                System.out.println("Introduza o ID do medicamento");
                int a = s.nextInt();
                String nome = g.consNomeMedicamento(a);
                System.out.printf("Confere o Medicamento ?" + g.consNomeMedicamento(a) + "\nSim(s) Nao (n)");
                str1 = s.next();
                while (nome.equals("Medicamento Nao Existe")) {
                    System.out.println("Medicamento Não Existe. Introduza de novo o ID:");
                    a = s.nextInt();
                    nome = g.consNomeMedicamento(a);

                }

        
               

                System.out.println(g.cria_receita(idmedico, id, a, x));
                System.out.println("Deseja Adicionar mais algum medicamento à receita ? Sim(s) Nao(n)");
                str = s.next();
            }




        }


    }
}
