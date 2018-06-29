package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Produto;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Conta;

public class TesteRapidoProjeto {
	
	public static void main (String[] args) {  
		
		parte1();
		
		parte2();
		
		parte3();
		
		parte4();
		System.out.println("fim do teste");
		
	}

	public static void parte1(){
		
		try {	
			Produto p;
			p = Fachada.cadastrarProduto("feijoada", 25.0);
			p = Fachada.cadastrarProduto("bode guisado", 20.0);
			p = Fachada.cadastrarProduto("galinhada", 15.0);
			p = Fachada.cadastrarProduto("cerveja", 6.0);
			p = Fachada.cadastrarProduto("refrigerante", 5.0);
			p = Fachada.cadastrarProduto("agua", 2.0);
			ArrayList<Produto> produtos = Fachada.listarProdutos();
			System.out.println("produtos cadastrados:");
			System.out.println(produtos);
            
			Fachada.criarMesas(20);		// 20 mesas
			ArrayList<Mesa> mesas = Fachada.listarMesas();
			System.out.println("mesas criadas:");
			System.out.println(mesas);
           
			Garcom g;
			g = Fachada.cadastrarGarcom("baixinho", 1,5);
			g = Fachada.cadastrarGarcom("esperto", 6,10);
			g = Fachada.cadastrarGarcom("zezinho", 10,15);
			g = Fachada.cadastrarGarcom("zezinho", 16,20);
			ArrayList<Garcom> garcons = Fachada.listarGarcons();
			System.out.println("garcons cadastrados:");
			System.out.println(garcons);
              
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	public static void parte2() {
		try {
			Fachada.criarConta(1);	//mesa 1
			Fachada.solicitarProduto(1, "galinhada");
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.solicitarProduto(1, "refrigerante");
			System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.fecharConta(1);
			System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
			
           
			Fachada.criarConta(5);	//mesa 5;
			Fachada.solicitarProduto(5, "feijoada");
			Fachada.solicitarProduto(5, "cerveja");
			Fachada.fecharConta(5);
			System.out.println("conta da mesa 5: \n"+ Fachada.consultarConta(5)); 
            

			double gorjeta = Fachada.calcularGorjeta("baixinho");
			System.out.println("gorjeta do baixinho="+gorjeta);
            
			ArrayList<Conta> contas = Fachada.listarContas();
			System.out.println("contas existentes:");
			System.out.println(contas);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void parte3() {
		try {
			Fachada.criarConta(7);
			Fachada.solicitarProduto(7, "galinhada");
			Fachada.solicitarProduto(7, "cerveja");
			System.out.println("conta da mesa 7: \n"+ Fachada.consultarConta(7));
			
			Fachada.criarConta(8);
			Fachada.solicitarProduto(8, "agua");
			Fachada.solicitarProduto(8, "refrigerante");
			System.out.println("conta da mesa 8: \n"+ Fachada.consultarConta(8));
			
			Fachada.transferirConta(7, 8);
			
			System.out.println("conta da mesa 8: \n"+ Fachada.consultarConta(8));
			
			//System.out.println("listando as mesas \n"+Fachada.listarMesas());
			//consultando a conta que foi fechada 
			System.out.println("conta da mesa 7: \n"+ Fachada.consultarConta(7));
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void parte4() {
		try {
			
			Fachada.criarConta(10);
			Fachada.solicitarProduto(10, "agua");
			Fachada.solicitarProduto(10, "galinhada");
			Fachada.fecharConta(10);
			Fachada.criarConta(10);
			Fachada.solicitarProduto(10, "cerveja");
			Fachada.fecharConta(10);
			Fachada.criarConta(10);
			Fachada.solicitarProduto(10, "feijoada");
			Fachada.cancelarConta(10);
			System.out.println("conta da mesa 10: \n"+ Fachada.consultarConta(10));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
