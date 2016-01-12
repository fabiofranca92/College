/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Consulta;
import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Medicos;
import Interface.Receita;
import Interface.Utentes;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class Medicos_Impl extends UnicastRemoteObject implements  Medicos, Serializable {
    private String nome ;
    private String morada;
    private String especialidade ;
    private HashSet<Receita> receitas = new HashSet<>();
    private HashMap<Integer,Integer> medicamentos = new HashMap<>();
    private HashSet<Integer> consultas = new HashSet<>();
    
    private Date data;
   
   
    public Medicos_Impl() throws RemoteException{       
        
  }
    @Override
    public void setConsulta(int idconsulta) throws RemoteException{
        consultas.add(idconsulta);
    }
    @Override
    public int getConsultas() throws RemoteException{
        return consultas.size();
    }
    @Override
    public HashSet GETCONS() throws RemoteException{
        return consultas;
    }
    @Override
    public void setReceit(Receita r) throws RemoteException{
        receitas.add(r);
    }
    @Override
    public int getReceitas() throws RemoteException {
        return receitas.size();
    }
    @Override
    public HashSet getReceita() throws RemoteException{
        return receitas;
    }
    @Override
    public String getMoradaMedico() throws RemoteException{
        return this.morada;
    }

   
    @Override
    public void setMoradaMedico( String morada) throws RemoteException {
        this.morada = morada;
    }

    
    @Override
    public void setNomeMedico(String nome) throws RemoteException {
       this.nome= nome;
    }

   
    @Override
    public String getNomeMedico() throws RemoteException {
       return this.nome;
    }

    
    @Override
    public String getdataMedico() throws RemoteException {
        return this.data.toString();
    }

    
    @Override
    public void setdataMedico(int dia, int mes,int ano) throws RemoteException {
        
        Date d = new Date(ano-1900,mes-1,dia);
        this.data= d;
    }

    
    @Override
    public String getEspecialidade() throws RemoteException {
        return this.especialidade;
    }

   
    @Override
    public void setEspecialidade(String especialidade) throws RemoteException {
       this.especialidade = especialidade;
    }

    @Override
   public void setmedicamento( int idmedicamento, int quantidade) throws RemoteException{
       
       medicamentos.put(idmedicamento, quantidade);
   }
   
    @Override
   public int getQuant(int idmedicamento) throws RemoteException{
        if(!medicamentos.containsKey(idmedicamento)){
            return -1;
        }else{
       return medicamentos.get(idmedicamento);
        }
   }

   

   
}
