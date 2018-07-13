package modelo;

public class PagamentoCartao extends Pagamento {
	private String cartao;
	private int quantidadeparcelas;
	
	public PagamentoCartao(double valor, String card, int qtdparc) {
		super(valor);
		cartao = card;
		quantidadeparcelas = qtdparc;
		
	}
	
	@Override
	public void calcularPagamento(double totalconta) {
		 if(quantidadeparcelas ==1 || quantidadeparcelas ==2 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta);
		 }else if(quantidadeparcelas ==3 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta+(totalconta*10)/100);
		 }else if (quantidadeparcelas ==4 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta+(totalconta*20)/100);
		 }
	}

	@Override
	public String toString() {
		return "PagamentoCartão"+"[cartao=" + cartao + ", quantidadeparcelas= " + quantidadeparcelas +
				", valor de cada parcela= "+getValorpago()/quantidadeparcelas+" "+super.toString()+ "]";
	}
	
	
}
