package aplicacao;	

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import fachada.Fachada;
import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenu mnProd;
	private JMenuItem itemCadastarProd;
	private JMenuItem itemListarProd;
	private JMenu mnGarcom;
	private JMenuItem itemCadastrarGarcom;
	private JMenuItem itemListarGarcom;
	private JMenuItem itemCalcularGorjeta;
	private JMenu mnMesa;
	private JMenuItem itemListarMesa;
	private JMenuItem itemSolicitarProd;
	private JLabel oii;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("La casa do IF - John Oliver");
			

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					Fachada.criarMesas(25);	
					Produto p;
					p = Fachada.cadastrarProduto("Pizza", 20.00);
					p = Fachada.cadastrarProduto("feijoada", 15.0);
					p = Fachada.cadastrarProduto("Rubacão", 22.00);
					p = Fachada.cadastrarProduto("Peixada", 60.00);
					p = Fachada.cadastrarProduto("Fava", 26.00);
					p = Fachada.cadastrarProduto("Panqueca", 8.00);
					p = Fachada.cadastrarProduto("Suco", 3.00);
					p = Fachada.cadastrarProduto("Água", 2.00);
					p = Fachada.cadastrarProduto("Refrigerante", 4.0);
					p = Fachada.cadastrarProduto("Cerveja", 8.00);
					Garcom g;
					g = Fachada.cadastrarGarcom("Heizemberg", 1, 5);
					g = Fachada.cadastrarGarcom("Guerreirinho", 6, 10);
					g = Fachada.cadastrarGarcom("Berlin", 11, 15);
					g = Fachada.cadastrarGarcom("Serginho", 16, 20);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Volte Sempre!!");
			}
		});

		frmPrincipal.setBounds(100, 100, 485, 340);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		oii = new JLabel("oiii");
		oii.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/smoli.jpg")));
		oii.setBounds(0, -12, 469, 305);
		frmPrincipal.getContentPane().add(oii);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setBorderPainted(false);
		UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(Color.black, 0));
		UIManager.put("MenuItem.selectionBackground", new Color(153, 102, 51));
		UIManager.put("MenuItem.selectionForeground", Color.WHITE);
		UIManager.put("Menu.selectionBackground", new Color(153, 102, 51));
		UIManager.put("Menu.selectionForeground", Color.WHITE);
		UIManager.put("MenuBar.selectionBackground", new Color(153, 102, 51));
		UIManager.put("MenuBar.selectionForeground", Color.WHITE);
		
		frmPrincipal.setJMenuBar(menuBar);

		mnProd = new JMenu("   Produto   ");
		mnProd.setContentAreaFilled(false);
		
		mnProd.setForeground(Color.WHITE);
		mnProd.setBorderPainted(false);
		menuBar.add(mnProd);
		
		itemCadastarProd = new JMenuItem("Cadastrar");
		itemCadastarProd.setAlignmentY(Component.TOP_ALIGNMENT);
		itemCadastarProd.setContentAreaFilled(false);
		itemCadastarProd.setBorder(null);
		itemCadastarProd.setBackground(Color.BLACK);
		itemCadastarProd.setForeground(Color.WHITE);
		itemCadastarProd.setBorderPainted(false);
		itemCadastarProd.setBorderPainted(false);
		itemCadastarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarProduto t = new TelaCadastrarProduto();
				t.setVisible(true);
			}
		});
		mnProd.add(itemCadastarProd);

		itemListarProd = new JMenuItem("Listar");
		itemListarProd.setContentAreaFilled(false);
		itemListarProd.setBorder(null);
		itemListarProd.setBorderPainted(false);
		itemListarProd.setBackground(Color.BLACK);
		itemListarProd.setForeground(Color.WHITE);
		
		itemListarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaProduto t = new TelaListaProduto();
				t.setVisible(true);
			}
		});
		mnProd.add(itemListarProd);
		mnProd.setBorderPainted(false);
 
		mnMesa = new JMenu("       Mesa       ");
		mnMesa.setForeground(Color.WHITE);
		mnMesa.setBorderPainted(false);
		menuBar.add(mnMesa);

		itemListarMesa = new JMenuItem("Listar");
		itemListarMesa.setBackground(Color.BLACK);
		itemListarMesa.setForeground(Color.WHITE);
		itemListarMesa.setContentAreaFilled(false);
		itemListarMesa.setBorder(null);
		itemListarMesa.setBorderPainted(false);
		itemListarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaMesas t = new TelaListaMesas();
				t.setVisible(true);
			}
		});
		mnMesa.add(itemListarMesa);
		
		itemSolicitarProd = new JMenuItem("Solicitar Produto");
		itemSolicitarProd.setBackground(Color.BLACK);
		itemSolicitarProd.setForeground(Color.WHITE);
		itemSolicitarProd.setContentAreaFilled(false);
		itemSolicitarProd.setBorder(null);
		itemSolicitarProd.setBorderPainted(false);
		itemSolicitarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPedidoProduto t = new TelaPedidoProduto();
				t.setVisible(true);
			}
		});
		mnMesa.add(itemSolicitarProd);

		
		mnGarcom = new JMenu("   Garçom   ");
		mnGarcom.setForeground(Color.WHITE);
		mnGarcom.setBorderPainted(false);
		menuBar.add(mnGarcom);	

		itemCadastrarGarcom = new JMenuItem("Cadastrar");
		itemCadastrarGarcom.setBackground(Color.BLACK);
		itemCadastrarGarcom.setForeground(Color.WHITE);
		itemCadastrarGarcom.setContentAreaFilled(false);
		itemCadastrarGarcom.setBorder(null);
		itemCadastrarGarcom.setBorderPainted(false);
		itemCadastrarGarcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGarcom t = new TelaCadastrarGarcom();
				t.setVisible(true);
			}
		});
		mnGarcom.add(itemCadastrarGarcom);

		itemListarGarcom = new JMenuItem("Listar");
		itemListarGarcom.setForeground(Color.WHITE);
		itemListarGarcom.setBackground(Color.BLACK);
		itemListarGarcom.setContentAreaFilled(false);
		itemListarGarcom.setBorder(null);
		itemListarGarcom.setBorderPainted(false);
		itemListarGarcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaGarcons t = new TelaListaGarcons();
				t.setVisible(true);
			}
		});
		mnGarcom.add(itemListarGarcom);
		
		
		itemCalcularGorjeta = new JMenuItem("Gorjeta");
		itemCalcularGorjeta.setForeground(Color.WHITE);
		itemCalcularGorjeta.setBackground(Color.BLACK);
		itemCalcularGorjeta.setContentAreaFilled(false);
		itemCalcularGorjeta.setBorder(null);
		itemCalcularGorjeta.setBorderPainted(false);
		itemCalcularGorjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGorjeta t = new TelaGorjeta();
				t.setVisible(true);
			}
		});
		mnGarcom.add(itemCalcularGorjeta);
		
		
		JMenu mnConta = new JMenu("     Conta     ");
		mnConta.setForeground(Color.WHITE);
		mnConta.setBorderPainted(false);
		menuBar.add(mnConta); 

		JMenuItem itemCriarConta = new JMenuItem("Criar");
		itemCriarConta.setBackground(Color.BLACK);
		itemCriarConta.setForeground(Color.WHITE);
		itemCriarConta.setContentAreaFilled(false);
		itemCriarConta.setBorder(null);
		itemCriarConta.setBorderPainted(false);
		itemCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarConta t = new TelaCriarConta();
				t.setVisible(true);
			}
		});
		mnConta.add(itemCriarConta);

		JMenuItem itemListarConta = new JMenuItem("Listar");
		itemListarConta.setForeground(Color.WHITE);
		itemListarConta.setBackground(Color.BLACK);
		itemListarConta.setContentAreaFilled(false);
		itemListarConta.setBorder(null);
		itemListarConta.setBorderPainted(false);
		itemListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaConta t = new TelaListaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(itemListarConta);

		JMenuItem itemConsultarConta = new JMenuItem("Consultar");
		itemConsultarConta.setForeground(Color.WHITE);
		itemConsultarConta.setBackground(Color.BLACK);
		itemConsultarConta.setContentAreaFilled(false);
		itemConsultarConta.setBorder(null);
		itemConsultarConta.setBorderPainted(false);
		itemConsultarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaConta t = new TelaConsultaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(itemConsultarConta);
		
		JMenuItem itemCancelarConta = new JMenuItem("Cancelar");
		itemCancelarConta.setForeground(Color.WHITE);
		itemCancelarConta.setBackground(Color.BLACK);
		itemCancelarConta.setContentAreaFilled(false);
		itemCancelarConta.setBorder(null);
		itemCancelarConta.setBorderPainted(false);
		itemCancelarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelaConta t = new TelaCancelaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(itemCancelarConta);
		
		JMenuItem itemTransferirConta = new JMenuItem("Transferir");
		itemTransferirConta.setForeground(Color.WHITE);
		itemTransferirConta.setBackground(Color.BLACK);
		itemTransferirConta.setContentAreaFilled(false);
		itemTransferirConta.setBorder(null);
		itemTransferirConta.setBorderPainted(false);
		itemTransferirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTransferenciaContas t = new TelaTransferenciaContas();
				t.setVisible(true);
			}
		});
		mnConta.add(itemTransferirConta);
		
		JMenuItem itemFecharConta = new JMenuItem("Fechar");
		itemFecharConta.setForeground(Color.WHITE);
		itemFecharConta.setBackground(Color.BLACK);
		itemFecharConta.setContentAreaFilled(false);
		itemFecharConta.setBorder(null);
		itemFecharConta.setBorderPainted(false);
		itemFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFechaConta t = new TelaFechaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(itemFecharConta);
		
		JMenuItem itemPagarConta = new JMenuItem("Pagar");
		itemPagarConta.setForeground(Color.WHITE);
		itemPagarConta.setBackground(Color.BLACK);
		itemPagarConta.setContentAreaFilled(false);
		itemPagarConta.setBorder(null);
		itemPagarConta.setBorderPainted(false);
		itemPagarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagarConta t = new TelaPagarConta();
				t.setVisible(true);
			}
		});
		
		mnConta.add(itemPagarConta);
		
	}
}
