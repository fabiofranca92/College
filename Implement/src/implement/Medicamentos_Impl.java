/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Medicos;
import Interface.Utentes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.HashSet;

/**
 *
 * @author fabiofranca
 */
public class Medicamentos_Impl extends UnicastRemoteObject  implements Medicamentos,java.io.Serializable{
    private String nome;
    private int preco;  
    private HashSet<Utentes> utentes = new HashSet<Utentes>();
    private HashSet<Medicos> medicos = new HashSet<Medicos>();
    private int idmedicamento;

public Medicamentos_Impl() throws RemoteException{    


}

    @Override
    public int getidmedicamento() throws RemoteException {
        return idmedicamento;
    }

    @Override
    public void setidmedicamento(int id) throws RemoteException {
        this.idmedicamento = id;
    }

    @Override
    public String getNomeMedicamento() throws RemoteException {
       return this.nome;
    }
    @Override
    public void setNomeMedicamento(String nome) throws RemoteException{
        this.nome = nome;
    }

   
   
}