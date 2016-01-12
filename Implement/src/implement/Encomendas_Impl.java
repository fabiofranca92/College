/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Encomendas;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author fabiofranca
 */
public class Encomendas_Impl extends UnicastRemoteObject implements Encomendas, java.io.Serializable {
   
    private int idmedicamento;
    
    private int quantidade;
    private Date data;
      
    public Encomendas_Impl() throws RemoteException{
         
      }     
     
      
    @Override
      public void setidMedicamento(int idmedicamento){
        this.idmedicamento = idmedicamento;
    }
    @Override
      public void setquantidade(int quantidade){
        this.quantidade = quantidade;
    }
    @Override
    public int getMed() {
        return this.idmedicamento;
    }
    @Override
    public int getQuant(){
        return this.quantidade;
    }
    
    @Override
    public void setData(int dia,int mes, int ano) throws RemoteException{
        Date d = new Date(ano-1900,mes-1,dia);
        this.data= d;
    }
public Date getData() throws RemoteException{
    return this.data;
   
    }
}
