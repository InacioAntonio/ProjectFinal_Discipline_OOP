package visao;
import persistencia.FazendeiroDAO;
import aplicacao.Fazendeiro;
import java.util.Scanner;

public class Principal {
		public static void main(String[] args) {
			int op, opLogin, opAtualizar;
			Scanner ler = new Scanner(System.in);
			Fazendeiro fazendeiro, fBusca, fazendeiroSessao;
			String cpf, nome, senha, telefone, cpfAtualiza;
			int idade;
			FazendeiroDAO fDAO;
			
			do {
				System.out.println("1 - Login");
				System.out.println("2 - Cadastrar Fazendeiro");
				System.out.println("3 - Sair");
				op = ler.nextInt();

				ler.nextLine();
				switch(op) {
					case 1:
						System.out.println("Ola fazendeiro!");
						System.out.println("Digite seu cpf:");
						cpf = ler.nextLine();
						System.out.println("Digite sua senha:");
						senha = ler.nextLine();
						fDAO = new FazendeiroDAO();
						fBusca = fDAO.buscar(cpf);
						
						if(fBusca != null) {
							
							if(fBusca.getSenha().equals(senha)) {
								fazendeiroSessao = fBusca;
								do {
									System.out.println("1 - Cadastrar Bode");
									System.out.println("2 - Relatorio geral dos bodes");
									System.out.println("3 - Buscar Bode");
									System.out.println("4 - Alterar Bode");
									System.out.println("5 - Deletar Bode");
									System.out.println("6 - Cadastrar Produto");
									System.out.println("7 - Relatorio geral dos produtos");
									System.out.println("8 - Buscar Produto");
									System.out.println("9 - Alterar Produto");
									System.out.println("10 - Deletar Produto");
									System.out.println("11 - Atualizar fazendeiro");
									System.out.println("12 - Deletar Fazendeiro");
									System.out.println("13 - Visualizar dados");
									System.out.println("14 - Sair");
									opLogin = ler.nextInt();
									ler.nextLine();
									
									switch(opLogin) {
										case 11:
											do {
												System.out.println("Quais dados deseja alterar?");
												System.out.println("1 - Nome");
												System.out.println("2 - CPF");
												System.out.println("3 - senha");
												System.out.println("4 - idade");
												System.out.println("5 - telefone");
												System.out.println("6 - Sair");
												opAtualizar = ler.nextInt();
												ler.nextLine();
												switch (opAtualizar) {
												
												case 1: 
													System.out.println("Digite o seu cpf:");
													cpf = ler.nextLine();
													System.out.println("Digite seu novo nome:");
													nome = ler.nextLine();
													fazendeiro = fDAO.buscar(cpf);
													
													if(fazendeiro != null) {
														fazendeiroSessao.setNome(nome);
														fDAO.atualizar(fazendeiroSessao);
														System.out.println("Nome atualizado com sucesso");
													}else {
														System.out.println("CPF invalido");
													}
												break;
												
												case 2: 
													System.out.println("Digite o seu cpf:");
													cpf = ler.nextLine();
													if(fDAO.buscar(cpf) != null) {
														System.out.println("Digite seu novo cpf:");
														cpfAtualiza = ler.nextLine();
														fazendeiro = fDAO.buscar(cpfAtualiza);
														
														if(fazendeiro == null) {
															fazendeiroSessao.setCpf(cpfAtualiza);
															fDAO.atualizar(fazendeiroSessao, cpf);
															System.out.println("Cpf alterado com sucesso");
														}else{
															System.out.println("CPF ja cadastrado");
														}
													}else {
														System.out.println("CPF invalido");
													}
												break;
												
												case 3:
													System.out.println("Digite o seu cpf:");
													cpf = ler.nextLine();
													System.out.println("Digite sua nova senha:");
													senha = ler.nextLine();
													fazendeiro = fDAO.buscar(cpf);
													
													if(fazendeiro != null) {
														fazendeiroSessao.setSenha(senha);
														fDAO.atualizar(fazendeiroSessao);
														System.out.println("Senha atualiza com sucesso");
													}else {
														System.out.println("CPF invalido");
													}
													
													break;
													
												case 4: 
													System.out.println("Digite o seu cpf:");
													cpf = ler.nextLine();
													System.out.println("Digite sua nova idade:");
													idade = ler.nextInt();
													fazendeiro = fDAO.buscar(cpf);
													
													if(fazendeiro != null) {
														fazendeiroSessao.setIdade(idade);
														fDAO.atualizar(fazendeiroSessao);
														System.out.println("Idade atualizada com sucesso");
													}else {
														System.out.println("CPF invalido");
													}
												break;
												
												case 5: 
													System.out.println("Digite o seu cpf:");
													cpf = ler.nextLine();
													System.out.println("Digite seu novo telefone:");
													telefone = ler.nextLine();
													fazendeiro = fDAO.buscar(cpf);
													
													if(fazendeiro != null) {
														fazendeiroSessao.setTelefone(telefone);
														fDAO.atualizar(fazendeiroSessao);
														System.out.println("Telefone atualizado com sucesso");
													}else {
														System.out.println("CPF invalido");
													}
												break;
													
												default:
													System.out.println("Opcao invalida");
												
												}
											}while(opAtualizar != 6);
										break;
										
										case 12:
											System.out.println("Digite sua senha para deletar sua conta:");
											senha = ler.nextLine();
											
											if(senha.equals(fazendeiroSessao.getSenha())){
												fDAO.deletar(fazendeiroSessao.getCpf());
												System.out.println("Conta deletada com sucesso");
												fazendeiroSessao = null;
											}
										break;
										
										case 13:
											fazendeiro = fDAO.buscar(fazendeiroSessao.getCpf());
											System.out.println("CPF: " + fazendeiro.getCpf());
											System.out.println("Nome: " + fazendeiro.getNome());
											System.out.println("Senha: " + fazendeiro.getSenha());
											System.out.println("Telefone: " + fazendeiro.getTelefone());
											System.out.println("Idade: " + fazendeiro.getIdade());
											break;
									}
									
									if(fazendeiroSessao == null)
										break;

								}while(opLogin != 14);
							}else {
								System.out.println("Senha incorreta");
							}
						}else {
							System.out.println("Usuario nao cadastrado no sistema\n");
						}
						
					break;
					
					case 2:
						System.out.println("Ola fazendeiro!");
						System.out.println("Qual seu cpf?");
						cpf = ler.nextLine();
						fDAO = new FazendeiroDAO();
						if(fDAO.buscar(cpf) == null) {
							
							System.out.println("Qual seu nome?");
							nome = ler.nextLine();
							System.out.println("Qual a sua idade?");
							idade = ler.nextInt();
							ler.nextLine();
							System.out.println("Qual seu numero de telefone?");
							telefone = ler.nextLine();
							System.out.println("Qual a sua senha?");
							senha = ler.nextLine();
							
							fazendeiro = new Fazendeiro(nome, cpf, senha, idade, telefone);
							fDAO.cadastrar(fazendeiro);
							System.out.println("Fazendeiro cadastrado com sucesso!");
						}else {
							System.out.println("Fazendeiro ja cadastrado com esse cpf");
						}
						
					break;
				}
				
			}while(op != 3);
			
			System.out.println("Fim de programa");
		}
}
