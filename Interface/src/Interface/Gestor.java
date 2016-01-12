/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author fabiofranca
 */
public interface Gestor extends Remote {

    public String cria_medico(String nome, String morada, String especialidade, int dia, int mes, int ano) throws RemoteException;

    public String cria_utente(String nome, String morada, int dia, int mes, int ano) throws RemoteException;

    public String cons_moradaMedico(int idmedico) throws RemoteException;

    public String cons_dataMedico(int idmedico) throws RemoteException;

    public String ins_moradaMedico(int idmedico, String morada) throws RemoteException;

    public String ins_dataMedico(int idmedico, int dia, int mes, int ano) throws RemoteException;

    public String cons_nomeMedico(int idmedico) throws RemoteException;

    public String ins_nomeMedico(int idmedico, String nome) throws RemoteException;

    public String cons_especialidadeMedico(int idmedico) throws RemoteException;

    public String ins_especialidadeMedico(int idmedico, String nome) throws RemoteException;

    public String cria_consultaMedica(int idmedico, int idutente, int dia, int mes, int ano, int hora) throws RemoteException;
    
    public int verificaStock(int idmedicamento) throws RemoteException;

    public int getiFunc() throws RemoteException;

    public int getidConsulta() throws RemoteException;

    public String cria_func(String nome, String funcao, String morada) throws RemoteException;

    public String cons_moradaUtente(int idmedico) throws RemoteException;

    public String cons_dataUtente(int idmedico) throws RemoteException;

    public String ins_moradaUtente(int idmedico, String morada) throws RemoteException;

    

    public String cons_nomeUtente(int idmedico) throws RemoteException;

    public String ins_nomeUtente(int idmedico, String nome) throws RemoteException;

    public String cons_moradaFunc(int idfunc) throws RemoteException;

    public String cons_funcao(int idfunc) throws RemoteException;

    public String ins_moradaFunc(int idfunc, String morada) throws RemoteException;

    public String ins_funcao(int idfunc, String funcao) throws RemoteException;

    public String cons_nomeFunc(int idfunc) throws RemoteException;

    public String ins_nomeFunc(int idfunc, String nome) throws RemoteException;

    public boolean confirma_hora(int idmedico, Date horacons) throws RemoteException;

    public int cons_consultas(int idconsulta) throws RemoteException;

    public String cria_enfermeiro(String nome, String morada, int dia, int mes, int ano) throws RemoteException;

    public String cons_moradaEnfermeiro(int idenfermeiro) throws RemoteException;

    public String cons_dataEnfermeiro(int idenfermeiro) throws RemoteException;

    public String ins_dataEnfermeiro(int idmedico, int dia, int mes, int ano) throws RemoteException;

    public String cons_nomeEnfermeiro(int idenfermeiro) throws RemoteException;

    public String ins_nomeEnfermeiro(int idenfermeiro, String nome) throws RemoteException;

    public int getidAto() throws RemoteException ;
    
    public String cria_consultaEnfermeiro( int idenfermeiro, int idutente, int dia, int mes, int ano, int hora) throws RemoteException;

    public String ins_moradaEnfermeiro(int idenfermeiro, String morada) throws RemoteException;

    public String consNomeMedicamento(int i) throws RemoteException;

    public String adicionar_gastosProdutos(int idenfermagem, int produto, int quantidade, int dia, int mes, int ano) throws RemoteException ;

    public void medMedico(int idmedico, int idmedicamento, int quantidade) throws RemoteException;

    public String remover_medicamento(int idmedicamento, int quantidade) throws RemoteException;

    public String cria_receita(int idmedico, int idutente, int idmedicamento, int quantidade) throws RemoteException;

    public String adicionar_medicamento(int idmedicamento, int quantidade) throws RemoteException;

    public int getidMedico() throws RemoteException;

    public String adicionar_gastosMedicamentos (int idenfermagem, int produto, int quantidade,int dia,int mes,int ano ) throws RemoteException ;

    public int getidUtente() throws RemoteException;

    public HashSet<String> consprevIDENFER() throws RemoteException;

    public HashSet<String> consultasDATA(Date data) throws RemoteException;

    public int getidEncomenda() throws RemoteException;

    public String receberEncomenda(int idencomenda) throws RemoteException;

    public String fazerEncomenda(int idmedicamento, int quantidade, int dia, int mes, int ano) throws RemoteException;

    public HashSet verEncomendas() throws RemoteException;
    
    public HashSet verEncomendasPro() throws RemoteException;
    
    public String receberEncomendaProd(int idencomenda) throws RemoteException;

    public String fazerEncomendaProd(int idproduto, int quantidade, int dia, int mes, int ano) throws RemoteException;

    public HashSet<String> consultarStockMedicamentos() throws RemoteException;

    public HashSet<String> consultarProdMin() throws RemoteException;

    public HashSet<String> consultarStockProdutos() throws RemoteException;

    public HashSet<String> consultarMedMin() throws RemoteException;

    public HashSet<String> consprevIDMEDICO(int idmedico) throws RemoteException;

    public HashSet<String> consprevEspecialidade(String especialidade) throws RemoteException;

    public HashSet<String> consprevIDUtente(int idutente) throws RemoteException;

    public Date[] inserir_horae(int idenfermeiro, Date horacons) throws RemoteException;

    public Date[] remover_horae(int idenfermeiro) throws RemoteException;

    public boolean confirma_horae(int idenfermeiro, Date horacons) throws RemoteException;

    public HashSet<String> prodMaisUtilizados() throws RemoteException;

    public HashSet<String> MedMaisUtilizados() throws RemoteException;

    public HashSet<String> MedPresc(int idmedicamento) throws RemoteException;

    public HashSet<String> MedAtos() throws RemoteException;

       public HashSet<String> MaisReceitas() throws RemoteException ;
    
    public HashSet<String> EnfAtos() throws RemoteException;

    public HashSet<String> levantar_receita(int idutente,int dia,int mes,int ano) throws RemoteException;

    public int getidEnfermeiro() throws RemoteException;

    public int getidMedicamento() throws RemoteException;

    public void cria_medicamento(String nome, int quantidade) throws RemoteException;

    public int getidProduto() throws RemoteException;

    public void cria_produto(String nome, int quantidade) throws RemoteException;
    
    public HashSet ListarFuncionarios() throws RemoteException;
    
    public HashSet ListarEnfermeiros() throws RemoteException;
    
     public HashSet ListarMedicos() throws RemoteException;
     
     public HashSet ListarUtentes() throws RemoteException;
}
