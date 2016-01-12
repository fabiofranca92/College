/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Interface.AtoEnfermagem;
import Interface.Consulta;
import Interface.Encomendas;
import Interface.EncomendasProd;
import Interface.Enfermeiros;
import Interface.Funcionario;
import Interface.Gestor;
import Interface.Medicamentos;
import Interface.Medicos;
import Interface.Produtos;
import Interface.Receita;
import Interface.Utentes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author fabiofranca
 */
public class Gestor_Impl extends UnicastRemoteObject implements Gestor, java.io.Serializable {

    public HashMap<Integer, Medicos> medicos;
    public HashMap<Integer, Utentes> utentes;
    public HashMap<Integer, Medicamentos> medicamentos;
    public HashMap<Integer, Produtos> produtos;
    public HashMap<Integer, Consulta> consultas;
    public HashMap<Integer, Integer> medutilizados;
    public HashMap<Integer, Integer> proutilizados;
    public HashMap<Integer, Utentes> receitas;
    public HashMap<Integer, Funcionario> funcionarios;
    public HashMap<Integer, Date[]> horasconsultas;
    public HashMap<Integer, Enfermeiros> enfermeiros;
    public HashMap<Integer, Date[]> consultae;
    public HashMap<String, Medicamentos> medicamentos1;
    public HashMap<Integer, String> consespec;
    public HashMap<Integer, Integer> farmacia;
    public HashMap<Integer, Integer> farmacia1;
    public HashMap<Integer, Encomendas> encomendas;
    public HashMap<Integer, EncomendasProd> encomendas1;
    public HashMap<Integer, AtoEnfermagem> enfermagem;

    public Gestor_Impl() throws RemoteException {
        medicos = new HashMap<>();
        utentes = new HashMap<>();
        medicamentos = new HashMap<>();
        produtos = new HashMap<>();
        medicamentos1 = new HashMap<>();
        consultas = new HashMap<>();
        receitas = new HashMap<>();
        funcionarios = new HashMap<>();
        horasconsultas = new HashMap<>();
        enfermeiros = new HashMap<>();
        consultae = new HashMap<>();
        consespec = new HashMap<>();
        farmacia = new HashMap<>();
        enfermagem = new HashMap<>();
        encomendas = new HashMap<>();
        encomendas1 = new HashMap<>();
        medutilizados = new HashMap<>();
        proutilizados = new HashMap<>();
        farmacia1 = new HashMap<>();

    }

    @Override
    public int getidMedico() throws RemoteException {
        int id_medico = 0;
        if (medicos.isEmpty()) {
            synchronized (medicos) {
                id_medico = 1;
            }
        } else {
            synchronized (medicos) {
                id_medico = medicos.size() + 1;
            }

        }
        return id_medico;
    }

    @Override
    public int getidUtente() throws RemoteException {
        int idutente = 0;
        if (utentes.isEmpty()) {
            synchronized (utentes) {
                idutente = 1;
            }

        } else {
            idutente = utentes.size() + 1;
        }
        return idutente;
    }

    @Override
    public String cria_medico(String nome, String morada, String especialidade, int dia, int mes, int ano) throws RemoteException {
        int idmedico = getidMedico();


        Medicos m = new Medicos_Impl();
        medicos.put(idmedico, m);
        medicos.get(idmedico).setNomeMedico(nome);
        medicos.get(idmedico).setMoradaMedico(morada);
        medicos.get(idmedico).setEspecialidade(especialidade);
        medicos.get(idmedico).setdataMedico(dia, mes, ano);
        return medicos.get(idmedico).getNomeMedico() + "adicionado com sucesso com o id: " + idmedico;
    }

    @Override
    public String cria_utente(String nome, String morada, int dia, int mes, int ano) throws RemoteException {


        int idutente = getidUtente();

        Utentes u = new Utentes_Impl();
        utentes.put(idutente, u);
        utentes.get(idutente).setdataUtente(dia, mes, ano);
        utentes.get(idutente).setNomeUtente(nome);
        utentes.get(idutente).setMoradaUtente(morada);
        return utentes.get(idutente) + "criado com sucesso com o id: " + idutente;

    }

    @Override
    public int getidMedicamento() throws RemoteException {
        if (medicamentos.isEmpty()) {
            return 1;
        } else {
            return medicamentos.size() + 1;
        }
    }

    @Override
    public void cria_medicamento(String nome, int quantidade) throws RemoteException {
        int id = getidMedicamento();
        Medicamentos m = new Medicamentos_Impl();
        medicamentos.put(id, m);
        medicamentos.get(id).setNomeMedicamento(nome);
        farmacia.put(id, quantidade);
    }

    @Override
    public int getidProduto() throws RemoteException {
        if (produtos.isEmpty()) {
            return 1;
        } else {
            return produtos.size() + 1;
        }
    }

    @Override
    public void cria_produto(String nome, int quantidade) throws RemoteException {
        int id = getidProduto();
        Produtos p = new Produtos_Impl();
        produtos.put(id, p);
        produtos.get(id).setNome(nome);
        this.farmacia1.put(id, quantidade);

    }

