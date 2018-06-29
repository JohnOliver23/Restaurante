package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Conta;

public class TelaConsultaConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMesa;
	private JLabel lblIdMesa;
	private JButton btnConsultar;
	private JTextArea txtContas;
	private JLabel lblStatus;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaConta frame = new TelaConsultaConta();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaConta() {
		setTitle("Consultar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIdMesa = new JTextField();
		txtIdMesa.setBounds(111, 11, 86, 20);
		contentPane.add(txtIdMesa);
		txtIdMesa.setColumns(10);

		lblIdMesa = new JLabel("Id Mesa: ");
		lblIdMesa.setBounds(33, 14, 78, 14);
		contentPane.add(lblIdMesa);

		

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = Integer.parseInt(txtIdMesa.getText());
					Conta c = Fachada.consultarConta(id);
					txtContas.setText("");
					txtContas.setText(c.toString());
			
					txtIdMesa.setText("");
					txtIdMesa.requestFocus();
				}
				catch(Exception e2){
					lblStatus.setText(e2.getMessage());
				}
			}
		});
		btnConsultar.setBounds(444, 10, 90, 23);
		contentPane.add(btnConsultar);
		
		txtContas = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtContas);
		scroll.setBounds(24, 50, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(25, 235, 483, 14);
		contentPane.add(lblStatus);
	}
}