package modelo;

import java.util.ArrayList;

public class Mesa {
	private int id;
	private boolean ocupada;
	private ArrayList<Conta> contas = new ArrayList<>();
	private Garcom garcom;
	
	/*Constructor*/
	public Mesa(int id) {
		this.id = id;
	}
	
	/*Getters and setters */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public Garcom getGarcom() {
		if(this.garcom == null) {
			return null;
		}
		return garcom;
	}
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public Conta localizar(int num) {
		for(Conta c : contas) {
			if(c.getNumero() == num) {
				return c;
			}
		}
		return null;
	}
	public Conta ultimaConta() {
		if(contas.isEmpty()) {
			return null;
		}
		return contas.get(contas.size()-1);
	}
	public ArrayList<Conta> getContas(){
		return this.contas;
	}
	
	/*add and remove*/
	public void adicionar(Conta c) {
		contas.add(c);
		c.setMesa(this);
	}
	
	public void remover(Conta c) {
		contas.remove(c);
		c.setMesa(null);
	}
	/*toString*/
	@Override
	public String toString() {
		String texto = "[ Mesa [ id= " + id + "] , Ocupada = [ "+ocupada+" ] Garçom = [";
		if(garcom==null) {
			texto+=" não tem garcom ";
		}else {
			texto+=" "+garcom.getApelido()+" ";
		}
		texto+=" ] ]\n";
		return texto;
		
	}
	
	
	
}