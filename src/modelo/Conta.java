package modelo;

import java.util.ArrayList;

public class Conta {
private int numero;
private String dtfechamento;
private double total;
private Mesa mesa;
private ArrayList<Produto> produtos = new ArrayList<>();
private Pagamento pagamento;
/*Constructor */
public Conta(int numero) {
	this.numero = numero;
}

/*/*Getters and setters */

public int getNumero() {
	return numero;
}
public Pagamento getPagamento() {
	return pagamento;
}

public void setPagamento(Pagamento pagamento) {
	this.pagamento = pagamento;
}

public void setNumero(int numero) {
	this.numero = numero;
}
public String getDtfechamento() {
	return dtfechamento;
}
public void setDtfechamento(String dtfechamento) {
	this.dtfechamento = dtfechamento;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Mesa getMesa() {
	return mesa;
}
public void setMesa(Mesa mesa) {
	this.mesa = mesa;
	
}

/*add and remove */
public void adicionar(Produto p) {
	produtos.add(p);
	this.setTotal(this.getTotal()+p.getPreco());
	
}

public void remover(Produto p ) {
	produtos.remove(p);
}

public Produto localizar (String nome) {
	for(Produto p: produtos) {
		if(p.getNome().equals(nome)) {
			return p;
		}
	}
	return null;
}
public ArrayList<Produto> getProdutos(){
	return produtos;
}




/*toString*/
@Override
public String toString() {
	String texto = "\n[ Conta [numero=" + numero + ", dtfechamento=" + dtfechamento + ", total=" + total + ", mesa=" + mesa+" Produtos: = [ ";
	if(produtos.isEmpty()) {
		texto+=" n�o tem produtos";
	}else {
		for(Produto p : produtos) {
			texto+=p+" ,";
		}
	}
	
	if(pagamento != null) {
		texto+="\n"+pagamento;
	}
	texto+=" ] ";
	return texto;
}



}
