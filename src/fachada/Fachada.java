package fachada;	

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

import modelo.Produto;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Conta;
import modelo.Pagamento;
import modelo.PagamentoCartao;
import modelo.PagamentoDinheiro;
import repositorio.Restaurante;

public class Fachada {

	private static Restaurante restaurante = new Restaurante();
	private static int numconta = 0;
	               /*listar  */
	public static ArrayList<Produto>listarProdutos(){
		return restaurante.getProdutos();
	}
	
	public static ArrayList<Produto>listarProdutos(String nome){
		ArrayList<Produto> aux = new ArrayList<>();
		for(Produto p : restaurante.getProdutos()) {
			if(p.getNome().contains(nome)) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public static TreeMap<String,Garcom>listarGarcons(){
		return restaurante.getGarcons();
	}
	
	public static ArrayList<Mesa>listarMesas(){
		return restaurante.getMesas();
	}
	public static ArrayList<Conta>listarContas(){
		return restaurante.getContas();
	}
	
	/*criar mesas*/
	public static void criarMesas(int n) {
		Mesa aux;
		for(int i=1; i<=n; i++) {
			aux = new Mesa(i);
			aux.setOcupada(false);
			restaurante.adicionar(aux);
		}
	}
	/*Criar Conta */
	public static Conta criarConta(int idmesa) throws Exception {
		Mesa mesaaux = restaurante.localizarMesa(idmesa);
		if(mesaaux==null) {
			throw new Exception("mesa não cadastrada"+idmesa);
		}
		if(mesaaux.getGarcom() == null) {
			
			throw new Exception("Mesa não em garçom");
		}
		if(mesaaux.isOcupada()) {
			throw new Exception("a mesa está ocupada"+idmesa);
             
		}
		
			numconta++;
			Conta contaaux = new Conta(numconta);
			mesaaux.adicionar(contaaux);
			contaaux.getMesa().setOcupada(true);
			restaurante.adicionar(contaaux);
			return contaaux;
	}
	/*cadastrar Produtos*/
	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		Produto p = restaurante.localizarProduto(nome);
		if (p!=null) {
			throw new Exception("produto ja cadastrado: " + nome);
		}else {
		     p = new Produto(nome,preco);
		     restaurante.adicionar(p);
		     return p;
		}
	}
	
	/*Cadastrar Garcom*/
	public static Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal) throws  Exception{
			if ((mesafinal - mesainicial) !=4) {
				throw new Exception("intervalo de mesas inválidos!");
			}
			Garcom g = restaurante.localizarGarcom(apelido);
			if(g != null){
				throw new Exception("Garcom ja cadastrado");
			}
		    g = new Garcom(apelido);
		    ArrayList<Mesa> mesagarcom = new ArrayList<>();
		    for(int i = mesainicial; i<=mesafinal; i++) {
		    	Mesa aux = restaurante.localizarMesa(i);
		    	if(aux == null) {
					throw new Exception ("mesa inexistente");
				}else if(aux.getGarcom()!= null) {
					throw new Exception ("mesa já possui garçom");
				}
		    	mesagarcom.add(aux);
		    }
		     for(Mesa m: mesagarcom) {
		    	 g.adicionar(m);
		     }
		     restaurante.adicionar(g);
		     return g;
		
	}
	
	/*consultar Conta */
	public static Conta consultarConta(int idmesa) throws Exception {
		Conta aux = restaurante.localizarUltimaContaPorMesa(idmesa);
		if(aux==null) {
			throw new Exception("conta inexistente "+idmesa);
		}
			return aux;
		
	}
	
	/*solicitar produto */
	public static Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception {
		Produto p = restaurante.localizarProduto(nomeproduto);
		if(p== null) {
			throw new Exception("produto não cadastrado"+nomeproduto);
		}
		Mesa m = restaurante.localizarMesa(idmesa);
		if(m == null) {
			throw new Exception("mesa inválida"+idmesa);
		}else if(m.isOcupada()== false) {
			throw new Exception("a conta não está em aberta"+idmesa);
		}
		restaurante.localizarUltimaContaPorMesa(idmesa).adicionar(p);
		return p;
	}
	
