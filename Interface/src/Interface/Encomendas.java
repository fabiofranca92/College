/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author fabiofranca
 */
public interface Encomendas extends Remote {
    
    
    
     public void setData(int dia,int mes, int ano) throws RemoteException;
     
     public void setidMedicamento(int idmedicamento) throws RemoteException;
    
      public void setquantidade(int quantidade) throws RemoteException;
      
      public int getMed() throws RemoteException ;
      
      public int getQuant() throws RemoteException;
      
      public Date getData() throws RemoteException;
      
      
          
      
}
