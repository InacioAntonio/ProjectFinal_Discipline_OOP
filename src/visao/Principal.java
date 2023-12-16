package visao;
import persistencia.*;
import aplicacao.*;
import aplicacao.Fazendeiro;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
		public static void main(String[] args) {
			int op, opLogin, opAtualizar;
			Scanner ler = new Scanner(System.in);
			Fazendeiro fazendeiro, fBusca, fazendeiroSessao;
			String cpf, nome, senha, telefone, cpfAtualiza;
			int idade, id;
			FazendeiroDAO fDAO;
			BodeDAO bd;
			ProdutoDAO pd;
			Bode_produtoDAO bpDAO = new Bode_produtoDAO();
			Bode bode;
			Produto produto;
			ArrayList<Bode> listaBode;
			ArrayList<Produto> listaProduto;
			ArrayList<Relatorio_BodeProd> relatorioBodeProduto = new ArrayList<Relatorio_BodeProd>();
			int bodeEscolha;
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
									System.out.println("14 - Relatorio geral dos bodes");
									System.out.println("15 - Relatorio dos bodes do sistema");
									System.out.println("16 - Sair");
									opLogin = ler.nextInt();
									ler.nextLine();
									
									switch(opLogin) {
									case 1:
										bode = new Bode();
										bd  = new BodeDAO();
										bode.setCpfFazendeiro(fazendeiroSessao.getCpf());
										System.out.println("Digite o nome do seu Bode");
										bode.setNome(ler.nextLine());
										System.out.println("Digite o genero do seu Bode");
										bode.setGenero(ler.nextLine());
										System.out.println("Digite o Peso do seu Bode");
										bode.setPeso(ler.nextFloat());
										bd.CadastrarBode(bode);
										break;
									case 2:
										bd = new BodeDAO();
										listaBode = bd.buscar(fazendeiroSessao.getCpf());
										for (int i=0;i<listaBode.size();i++) {
											System.out.println("ID: "+listaBode.get(i).getId());
											System.out.println("Nome: "+listaBode.get(i).getNome());
											System.out.println("Genero: "+listaBode.get(i).getGenero());
											System.out.println("Peso: "+listaBode.get(i).getPeso());
											System.out.println("Cpf_Fazendeiro: "+listaBode.get(i).getCpfFazendeiro());
											
										}
										break;
									case 3:
										bd = new BodeDAO();
										System.out.println("Digite o ID do seu Bode");
										bode = bd.BuscarId(ler.nextInt());
										if (bode != null) {
											System.out.println("ID: "+bode.getId());
											System.out.println("Nome: "+bode.getNome());
											System.out.println("Genero: "+bode.getGenero());
											System.out.println("Peso: "+bode.getPeso());
											System.out.println("Cpf_Fazendeiro: "+bode.getCpfFazendeiro());
											
										}else {
											System.out.println("Nada foi encontrado");
										}
										break;
									case 4:
										System.out.println("Digite o id do bode que deseja alterar:");
										bd = new BodeDAO();
										id = ler.nextInt();
										bode = bd.BuscarId(id);
										if (bode != null) {
											System.out.println("Digite as novas informações:");
											ler.nextLine();
											System.out.println("Nome: ");
											bode.setNome(ler.nextLine());
											System.out.println("Genero: ");
											bode.setGenero(ler.nextLine());
											System.out.println("Peso: ");
											bode.setPeso(ler.nextFloat());
											bd.atualizar(bode, id);
										}else {
											System.out.println("Nada foi encontrado");
										}
										break;
									case 5:
										System.out.println("Digite o id do bode que deseja deletar:");
										bd = new BodeDAO();
										id = ler.nextInt();
										bode = bd.BuscarId(id);
										if (bode != null) {
											bd.deletar(id);
											System.out.println("Bode deletado");
										}else {
											System.out.println("Nada foi encontrado");
										}
										break;
									case 6:
										bd = new BodeDAO();
										listaBode = bd.buscar(fazendeiroSessao.getCpf());
										if (listaBode == null) {
											System.out.println("Sem Bodes cadastrados");
										}else {
											System.out.println("\n");
											for(int i=0; i < listaBode.size();i++) {
												System.out.println("ID: "+listaBode.get(i).getId());
												System.out.println("Nome: "+listaBode.get(i).getNome());
												System.out.println("Genero: "+listaBode.get(i).getGenero());
												System.out.println("Peso: "+listaBode.get(i).getPeso());
											}
											System.out.println("\n");
											
											System.out.println("Digite o numero do bode que deseja cadastrar o produto:");
											bodeEscolha = ler.nextInt();
											produto = new Produto();
											ler.nextLine();
											System.out.println("Digite a Categoria do Produto");
											produto.setCategoria(ler.nextLine());
											System.out.println("Digite o Peso do Produto");
											produto.setPeso(ler.nextFloat());
											System.out.println("Digite a Descricao do Produto");
											ler.nextLine();
											produto.setDescricao(ler.nextLine());
											System.out.println("Digite a Quantidade do Produto");
											produto.setQuantidade(ler.nextInt());
											System.out.println("Digite o Preco do Produto");
											ler.nextLine();
											produto.setPreco(ler.nextFloat());
											pd = new ProdutoDAO();
											pd.Cadastrar(produto);
											listaProduto = pd.Buscar(produto.getCategoria());
											int ultimoIndice = listaProduto.size()-1;
											bpDAO.cadastrar(bodeEscolha, listaProduto.get(ultimoIndice).getId());
											System.out.println("Produto cadastrado com sucesso");
										}
										break;
									case 7:
										pd = new ProdutoDAO();
										System.out.println("Digite a Categoria do Produto");
										listaProduto = pd.Buscar(ler.nextLine());
										for (int i=0; i<listaProduto.size();i++) {
											System.out.println("ID: "+listaProduto.get(i).getId());
											System.out.println("Categoria: "+listaProduto.get(i).getCategoria());
											System.out.println("Descricao: "+listaProduto.get(i).getDescricao());
											System.out.println("Peso: "+listaProduto.get(i).getPeso());
											System.out.println("Quantidade: "+listaProduto.get(i).getQuantidade());
										}
										break;
									case 8:
										pd = new ProdutoDAO();
										System.out.println("Digite o Id do Produto da Busca");
										produto = pd.Buscar(ler.nextInt());
										if (produto !=null) {
											System.out.println("ID: "+ produto.getId());
											System.out.println("Categoria: "+produto.getCategoria());
											System.out.println("Descricao: "+produto.getDescricao());
											System.out.println("Preco: "+produto.getPreco());
											System.out.println("Peso: "+produto.getPeso());
											System.out.println("Quantidade: "+produto.getQuantidade());
											
										}else {
											System.out.println("Não foi achado nada ");
										}
										break;
										
										
										case 9:
											pd = new ProdutoDAO();
											System.out.println("Digite o Id do Produto que deseja alterar");
											id = ler.nextInt();
											produto = pd.Buscar(id);
											if (produto !=null) {
												ler.nextLine();	
												System.out.println("Digite as novas informações:");
												System.out.println("Categoria: ");
												produto.setCategoria(ler.nextLine());
												System.out.println("Descricao: ");
												produto.setDescricao(ler.nextLine());
												System.out.println("Preco: ");
												produto.setPreco(ler.nextFloat());
												System.out.println("Peso: ");
												produto.setPeso(ler.nextFloat());
												System.out.println("Quantidade: ");
												produto.setQuantidade(ler.nextInt());
												pd = new ProdutoDAO();
												pd.Atualizar(produto);
												System.out.println("Produto atualizado com sucesso");
											}else {
												System.out.println("Não foi achado nada ");
											}
										break;
										
										case 10:
											pd = new ProdutoDAO();
											System.out.println("Digite o Id do Produto que deseja alterar");
											id = ler.nextInt();
											produto = pd.Buscar(id);
											if (produto !=null) {
												pd = new ProdutoDAO();
												pd.Deletar(id);
												System.out.println("Produto deletado com sucesso");
											}else {
												System.out.println("Não foi achado nada ");
											}
										break;
										
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
											
										case 14:
											relatorioBodeProduto = bpDAO.relatorioAssociados(fazendeiroSessao.getCpf());
											
											for(int i=0; i < relatorioBodeProduto.size();i++) {
												System.out.println("Fazendeiro: " + relatorioBodeProduto.get(i).getCpfFazendeiro());
												System.out.println("Nome do bode: " + relatorioBodeProduto.get(i).getNome());
												System.out.println("Peso do produto:" + relatorioBodeProduto.get(i).getPeso());
												System.out.println("Id produto:"+relatorioBodeProduto.get(i).getId());
												System.out.println("Id bode: "+relatorioBodeProduto.get(i).getId_bode());
												System.out.println("Categoria do produto: "+relatorioBodeProduto.get(i).getCategoria());
												System.out.println("Peso do bode: "+relatorioBodeProduto.get(i).getPeso());
												System.out.println("Preco do produto: "+relatorioBodeProduto.get(i).getPreco());
												System.out.println("");
											}
											break;
											
										case 15:
											bd = new BodeDAO();
											relatorioBodeProduto = bpDAO.relatorioGeral(fazendeiroSessao.getCpf());
											
											for(int i=0; i < relatorioBodeProduto.size();i++) {
												System.out.println("Fazendeiro: " + relatorioBodeProduto.get(i).getCpfFazendeiro());
												System.out.println("Nome do bode: " + relatorioBodeProduto.get(i).getNome());
												System.out.println("Peso do produto:" + relatorioBodeProduto.get(i).getPeso());
												System.out.println("Id produto:"+relatorioBodeProduto.get(i).getId());
												System.out.println("Id bode: "+relatorioBodeProduto.get(i).getId_bode());
												System.out.println("Categoria do produto: "+relatorioBodeProduto.get(i).getCategoria());
												System.out.println("Peso do bode: "+relatorioBodeProduto.get(i).getPeso());
												System.out.println("Preco do produto: "+relatorioBodeProduto.get(i).getPreco());
												System.out.println("");
											}
											break;
									}
									
									if(fazendeiroSessao == null)
										break;

								}while(opLogin != 16);
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
