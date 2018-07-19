package modelo;

public class Produto implements Comparable<Produto> {
private String nome;
private double preco;
public Produto(String nome, double preco) {
	this.nome = nome;
	this.preco = preco;
}
/*getters and setters */
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
@Override
public String toString() {
	return "Produto [nome=" + nome + ", preco=" + preco + "]";
}
@Override
public int compareTo(Produto outro) {
	return this.getNome().compareToIgnoreCase(outro.getNome());
}






}
