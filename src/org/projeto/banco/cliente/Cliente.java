package org.projeto.banco.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.projeto.banco.conta.ContaCorrente;

public class Cliente implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	private List<ContaCorrente> contas;
	
	public Cliente() {
		
	}
	public Cliente(String cpf,String nome) {
		this.cpf = cpf;
		this.nome = nome;
		contas = new ArrayList<>();
	   }
	@Override
	public int hashCode() {
		return Objects.hash(contas, cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(contas, other.contas) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrente> contas) {
		this.contas = contas;
	}
	public void abrirConta(ContaCorrente cb) {
	if(contas.contains(cb)) {
		System.out.println("Conta já cadastrada");
	}else {
		this.contas.add(cb);
		System.out.println("Conta criada com sucesso");
	}
	}
	public void fecharConta(ContaCorrente cb) {
		if(cb.getSaldo() != 0.0) {
			System.err.println("Não fi possivel fechar conta.Conta com saldo");
		}
		else if(contas.contains(cb)) {
			this.contas.remove(cb);
			System.out.println("Conta fechada com sucesso");
		}else {
			System.out.println("Conta não existe ou não está associada ao cliente");
		}
	}
	public ContaCorrente localizarContaPeloNumero(int numero) {
		for(int i= 0;i < contas.size();i++) {
			ContaCorrente cb = contas.get(i);
			if(cb.getNumeroConta() == numero) {
				System.out.println("Conta número" + numero + "foi encontrada com sucesso");
				return cb;
				
			}
		}
		System.out.println("Conta não localizada");
		return null;
	}
	public double balancoContasCliente() {
		double saldoTotalCliente = 0.0;
		for(int i = 0; i < contas.size(); i++) {
			ContaCorrente cb = contas.get(i);
			saldoTotalCliente += cb.getSaldo();
		}
		System.out.println("O seu saldo total é:" + saldoTotalCliente);
		return saldoTotalCliente;
		}
	}

