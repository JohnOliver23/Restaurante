package modelo;

public abstract class Pagamento {
	private  double valorpago;
	
	public Pagamento(double valor) {
		super();
		valorpago = valor;
	}
	
	
	
	public double getValorpago() {
		return valorpago;
	}



	public void setValorpago(double valorpago) {
		this.valorpago = valorpago;
	}



	public abstract void calcularPagamento(double totalconta);
	
	public double calcularGorjeta() {
		return (valorpago*10)/100;
	}

	@Override
	public String toString() {
		return "Pagamento [valorpago=" + valorpago + "]";
	}
		
	
	
}
