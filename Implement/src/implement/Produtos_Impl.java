/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Produtos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fabiofranca
 */
public class Produtos_Impl extends UnicastRemoteObject implements Produtos,java.io.Serializable{
    private String nome;
    
    
    public Produtos_Impl() throws RemoteException{
                
            }

    @Override
    public String getnomeProduto() throws RemoteException{
        return this.nome;
    }
    @Override
    public void setNome(String nome) throws RemoteException{
        this.nome = nome;
    }
}
