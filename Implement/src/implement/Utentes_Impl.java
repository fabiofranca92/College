/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Consulta;
import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Medicos;
import Interface.Utentes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author fabiofranca
 */
public class Utentes_Impl extends UnicastRemoteObject implements Utentes,java.io.Serializable {
    private String nome;
    private String morada;
    private Date data;
    private HashMap<Integer,Integer> medicamentos = new HashMap<>();
    private HashSet<Integer> consulta = new HashSet<>();
    private int idmedico;
    
    public Utentes_Impl() throws RemoteException {
        super();
    }
    
    @Override
    public HashMap<Integer,Integer> getmed() throws RemoteException{
        return this.medicamentos;
    }

    @Override
    public String getMoradaUtente() throws RemoteException {
       return this.morada;
    }

    @Override
    public void setMoradaUtente(String morada) throws RemoteException {
        this.morada = morada;
    }

    @Override
    public void setNomeUtente(String nome) throws RemoteException {
        this.nome = nome ;
    }

    @Override
    public String getNomeUtente() throws RemoteException {
       return this.nome;
    }

    @Override
    public String getdataUtente() throws RemoteException {
        return data.toString();
    }

    @Override
    public Date setdataUtente(int dia,int mes,int ano) throws RemoteException {
        Date d = new Date(ano-1900,mes-1,dia);
        return d;
    }
    @Override
    public void setmedicamentoUtente (int idmedicamento,int quantidade){
        medicamentos.put(idmedicamento, quantidade);
    }
    @Override
    public void setConsulta(int idconsulta) throws RemoteException{
        this.consulta.add(idconsulta);
    }
    @Override
    public HashSet getConsulta() throws RemoteException{
    return this.consulta;
}
    
   
}