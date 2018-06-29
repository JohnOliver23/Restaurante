package aplicacao;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton btnCadastro;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProduto frame = new TelaCadastrarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarProduto() {
		setTitle("Cadastrando Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(53, 11, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("Preço");
		lblPreco.setBounds(10, 52, 46, 14);
		contentPane.add(lblPreco);

		txtPreco = new JTextField();
		txtPreco.setBounds(53, 49, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = txtNome.getText();
					double preco = Double.parseDouble(txtPreco.getText());
					Produto p = Fachada.cadastrarProduto(nome, preco);
					lblMsg.setText("Produto "+ p.getNome() + " cadastrado");
					
					txtNome.setText("");
					txtPreco.setText("");
					txtNome.requestFocus();
				}
				catch(Exception e1){
					lblMsg.setText(e1.getMessage());
				}
			}
		});
		btnCadastro.setBounds(149, 32, 115, 23);
		contentPane.add(btnCadastro);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 94, 273, 14);
		contentPane.add(lblMsg);
	}
}
