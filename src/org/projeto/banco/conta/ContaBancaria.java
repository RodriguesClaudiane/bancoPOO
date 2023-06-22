package org.projeto.banco.conta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.projeto.banco.cliente.RegistroTransacoes;

abstract class ContaBancaria implements IContaBancaria {
public  int numeroConta;
public LocalDateTime dataAbertura;
public boolean status;
public double saldo;
public List<RegistroTransacoes> transacoes;

	
public ContaBancaria() {
	this.numeroConta = new Random().nextInt(999999999);
	this.saldo = 0.0;
	this.dataAbertura = LocalDateTime.now();
	this.status = true;
	transacoes = new ArrayList<>();
}


public int getNumeroConta() {
	return numeroConta;
}


public void setNumeroConta(int numeroConta) {
	this.numeroConta = numeroConta;
}


public LocalDateTime getDataAbertura() {
	return dataAbertura;
}


public void setDataAbertura(LocalDateTime dataAbertura) {
	this.dataAbertura = dataAbertura;
}


public boolean isStatus() {
	return status;
}


public void setStatus(boolean status) {
	this.status = status;
}


public double getSaldo() {
	return saldo;
}


public void setSaldo(double saldo) {
	this.saldo = saldo;
}


public List<RegistroTransacoes> getTransacoes() {
	return transacoes;
}


public void setTransacoes(List<RegistroTransacoes> transacoes) {
	this.transacoes = transacoes;
}


@Override
public int hashCode() {
	return Objects.hash(dataAbertura, numeroConta, saldo, status);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ContaBancaria other = (ContaBancaria) obj;
	return Objects.equals(dataAbertura, other.dataAbertura) && numeroConta == other.numeroConta
			&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo) && status == other.status;
}


@Override
public String toString() {
	return "ContaBancaria [numeroConta=" + numeroConta + ", dataAbertura=" + dataAbertura + ", status=" + status
			+ ", saldo=" + saldo + "]";
}

}

