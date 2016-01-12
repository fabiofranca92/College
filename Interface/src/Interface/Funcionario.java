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
public interface Funcionario extends Remote {
    public void setnome(String nome) throws RemoteException;
 
    public String getnome() throws RemoteException;
    
    public void setmorada(String morada) throws RemoteException;
    
    public String getmorada() throws RemoteException;
    
    public void setfuncao(String funcao) throws RemoteException;
    
    public String getfuncao() throws RemoteException;
}
