/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author fabiofranca
 */
public interface AtoEnfermagem extends Remote {

    public int getidUtente() throws RemoteException;
    public void setProdutos(int produto, int quantidade) throws RemoteException;

    public HashMap getProdutos() throws RemoteException;

    public void setMedicamentos(int medicamento, int quantidade) throws RemoteException;

    public HashMap getMedicamentos() throws RemoteException;

    public void setEnfermeiro(int idenfermeiro) throws RemoteException;

    public void setUtente(int idutente) throws RemoteException;

    public int getidEnferm() throws RemoteException;

    public void setdata(int dia, int mes, int ano, int hora) throws RemoteException;

    public Date getData() throws RemoteException;
}
