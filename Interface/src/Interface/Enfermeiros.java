/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
/**
 *
 * @author Filipe
 */
public interface Enfermeiros extends Remote {
    
    public void setNomeEnfermeiro(String nome) throws RemoteException;
    
    public String getNomeEnfermeiro() throws RemoteException;
    
    public String getdataEnfermeiro() throws RemoteException;
    
    public Date setdataEnfermeiro(int dia,int mes,int ano) throws RemoteException;
    
    public String getMoradaEnfermeiro() throws RemoteException;
    
    public void setMoradaEnfermeiro(String morada) throws RemoteException;
    
    public int getAtos() throws RemoteException;
    
    public void setAtos(AtoEnfermagem ae) throws RemoteException;
}