package org.projeto.banco.conta;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.projeto.banco.cliente.RegistroTransacoes;
import org.projeto.banco.cliente.TiposTransacao;


public class ContaCorrente extends ContaBancaria implements Serializable {
	

	private static final long serialVersionUID = 1L;
	public void depositar(double quantia) {
		if (status) {
			if (quantia > 0) {
				this.saldo += quantia;
				transacoes.add(new RegistroTransacoes(quantia, TiposTransacao.Credito, LocalDateTime.now()));
				System.out.println("Deposito realizado com sucesso.");
			} else {
				System.err.println("Valor invalido para deposito.");

			}
		} else {
			System.err.println("Operação não permitida. Conta desativada.");

		}
	}

	public void transferir(ContaCorrente cb, double quantia) {
		if (!this.status) {
			System.err.println("Sua conta está desativada");
		}
		else if (cb.isStatus() != true) {
			System.err.println("Conta de destino desativada");
		}
		else if (quantia <= 0) {
				System.err.println("Valor inválido para transferência.");
		}
		else if (quantia > this.saldo) {
			System.err.println("Saldo insuficiente");
			} else {
				this.saldo -= quantia;
				cb.setSaldo(cb.getSaldo() + quantia);
				cb.transacoes.add(new RegistroTransacoes(quantia, TiposTransacao.Transacao_Credito, LocalDateTime.now()));
				transacoes.add(new RegistroTransacoes(quantia, TiposTransacao.Transacao_Debito, LocalDateTime.now()));
				System.out.println("Transferencia feita com sucesso!");
			}
	}
	public void sacar(double quantia) {
		if (!this.status) {
			System.err.println("Operação não permitida.Conta desativada");
		}
			else if (quantia <= 0) {
				System.err.println("Valor inválido para saque");
			}
			else if (quantia > this.saldo) {
				System.err.println("Saldo insuficiente");
			}else{
					this.saldo -= quantia;
					transacoes.add(new RegistroTransacoes(quantia, TiposTransacao.Debito, LocalDateTime.now()));
					System.out.println("Saque realizado com sucesso!");
			}
	             }
	public void desativarConta() {
		if(this.status != true) {
			System.err.println("Conta já inativa");
		}else{
			this.status = false;
		}
	}
	public void reativarConta() {
		if(this.status == true){
			System.err.print("Conta já ativa");
		}else {
			this.status = true;
		}
	}
	};
