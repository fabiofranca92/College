/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author fabiofranca
 */
public interface Utentes extends Remote {
  
    public HashMap<Integer,Integer> getmed() throws RemoteException;
    
    public String getMoradaUtente() throws RemoteException;
    
    public void setMoradaUtente(String morada) throws RemoteException;
    
    public void setNomeUtente(String nome ) throws RemoteException;
    
    public String getNomeUtente() throws RemoteException;
    
    public String getdataUtente() throws RemoteException;
    
    public Date setdataUtente(int dia,int mes,int ano) throws RemoteException;
    
    public void setmedicamentoUtente (int idmedicamento,int quantidade) throws RemoteException;
    
    public HashSet getConsulta() throws RemoteException;
    
    public void setConsulta(int idconsulta) throws RemoteException;
}
    