/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author fabiofranca
 */
import Interface.Gestor;
import Interface.Utentes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    public static void main(String args[]) throws RemoteException, NotBoundException, FileNotFoundException, IOException {
        
        
            Gestor g ;
            Registry reg;
            Cliente client = new Cliente();
            client.connectarServidor();
            
            reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            g = (Gestor) reg.lookup("GestaoUtentes");
            
            String str = "";
            while (str.equals("n") == false) {



                Scanner s = new Scanner(System.in);
                System.out.printf("Indique o Serviço\n"
                        + "1-Criar, Editar , Consultar Dados Pessoais do Staff\n"
                        + "2-Medico\n"
                        + "3-Enfermaria\n"
                        + "4-Farmacia\n"
                        + "5-Dados Estatísticos\n");
                
                int primeiro = s.nextInt();
                if(primeiro == 1){
                    System.out.printf("1-Utente\n"
                            + "2-Medico\n"
                            + "3-Funcionário\n"
                            + "4-Enfermeiro\n");
                    int criarEditar = s.nextInt();
                    if(criarEditar == 1){
                        CriarEditarUtente.main(args);
                    }else if(criarEditar == 2){
                        CriarEditarMedico.main(args);
                    }else if(criarEditar == 3){
                        CriarEditarFuncionario.main(args);
                    }else if(criarEditar == 4){
                        CriarEditarEnfermeiro.main(args);
                    }else
                        System.out.println("Operação Indisponivel");
                }else if(primeiro == 2){
                    System.out.println("1-Marcar Consulta Médica\n"
                            + "2-Procurar Consulta pela data\n"
                            + "3-Consultas Previstas\n"
                            + "4-Passar Receita");
                    int medico = s.nextInt();
                    if(medico == 1){
                        ConsultaMedica.main(args);
                    }else if(medico == 2){
                        ConsultaUtenteData.main(args);
                    }else if (medico == 3){
                        ConsultasPrevistas.main(args);
                    }else if (medico == 4){
                        PassarReceita.main(args);
                    }else{
                        System.out.println("Operação Não Disponível");
                    }
                    }else if(primeiro == 3){
                        System.out.printf("1- Marcar Ato de Enfermagem\n"
                                + "2- Consultar Atos Agendados\n"
                                + "3- Adicionar Gastos a um Ato de Enfermagem\n");
                        int enf = s.nextInt();
                        if(enf == 1){
                            AtoEnfermagem.main(args);
                        }else if(enf == 2){
                            AtosEnfermagemAgendados.main(args);
                        }else if(enf == 3){
                            GastosEnfermaria.main(args);
                        }else{
                            System.out.println("Operação Não Disponível");
                        }
                        
                    }else if(primeiro == 4){
                        System.out.printf("1-Consultar Stock\n"
                                + "2-Encomendar Medicamentos\n"
                                + "3-Encomendar Produtos\n"
                                + "4-Levantar Receita\n"
                                + "5-Receber Encomenda \n"
                                + "6-Consultar Encomendas Previstas de Medicamentos\n"
                                + "7-Consultar Encomendas Previstas de Produtos\n"
                                + "8-Consultar Produtos e Medicamentos Abaixo do Mínimo\n");
                        int farmacia = s.nextInt();
                        if(farmacia == 1){
                            ConsultarStock.main(args);
                        }else if(farmacia == 2){
                            FazerEncomenda.main(args);
                        }else if(farmacia == 3){
                            FazerEncomendaProdutos.main(args);
                        }else if(farmacia == 4){
                            Levantar_Receita.main(args);
                        }else if(farmacia == 5){
                            ReceberEncomenda.main(args);
                        }else if(farmacia == 6){
                            EncomendasPrevistas.main(args);
                        }else if (farmacia == 7){
                            EncomendasPrevistasProd.main(args);
                        }else if (farmacia == 8){
                            ProdutosMedMinimo.main(args);
                        }else {
                            System.out.println("Operação Indisponível");
                        }
                    }else if(primeiro == 5){
                        System.out.println("1-Consultar Médicos/Enfermeiros com Mais Consultas\n"          
                                + "2-Procurar Médico que receitou mais certo Medicamento\n"
                                + "3-Procurar Medicamentos Mais Utilizadps na Enfermaria\n"
                                + "4-Procurar Produtos Mais Utilizados na Enfermaria\n"
                                + "5-Procurar Medicos Com Mais Receitas\n"
                                + "6-Listar Todos Medicos/Funcionarios/Utentes/Enfermeiros\n"
                                );
                        int stats = s.nextInt();
                        if(stats == 1){
                            MaisAtos.main(args);
                        }else if(stats == 2 ){
                            MedPresc.main(args);
                        }else if(stats == 3){
                            MedMais.main(args);
                        }else if(stats == 4){
                            ProdMais.main(args);
                        }else if(stats == 5){
                            MaisReceitas.main(args);
                        }else if(stats == 6){
                            Listar.main(args);
                        }else {
                            System.out.println("Operação Indisponivel");
                        }
                    }else {
                        System.out.println("Operação Indisponivel");
                    }
                System.out.println("Deseja voltar ao menu inicial? sim(s)/nao(n)");
                str = s.next();
            }
        }
                    
                
              

            









    
        
    

    private void connectarServidor() throws RemoteException{
        Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
        System.out.println("Ligado ao Servidor");
    }
}

