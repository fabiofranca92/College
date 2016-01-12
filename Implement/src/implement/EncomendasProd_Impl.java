/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Encomendas;
import Interface.EncomendasProd;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author fabiofranca
 */
public class EncomendasProd_Impl extends UnicastRemoteObject implements EncomendasProd, java.io.Serializable{
    
    private int idencomenda;
    private int idproduto;
    
    private int quantidade;
    private Date data;
      
    public EncomendasProd_Impl() throws RemoteException{
         
      }     
     
      
    @Override
      public void setidProduto(int idproduto){
        this.idproduto = idproduto;
    }
    @Override
      public void setquantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getPro() {
        return this.idproduto;
    }
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

