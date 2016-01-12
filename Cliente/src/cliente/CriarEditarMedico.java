/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import Interface.Medicos;
import Interface.Utentes;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class CriarEditarMedico {
            
    public static void main(String args[]) throws RemoteException, NotBoundException {
            Gestor g;
            Medicos m;
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            g = (Gestor) registry.lookup("GestaoUtentes");
            m = (Medicos) registry.lookup("Medicos");
        int x = 0;


        while (x != 4) {
            System.out.printf("Medico:\nIntroduza o numero da operação que deseja:\n1- Adicionar\n2-Editar\n3-Consultar\n4-Sair\n");
            Scanner s = new Scanner(System.in);
            x= s.nextInt();
            if (x == 1) {
             
                System.out.println("Insira o nome do Utente");
                String nome = s.next();
                System.out.printf("Insira a morada do Utente\n\n");
                String morada = s.next();
                System.out.println("Especialidade");
                String especialidade = s.next();
                System.out.println("Introduza dia(dd) mes(mm) e ano(yyyy) de nascimento");            
                int dia = s.nextInt();
                int mes = s.nextInt();
                int ano = s.nextInt();      
                String resultado = g.cria_medico( nome, morada,especialidade,dia,mes,ano);
                System.out.printf(resultado+"\n\n");
            }
            else if (x == 2) {
                System.out.printf("Indique a Informação que quer Alterar\n1-Morada\n2-Nome\n3-Especialidade");
                int j = s.nextInt();
                if (j == 1) {
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Insira a morada do Medico");
                    String morada = s.nextLine();        
                    System.out.println(g.ins_moradaMedico(id, morada));
                }            
                else if (j == 2) {
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Insira o nome do Medico");
                    String nome = s.next();              
                    System.out.println(g.ins_nomeMedico(id, nome));
                }else if (j == 3){
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Insira a especialidade do Medico");
                    String especialidade = s.next();    
                    System.out.println( g.ins_especialidadeMedico(id, especialidade));
                }else{
                    System.out.println("Operação Não Disponivel");
                }
            }
            else if (x == 3){
                System.out.printf("Indique a Informação que quer Consultar\n1-Morada\n2-Nome\n3-Especialidade");
                int z = s.nextInt();
                if(z == 1){
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Morada :"+g.cons_moradaMedico(id));
                }else if(z == 2){
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Nome :"+g.cons_nomeMedico(id));
                }else if(z == 3){
                    System.out.println("Insira o id do Medico");
                    int id = s.nextInt();
                    System.out.println("Especialidade :"+g.cons_especialidadeMedico(id));
                } else{
                    System.out.println("Operação Não Disponivel");
                }
            }
            
        }




    }
}
