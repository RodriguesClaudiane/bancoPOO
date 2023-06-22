package org.projeto.banco.cliente;

import java.io.Serializable;

public enum TiposTransacao implements Serializable {

	Credito(1),
	Debito(2),
	Transacao_Credito(3),
	Transacao_Debito(4);
	
	
private final int valor;
	
	private TiposTransacao(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static TiposTransacao transacaoFromValor(int valor) {
		for(TiposTransacao t : values()) {
			if(t.getValor() == valor)
				return t;
		}
		return null;
	}
}

