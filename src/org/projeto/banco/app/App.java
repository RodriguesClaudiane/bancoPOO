package org.projeto.banco.app;

import java.util.Scanner;

import org.projeto.banco.cliente.Cliente;
import org.projeto.banco.conta.ContaCorrente;
import org.projeto.banco.persistencia.Persistencia;


	public class App {

		public static void main(String[] args) {

			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("Bem-vindo ao banco! O que você gostaria de fazer?");
				System.out.println("1. Cadastrar novo cliente");
				System.out.println("2. Selecionar cliente existente");
				System.out.println("3. Sair");

				int opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					System.out.println("Digite o nome do cliente:");
					String nome = scanner.nextLine();
					System.out.println("Digite o CPF do cliente:");
					String cpf = scanner.nextLine();
					Cliente cliente = new Cliente(cpf, nome);
					Persistencia.getInstance().salvarCliente(cliente);
					break;

				case 2:
					System.out.println("Digite o CPF do cliente:");
					cpf = scanner.next();

					cliente = Persistencia.getInstance().localizarClientePorCPF(cpf);

					if (cliente == null) {
						System.out.println("Cliente não encontrado");
						break;
					}

					System.out.println("Cliente selecionado: " + cliente.getNome());
					System.out.println("\nO que você gostaria de fazer?\n");
					System.out.println("1. Criar nova conta");
					System.out.println("2. Ver informações das contas");
					System.out.println("3. Realizar Deposito");
					System.out.println("4. Realizar Saque");
					System.out.println("5. Realizar Transferencia");

					opcao = scanner.nextInt();
					scanner.nextLine();

					switch (opcao) {
					case 1:
						ContaCorrente conta = new ContaCorrente();
						cliente.abrirConta(conta);
						Persistencia.getInstance().atualizarClienteCadastro(cliente);
						System.out.println("Conta criada com sucesso!");
						break;

					case 2:
						if (cliente.getContas().size() == 0) {
							System.err.println("Nao ha contas associada a este cliente.");
						} else {
							for (ContaCorrente cb : cliente.getContas()) {
								System.out.println(cb);
							}
						}
						break;
					case 3:
						if (cliente.getContas().size() == 0) {
							System.err.println("Nao ha contas associada a este cliente.");
						} else {
							for (ContaCorrente cb : cliente.getContas()) {
								System.out.println(cb);
							}
						}
						System.out.println("Em qual conta deseja realizar o deposito?");
						int opcaoContaDeposito = 0;
						double quantia = 0.0;
						opcaoContaDeposito = scanner.nextInt();
						System.out.println("Insira o valor da quantia a ser depositada: ");
						quantia = scanner.nextDouble();
						ContaCorrente temp = cliente.localizarContaPeloNumero(opcaoContaDeposito);
						if (temp != null) {
							temp.depositar(temp.getSaldo() + quantia);
							Persistencia.getInstance().atualizarClienteCadastro(cliente);
						}
						break;
					default:
						System.out.println("Opção inválida");
						break;
					}
					break;
				case 3:
					System.out.println("Até logo!");
					System.exit(0);

				default:
					System.out.println("Opção inválida");
					break;
				}
			}
		}
	}


