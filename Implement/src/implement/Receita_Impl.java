/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Medicamentos;
import Interface.Receita;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author fabiofranca
 */
public class Receita_Impl extends UnicastRemoteObject implements Receita,java.io.Serializable {
    private HashMap<Integer,Integer> medReceita ;
    private int idreceita;
    public Receita_Impl() throws RemoteException {
        medReceita = new HashMap<Integer,Integer>();
    }
    
    public void setmedicamento(int idmedicamento,int quantidade) throws RemoteException{
       medReceita.put(idmedicamento, quantidade);
       
    }
    
}
