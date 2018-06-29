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

public class TelaTransferenciaContas extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigem;
	private JTextField txtDestino;
	private JLabel lblOrigem;
	private JLabel lblDestino;
	private JButton btnTransferir;
	private JLabel lblStatus;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTransferenciaContas frame = new TelaTransferenciaContas();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}


	public TelaTransferenciaContas() {
		setTitle("Transferir Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtOrigem = new JTextField();
		txtOrigem.setBounds(192, 11, 86, 20);
		contentPane.add(txtOrigem);
		txtOrigem.setColumns(10);

		lblOrigem = new JLabel("Mesa de origem:");
		lblOrigem.setBounds(28, 14, 123, 14);
		contentPane.add(lblOrigem);

		lblDestino = new JLabel("Mesa de destino:");
		lblDestino.setBounds(28, 52, 123, 14);
		contentPane.add(lblDestino);

		txtDestino = new JTextField();
		txtDestino.setBounds(192, 49, 86, 20);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int mesa_origem = Integer.parseInt(txtOrigem.getText());
					int mesa_destino = Integer.parseInt(txtDestino.getText());
					Fachada.transferirConta(mesa_origem, mesa_destino);
					lblStatus.setText("conta transferida!");
					
					txtOrigem.setText("");
					txtDestino.setText("");
					txtOrigem.requestFocus();
				}
				catch(Exception e2){
					lblStatus.setText(e2.getMessage());
				}
			}
		});
		btnTransferir.setBounds(107, 84, 115, 23);
		contentPane.add(btnTransferir);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(10, 130, 322, 20);
		contentPane.add(lblStatus);
	}
}