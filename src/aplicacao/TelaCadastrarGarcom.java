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
import modelo.Garcom;

public class TelaCadastrarGarcom extends JFrame {

	private JPanel contentPane;
	private JTextField txtApelido;
	private JTextField txtMesa;
	private JLabel lblNome;
	private JLabel lblMesa;
	private JButton btnCadastro;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarGarcom frame = new TelaCadastrarGarcom();
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
	public TelaCadastrarGarcom() {
		setTitle("Cadastro de Garçons");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtApelido = new JTextField();
		txtApelido.setBounds(72, 11, 86, 20);
		contentPane.add(txtApelido);
		txtApelido.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(16, 14, 46, 14);
		contentPane.add(lblNome);

		lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(16, 52, 46, 14);
		contentPane.add(lblMesa);

		txtMesa = new JTextField();
		txtMesa.setBounds(72, 49, 86, 20);
		contentPane.add(txtMesa);
		txtMesa.setColumns(10);

		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String apelido = txtApelido.getText();
					int id = Integer.parseInt(txtMesa.getText());
					Garcom g = Fachada.cadastrarGarcom(apelido, id, id+4);
					lblMsg.setText("cadastrado "+g.getApelido());
					
					txtApelido.setText("");
					txtMesa.setText("");
					txtApelido.requestFocus();
				}
				catch(Exception erro){
					lblMsg.setText(erro.getMessage());
				}
			}
		});
		btnCadastro.setBounds(168, 30, 115, 23);
		contentPane.add(btnCadastro);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 94, 273, 14);
		contentPane.add(lblMsg);
	}
}