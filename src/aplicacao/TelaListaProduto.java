package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaListaProduto extends JFrame {

	private JPanel contentPane;
	private JTextArea txtArea;
	private JButton btnListar;

	
	public TelaListaProduto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnListar.doClick();
			}
		});
		setTitle("Listar Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					String texto;
					ArrayList<Produto> lista = Fachada.listarProdutos();
					texto = "Lista de produtos: \n";
					if (lista.isEmpty())
						texto += "Não têm produtos cadastrados \n";
					else 	
						for(Produto p: lista) 
							texto +=  p + "\n"; 

					txtArea.setText(texto);
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		
		txtArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtArea);
		scroll.setBounds(24, 29, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
	}
}