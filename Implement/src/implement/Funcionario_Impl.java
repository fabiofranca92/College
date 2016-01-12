/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.Funcionario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fabiofranca
 */
public class Funcionario_Impl extends UnicastRemoteObject implements Funcionario,java.io.Serializable {
    private String nome;
    private String funcao;
    private String morada;
  

    public Funcionario_Impl() throws RemoteException{
        super();
    }
    
    @Override
    public void setnome(String nome) throws RemoteException{
        this.nome = nome;
    }
    @Override
    public String getnome() throws RemoteException{
        return this.nome;
    }
    @Override
    public void setmorada(String morada) throws RemoteException{
        this.morada= morada;
    }
    @Override
    public String getmorada() throws RemoteException{
        return this.morada;
    }
    @Override
    public void setfuncao(String funcao) throws RemoteException{
        this.funcao = funcao;
    }
    @Override
    public String getfuncao() throws RemoteException{
        return this.funcao;
    }
}
