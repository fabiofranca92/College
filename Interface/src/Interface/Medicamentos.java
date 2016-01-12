/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fabiofranca
 */
public interface Medicamentos extends Remote {
    
    public int getidmedicamento() throws RemoteException;
    
    public void setidmedicamento(int id) throws RemoteException;
    
    public String getNomeMedicamento() throws RemoteException ;
    
     public void setNomeMedicamento(String nome) throws RemoteException;
    
    
}
