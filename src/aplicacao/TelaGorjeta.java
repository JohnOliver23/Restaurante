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


public class TelaGorjeta extends JFrame {

	private JPanel contentPane;
	private JTextField txtApelido;
	private JLabel lblApelido;
	private JButton btnCalcular;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGorjeta frame = new TelaGorjeta();
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
	public TelaGorjeta() {
		setTitle("Cálculo da Gorjeta do Garçom");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 103);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtApelido = new JTextField();
		txtApelido.setBounds(49, 11, 86, 20);
		contentPane.add(txtApelido);
		txtApelido.setColumns(10);

		lblApelido = new JLabel("Nome");
		lblApelido.setBounds(10, 14, 46, 14);
		contentPane.add(lblApelido);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String apelido = txtApelido.getText();
					double gorjeta = Fachada.calcularGorjeta(apelido);
					
					lblMensagem.setText("garçom "+ apelido+ " tem uma gorjeta de R$ "+ gorjeta);
					
					txtApelido.setText("");
					txtApelido.requestFocus();
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnCalcular.setBounds(168, 10, 115, 23);
		contentPane.add(btnCalcular);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(10, 42, 273, 21);
		contentPane.add(lblMensagem);
	}
}