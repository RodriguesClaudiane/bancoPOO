package org.projeto.banco.persistencia;
import org.projeto.banco.cliente.*;
import org.projeto.banco.conta.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persistencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Cliente> cadastroClientes = new ArrayList<>();

	private static Persistencia instance;
	
	private Persistencia() {
		carregarDadosDeArquivo();
	}
	
	public static Persistencia getInstance() {
		if(instance!=null)
			return instance;
		else
			return new Persistencia();
	}

	public void salvarCliente(Cliente c) {
		if (!cadastroClientes.contains(c)) {
			cadastroClientes.add(c);
			salvarDadosEmArquivo();
			System.out.println("Cliente cadastrados com sucesso!");
		} else
			System.err.println("Cliente ja cadastrado no sistema!");

	}
	
	public Cliente localizarClientePorCPF(String cpf) {
		Cliente c = new Cliente();
		c.setCpf(cpf);
		if(cadastroClientes.contains(c)) {
			int index = cadastroClientes.indexOf(c);
			c = cadastroClientes.get(index);
			return c;
		}else
			return null;
	}
	
	public void atualizarClienteCadastro(Cliente c) {
		if(cadastroClientes.contains(c)) {
			int index = cadastroClientes.indexOf(c);
			cadastroClientes.set(index, c);
			salvarDadosEmArquivo();
		}else
			System.err.println("Cliente não encontrado!");
	}

	public void salvarDadosEmArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("dadosClientes");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cadastroClientes);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void carregarDadosDeArquivo() {

		try {
			FileInputStream fis = new FileInputStream("dadosClientes");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cadastroClientes = (ArrayList<Cliente>)ois.readObject();
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
