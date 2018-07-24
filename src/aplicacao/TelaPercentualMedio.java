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


public class TelaPercentualMedio extends JFrame {

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
					TelaPercentualMedio frame = new TelaPercentualMedio();
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
	public TelaPercentualMedio() {
		setTitle("C�lculo da Gorjeta do Gar�om");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 103);
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
					double gorjeta = Fachada.calcularPercentualMedio(apelido);

					lblMensagem.setText(apelido+ " tem um percentual m�dio de R$ "+ gorjeta);
					
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
		lblMensagem.setBounds(10, 42, 350, 21);
		contentPane.add(lblMensagem);
	}
}