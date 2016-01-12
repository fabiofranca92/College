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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class Listar {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        Gestor g = null;
        Registry registry;
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        Scanner s = new Scanner(System.in);
        System.out.printf("Indique a Entidade que deseja ver\n"
                + "1-Utentes\n"
                + "2-Medicos\n"
                + "3-Funcionarios\n"
                + "4-Enfermeiros\n");
        int x = s.nextInt();
        if (x == 1) {
            HashSet<String> cons = new HashSet<>();
            cons.addAll(g.ListarMedicos());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }

        } else if (x == 2) {
            HashSet<String> cons = new HashSet<>();

            cons.addAll(g.ListarMedicos());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }
        } else if (x == 3) {
            HashSet<String> cons = new HashSet<>();

            cons.addAll(g.ListarFuncionarios());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }
        } else if (x == 4) {
            HashSet<String> cons = new HashSet<>();

            cons.addAll(g.ListarEnfermeiros());
            Iterator<String> it = cons.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }
        } else {
            System.out.println("Operação Indisponivel");
        }
    }
}