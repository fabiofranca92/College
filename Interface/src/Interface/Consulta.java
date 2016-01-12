/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author fabiofranca
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface Consulta extends Remote {
    public void setmedico( int idmedico) throws RemoteException;
    
    public void setidutente(int idutente) throws RemoteException;
    
    public int getidmedico() throws RemoteException;
    
    public void setEspecialidade(String especialidade) throws RemoteException ;
     public String getEspecialidade() throws RemoteException ;
     
     public void setdata(int dia,int mes,int ano,int hora) throws RemoteException ;
     
     public Date getData() throws RemoteException ;
     public int getidutente() throws RemoteException;
     
     
}
