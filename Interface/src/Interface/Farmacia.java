
    package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Filipe
 */
public interface Farmacia extends Remote {
    
   
     public int getquantidade() throws RemoteException;
    
     public int getstock() throws RemoteException;
     
     public void setstock(int stock) throws RemoteException;
     
     public void setquantidade(int quantidade) throws RemoteException;
     
}

