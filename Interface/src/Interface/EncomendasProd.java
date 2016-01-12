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
 * @author fabiofranca
 */
public interface EncomendasProd extends Remote {
     public void setData(int dia,int mes, int ano) throws RemoteException;
     
     public void setidProduto(int idproduto) throws RemoteException;
    
      public void setquantidade(int quantidade) throws RemoteException;
      
      public int getPro() throws RemoteException ;
      
      public int getQuant() throws RemoteException;
      
      public Date getData() throws RemoteException;
}
