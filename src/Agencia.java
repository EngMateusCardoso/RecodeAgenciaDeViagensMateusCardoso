import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Agencia {

	private List<Viagem> listaDeViagens = new ArrayList<>();
	private List<Cliente> listaDeClientes = new ArrayList<>();
	private int ind = 0;
	
	public void menu(Scanner in) {
		int opcaoMenu;
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("---------------  Agencia de Viagens Recode  ----------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("--------------------------  MENU  --------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("[1] CADASTRAR");
			System.out.println("[2] CONSULTAR");
			System.out.println("[0] ENCERRAR");
			opcaoMenu = Integer.parseInt(in.nextLine());

			if (opcaoMenu == 1) {
				this.cadastrar(in);
			}if(opcaoMenu == 2) {
				this.consultar(in);
			}
		}while(opcaoMenu != 0);	
	}
	
	private void cadastrar(Scanner in) {
		int controle = 1;
		while(controle != 0) {
			//Cadastro do Cliente
			listaDeClientes.add(new Cliente());
			listaDeViagens.add(new Viagem());
			System.out.println("-----------------------------------------");
			System.out.println("---------- Cadastro do Cliente ----------");
			System.out.println("-----------------------------------------");
			System.out.print("Nome: ");
			this.listaDeClientes.get(this.ind).setNome(in.nextLine());
			System.out.print("Telefone para contato: ");
			this.listaDeClientes.get(this.ind).setTelefoneContato(in.nextLine());
			System.out.print("Endereço (cidade de partida): ");
			this.listaDeClientes.get(this.ind).setSaida(in.nextLine());
			//Cadastro da Viagem
			System.out.println("-----------------------------------------");
			System.out.println("---------- Cadastro do Destino ----------");
			System.out.println("-----------------------------------------");
			System.out.println("Selecione o seu destino Destino:");
			System.out.println("[1] Angra dos Reis (RJ)");
			System.out.println("[2] Aparecida (SP)");
			System.out.println("[3] Fernando de Noronha (PE)");
			System.out.println("[4] Ouro Preto (MG)");
			System.out.println("[5] Gramado (RS)");
			int indiceSelecao = Integer.parseInt(in.nextLine());
			switch (indiceSelecao) {
				case 1:
					this.listaDeViagens.get(this.ind).setDestino("Angra dos Reis (RJ)");
					break;
				case 2:
					this.listaDeViagens.get(this.ind).setDestino("Aparecida (SP)");
					break;
				case 3:
					this.listaDeViagens.get(this.ind).setDestino("Fernando de Noronha (PE)");
					break;
				case 4:
					this.listaDeViagens.get(this.ind).setDestino("Ouro Preto (MG)");
					break;
				case 5:
					this.listaDeViagens.get(this.ind).setDestino("Gramado (RS)");
					break;
				default:
					this.listaDeViagens.get(this.ind).setDestino("Destino imformado incorretamente");
					break;
			}
			System.out.println("Entre com a data desejada: ");
			this.listaDeViagens.get(this.ind).setData(in.nextLine());
			System.out.println("Deseja o pacote Premium: ");
			System.out.println("[1] Sim");
			System.out.println("[0] Não");
			indiceSelecao = Integer.parseInt(in.nextLine());
			switch (indiceSelecao) {
				case 1:
					this.listaDeViagens.get(this.ind).setPacote("Premium");
					break;
				case 0:
					this.listaDeViagens.get(this.ind).setPacote("Básico");
					break;
				default:
					this.listaDeViagens.get(this.ind).setPacote("Não especificado");
					break;
			}
			//Finalizado
			do {
				System.out.println("Cadastro Finalizado!");
				System.out.println("--------------------------------");
				System.out.println("[1] Novo cadastro");
				System.out.println("[0] Voltar ao MENU!");
				controle = Integer.parseInt(in.nextLine());
			}while(controle != 0);
			this.ind++;
		}
	}
	
	private void consultar(Scanner in) {
		int controle = 1;
		while(controle != 0) {
			System.out.println("---------------------------------------------------------");
			System.out.println("---------------------------------------------------------");
			System.out.println("------------------CONSULTA DE CADASTRO-------------------");
			System.out.println("Entre com o nome do cliente que deseja fazer a consulta ");
			System.out.println("Ou entre com 'Geral' para consultar todos os cadastrados ");
			System.out.println("---------------------------------------------------------");
			System.out.print("Consultar: ");
			String nomeConsultado = in.nextLine();
			
			int t = 0;
			if (nomeConsultado.equals("Geral")) {
				for (int i = 0; i<this.listaDeClientes.size();i++) {
					this.modeloConsulta(i);
				}
			} else {
				for (int i =0;i<this.listaDeClientes.size();i++) {
					if (nomeConsultado.equals(this.listaDeClientes.get(i).getNome())) {
						this.modeloConsulta(i);
						t = 1;
					}		
				}
				if (t==0) {
					System.out.println("Esse nome não foi cadastrado, ou foi digitado incorretamente, tente novamente!");
					System.out.println("________________________________________________________________________________");
				}
			}
			do {
				System.out.println("[1] Fazer nova consulta");
				System.out.println("[0] Voltar ao Menu");
				controle = Integer.parseInt(in.nextLine());
			}while (controle != 0);
		}
	}
	
	private void modeloConsulta(int i) {
		System.out.println("Viagem de " + this.listaDeClientes.get(i).getNome() + ", saindo de " + this.listaDeClientes.get(i).getSaida()  + " e com destino a " + this.listaDeViagens.get(i).getDestino());
		System.out.println("Data da viagem: " + this.listaDeViagens.get(i).getData() + "        |      Pacote " + this.listaDeViagens.get(i).getPacote());
		System.out.println("telefone para contato: " + this.listaDeClientes.get(i).getTelefoneContato());
		System.out.println("________________________________________________________________________________");
	}
	
}
