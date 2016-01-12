/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Interface.Gestor;
import Interface.Utentes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fabiofranca
 */
public class PopularTabelas {
     public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        Gestor g;
        Random r = new Random();
        Utentes u;
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        g = (Gestor) registry.lookup("GestaoUtentes");
        final File file_n = new File("/Users/fabiofranca/Desktop/nomes.txt");
        final File file_m = new File("/Users/fabiofranca/Desktop/morada.txt");
        final File file_a = new File("/Users/fabiofranca/Desktop/apelido.txt");
        final File file_e = new File("/Users/fabiofranca/Desktop/especialidade.txt");
        final File file_f = new File("/Users/fabiofranca/Desktop/funcoes.txt");
        
        BufferedReader reader_nome = new BufferedReader(new FileReader(file_n));
        BufferedReader reader_morada = new BufferedReader(new FileReader(file_m));
        BufferedReader reader_apelido = new BufferedReader(new FileReader(file_a));
        BufferedReader reader_especialidade = new BufferedReader(new FileReader(file_e));
        BufferedReader reader_funcao = new BufferedReader(new FileReader(file_f));
        
        ArrayList<String> temp_nome = new ArrayList<>();
        ArrayList<String> temp_apelido = new ArrayList<>();
        ArrayList<String> temp_morada = new ArrayList<>();
        ArrayList<String> temp_especialidade = new ArrayList<>();
        ArrayList<String> temp_funcao = new ArrayList<>();
        
        String line_n, line_m, line_a, line_e, line_f;
        int countn = 0, countm = 0, counta = 0, counte = 0;
        while ((line_n = reader_nome.readLine()) != null) {
            temp_nome.add(line_n);
            countn += 1;
        }
        while ((line_m = reader_morada.readLine()) != null) {
            temp_morada.add(line_m);
            countm += 1;
        }
        while ((line_a = reader_apelido.readLine()) != null) {
            temp_apelido.add(line_a);
            counta += 1;
        }
        while ((line_e = reader_especialidade.readLine()) != null) {
            temp_especialidade.add(line_e);
            counte += 1;
        }
        while ((line_f = reader_funcao.readLine()) != null) {
            temp_funcao.add(line_f);
            counte += 1;
        }
        System.out.println("1");
        int i, dia,mes;
        int ano = 0;
        String nomepu = null, nomeau = null, morada = null;
        for (i = 1; i <= 100000; i++) {
            
            nomepu = temp_nome.get((int) (Math.random() * countn));
            nomeau = temp_apelido.get((int) (Math.random() * counta));
            String nomeu = (nomepu + " " + nomeau);
            morada = temp_morada.get((int) (Math.random() * countm));
            
            dia = (int) r.nextInt(29);
            
            mes = (int) r.nextInt(12);
            
            ano = (int) r.nextInt(1912)+100;
            
            g.cria_utente( nomeu, morada, dia,mes,ano);
            System.out.println("U"+i);
        }
         System.out.println("utentes ok");
        String nomepe = null, nomeae = null, nomee;
        for ( i = 1; i <= 7000; i++) {
            nomepe = temp_nome.get((int) (Math.random() * countn));
            nomeae = temp_apelido.get((int) (Math.random() * counta));
            nomee = (nomepe + " " + nomeae);
            morada = temp_morada.get((int) (Math.random() * countm));
             dia = (int) r.nextInt(29);
            
            mes = (int) r.nextInt(12);
            
            ano = (int) r.nextInt(65)+1947;
            
            g.cria_enfermeiro(nomee, morada, dia, mes, ano);
             System.out.println("E"+i);
        }
         System.out.println("enfermeiros ok");
        String nomepm = null, nomeam = null, nomem, especialidade;
        for (i = 1; i <= 5000; i++) {
            nomepm = temp_nome.get((int) (Math.random() * countn));
            nomeam = temp_apelido.get((int) (Math.random() * counta));
            nomem = (nomepm + " " + nomeam);
            especialidade = temp_especialidade.get((int) r.nextInt(9));
            morada = temp_morada.get((int) (Math.random() * countm));
             dia = (int) r.nextInt(29);
            
            mes = (int) r.nextInt(12);
            
            ano = (int) r.nextInt(65)+1947;
            
            g.cria_medico(nomem, morada, especialidade, dia, mes, ano);
            System.out.println("M"+i);
        }
        String nomepf = null, nomeaf = null, nomef,funcao = null;
        for (i = 1; i <= 3000; i++) {
            morada = temp_morada.get((int) (Math.random() * countm));
            nomepf = temp_nome.get((int) (Math.random() * countn));
            nomeaf = temp_apelido.get((int) (Math.random() * counta));
            nomef = (nomepf + " " + nomeaf);
            funcao = temp_funcao.get((int) (Math.random() * countn));
            g.cria_func(nomef,funcao,morada);
            System.out.println("F"+i);
        }
         System.out.println("funcionarios ok");

        g.cria_medicamento("Ben-u-ron", 23);
        g.cria_medicamento("Brufen", 43);
        g.cria_medicamento("Clavamox", 11);
        g.cria_medicamento("Vastarel", 10);
        g.cria_medicamento("Imodium", 43);
        g.cria_medicamento("Buscopan", 21);
        g.cria_medicamento("Gurosan", 15);
        g.cria_medicamento("Xanax", 14);
        
        
        g.cria_produto("Algálias", 12);
        g.cria_produto("Adesivo comum", 100);
        g.cria_produto("Algodão cardado", 200);
        g.cria_produto("Pensos impermeáveis", 30);
        g.cria_produto("Desinfectante para mãos", 10);
        g.cria_produto("Frasco para recolha de amostras", 12);
        g.cria_produto("Gel lubrificante", 12);
        g.cria_produto("Seringa", 30);
        g.cria_produto("Penso rápido", 300);
         

        for (int zy = 1; zy <= 300; zy++) {

            int idmedico = r.nextInt(50)+1;
            int idutente = r.nextInt(50)+1;
            int medicamento = r.nextInt(8)+1;
            int quantidade = r.nextInt(5)+1;
            
            System.out.println(g.cria_receita(idmedico, idutente, medicamento, quantidade));
              
        }
      for (int zy = 1; zy <= 300; zy++) {

            int idmedico = r.nextInt(50)+1;
            int idutente = r.nextInt(50)+1;
             dia = r.nextInt(8)+1;
             mes = r.nextInt(5)+1;
             ano = r.nextInt(2)+2013;
            int hora = r.nextInt(5)+12;
            System.out.println(g.cria_consultaMedica(idmedico, idutente, dia, mes, ano, hora));
             
        }
          for (int zy = 1; zy <= 300; zy++) {

            int idmedico = r.nextInt(50)+1;
            int idutente = r.nextInt(50)+1;
             dia = r.nextInt(8)+1;
             mes = r.nextInt(5)+1;
             ano = r.nextInt(2)+2013;
            int hora = r.nextInt(5)+12;
            System.out.println(g.cria_consultaEnfermeiro(idmedico, idutente, dia, mes, ano, hora));
             
        }
     }

}


