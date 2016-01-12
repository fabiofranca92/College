package cliente;

import Interface.Enfermeiros;
import Interface.Gestor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import Interface.Utentes;

/**
 *
 * @author Filipe
 */
public class CriarEditarEnfermeiro {

    public static void main(String args[]) throws RemoteException, NotBoundException {

        Gestor g;
        Enfermeiros e;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        e = (Enfermeiros) registry.lookup("Enfermeiros");
        int x = 0;

        while (x != 4) {
            System.out.printf("Introduza o numero da operação que deseja:\n1- Adicionar\n2-Editar\n3-Consultar\n4-Sair\n");
            Scanner s = new Scanner(System.in);
            x = s.nextInt();
            if (x == 1) {
                System.out.println("Insira o nome do Enfermeiro");
                String nome = s.next();
                System.out.printf("Insira a morada do Enfermeiro\n");
                String morada = s.next();
                System.out.println("Introduza um dia(dd) ,depois o Mes(mm) e o ano(yyyy) ");
                int dia = s.nextInt();
                int mes = s.nextInt();
                int ano = s.nextInt();
                String resultado = g.cria_enfermeiro( nome, morada, dia, mes, ano);
                System.out.printf(resultado + "\n\n");
            } else if (x == 2) {
                System.out.printf("Indique a Informação que quer Alterar\n1-Morada\n2-Nome");
                int j = s.nextInt();
                if (j == 1) {
                    System.out.println("Insira o id do Enfermeiro");
                    int id = s.nextInt();
                    System.out.println("Insira a morada do Enfermeiro");
                    String morada = s.nextLine();
                    System.out.println(g.ins_moradaEnfermeiro(id, morada));

                } else if (j == 2) {
                    System.out.println("Insira o id do Enfermeiro");
                    int id = s.nextInt();
                    System.out.println("Insira o nome do Enfermeiro");
                    String nome = s.next();
                    System.out.println(g.ins_nomeEnfermeiro(id, nome));
                } else {
                    System.out.println("Operação Não Disponivel");
                }

            } else if (x == 3) {
                System.out.printf("Indique a Informação que quer Consultar\n1-Morada\n2-Nome\n3-Data");
                int z = s.nextInt();
                if (z == 1) {
                    System.out.println("Insira o id do Enfermeiro");
                    int id = s.nextInt();
                    System.out.println("Morada :" + g.cons_moradaEnfermeiro(id));
                } else if (z == 2) {
                    System.out.println("Insira o id do Enfermeiro");
                    int id = s.nextInt();
                    System.out.println("Nome :" + g.cons_nomeEnfermeiro(id));
                } else if (z == 3) {
                    System.out.println("Insira o id do Enfermeiro");
                    int id = s.nextInt();
                    System.out.println("Data: " + g.cons_dataEnfermeiro(id));
                } else {
                    System.out.println("Operação Não Disponível");

                }

            }

        }
    }
}