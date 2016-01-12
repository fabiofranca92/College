/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Funcionario;
import Interface.Gestor;
import Interface.Medicos;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class CriarEditarFuncionario {
      public static void main(String args[]) throws RemoteException, NotBoundException {
            Gestor g;
            Funcionario f;
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            g = (Gestor) registry.lookup("GestaoUtentes");
            f = (Funcionario) registry.lookup("Funcionarios");
        int x = 0;


        while (x != 4) {
            System.out.printf("Funcionario\nIntroduza o numero da operação que deseja:\n1- Adicionar\n2-Editar\n3-Consultar\n4-Sair\n");
            Scanner s = new Scanner(System.in);
            x= s.nextInt();
            if (x == 1) {
                
                System.out.println("Insira o nome :");
                String nome = s.next();
                System.out.printf("Insira a morada :\n\n");
                String morada = s.next();
                System.out.println("Insira a Função");
                String funcao = s.next();
                String resultado = g.cria_func( nome, morada,funcao);
                System.out.printf(resultado+"\n\n");
            }
            else if (x == 2) {
                System.out.printf("Indique a Informação que quer Alterar\n1-Morada\n2-Nome\n3-Função");
                int j = s.nextInt();
                if (j == 1) {
                    System.out.println("Insira o id do Funcionario");
                    int id = s.nextInt();
                    System.out.println("Insira a morada");
                    String morada = s.nextLine();
                    System.out.println( g.ins_moradaFunc(id, morada));
                }
            
                else if (j == 2) {
                    System.out.println("Insira o id do Funcionário");
                    int id = s.nextInt();
                    System.out.println("Insira o nome:");
                    String nome = s.next();      
                    System.out.println( g.ins_nomeFunc(id, nome));
                }else if ( j == 3 ){
                    System.out.println("Insira o id do Funcionário");
                    int id = s.nextInt();
                    System.out.println("Insira a funcao:");
                    String nome = s.next();      
                    System.out.println( g.ins_funcao(id, nome));
                } else {
                     System.out.println("Operação Não Disponivel");
                }
            }
            else if (x == 3){
                System.out.printf("Indique a Informação que quer Consultar\n1-Morada\n2-Nome\n3-Funcao");
                int z = s.nextInt();
                if(z == 1){
                    System.out.println("Insira o id do Funcionario");
                    int id = s.nextInt();
                    System.out.println("Morada :"+g.cons_moradaFunc(id));
                }else if(z == 2){
                    System.out.println("Insira o id do Funcionário");
                    int id = s.nextInt();
                    System.out.println("Nome :"+g.cons_nomeFunc(id));
                }else if ( z == 3){
                    System.out.println("Insira o id do Utente");
                    int id = s.nextInt();
                    System.out.println("Função :"+g.cons_funcao(id));
                }else{
                     System.out.println("Operação Não Disponivel");
                }
            }
            
        }




    }
}
