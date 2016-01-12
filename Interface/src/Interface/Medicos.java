/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;


/**
 *
 * @author fabiofranca
 */
public interface Medicos extends Remote {
    public String getMoradaMedico() throws RemoteException;
    
    public void setMoradaMedico(String morada) throws RemoteException;
    
    public void setNomeMedico(String nome ) throws RemoteException;
    
    public String getNomeMedico() throws RemoteException;
    
    public String getdataMedico() throws RemoteException;
    
    public void setdataMedico(int dia,int mes,int ano) throws RemoteException;
    
    public String getEspecialidade() throws RemoteException;
    
    public void setEspecialidade(String especialidade) throws RemoteException;
    
    public void setmedicamento(int idmedicamento, int quantidade) throws RemoteException;
    
    public int getQuant(int idmedicamento) throws RemoteException;
    
    public void setConsulta(int idconsulta) throws RemoteException;
    
    public int getConsultas() throws RemoteException;
    public HashSet GETCONS() throws RemoteException;
    public void setReceit(Receita r) throws RemoteException;
    
    public int getReceitas() throws RemoteException ;
    
    public HashSet getReceita() throws RemoteException;
}
