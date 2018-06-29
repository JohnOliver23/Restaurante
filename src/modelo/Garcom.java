package modelo;

import java.util.ArrayList;

public class Garcom {
	private String apelido;
	private ArrayList<Mesa> mesas = new ArrayList<>();
	
	/*Constructor */
	public Garcom(String apelido) {
		this.apelido = apelido;
	}
	
	/*getters and setters */
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public Mesa localizarMesa(int id) {
		for(Mesa m: mesas) {
			if(m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	
	//add remove
	public void adicionar(Mesa m) {
		mesas.add(m);
		m.setGarcom(this);//bidirecional
	}
	
	public void remover(Mesa m) {
		mesas.remove(m);
		//m.setGarcom(null);//bidirecional
	}
	
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	
	/*ToString*/
	@Override
	public String toString() {
		String texto = "Garcom [apelido= " + apelido + "] , mesas=[ ";
		if(mesas.isEmpty()) {
			texto+= "não tem mesas";
		}else {
			for(Mesa m: mesas) {
				texto+=m.getId()+" ,";
			}
		}
		texto+=" ]\n";
		return texto;
	}
	
	
	
	
	
}
