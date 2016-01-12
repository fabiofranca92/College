/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabiofranca
 */
package implement;

import Interface.AtoEnfermagem;
import Interface.Enfermeiros;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import Interface.Utentes;

/**
 *
 * @author Filipe
 */
public class Enfermeiros_Impl extends UnicastRemoteObject implements Enfermeiros, Serializable{

    private String nome;
    private String morada;
    private HashSet<Utentes> utentes = new HashSet<>();
    private HashSet<AtoEnfermagem> atosenferm = new HashSet<>();
    private Date data;

    public Enfermeiros_Impl() throws RemoteException {
        this.atosenferm = new HashSet<>();
        this.utentes = new HashSet<>();
    }

    @Override
    public void setNomeEnfermeiro(String nome) throws RemoteException {
        this.nome = nome;
    }

    @Override
    public String getNomeEnfermeiro() throws RemoteException {
        return this.nome;
    }

    @Override
    public String getdataEnfermeiro() throws RemoteException {
        return this.data.toString();
    }

    @Override
    public Date setdataEnfermeiro(int dia, int mes, int ano) throws RemoteException {

        Date d = new Date(ano - 1900, mes - 1, dia);
        return d;
    }

    @Override
    public String getMoradaEnfermeiro() throws RemoteException {
        return this.morada;
    }

    @Override
    public void setMoradaEnfermeiro(String morada) throws RemoteException {
        this.morada = morada;
    }
    @Override
    public int getAtos() throws RemoteException{
        return this.atosenferm.size();
    }
    @Override
    public void setAtos(AtoEnfermagem ae) throws RemoteException{
        this.atosenferm.add(ae);
    }
}