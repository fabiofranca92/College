/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.AtoEnfermagem;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author fabiofranca
 */
public class AtoEnfermagem_Impl extends UnicastRemoteObject implements AtoEnfermagem,java.io.Serializable {
    private HashMap<Integer,Integer> produtos = new HashMap<>();
    private HashMap<Integer,Integer> medicamentos = new HashMap<>();
    private int idenfermeiro;
    private int idutente;
    private Date data;

    public AtoEnfermagem_Impl() throws RemoteException{
    
    }
    @Override
        public void setProdutos(int produto,int quantidade) throws RemoteException{
           this.produtos.put(produto, quantidade);
        
    }
    @Override
    public HashMap getProdutos() throws RemoteException{
        return this.produtos;
    }
    @Override
    public void setMedicamentos(int medicamento,int quantidade)throws RemoteException{
           this.medicamentos.put(medicamento, quantidade);
        
    }
    @Override
    public HashMap getMedicamentos()throws RemoteException{
        return this.medicamentos;
    }
    @Override
        public void setEnfermeiro(int idenfermeiro)throws RemoteException{
            this.idenfermeiro = idenfermeiro;
        }
    @Override
        public void setUtente(int idutente)throws RemoteException{
            this.idutente = idutente;
        }
    
    @Override
    public int getidUtente() throws RemoteException{
        return this.idutente;
    }
    @Override
    
    public int getidEnferm() throws RemoteException{
        return this.idenfermeiro;
    }
    
    @Override
     public void setdata(int dia,int mes,int ano,int hora) throws RemoteException {
        Date horacons = new Date(ano - 1900, mes - 1, dia, hora, 00);
        this.data = horacons;
    }
    @Override
    public Date getData() throws RemoteException {
        return this.data;
    }
}
       


