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
public interface Receita extends Remote{
     public void setmedicamento(int idmedicamento,int quantidade) throws RemoteException;
     
     
}
