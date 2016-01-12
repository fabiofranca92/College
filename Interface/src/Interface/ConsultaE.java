/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Filipe
 */
public interface ConsultaE extends Remote {
    
    public void setenfermeiro( int idenfermeiro) throws RemoteException;
    
    public void setidutente(int idutente) throws RemoteException;
}