    @Override
    public String cons_moradaMedico(int idmedico) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            return medicos.get(idmedico).getMoradaMedico();
        } else {
            return "Médico inexistente";
        }
    }

    @Override
    public String ins_moradaMedico(int idmedico, String morada) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            medicos.get(idmedico).setMoradaMedico(morada);
            return "Morada alterada com sucesso";
        } else {
            return "Medico inexistente";
        }
    }

    @Override
    public String cons_dataMedico(int idmedico) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            return medicos.get(idmedico).getdataMedico();
        } else {
            return "Médico inexistente";
        }
    }

    @Override
    public String ins_dataMedico(int idmedico, int dia, int mes, int ano) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            medicos.get(idmedico).setdataMedico(dia, mes, ano);
            return "Data Alterada Com Sucesso";
        } else {
            return "Medico Inexistente";
        }
    }

    @Override
    public String cons_nomeMedico(int idmedico) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            return medicos.get(idmedico).getNomeMedico();
        } else {
            return "Medico Inexistente";
        }

    }

    @Override
    public String ins_nomeMedico(int idmedico, String nome) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            medicos.get(idmedico).setNomeMedico(nome);
            return "Nome do medico alterado com sucesso";
        } else {
            return "Medico Inexistente";
        }
    }

    @Override
    public String cons_especialidadeMedico(int idmedico) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            return medicos.get(idmedico).getEspecialidade();

        } else {
            return "Médico Inexistente";
        }
    }

    @Override
    public String ins_especialidadeMedico(int idmedico, String nome) throws RemoteException {
        if (medicos.containsKey(idmedico)) {
            medicos.get(idmedico).setNomeMedico(nome);
            return "Especialidade do médico Alterada com Sucesso";
        } else {
            return "Médico Inexistente";
        }
    }

    @Override
    public int getidConsulta() throws RemoteException {
        int id = 0;
        if (consultas.isEmpty()) {
            synchronized (consultas) {
                id = 1;
            }
        } else {
            synchronized (consultas) {
                id = consultas.size() + 1;
            }
        }
        return id;
    }

    @Override
    public synchronized String cria_consultaMedica(int idmedico, int idutente, int dia, int mes, int ano, int hora) throws RemoteException {
        int idconsulta = getidConsulta();
        if (!medicos.containsKey(idmedico)) {
            return "Médico Inexistente";
        } else if (consultas.containsKey(idconsulta)) {
            consultas.get(idconsulta);
            return "Consulta já marcada";
        } else if (!utentes.containsKey(idutente)) {
            return "Utente Inexistente";

        } else {

            Date horacons = new Date(ano - 1900, mes - 1, dia, hora, 00);
            horasconsultas.put(idmedico, inserir_hora(idmedico, horacons));

            if ((confirma_hora(idmedico, horacons) == false) || ((horacons.getHours() + 1) > 22 || horacons.getHours() < 9)) {
                horasconsultas.put(idmedico, remover_hora(idmedico));

                return "Hora indisponivel para o medico";
            } else {
                Consulta c = new Consulta_Impl();
                consultas.put(idconsulta, c);

                consultas.get(idconsulta).setidutente(idutente);

                consultas.get(idconsulta).setmedico(idmedico);
                consultas.get(idconsulta).setEspecialidade(medicos.get(idmedico).getEspecialidade());
                consultas.get(idconsulta).setdata(dia, mes, ano, hora);
                medicos.get(idmedico).setConsulta(idconsulta);
                consespec.put(idconsulta, medicos.get(idmedico).getEspecialidade());
                utentes.get(idutente).setConsulta(idconsulta);

                return "Consulta Marcada Com Sucesso";
            }

        }

    }

    @Override
    public int cons_consultas(int idconsulta) throws RemoteException {


        return consultas.get(idconsulta).getidmedico();

    }

    public Date[] inserir_hora(int idmedico, Date horacons) {

        if (horasconsultas.containsKey(idmedico)) {

            Date data[] = horasconsultas.get(idmedico);
            Date fim[] = new Date[horasconsultas.get(idmedico).length + 1];
            for (int i = 0; i <= (horasconsultas.get(idmedico).length - 1); i++) {
                fim[i] = data[i];
            }
            fim[horasconsultas.get(idmedico).length] = horacons;

            return fim;
        }
        Date x[] = new Date[1];
        x[0] = horacons;

        return x;
    }

    public Date[] remover_hora(int idmedico) {

        Date data[] = horasconsultas.get(idmedico);
        if (data.length == 1) {
            Date fim[] = new Date[1];
            return fim;
        } else {
            Date fim[] = new Date[horasconsultas.get(idmedico).length - 1];
            for (int i = 0; i <= (horasconsultas.get(idmedico).length - 2); i++) {
                fim[i] = data[i];
            }
            return fim;
        }

    }

    @Override
    public boolean confirma_hora(int idmedico, Date horacons) {
        int soma = 0;
        if (horasconsultas.get(idmedico).length == 0) {
            if (horasconsultas.containsKey(idmedico)) {


                for (int i = 0; i <= (horasconsultas.get(idmedico).length - 2); i++) {
                    if ((horacons.getTime() <= (horasconsultas.get(idmedico)[i].getTime() + 3599999)) && (horacons.getTime() >= (horasconsultas.get(idmedico)[i].getTime() - 3599999))) {
                        soma = soma + 1;
                    }
                }
                if (soma != 0) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;
            }

        } else {
            return true;
        }
    }

    @Override
    public String cria_receita(int idmedico, int idutente, int idmedicamento, int quantidade) throws RemoteException {
        utentes.get(idutente).setmedicamentoUtente(idmedicamento, quantidade);
        Receita r = new Receita_Impl();
        medicos.get(idmedico).setReceit(r);
        medicos.get(idmedico).setmedicamento(idmedicamento, quantidade);
        return "Medicamento associado com sucesso";


    }

    @Override
    public HashSet<String> levantar_receita(int idutente, int dia, int mes, int ano) throws RemoteException {
        HashSet<String> resposta = new HashSet<>();
        HashMap<Integer, Integer> receita = utentes.get(idutente).getmed();
        if (utentes.get(idutente).getmed().isEmpty()) {
            resposta.add("Utente sem Receita por Levantar");
        } else {
            HashSet<Integer> medicamento = new HashSet<>();
            medicamento.addAll(receita.keySet());
            Scanner s = new Scanner(System.in);
            Iterator<Integer> it = medicamento.iterator();
            while (it.hasNext()) {
                int a = it.next();
                int inicial = farmacia.get(a);
                int fim = inicial - receita.get(a);
                if (fim < 0) {
                    resposta.add("Medicamento " + medicamentos.get(a).getNomeMedicamento() + " Insuficiente em Stock\nFoi feita uma encomenda automatica\n");

                    fazerEncomenda(a, 15, dia, mes, ano);

                    farmacia.remove(a);
                    farmacia.put(a, inicial);
                } else if (fim < 15) {
                    resposta.add("Medicamento " + medicamentos.get(a).getNomeMedicamento() + " Levantado com Sucesso\nStock Minimo Atingido\nFoi feita uma encomenda automatica deste produto\n");

                    fazerEncomenda(a, 15, dia, mes, ano);

                    utentes.get(idutente).getmed().remove(a);
                } else {
                    resposta.add("Medicamento " + medicamentos.get(a).getNomeMedicamento() + " Levantado com Sucesso\n");

                    utentes.get(idutente).getmed().remove(a);
                }
            }
        }
        return resposta;
    }

    @Override
    public int verificaStock(int idmedicamento) throws RemoteException {
        HashSet<Integer> med = new HashSet<>();
        med.addAll(farmacia.keySet());
        Iterator<Integer> it = med.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (a == idmedicamento) {
                if (farmacia.get(a) <= 15) {
                    return -1;
                }
            }
        }
        return 0;



    }

    @Override
    public void medMedico(int idmedico, int idmedicamento, int quantidade) throws RemoteException {
        medicos.get(idmedico).setmedicamento(idmedicamento, quantidade);
    }

    @Override
    public int getiFunc() throws RemoteException {
        int idfunc = 0;
        if (funcionarios.isEmpty()) {
            synchronized (funcionarios) {
                idfunc = 1;
            }
        } else {
            synchronized (funcionarios) {
                idfunc = funcionarios.size() + 1;
            }
        }
        return idfunc;
    }

    @Override
    public String cria_func(String nome, String funcao, String morada) throws RemoteException {
        int idfunc = getiFunc();
        if (funcionarios.containsKey(idfunc)) {
            return "Funcionario já Existente";
        } else {
            Funcionario f = new Funcionario_Impl();
            f.setfuncao(funcao);
            f.setmorada(morada);
            f.setnome(nome);
            funcionarios.put(idfunc, f);
            return "Funcionário criado com sucesso com o id: " + idfunc;
        }
    }

    @Override
    public String cons_moradaUtente(int idutente) throws RemoteException {
        if (utentes.containsKey(idutente)) {
            return utentes.get(idutente).getMoradaUtente();
        } else {
            return "Utente Inexistente";
        }
    }

    @Override
    public String cons_dataUtente(int idutente) throws RemoteException {
        if (utentes.containsKey(idutente)) {
            return utentes.get(idutente).getdataUtente();
        } else {
            return "Utente Inexistente";
        }
    }

    @Override
    public String ins_moradaUtente(int idutente, String morada) throws RemoteException {
        if (utentes.containsKey(idutente)) {
            utentes.get(idutente).setMoradaUtente(morada);
            return "Morada Inserida com sucesso";
        } else {
            return "Utente Inexistente";
        }
    }

    @Override
    public String cons_nomeUtente(int idutente) throws RemoteException {
        if (utentes.containsKey(idutente)) {
            return utentes.get(idutente).getNomeUtente();
        } else {
            return "Utente Inexistente";
        }
    }

    @Override
    public String ins_nomeUtente(int idutente, String nome) throws RemoteException {
        if (utentes.containsKey(idutente)) {
            utentes.get(idutente).setNomeUtente(nome);
            return "Nome alterado com sucesso";
        } else {
            return "Utente Inexistente";
        }
    }

    @Override
    public String cons_moradaFunc(int idfunc) throws RemoteException {
        if (funcionarios.containsKey(idfunc)) {
            return funcionarios.get(idfunc).getmorada();
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public String cons_funcao(int idfunc) throws RemoteException {

        if (funcionarios.containsKey(idfunc)) {
            return funcionarios.get(idfunc).getfuncao();
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public String ins_moradaFunc(int idfunc, String morada) throws RemoteException {
        if (funcionarios.containsKey(idfunc)) {
            funcionarios.get(idfunc).setmorada(morada);
            return "Morada Inserida com Sucesso";
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public String ins_funcao(int idfunc, String funcao) throws RemoteException {
        if (funcionarios.containsKey(idfunc)) {
            funcionarios.get(idfunc).setfuncao(funcao);
            return "Função Inserida com Sucesso";
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public String cons_nomeFunc(int idfunc) throws RemoteException {
        if (funcionarios.containsKey(idfunc)) {
            return funcionarios.get(idfunc).getnome();
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public String ins_nomeFunc(int idfunc, String nome) throws RemoteException {
        if (funcionarios.containsKey(idfunc)) {
            funcionarios.get(idfunc).setnome(nome);
            return "Nome Inserido com Sucesso";
        } else {
            return "Funcionário Inexistente";
        }
    }

    @Override
    public int getidEnfermeiro() throws RemoteException {
        int id = 0;
        if (enfermeiros.isEmpty()) {
            synchronized (enfermeiros) {
                id = 1;
            }
        } else {
            synchronized (enfermeiros) {
                id = enfermeiros.size() + 1;
            }
        }
        return id;
    }

    @Override
    public String cria_enfermeiro(String nome, String morada, int dia, int mes, int ano) throws RemoteException {
        int idenfermeiro = getidEnfermeiro();

        Enfermeiros e = new Enfermeiros_Impl();
        enfermeiros.put(idenfermeiro, e);
        enfermeiros.get(idenfermeiro).setMoradaEnfermeiro(morada);
        enfermeiros.get(idenfermeiro).setNomeEnfermeiro(nome);
        enfermeiros.get(idenfermeiro).setdataEnfermeiro(dia, mes, ano);
        return enfermeiros.get(idenfermeiro).getNomeEnfermeiro() + " adicionado com sucesso com o id : " + idenfermeiro;
    }

    @Override
    public String cons_moradaEnfermeiro(int idenfermeiro) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            return enfermeiros.get(idenfermeiro).getMoradaEnfermeiro();
        } else {
            return "Enfermeiro Inexistente";
        }
    }

    @Override
    public String cons_dataEnfermeiro(int idenfermeiro) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            return enfermeiros.get(idenfermeiro).getdataEnfermeiro();
        } else {
            return "Enfermeiro Inexistente";
        }
    }

    @Override
    public String ins_dataEnfermeiro(int idenfermeiro, int dia, int mes, int ano) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            enfermeiros.get(idenfermeiro).setdataEnfermeiro(dia, mes, ano);
            return "Data Inserida com Sucesso";
        } else {
            return "Enfermeiro Inexistente";
        }
    }

    @Override
    public String cons_nomeEnfermeiro(int idenfermeiro) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            return enfermeiros.get(idenfermeiro).getNomeEnfermeiro();
        } else {
            return "Enfermeiro Inexistente";
        }
    }

    @Override
    public String ins_nomeEnfermeiro(int idenfermeiro, String nome) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            enfermeiros.get(idenfermeiro).setNomeEnfermeiro(nome);
            return "Nome Inserido com Sucesso";
        } else {
            return "Enfermeiro Inexistente";
        }
    }

    @Override
    public int getidAto() throws RemoteException {
        int idato = 0;
        if (enfermagem.isEmpty()) {
            synchronized (enfermagem) {
                idato = 1;
            }
        } else {
            synchronized (enfermagem) {
                idato = enfermagem.size() + 1;
            }

        }
        return idato;
    }

    @Override
    public synchronized String cria_consultaEnfermeiro(int idenfermeiro, int idutente, int dia, int mes, int ano, int hora) throws RemoteException {
        int idconsulta = getidAto();
        if (!enfermeiros.containsKey(idenfermeiro)) {
            return "Enfermeiro Inexistente";
        } else if (enfermagem.containsKey(idconsulta)) {
            enfermagem.get(idconsulta);
            return "Consulta de Enfermaria já marcada";
        } else if (!utentes.containsKey(idutente)) {
            return "Utente Inexistente";

        } else {

            Date horacons = new Date(ano - 1900, mes - 1, dia, hora, 00);
            consultae.put(idenfermeiro, inserir_horae(idenfermeiro, horacons));

            if ((confirma_horae(idenfermeiro, horacons) == false) || ((horacons.getHours() > 21) || (horacons.getHours() < 8))) {
                consultae.put(idenfermeiro, remover_horae(idenfermeiro));

                return "Hora indisponivel para o Enfermeiro";
            } else {
                AtoEnfermagem ae = new AtoEnfermagem_Impl();

                enfermagem.put(idconsulta, ae);
                enfermeiros.get(idenfermeiro).setAtos(ae);
                enfermagem.get(idconsulta).setUtente(idutente);
                enfermagem.get(idconsulta).setEnfermeiro(idenfermeiro);
                enfermagem.get(idconsulta).setdata(dia, mes, ano, hora);

                return "Consulta Marcada Com Sucesso";
            }
        }
    }

    @Override
    public Date[] inserir_horae(int idenfermeiro, Date horacons) {

        if (consultae.containsKey(idenfermeiro)) {

            Date data[] = consultae.get(idenfermeiro);
            Date fim[] = new Date[consultae.get(idenfermeiro).length + 1];
            for (int i = 0; i <= (consultae.get(idenfermeiro).length - 1); i++) {
                fim[i] = data[i];

            }
            fim[consultae.get(idenfermeiro).length] = horacons;

            return fim;
        }
        Date x[] = new Date[1];
        x[0] = horacons;

        return x;
    }

    @Override
    public Date[] remover_horae(int idenfermeiro) {

        Date data[] = consultae.get(idenfermeiro);
        if (data.length == 1) {
            Date fim[] = new Date[1];
            return fim;
        } else {
            Date fim[] = new Date[consultae.get(idenfermeiro).length - 1];
            for (int i = 0; i <= (consultae.get(idenfermeiro).length - 2); i++) {
                fim[i] = data[i];
            }
            return fim;
        }

    }

    @Override
    public boolean confirma_horae(int idenfermeiro, Date horacons) {
        int soma = 0;
        if (consultae.get(idenfermeiro).length == 0) {
            if (consultae.containsKey(idenfermeiro)) {


                for (int i = 0; i <= (consultae.get(idenfermeiro).length - 2); i++) {
                    if ((horacons.getTime() <= (consultae.get(idenfermeiro)[i].getTime() + 3599999)) && (horacons.getTime() >= (consultae.get(idenfermeiro)[i].getTime() - 3599999))) {
                        soma = soma + 1;
                    }
                }
                if (soma != 0) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;
            }

        } else {
            return true;
        }
    }

    @Override
    public String ins_moradaEnfermeiro(int idenfermeiro, String morada) throws RemoteException {
        if (enfermeiros.containsKey(idenfermeiro)) {
            return enfermeiros.get(idenfermeiro).getMoradaEnfermeiro();
        } else {
            return " Enfermeiro Inexistente";
        }
    }

    @Override
    public String consNomeMedicamento(int i) throws RemoteException {
        if (medicamentos.containsKey(i)) {
            return (medicamentos.get(i).getNomeMedicamento());
        }
        return "Medicamento Nao Existe";





    }

    @Override
    public String remover_medicamento(int idmedicamento, int quantidade) throws RemoteException {
        if (farmacia.containsKey(idmedicamento)) {

            int bquantidade = farmacia.get(idmedicamento) - quantidade;

            if (bquantidade >= 0) {
                farmacia.remove(idmedicamento);
                farmacia.put(idmedicamento, bquantidade);
                return "Stock actualizado";
            } else {
                return " Stock insuficiente";
            }


        }
        return "Não existe em Stock";
    }

    @Override
    public String adicionar_medicamento(int idmedicamento, int quantidade) throws RemoteException {
        if (farmacia.containsKey(idmedicamento)) {
            int bquantidade = farmacia.get(idmedicamento);
            farmacia.remove(idmedicamento);
            farmacia.put(idmedicamento, quantidade + bquantidade);
            return "Stock actualizado";
        } else {
            farmacia.put(idmedicamento, quantidade);

            return "Stock Actualizado";
        }
    }

    public String adicionar_produtos(int idproduto, int quantidade) throws RemoteException {
        if (farmacia1.containsKey(idproduto)) {
            int bquantidade = farmacia1.get(idproduto);
            farmacia1.remove(idproduto);
            farmacia1.put(idproduto, quantidade + bquantidade);
            return "Stock actualizado";
        } else {
            farmacia1.put(idproduto, quantidade);
            return "Stock Actualizado";
        }

    }

    public String remover_produtos(int idprodutos, int quantidade) throws RemoteException {
        if (farmacia1.containsKey(idprodutos)) {

            int bquantidade = farmacia1.get(idprodutos) - quantidade;

            if (bquantidade >= 0) {
                farmacia1.remove(idprodutos);
                farmacia1.put(idprodutos, bquantidade);
                return "Stock actualizado";
            } else {
                return " Stock insuficiente";
            }


        }
        return "Não existe em Stock";
    }

    @Override
    public String adicionar_gastosProdutos(int idenfermagem, int produto, int quantidade, int dia, int mes, int ano) throws RemoteException {
        if (enfermagem.containsKey(idenfermagem)) {

            if (produtos.containsKey(produto)) {
                int inicial = farmacia1.get(produto);
                int fim = inicial - quantidade;
                if (fim < 0) {
                    farmacia1.remove(produto);
                    farmacia1.put(produto, inicial);
                    fazerEncomenda(produto, 15, dia, mes, ano);

                    return "Produto" + produtos.get(produto).getnomeProduto() + " Insuficiente em Stock\nFoi feita uma encomenda automatica\n";
                } else if (fim < 15) {
                    fazerEncomenda(produto, 15, dia, mes, ano);
                    enfermagem.get(idenfermagem).setProdutos(produto, quantidade);
                    proutilizados.put(produto, quantidade);
                    farmacia1.remove(produto);
                    farmacia1.put(produto, fim);
                    return "Produto" + produtos.get(produto).getnomeProduto() + " Adicionado com Sucesso\n Stock Minimo Atingido\nFoi feita uma encomenda automatica deste produto\n";


                } else {
                    farmacia1.remove(produto);
                    farmacia1.put(produto, fim);
                    return "Gasto Adicionado com Sucesso";
                }
            } else {
                return "produto nao existe";
            }
        } else {
            return "Ato de Enfermaria Inexistente";
        }



    }

    @Override
    public String adicionar_gastosMedicamentos(int idenfermagem, int produto, int quantidade, int dia, int mes, int ano) throws RemoteException {
        if (enfermagem.containsKey(idenfermagem)) {

            if (medicamentos.containsKey(produto)) {
                int inicial = farmacia.get(produto);
                int fim = inicial - quantidade;
                if (fim < 0) {
                    farmacia.remove(produto);
                    farmacia.put(produto, inicial);
                    fazerEncomenda(produto, 15, dia, mes, ano);

                    return "Medicamento" + medicamentos.get(produto).getNomeMedicamento() + " Insuficiente em Stock\nFoi feita uma encomenda automatica\n";
                } else if (fim < 15) {
                    fazerEncomenda(produto, 15, dia, mes, ano);
                    enfermagem.get(idenfermagem).setMedicamentos(produto, quantidade);
                    medutilizados.put(produto, quantidade);
                    farmacia.remove(produto);
                    farmacia.put(produto, fim);
                    return "Medicamento" + medicamentos.get(produto).getNomeMedicamento() + " Adicionado com Sucesso\n Stock Minimo Atingido\nFoi feita uma encomenda automatica deste produto\n";


                } else {
                    farmacia.remove(produto);
                    farmacia.put(produto, fim);
                    return "Gasto Adicionado com Sucesso";
                }
            } else {
                return "Medicamento nao existe";
            }
        } else {
            return "Ato de Enfermaria Inexistente";
        }
    }

    @Override
    public int getidEncomenda() throws RemoteException {
        int idenco = 0;
        if (encomendas.isEmpty()) {
            synchronized (encomendas) {
                idenco = 1;
            }
        } else {
            synchronized (encomendas) {
                idenco = encomendas.size() + 1;
            }
        }
        return idenco;
    }

    @Override
    public String fazerEncomenda(int idmedicamento, int quantidade, int dia, int mes, int ano) throws RemoteException {
        int idencomenda = getidEncomenda();
        if (!encomendas.containsKey(idencomenda)) {
            Encomendas e = new Encomendas_Impl();
            encomendas.put(idencomenda, e);
            encomendas.get(idencomenda).setidMedicamento(idmedicamento);
            encomendas.get(idencomenda).setquantidade(quantidade);
            encomendas.get(idencomenda).setData(dia + 7, mes, ano);
            return "Encomenda feita com sucesso";
        } else {
            return "Encomenda já Existe";
        }

    }

    @Override
    public HashSet verEncomendas() throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(encomendas.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            cons.add("Encomenda " + a +" De "+encomendas.get(a).getQuant()+"unidades do Medicamento "+medicamentos.get(encomendas.get(a).getMed()).getNomeMedicamento()+ " Chega no dia::" + encomendas.get(a).getData());
        }
        return cons;
    }

    @Override
    public HashSet verEncomendasPro() throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(encomendas1.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            cons.add("Encomenda " + a +" De "+encomendas1.get(a).getQuant()+"unidades de "+produtos.get(encomendas1.get(a).getPro()).getnomeProduto()+ " Chega no dia::" + encomendas1.get(a).getData());
        }
        return cons;
    }

    @Override
    public String fazerEncomendaProd(int idproduto, int quantidade, int dia, int mes, int ano) throws RemoteException {
        int idencomenda = getidEncomenda();
        if (!encomendas1.containsKey(idencomenda)) {
            EncomendasProd ep = new EncomendasProd_Impl();
            encomendas1.put(idencomenda, ep);
            encomendas1.get(idencomenda).setidProduto(idproduto);
            encomendas1.get(idencomenda).setquantidade(quantidade);
            encomendas1.get(idencomenda).setData(dia + 7, mes, ano);
            return "Encomenda feita com sucesso";
        } else {
            return "Encomenda já Existe";
        }

    }

    @Override
    public String receberEncomenda(int idencomenda) throws RemoteException {
        if (encomendas.containsKey(idencomenda)) {
            int idmedicamento = encomendas.get(idencomenda).getMed();
            int quantidade = encomendas.get(idencomenda).getQuant();
            adicionar_medicamento(idmedicamento, quantidade);
            return "Encomenda " + idencomenda + " Entregue";
        } else {
            return "Encomenda Inexistente";
        }
    }

    @Override
    public String receberEncomendaProd(int idencomenda) throws RemoteException {
        if (encomendas1.containsKey(idencomenda)) {
            int idproduto = encomendas1.get(idencomenda).getPro();
            int quantidade = encomendas1.get(idencomenda).getQuant();
            adicionar_produtos(idproduto, quantidade);
            return "Encomenda " + idencomenda + " Entregue";
        } else {
            return "Encomenda Inexistente";
        }
    }

    @Override
    public HashSet<String> consultarStockMedicamentos() throws RemoteException {
        HashSet<String> stock = new HashSet<>();
        Set<Integer> x = new HashSet<>();

        x.addAll(farmacia.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int c = it.next();
            stock.add("Medicamento : " + medicamentos.get(c).getNomeMedicamento() + " Quantidade: " + farmacia.get(c));
        }
        return stock;

    }

    @Override
    public HashSet<String> consultarStockProdutos() throws RemoteException {
        HashSet<String> stock = new HashSet<>();
        Set<Integer> x = new HashSet<>();

        x.addAll(farmacia1.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int c = it.next();
            stock.add("Medicamento : " + produtos.get(c).getnomeProduto() + " Quantidade: " + farmacia1.get(c));
        }
        return stock;

    }

    public HashSet<String> consultarEncomendasMed() throws RemoteException {

        HashSet<String> encomenda = new HashSet<>();
        Set<Integer> x = new HashSet<>();

        x.addAll(encomendas.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int chave = it.next();
            encomenda.add("Encomenda ID: " + chave + " Data de Entrega: " + encomendas.get(chave).getData());
        }
        return encomenda;
    }

    public HashSet<String> consultarEncomendasProd() throws RemoteException {
        HashSet<String> encomenda = new HashSet<>();
        Set<Integer> x = new HashSet<>();

        x.addAll(encomendas1.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int chave = it.next();
            encomenda.add("Encomenda ID: " + chave + " Data de Entrega: " + encomendas1.get(chave).getData());
        }
        return encomenda;
    }

    @Override
    public HashSet<String> consultarMedMin() throws RemoteException {
        HashSet<String> med = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(farmacia.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (farmacia.get(a) <= 15) {
                med.add("Medicamento " + medicamentos.get(a).getNomeMedicamento() + " Quantidade" + farmacia.get(a));
            }
        }
        return med;
    }

    @Override
    public HashSet<String> consultarProdMin() throws RemoteException {
        HashSet<String> med = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(farmacia1.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (farmacia1.get(a) <= 15) {
                med.add("Produto " + produtos.get(a).getnomeProduto() + " Quantidade" + farmacia1.get(a));
            }
        }
        return med;
    }

    @Override
    public HashSet<String> consprevIDMEDICO(int idmedico) throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(medicos.get(idmedico).GETCONS());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            cons.add(("ID Médico : " + consultas.get(a).getidmedico() + " Nome: " + medicos.get(consultas.get(a).getidmedico()).getNomeMedico() + " Utente " + utentes.get(consultas.get(a).getidutente()).getNomeUtente() + " Data :" + consultas.get(a).getData().toString()));
        }
        return cons;
    }

    @Override
    public HashSet<String> consprevEspecialidade(String especialidade) throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(consespec.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (consespec.get(a).equals(especialidade)) {
                cons.add("Medico : " + medicos.get(consultas.get(a).getidmedico()).getNomeMedico() + " Utente :" + utentes.get(consultas.get(a).getidutente()).getNomeUtente() + " Data : " + consultas.get(a).getData().toString());
            }
        }
        return cons;
    }

    @Override
    public HashSet<String> consprevIDUtente(int idutente) throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(utentes.get(idutente).getConsulta());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            cons.add(("Médico : " + medicos.get(consultas.get(a).getidmedico()).getNomeMedico() + "ID Utente : " + consultas.get(a).getidutente() + " Nome : " + utentes.get(consultas.get(a).getidutente()).getNomeUtente() + " Data :" + consultas.get(a).getData().toString()));
        }
        return cons;
    }

    @Override
    public HashSet<String> consprevIDENFER() throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(enfermagem.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            cons.add(("ID Enfermeiro : " + enfermagem.get(a).getidEnferm() + " Nome: " + enfermeiros.get(enfermagem.get(a).getidEnferm()).getNomeEnfermeiro() + "Utente : " + utentes.get(enfermagem.get(a).getidUtente()).getNomeUtente() + " Data :" + enfermagem.get(a).getData().toString()));
        }
        return cons;
    }

    @Override
    public HashSet<String> consultasDATA(Date data) throws RemoteException {
        HashSet<String> cons = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        x.addAll(consultas.keySet());
        Iterator<Integer> it = x.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (consultas.get(a).getData().getTime() <= data.getTime()) {
                cons.add("Utente :" + utentes.get(consultas.get(a).getidutente()) + " Medico : " + medicos.get(consultas.get(a).getidmedico()).getNomeMedico() + " No Dia : " + consultas.get(a).getData());
            }
        }
        return cons;

    }

    @Override
    public HashSet<String> prodMaisUtilizados() throws RemoteException {

        HashSet<String> fim = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(proutilizados.keySet());
        Iterator<Integer> it1 = set.iterator();
        HashSet<Integer> somatorio = new HashSet<>();
        somatorio.addAll(proutilizados.values());
        Object array[] = somatorio.toArray();

        Arrays.sort(array);
        int x = (int) Math.round(array.length * 0.25);

        Object array1[] = reverse(array);

        Object array2[] = Arrays.copyOf(array1, x + 1);


        while (it1.hasNext()) {
            int z = it1.next();
            for (int i = 0; i <= array2.length - 1; i++) {
                if (proutilizados.get(z) == array2[i]) {
                    fim.add("Produto :" + produtos.get(z).getnomeProduto() + " Nr de vezes Utilizado :" + proutilizados.get(z));
                }

            }

        }

        return fim;



    }

    @Override
    public HashSet<String> MedMaisUtilizados() throws RemoteException {



        HashSet<String> fim = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(medutilizados.keySet());
        Iterator<Integer> it1 = set.iterator();
        HashSet<Integer> somatorio = new HashSet<>();
        somatorio.addAll(medutilizados.values());
        Object array[] = somatorio.toArray();

        Arrays.sort(array);
        int x = (int) Math.round(array.length * 0.25);

        Object array1[] = reverse(array);

        Object array2[] = Arrays.copyOf(array1, x + 1);


        while (it1.hasNext()) {
            int z = it1.next();
            for (int i = 0; i <= array2.length - 1; i++) {
                if (medutilizados.get(z) == array2[i]) {
                    fim.add("Medicamento :" + medicamentos.get(z).getNomeMedicamento() + " Nr de vezes Utilizado :" + medutilizados.get(z));
                }

            }

        }

        return fim;



    }

    public static Object[] reverse(Object[] arr) {
        List< Object> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }

    @Override
    public HashSet<String> MedPresc(int idmedicamento) throws RemoteException {
        HashSet<String> fim = new HashSet<>();
        int maximo = 0;
        Set<Integer> x = new HashSet<>();
        x.addAll(medicos.keySet());
        Iterator<Integer> it = x.iterator();
        int z = 0;
        while (it.hasNext()) {
            int a = it.next();

            if (medicos.get(a).getQuant(idmedicamento) > maximo) {
                maximo = medicos.get(a).getQuant(idmedicamento);
                z = a;


            }

        }

        fim.add("Medico :" + medicos.get(z).getNomeMedico() + "ID Medico :" + z);
        return fim;



    }

    @Override
    public HashSet<String> MedAtos() throws RemoteException {



        Set<Integer> med = new HashSet<>();
        HashMap<Integer, Integer> x = new HashMap<>();
        med.addAll(medicos.keySet());

        Iterator<Integer> it = med.iterator();
        while (it.hasNext()) {
            int a = it.next();
            x.put(a, medicos.get(a).getConsultas());
            if (medicos.get(a).getConsultas() == 0) {
                x.remove(a);
            }
        }

        HashSet<String> fim = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(x.keySet());
        Iterator<Integer> it1 = set.iterator();
        HashSet<Integer> somatorio = new HashSet<>();
        somatorio.addAll(x.values());
        Object array[] = somatorio.toArray();

        Arrays.sort(array);
        int g = (int) Math.round(array.length * 0.25);

        Object array1[] = reverse(array);

        Object array2[] = Arrays.copyOf(array1, g + 1);
        while (it1.hasNext()) {
            int z = it1.next();
            for (int i = 0; i <= array2.length - 1; i++) {
                if (x.get(z) == array2[i]) {
                    fim.add("Medico :" + medicos.get(z).getNomeMedico() + " Nr de Consultas :" + x.get(z));
                }

            }

        }
        return fim;



    }

    @Override
    public HashSet<String> EnfAtos() throws RemoteException {


        Set<Integer> med = new HashSet<>();
        HashMap<Integer, Integer> x = new HashMap<>();
        med.addAll(enfermeiros.keySet());

        Iterator<Integer> it = med.iterator();
        while (it.hasNext()) {
            int a = it.next();
            x.put(a, enfermeiros.get(a).getAtos());
            if (enfermeiros.get(a).getAtos() == 0) {
                x.remove(a);
            }
        }

        HashSet<String> fim = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(x.keySet());
        Iterator<Integer> it1 = set.iterator();
        HashSet<Integer> somatorio = new HashSet<>();
        somatorio.addAll(x.values());
        Object array[] = somatorio.toArray();

        Arrays.sort(array);
        int g = (int) Math.round(array.length * 0.25);

        Object array1[] = reverse(array);

        Object array2[] = Arrays.copyOf(array1, g + 1);
        while (it1.hasNext()) {
            int z = it1.next();
            for (int i = 0; i <= array2.length - 1; i++) {
                if (x.get(z) == array2[i]) {
                    fim.add("Enfermeiro :" + enfermeiros.get(z).getNomeEnfermeiro() + " Nr de Atos :" + x.get(z));
                }

            }

        }

        return fim;



    }

    @Override
    public HashSet<String> MaisReceitas() throws RemoteException {
        Set<Integer> med = new HashSet<>();
        HashMap<Integer, Integer> x = new HashMap<>();
        med.addAll(medicos.keySet());

        Iterator<Integer> it = med.iterator();
        while (it.hasNext()) {
            int a = it.next();
            x.put(a, medicos.get(a).getReceitas());
            if (medicos.get(a).getReceitas() == 0) {
                x.remove(a);
            }
        }

        HashSet<String> fim = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(x.keySet());
        Iterator<Integer> it1 = set.iterator();
        HashSet<Integer> somatorio = new HashSet<>();
        somatorio.addAll(x.values());
        Object array[] = somatorio.toArray();

        Arrays.sort(array);
        int g = (int) Math.round(array.length * 0.25);

        Object array1[] = reverse(array);

        Object array2[] = Arrays.copyOf(array1, g + 1);


        while (it1.hasNext()) {
            int z = it1.next();
            for (int i = 0; i <= array2.length - 1; i++) {
                if (x.get(z) == array2[i]) {
                    fim.add("Medico :" + medicos.get(z).getNomeMedico() + " \nNr de Receitas :" + x.get(z));
                }

            }

        }

        return fim;


    }
    @Override
    public HashSet ListarUtentes() throws RemoteException{
        HashSet<String> utente = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        
        
        x.addAll(utentes.keySet());
        Iterator<Integer> it = x.iterator();
        while(it.hasNext()){
            int a = it.next();
            utente.add("Utente : "+this.utentes.get(a).getNomeUtente()+" Morada : "+this.utentes.get(a).getMoradaUtente()+" Data de Nascimento : "+this.utentes.get(a).getdataUtente());
        }
        return utente;
    }
    @Override
    public HashSet ListarMedicos() throws RemoteException{
        HashSet<String> med = new HashSet<>();
        Set<Integer> x = new HashSet<>();
          x.addAll(medicos.keySet());
        Iterator<Integer> it = x.iterator();
        
      
        
        while(it.hasNext()){
            int a = it.next();
            med.add("Medico "+medicos.get(a).getNomeMedico()+" Morada : "+medicos.get(a).getMoradaMedico() +" Especialidade : "+medicos.get(a).getEspecialidade());
        }
        return med;
    }
    
    @Override
    public HashSet ListarEnfermeiros() throws RemoteException{
        HashSet<String> enf = new HashSet<>();
        Set<Integer> x = new HashSet<>();
         x.addAll(enfermeiros.keySet());
        Iterator<Integer> it = x.iterator();
        
       
        while(it.hasNext()){
            int a = it.next();
            enf.add("Enfermeiro "+enfermeiros.get(a).getNomeEnfermeiro()+" Morada : "+enfermeiros.get(a).getMoradaEnfermeiro() +" Data-de-Nascimento : "+enfermeiros.get(a).getdataEnfermeiro());
        }
        return enf;
    }
    
    @Override
    public HashSet ListarFuncionarios() throws RemoteException{
        HashSet<String> func = new HashSet<>();
        Set<Integer> x = new HashSet<>();    
        x.addAll(funcionarios.keySet());
        Iterator<Integer> it = x.iterator();
        while(it.hasNext()){
            int a = it.next();
            func.add("Funcionario "+funcionarios.get(a).getnome()+" Morada : "+funcionarios.get(a).getmorada() );
        }
        return func;
    }
}
