package org.projeto.banco.cliente;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

public class RegistroTransacoes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double valor;
	private TiposTransacao tipo;
	private LocalDateTime data;
	
	public RegistroTransacoes(double valor, TiposTransacao tipo, LocalDateTime data) {
		this.setId(new Random().nextInt(999999999));
		this.setValor(valor);
		this.setTipo(tipo);
		this.setData(data);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TiposTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TiposTransacao tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
