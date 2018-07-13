package modelo;

public class PagamentoDinheiro extends Pagamento {
	private int percentualdesconto;
	
	public PagamentoDinheiro(double valor, int percentual) {
		super(valor);
		percentualdesconto = percentual;
	}
	@Override
	public void calcularPagamento(double totalconta) {
		 setValorpago(totalconta - (totalconta*percentualdesconto)/100);
	}
	@Override
	public String toString() {
		return  "PagamentoDinheiro"+"[percentualdesconto= " + percentualdesconto +"% "+ super.toString()+"]";
	}
	
	
}
