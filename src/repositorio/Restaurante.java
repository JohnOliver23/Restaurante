package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;

public class Restaurante {
TreeMap<String,Garcom>  garcons  =  new  TreeMap<>();
private ArrayList<Mesa>mesas = new ArrayList<>();
private ArrayList<Conta>contas = new ArrayList<>();
private ArrayList<Produto>produtos = new ArrayList<>();

/*Add and remove*/
public void adicionar(Garcom g) {
	garcons.put(g.getApelido(), g);
}

public void remover(Garcom g) {
	garcons.remove(g.getApelido());
}

public void adicionar(Mesa m) {
	mesas.add(m);
}

public void remover(Mesa m) {
	mesas.remove(m);
}

public void adicionar(Conta c) {
	contas.add(c);
}

public void remover(Conta c) {
	contas.remove(c);
}

public void adicionar(Produto p) {
	produtos.add(p);
}

public void remover(Produto p) {
	produtos.remove(p);
}

/*localizar*/
public Garcom localizarGarcom(String nome){
	for(Garcom g : garcons.values()){
		if(g.getApelido().equalsIgnoreCase(nome))
			return g;
	}
	return null;
}

public Mesa localizarMesa(int id){
	for(Mesa m : mesas){
		if(m.getId() == id) {
			return m;
		}
	}
	return null;
}

public Conta localizarConta(int num){
	for(Conta c : contas){
		if(c.getNumero() == num)
			return c;
	}
	return null;
}

public Conta localizarUltimaContaPorMesa(int idmesa) {
    Mesa aux = localizarMesa(idmesa);
    if(aux!=null) {
        Conta c =  aux.ultimaConta();
        if(c !=null) {
        	return c;
        	
        }
    }
    return null;
    
}

public Produto localizarProduto(String nome){
	for(Produto p : produtos){
		if(p.getNome().equalsIgnoreCase(nome))
			return p;
	}
	return null;
}
           /*getters */

public TreeMap<String, Garcom> getGarcons() {
	return garcons;
}


public ArrayList<Mesa> getMesas() {
	return mesas;
}


public ArrayList<Conta> getContas() {
	return contas;
}


public ArrayList<Produto> getProdutos() {
	Collections.sort(produtos);
	return produtos;
}


}