	/*cancelar conta */
	public static void cancelarConta(int idmesa) throws Exception{
		Conta c = restaurante.localizarUltimaContaPorMesa(idmesa);
		
		if(c == null) {
			throw new Exception("conta inválida"+idmesa);
		}else if(c.getMesa().isOcupada() == false) {
			throw new Exception("a conta não está em aberto !");
		}
		c.getMesa().setOcupada(false);
		c.getMesa().remover(c);
		restaurante.remover(c);
	}
	/*transferir a conta */
	public static void transferirConta(int idmesaorigem, int idmesadestino)throws Exception{
		
		Conta origem = restaurante.localizarUltimaContaPorMesa(idmesaorigem);
		//System.out.println("krai");
		if(origem == null) {
			throw new Exception("conta de origem inválida"+idmesaorigem);
		}else if(origem.getMesa().isOcupada() ==false) {
			throw new Exception("a conta de origem não está em aberta"+idmesaorigem);
		}
		Conta destino = restaurante.localizarUltimaContaPorMesa(idmesadestino);
		//System.out.println("mzr");
		if(origem == null) {
			
			throw new Exception("conta de destino inválida"+idmesaorigem);
		}else if(origem.getMesa().isOcupada() ==false) {
			
			throw new Exception("a conta de destino não está em aberta"+idmesaorigem);
		}
		
		if(!origem.getMesa().getGarcom().getApelido().equals(destino.getMesa().getGarcom().getApelido())) {
			throw new Exception("transferência não permitida");
		}
		for(Produto p : origem.getProdutos()) {
			destino.adicionar(p);
		}
		
		cancelarConta(idmesaorigem);
	}
	/*fechar conta */
	public static void fecharConta(int idmesa)throws Exception {
		Conta aux = restaurante.localizarUltimaContaPorMesa(idmesa);
		if(aux == null) {
			throw new Exception("conta não existente"+idmesa);
		}else if(aux.getMesa().isOcupada() ==false) {
			throw new Exception("a conta não está em aberto"+idmesa);
		}else {
			
			java.util.Date data = Calendar.getInstance().getTime();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = formato.format(data);
			
			aux.setDtfechamento(dataFormatada);
			aux.getMesa().setOcupada(false);
		}
		
	}
	/*calcular Gorjeta */
	public static double calcularGorjeta(String nome) throws Exception {
		Garcom g = restaurante.localizarGarcom(nome);
		if(g==null) {
			throw new Exception("garcom não existente"+nome);
		}
		else {
			ArrayList<Mesa> mesas = g.getMesas();
			if(mesas.isEmpty()) {
				throw new Exception ("O Garçom não tem mesas");
			}
			double gorgeta = 0;
			     
			    ArrayList<Conta> contas;
			    for(Mesa m: mesas) {
			      contas = m.getContas();
			        if(!contas.isEmpty()) {  
			          for(Conta c: contas) {
			    	    if(c.getDtfechamento()!= null && c.getPagamento()!= null) {
			    		   gorgeta+=c.getTotal();
			    		   
			    	      }
			          }
			        }
			    }
				
			return (gorgeta * 10)/100;
		}
	}
	 
	public static boolean verificaGarcom(String nome, int idmesa) throws Exception {
		Mesa m = restaurante.localizarMesa(idmesa);
		Garcom g = restaurante.localizarGarcom(nome);
		if (m== null) {
			throw new Exception ("Mesa não Existente");
		}
		if(m.getGarcom() == null) {
			throw new Exception ("Mesa sem Garcom");
		}
		if(g == null) {
			throw new Exception ("Garçom não encontrado");
		}
		
		if(m.getGarcom().getApelido().equalsIgnoreCase(g.getApelido())) {
			return true;
		}else {
			throw new Exception("Garçom não tem permissão");
		}
		
		
		
	}
	
	public static Pagamento pagarConta(int idmesa, String tipo, int percentual, String cartao, int quantidade) throws Exception {
		
		Conta c = restaurante.localizarUltimaContaPorMesa(idmesa);
		if(c== null) {
			throw new Exception("Conta não encontrada");
		}
		if(c.getDtfechamento() == null) {
			throw new Exception("a conta não está fechada");
		}
		if(c.getPagamento()!= null) {
			throw new Exception("essa conta ja foi paga !");
		}
		if(tipo.equalsIgnoreCase("Dinheiro")) {
			if(percentual <0 || percentual >5) {
				throw new Exception("desconto não permitido");
			}
			PagamentoDinheiro pd = new PagamentoDinheiro(c.getTotal(), percentual);
			pd.calcularPagamento(c.getTotal());
			c.setPagamento(pd);
			return pd;
		}else if(tipo.equalsIgnoreCase("cartão")) {
			if(quantidade <0 || quantidade >4) {
				throw new Exception("quantidade de parcelas inválido");
			}
			if(c.getTotal()/quantidade <100) {
				throw new Exception("valor da parcela não permitida");
			}
			PagamentoCartao pc = new PagamentoCartao(c.getTotal(), cartao, quantidade);
			pc.calcularPagamento(c.getTotal());
			c.setPagamento(pc);
			return pc;
			
		}
		return null;
		
	}
	public static void excluirGarcom(String nome)throws Exception{
		Garcom g = restaurante.localizarGarcom(nome);
		if(g == null) {
			throw new Exception("Garcom inexistente");
		}
		for(Mesa m : g.getMesas()) {
			m.setGarcom(null);
		}
		restaurante.remover(g);
	}
	
	public static double calcularPercentualMedio(String apelido) throws Exception {
		Garcom g = restaurante.localizarGarcom(apelido);
		if (g==null) {
			throw new Exception("Garcom não encontrado");
		}
		double percentual = 0;
		int qtdContasDinheiro =0;
		for(Mesa m: g.getMesas()) {
			for(Conta c: m.getContas()) {
				String modelo = c.getPagamento().getClass().getSimpleName();
				if(modelo.equals("PagamentoDinheiro")) {
					PagamentoDinheiro p = (PagamentoDinheiro) c.getPagamento();
					percentual +=p.getPercentualdesconto();
					qtdContasDinheiro++;
				}
				 
				 
			}
		}
		return percentual/ qtdContasDinheiro;
	}

}
