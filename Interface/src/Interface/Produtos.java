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
public interface Produtos extends Remote {
    
    public String getnomeProduto() throws RemoteException;
    
    public void setNome(String nome) throws RemoteException;
}
