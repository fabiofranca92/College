/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Consulta;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author fabiofranca
 */
public class Consulta_Impl extends UnicastRemoteObject implements Consulta,java.io.Serializable {

    private int idmedico;
    private String especialidade;
    private int idutente;
    private Date data;
    public Consulta_Impl() throws RemoteException{
        
        super();
       
    }

    @Override
    public void setmedico( int idmedico) throws RemoteException {
        this.idmedico= idmedico;
    }
    
    @Override
    public void setidutente(int idutente) throws RemoteException {
        this.idutente = idutente;
    }
    public int getidutente() throws RemoteException{
        return this.idutente;
    }
    @Override
    public int getidmedico() throws RemoteException {
       return this.idmedico;
    }
    
    @Override
    public void setEspecialidade(String especialidade) throws RemoteException {
        this.especialidade= especialidade;
    }
    @Override
   public String getEspecialidade() throws RemoteException {
       return this.especialidade;
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