/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Interface.AtoEnfermagem;
import Interface.Consulta;
import Interface.Encomendas;
import Interface.EncomendasProd;
import Interface.Enfermeiros;
import Interface.Farmacia;
import Interface.Funcionario;
import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Medicos;
import Interface.Produtos;
import Interface.Receita;
import Interface.Utentes;
import implement.AtoEnfermagem_Impl;
import implement.Consulta_Impl;
import implement.EncomendasProd_Impl;
import implement.Encomendas_Impl;
import implement.Enfermeiros_Impl;
import implement.Farmacias_Impl;
import implement.Funcionario_Impl;
import implement.Gestor_Impl;
import implement.Medicamentos_Impl;
import implement.Medicos_Impl;
import implement.Produtos_Impl;
import implement.Receita_Impl;
import implement.Utentes_Impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor implements Runnable{
    Gestor stub;
    Utentes stub1;
    Medicos stub2;
    Enfermeiros stub3;
    Funcionario stub4;
    Receita stub5;
    Medicamentos stub6;
    Consulta stub7;
    AtoEnfermagem stub8;
    Encomendas stub9;
    EncomendasProd stub10;
    Farmacia stub11;
    Produtos stub12;
    
    public Servidor(){
       try {	
            carregar();
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {   
//             stub = new Gestor_Impl();
//             stub1 = new Utentes_Impl();
//             stub2 = new Medicos_Impl();
//             stub3= new Enfermeiros_Impl();
//             stub4 = new Funcionario_Impl();
//             stub5 = new Receita_Impl();
//             stub6 = new Medicamentos_Impl();
//             stub7 = new Consulta_Impl()  ;
//            stub8 = new AtoEnfermagem_Impl();
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.rebind("GestaoUtentes", stub);
                registry.rebind("Utente", stub1);
                registry.rebind("Medicos", stub2);
                registry.rebind("Enfermeiros", stub3);
                registry.rebind("Funcionarios", stub4);
                registry.rebind("Receita", stub5);
                registry.rebind("Medicamentos", stub6);
                registry.rebind("Consulta", stub7);
                registry.rebind("AEnfermagem",stub8);
//                registry.rebind("Encomendas", stub9);
//                registry.rebind("EncomendasProd_Impl", stub10);
//                registry.rebind("Farmacias", stub11);
//                registry.rebind("Produtos", stub12);
//               
                System.out.println("Servidor Pronto");
                new Thread(this).run();

		} catch (RemoteException e) {
			e.printStackTrace();
        }
    }
    
    public   void guardar(){
        try{
            
            OutputStream fos = new FileOutputStream("dados.dat");
            BufferedOutputStream buffer = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(buffer);
            
            oos.writeObject(stub);
            oos.writeObject(stub1);
            oos.writeObject(stub2);
            oos.writeObject(stub3);
            oos.writeObject(stub4);
            oos.writeObject(stub5);
            oos.writeObject(stub6);
            oos.writeObject(stub7);
            oos.writeObject(stub8);
            oos.writeObject(stub9);
            oos.writeObject(stub10);
            oos.writeObject(stub11);
            oos.writeObject(stub12);
           
            
            oos.flush();
            fos.close();
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public final   void carregar() throws RemoteException {
        try {
            
            InputStream fis = new FileInputStream("dados.dat");
            
            
            BufferedInputStream buffer = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(buffer);         
            
             stub = (Gestor) ois.readObject();
             stub1 = (Utentes) ois.readObject();
             stub2 = (Medicos) ois.readObject();
             stub3 = (Enfermeiros) ois.readObject();
             stub4 = (Funcionario) ois.readObject();
             stub5 = (Receita) ois.readObject();
             stub6 = (Medicamentos) ois.readObject();
             stub7 = (Consulta) ois.readObject();
             stub8 = (AtoEnfermagem) ois.readObject();
             stub9 = (Encomendas) ois.readObject();
            stub10 = (EncomendasProd) ois.readObject();
            stub11 = (Farmacia) ois.readObject();
            stub12 = (Produtos) ois.readObject();
      
            fis.close();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("O ficheiro nao Existe");
           
             stub = new Gestor_Impl();
             stub1 = new Utentes_Impl();
             stub2 = new Medicos_Impl();
             stub3= new Enfermeiros_Impl();
             stub4 = new Funcionario_Impl();
             stub5 = new Receita_Impl();
             stub6 = new Medicamentos_Impl();
             stub7 = new Consulta_Impl()  ;
            stub8 = new AtoEnfermagem_Impl();
        } catch (IOException ex) {
           ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void run() {
            Scanner s = new Scanner(System.in);
            System.out.println("Insira quit para sair e gravar.");
            int i =0 ;
            while (i==0){
                String str = s.next();
                if(str.equals("quit")){
                    this.guardar();
                    System.exit(0);
                    i= 1;
                }
            }
    }
    

    public static void main(String args[]) throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException{
	 
	Servidor s=new Servidor();
    }

}